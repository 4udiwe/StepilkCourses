package com.stepikcourses

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.twotone.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.LifecycleOwner
import com.stepikcourses.ui.theme.StepikCoursesTheme
import com.stepikcourses.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.domain.model.Courses
import com.stepikcourses.ui.screens.MainScreen
import kotlinx.serialization.Serializable

class MainActivity : ComponentActivity() {

    private val viewModel by viewModel<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StepikCoursesTheme {

                val navController = rememberNavController()

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        BottomAppBar {
                            IconButton(onClick = {
                                navController.navigate(ScreenHome)
                            }) {
                                Icon(imageVector = Icons.Default.Home, contentDescription = "home")
                            }
                            IconButton(onClick = {
                                navController.navigate(ScreenFavorite)
                            }) {
                                Icon(imageVector = Icons.Default.FavoriteBorder, contentDescription = "favorite")
                            }
                            IconButton(onClick = {
                                navController.navigate(ScreenUser)
                            }) {
                                Icon(imageVector = Icons.TwoTone.Person, contentDescription = "home")
                            }

                        }
                    }
                ) { innerPadding ->
                    NavHost(startDestination = ScreenHome, navController = navController){
                        composable<ScreenHome> {
                            MainScreen(viewModel = viewModel, innerPadding = innerPadding)

                        }
                        composable<ScreenFavorite> {

                        }
                        composable<ScreenUser> {

                        }
                    }
                }
            }
        }
    }
}

@Serializable
object ScreenHome
@Serializable
object ScreenFavorite
@Serializable
object ScreenUser


