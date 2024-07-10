package com.example.internshala

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.internshala.nav.NavDrawerLayout
import com.example.internshala.nav.Screens
import com.example.internshala.ui.composables.ApplicationContainer
import com.example.internshala.ui.screens.HomeScreen
import com.example.internshala.ui.screens.InternshipScreen
import com.example.internshala.ui.screens.JobsScreen
import com.example.internshala.ui.theme.INTERNSHALATheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // enableEdgeToEdge()
        setContent {

            INTERNSHALATheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()

                    val drawerState1 = rememberDrawerState(initialValue = DrawerValue.Closed)
                    ModalNavigationDrawer(
                        drawerContent = {
                            ModalDrawerSheet(
                                modifier = Modifier
                                    .fillMaxWidth(0.8f)
                                    .fillMaxHeight(),
                                drawerShape = RectangleShape) {
                            NavDrawerLayout()
                        } },
                        drawerState = drawerState1
                    ) {
                        ApplicationContainer(drawerState = drawerState1)
                    }

                }
            }
        }
    }
}
@Composable
fun NavHostScreen(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = "home"
    ){
        composable("home"){
            HomeScreen(navController)
        }
        composable("internships"){
            InternshipScreen(navController)
        }
        composable("jobs"){
            JobsScreen(navController)
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    INTERNSHALATheme {
        ApplicationContainer(
            rememberDrawerState(initialValue = DrawerValue.Open))
    }
}