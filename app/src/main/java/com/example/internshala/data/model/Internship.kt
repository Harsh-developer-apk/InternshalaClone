package com.example.internshala.data.model

data class Internship(
    val id:Int,
    val jobDesignation:String,
    val companyName:String,
    val companyLogo:Int? = null,
    val jobDescription:PlacementDescription,
    val jobLocation:String,
    val activelyHiring:Boolean = false,
    val duration:Int = 6,
    val stipend:String,
    val suggestion:String = "Internship",
    val postedTime:Char = 'h',
    val datePosted:String = "3 days ago",
    val opportuntyType:String = "internship"
    )
