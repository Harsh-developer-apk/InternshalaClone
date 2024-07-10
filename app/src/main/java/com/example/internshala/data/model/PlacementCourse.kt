package com.example.internshala.data.model

data class PlacementCourse(
    val id:Int,
    val courseTitle:String,
    val courseDuration:Int,
    val confirmedSalary:String,
    val numberOfJobs:String,
    val courseImageId:Int,
    val courseUrl:String = "",
    val internshipGuarantee:Boolean = false
)
