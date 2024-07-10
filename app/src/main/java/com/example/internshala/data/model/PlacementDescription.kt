package com.example.internshala.data.model

import androidx.annotation.StringRes

data class PlacementDescription(
@StringRes    val aboutPlacement:Int,
@StringRes    val aboutEmployer:Int,
@StringRes    val eligibility:Int,
@StringRes    val additionalInformation:Int = 0,
val perks:List<String> = emptyList(),
val requiredSkills:List<String> = emptyList(),
val numberOfOpenings:Int = 1,
val companyRegistrationDate:String = "",
val postedOpportunities:Int  = 1,
val hiredCandidates:Int = 1,
val applicants:Int =  1,
val lastDateToApply:String = "",
)
