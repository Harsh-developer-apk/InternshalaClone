package com.example.internshala.data.model

import com.example.internshala.R

data class TrendingCard(
    val imageId:Int,
    val imageDescription: String,
    val url:String = ""
)

object TrendingList{
    val list = listOf(
        TrendingCard(
            imageId = R.drawable.certification_course,
            imageDescription = "certification course",
            url = "https://trainings.internshala.com/?utm_source=is_web_custom_homepage_banner#certification-courses-section"),
        TrendingCard(imageId = R.drawable.super_skills,
            imageDescription = "Super skills course",
            url = "https://trainings.internshala.com/?utm_source=is_web_hp_banner_superskills_ext_july24&payment_source=hp_banner_superskills_ext_july24"),
        TrendingCard(R.drawable.mahindra_logistic,"Mahindra logistics","https://internshala.com/mahindra-logistic/"),
        TrendingCard(R.drawable.mba_internshala,"Study abroad","https://internshala.com/studyabroad/"),
        TrendingCard(R.drawable.intern_swiggy,"Intern at swiggy","https://internshala.com/intern-with-swiggy-june24/"),
        TrendingCard(R.drawable.job_trending,"Naukri ki tension khatam","https://internshala.com/jobs/"),
        TrendingCard(R.drawable.international_remote,"International Remote Internship","https://internshala.com/internships/international-internship/"),
    )
}
