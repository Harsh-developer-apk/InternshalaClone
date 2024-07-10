package com.example.internshala.nav

sealed class Screens(val route:String) {
    data object Home : Screens("home")
    data object Internship : Screens("internship")
    data object Job: Screens("job")
}