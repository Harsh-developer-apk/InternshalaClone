package com.example.internshala.data.model

data class BasicCourse(
    val id:Int,
    val courseTitle:String,
    val courseDuration:String,
    val courseRating:Float,
    val enrolledStudent:Int,
    val courseImageId:Int,
    val courseUrl:String = ""
)
