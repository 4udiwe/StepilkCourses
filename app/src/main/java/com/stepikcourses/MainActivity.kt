package com.stepikcourses

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.twotone.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import com.stepikcourses.ui.theme.StepikCoursesTheme
import com.stepikcourses.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.stepikcourses.ui.screens.CourseScreen
import com.stepikcourses.ui.screens.FavoriteScreen
import com.stepikcourses.ui.screens.MainScreen
import com.stepikcourses.ui.screens.UserScreen
import com.stepikcourses.ui.screens.enter.GreetingScreen
import com.stepikcourses.ui.screens.enter.RegistrationScreen
import com.stepikcourses.ui.screens.enter.SignInScreen
import kotlinx.coroutines.tasks.await
import kotlinx.serialization.Serializable
import kotlin.time.Duration

class MainActivity : ComponentActivity() {

    private val viewModel by viewModel<MainViewModel>()

    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.getCourses()

        enableEdgeToEdge()
        setContent {
            StepikCoursesTheme {

                val navController = rememberNavController()

                val botBarState =
                    remember { mutableStateOf(viewModel.firebaseAuth.currentUser != null) }


                Scaffold(
                    modifier = Modifier.fillMaxSize(),

                    bottomBar = {
                        if (botBarState.value) {
                            val home = remember { mutableStateOf(true) }
                            val fav = remember { mutableStateOf(false) }
                            val user = remember { mutableStateOf(false) }
                            BottomAppBar(
                                containerColor = colorResource(R.color.background),
                                contentColor = colorResource(R.color.elements),
                            ) {
                                Row (
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceAround
                                ){
                                    IconButton(onClick = {
                                        navController.navigate(ScreenHome)
                                        home.value = true
                                        fav.value = false
                                        user.value = false
                                    }) {
                                        Icon(
                                            imageVector = Icons.Default.Home,
                                            contentDescription = "home",
                                            tint = if (home.value)
                                                colorResource(R.color.green)
                                            else LocalContentColor.current
                                        )
                                    }
                                    IconButton(onClick = {
                                        navController.navigate(ScreenFavorite)
                                        home.value = false
                                        fav.value = true
                                        user.value = false
                                    }) {
                                        Icon(
                                            imageVector = Icons.Default.FavoriteBorder,
                                            contentDescription = "favorite",
                                            tint = if (fav.value)
                                                colorResource(R.color.green)
                                            else LocalContentColor.current
                                        )
                                    }
                                    IconButton(onClick = {
                                        navController.navigate(ScreenUser)
                                        home.value = false
                                        fav.value = false
                                        user.value = true
                                    }) {
                                        Icon(
                                            imageVector = Icons.TwoTone.Person,
                                            contentDescription = "user",
                                            tint = if (user.value)
                                                colorResource(R.color.green)
                                            else LocalContentColor.current
                                        )
                                    }
                                }

                            }
                        }
                    }
                ) { innerPadding ->
                    NavHost(
                        startDestination = if (viewModel.firebaseAuth.currentUser == null) ScreenGrerting else ScreenHome,
                        navController = navController
                    ) {
                        composable<ScreenHome> {
                            MainScreen(
                                viewModel = viewModel,
                                innerPadding = innerPadding,
                                onCourseClick = {
                                    navController.navigate(ScreenCourse)
                                }
                            )

                        }
                        composable<ScreenCourse> {
                            CourseScreen(
                                course = viewModel.currentCourse,
                                onBackClicked = { navController.popBackStack() },
                                viewModel = viewModel,
                                onGoToPlatformClicked = { course ->
                                    val urlIntent = Intent(Intent.ACTION_VIEW)
                                    urlIntent.data = Uri.parse(course.canonicalUrl)
                                    startActivity(urlIntent)
                                },
                                innerPadding = innerPadding
                            )
                        }
                        composable<ScreenFavorite> {
                            FavoriteScreen(
                                viewModel = viewModel,
                                innerPadding = innerPadding,
                                onCourseClick = {
                                    navController.navigate(ScreenCourse)
                                }
                            )
                        }
                        composable<ScreenUser> {
                            UserScreen(
                                viewModel = viewModel,
                                innerPadding = innerPadding,
                                onCourseClick = {
                                    navController.navigate(ScreenCourse)
                                },
                                onLogOut = {
                                    navController.navigate(ScreenGrerting)
                                    botBarState.value = false
                                }
                            )
                        }
                        composable<ScreenGrerting> {
                            GreetingScreen(
                                paddingValues = innerPadding,
                                onContinue = {
                                    navController.navigate(ScreenSignIn)
                                }
                            )
                        }
                        composable<ScreenSignIn> {
                            SignInScreen(
                                paddingValues = innerPadding,
                                onFieldsEmpty = {
                                    emptyFieldsToast()
                                },
                                onRegistrate = {
                                    navController.navigate(ScreenRegistration)
                                },
                                onSignIn = { email, password ->
                                    viewModel.signIn(
                                        email,
                                        password,
                                        onNav = { navController.navigate(ScreenHome) },
                                        onSignedToast = Toast.makeText(
                                            applicationContext,
                                            "Выполнен вход",
                                            Toast.LENGTH_SHORT
                                        ),
                                        onErrorToast = Toast.makeText(
                                            applicationContext,
                                            "Ошибка входа",
                                            Toast.LENGTH_SHORT
                                        )
                                    )
                                    botBarState.value = true
                                }
                            )
                        }
                        composable<ScreenRegistration> {
                            RegistrationScreen(
                                paddingValues = innerPadding,
                                onFieldsEmpty = {
                                    emptyFieldsToast()
                                },
                                onPasswordDismiss = {
                                    passwordDismissToast()
                                },
                                onSignIn = {
                                    navController.navigate(ScreenSignIn)
                                },
                                onRegistrate = { email, password ->
                                    viewModel.createUser(
                                        email,
                                        password,
                                        onNav = { navController.navigate(ScreenSignIn) },
                                        onEmailSentToast = { email ->
                                            Toast.makeText(
                                                applicationContext,
                                                "Писмо с подтверждением было отправлено на $email",
                                                Toast.LENGTH_LONG
                                            )
                                        },
                                        onErrorToast = Toast.makeText(
                                            applicationContext,
                                            "Ошибка регистрации",
                                            Toast.LENGTH_SHORT
                                        )
                                    )
                                    botBarState.value = true

                                }
                            )
                        }
                    }
                }
            }
        }
    }


    fun emptyFieldsToast() = Toast.makeText(this, "Заполните все поля!", Toast.LENGTH_SHORT).show()
    fun passwordDismissToast() =
        Toast.makeText(this, "Подтвердите почту", Toast.LENGTH_SHORT).show()

}

@Serializable
object ScreenHome

@Serializable
object ScreenFavorite

@Serializable
object ScreenUser

@Serializable
object ScreenCourse

@Serializable
object ScreenGrerting

@Serializable
object ScreenRegistration

@Serializable
object ScreenSignIn

