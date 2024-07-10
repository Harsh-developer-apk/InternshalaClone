package com.example.internshala.data.model

data class PlacementOpportunity(
    val id:Int,
    val opportunityType:String,
    val jobDesignation:String,
    val companyName:String,
    val jobDescription:PlacementDescription,
    val jobLocation:String,
    val companyLogo:Int? = null,
    val stipend:String? = null,
    val salary:String? = null,
    val requiredExperience:String? = null,
    val activelyHiring:Boolean = false,
    val duration:Int = 6,
    val suggestion:String = "Internship",
    val postedTime:Char = 'h',
    val datePosted:String = "3 days ago",
)
