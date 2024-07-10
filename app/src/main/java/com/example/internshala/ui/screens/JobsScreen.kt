package com.example.internshala.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.internshala.data.ListOfJob
import com.example.internshala.ui.composables.JobCard

@Composable
fun JobsScreen(navController: NavHostController){
    Column(){
        Filters(onClick = {})
        JobList(navController)
    }
}

@Composable
fun JobList(navController: NavHostController){
    val JobList = ListOfJob.list
    LazyColumn(
        modifier = Modifier
            /*.padding(top = filterBarHeight)*/
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(8.dp)
    ) {
        items(JobList.size){
            val job = JobList[it]
            JobCard(
                designation = job.jobDesignation,
                companyName = job.companyName,
                companyIcon = job.companyLogo,
                location = job.jobLocation,
                salary = job.salary,
                requiredExperience = job.requiredExperience,
                jobTag = job.suggestion,
                datePosted = job.datePosted,
                time = job.postedTime,
                activelyHiring = job.activelyHiring,
                onClick = {
                    Log.d("Navigating", "ID:${job.id}, TYPE:${job.opportunityType}")
                    navController.navigate("details"+"/${job.id}/"+job.opportunityType)
                }
            )
        }

    }
}