package com.example.internshala.nav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bed
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LiveTv
import androidx.compose.material.icons.outlined.Bed
import androidx.compose.material.icons.outlined.Book
import androidx.compose.material.icons.outlined.Groups
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.LiveTv
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(
    val title:String,
    val route:String,
    val hasBadge:Int,
    val hasNews:Boolean,
    val selectedIcon:ImageVector,
    val unselectedIcon:ImageVector
)

object BottomNavItemsList{
    val bottomNavItems = listOf(
        BottomNavItem(
            title = "Home",
            route = "home",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            hasBadge = 0,
            hasNews = false
        ),
        BottomNavItem(
            title = "Internships",
            route = "internships",
            selectedIcon = Icons.Filled.Book,
            unselectedIcon = Icons.Outlined.Book,
            hasBadge = 0,
            hasNews = false
        ),
        BottomNavItem(
            title = "Jobs",
            route = "jobs",
            selectedIcon = Icons.Filled.Bed,
            unselectedIcon = Icons.Outlined.Bed,
            hasBadge = 0,
            hasNews = false
        ),
        BottomNavItem(
            title = "Clubs",
            route = "clubs",
            selectedIcon = Icons.Filled.Groups,
            unselectedIcon = Icons.Outlined.Groups,
            hasBadge = 0,
            hasNews = false
        ),
        BottomNavItem(
            title = "Courses",
            route = "courses",
            selectedIcon = Icons.Filled.LiveTv,
            unselectedIcon = Icons.Outlined.LiveTv,
            hasBadge = 0,
            hasNews = false
        ),
    )

}
