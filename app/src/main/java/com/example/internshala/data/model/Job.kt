package com.example.internshala.data.model

data class Job(
    val id:Int,
    val jobDesignation:String,
    val companyName:String,
    val companyLogo:Int,
    val requiredExperience:String,
    val jobDescription:List<PlacementDescription> = emptyList(),
    val jobLocation:String,
    val activelyHiring:Boolean = false,
    val salary:String,
    val suggestion:String = "Job",
    val postedTime:Char = 'h',
    val datePosted:String = "3 days ago"
)
