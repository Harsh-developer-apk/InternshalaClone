package com.example.internshala.ui.composables

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.Bookmark
import androidx.compose.material.icons.outlined.ChatBubbleOutline
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.internshala.NavHostScreen
import com.example.internshala.nav.BottomNavItemsList
import com.example.internshala.ui.screens.DetailScreen
import com.example.internshala.ui.screens.HomeScreen
import com.example.internshala.ui.screens.InternshipScreen
import com.example.internshala.ui.screens.JobsScreen
import com.example.internshala.ui.theme.INTERNSHALATheme
import com.example.internshala.ui.theme.skyBlue
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.lang.System.exit

@Composable
fun ApplicationContainer(
   // navController: NavHostController,
    drawerState: DrawerState,
    modifier: Modifier = Modifier){
    val navController = rememberNavController()
    Scaffold(
        modifier = Modifier,
        topBar = {
            TopBar(drawerState)
        },
        bottomBar = {
                BottomBar(navController)

        }
    ) { paddingValues ->
        NavHost(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
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
            composable("details"+"/{id}/{type}",
                arguments = listOf(
                    navArgument("id"){
                        type = NavType.IntType
                    },
                    navArgument("type"){
                        type = NavType.StringType}
                )
            ){
                    DetailScreen(navController,it)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(drawerState: DrawerState){
    val scope: CoroutineScope = rememberCoroutineScope()
    TopAppBar(
        title = {
            Text(
            modifier = Modifier.padding(start = 6.dp),
            text = "Internships",
            style = MaterialTheme.typography.displayMedium
        ) },
        navigationIcon = {
            IconButton(
                modifier = Modifier.size(30.dp),
                onClick = {
                    scope.launch {
                        drawerState.open()
                    }
                }) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Menu"
                )
            }
        },
        actions = {
            IconButton(modifier =Modifier.size(30.dp),
                onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Outlined.Search,
                    contentDescription = "Search"
                )
            }
            IconButton(modifier =Modifier.size(30.dp),
                onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Outlined.Bookmark,
                    contentDescription = "bookmark"
                )
            }
            IconButton(modifier =Modifier.size(30.dp),
                onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Outlined.Notifications,
                    contentDescription = "notification"
                )
            }
            IconButton(modifier =Modifier.size(30.dp),
                onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Outlined.ChatBubbleOutline,
                    contentDescription = "chat"
                )
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomBar(navController: NavHostController){
    var selected by remember{
        mutableIntStateOf(0)
    }
    NavigationBar {
        BottomNavItemsList.bottomNavItems.forEachIndexed { index, bottomNavItem ->
            NavigationBarItem(
                selected = index == selected,
                onClick = {
                    selected = index
                    Log.d("Navigation", "BottomNavItem: ${bottomNavItem.route}")
                    navController.navigate(bottomNavItem.route)
                    },
                icon = {
                    BadgedBox(
                        badge = {
                            if(bottomNavItem.hasNews){ Badge() }
                        }
                    ) {
                        Icon(
                            imageVector = if(selected==index){bottomNavItem.selectedIcon} else{bottomNavItem.unselectedIcon},
                            contentDescription = if(selected==index){bottomNavItem.selectedIcon.name} else{bottomNavItem.unselectedIcon.name})
                    }
                },
                label = {
                    Text(
                        text = bottomNavItem.title,
                        style = MaterialTheme.typography.bodySmall)
                }
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    INTERNSHALATheme {
        ApplicationContainer(
            drawerState = rememberDrawerState(initialValue = DrawerValue.Closed))
    }
}
