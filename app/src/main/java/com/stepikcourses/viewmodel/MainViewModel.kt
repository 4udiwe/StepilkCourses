package com.stepikcourses.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.domain.entity.CourseModel
import com.example.domain.model.Course
import com.example.domain.usecase.AddFavoriteCourseUseCase
import com.example.domain.usecase.DeleteFavoriteUseCase
import com.example.domain.usecase.GetCourseUseCase
import com.example.domain.usecase.GetFavoriveCoursesUseCase
import com.google.android.gms.tasks.Task
import com.google.firebase.FirebaseException
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class MainViewModel(
    private val getCourseUseCase: GetCourseUseCase,
    private val addFavoriteCourseUseCase: AddFavoriteCourseUseCase,
    private val deleteFavoriteUseCase: DeleteFavoriteUseCase,
    getFavoriteCoursesUseCase: GetFavoriveCoursesUseCase
) : ViewModel() {

    private val _innerCourses = MutableStateFlow<List<Course>>(emptyList())
    val courses = _innerCourses.asStateFlow()

    lateinit var currentCourse: Course

    private var page = 3

    val favoriteCourses = getFavoriteCoursesUseCase.invoke()

    var sortingType = SortingType.DATE

    val firebaseAuth = FirebaseAuth.getInstance()


    fun getCourses() = viewModelScope.launch {
        val currentCourses = _innerCourses.value.toMutableList()
        repeat(3){
            val coursesInfo = getCourseUseCase.invoke(page)
            if (coursesInfo.meta?.hasNext == true) {
                currentCourses.addAll(coursesInfo.courses)
                page++
            }
            _innerCourses.value = currentCourses
        }

    }

    fun addFavorite(course: Course) = viewModelScope.launch {
        val model = CourseModel(
            id = course.id,
            summary = course.summary,
            cover = course.cover,
            isFavorite = course.isFavorite,
            price = course.price,
            title = course.title,
            becamePublishedAt = course.becamePublishedAt,
            description = course.description
        )
        addFavoriteCourseUseCase.invoke(model)
    }

    fun deleteFavorite(course: Course) = viewModelScope.launch {
        val model = CourseModel(
            id = course.id,
            summary = course.summary,
            cover = course.cover,
            isFavorite = course.isFavorite,
            price = course.price,
            title = course.title,
            becamePublishedAt = course.becamePublishedAt,
            description = course.description
        )
        deleteFavoriteUseCase.invoke(model)
    }
    fun signIn(email: String, password: String, onNav: () -> Unit, onSignedToast: Toast, onErrorToast: Toast) = viewModelScope.launch {
        try {
            val task = firebaseAuth.signInWithEmailAndPassword(email, password)
            task.await()
            if (task.isSuccessful && task.result.user != null) {
                if (task.result.user!!.isEmailVerified) {
                    onNav.invoke()
                    onSignedToast.show()
                } else
                    onErrorToast.show()
            }
        } catch (e: FirebaseAuthInvalidCredentialsException){
            onErrorToast.show()
        }

    }

    fun createUser(email: String, password: String, onNav: () -> Unit, onEmailSentToast: (email: String) -> Toast, onErrorToast: Toast) = viewModelScope.launch {
        try {
            val task = firebaseAuth.createUserWithEmailAndPassword(email, password)
            task.await()
            if (task.isSuccessful) {
                sendVerification()
                onEmailSentToast(email)
                onNav.invoke()
            } else {
                onErrorToast.show()
            }
        } catch (e: FirebaseException) {
            onErrorToast.show()
        }
    }

    fun sendVerification() = viewModelScope.launch{
        val user = firebaseAuth.currentUser
        if (user != null) {
            val task = user.sendEmailVerification()
            task.await()
            if (task.isSuccessful)
                Log.d("RRR", "email sent")
            else
                Log.d("RRR", "email not sent")

        }
    }

    fun logOut() = viewModelScope.launch {
        firebaseAuth.signOut()
    }
}
enum class SortingType {
    DATE, POPULARITY, RAINING
}