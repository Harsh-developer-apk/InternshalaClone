package com.example.internshala.ui.screens

import android.widget.Toast
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.CalendarToday
import androidx.compose.material.icons.outlined.Group
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.PlayCircleOutline
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material.icons.outlined.Timer
import androidx.compose.material.icons.outlined.Wallet
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.internshala.data.ListOfInternship
import com.example.internshala.data.ListOfJob
import com.example.internshala.data.model.PlacementDescription
import com.example.internshala.data.model.PlacementOpportunity
import com.example.internshala.ui.composables.ActivelyHiringChip
import com.example.internshala.ui.composables.ApplyButton
import com.example.internshala.ui.composables.BasicDetails
import com.example.internshala.ui.composables.BodyText
import com.example.internshala.ui.composables.CompanyActivityCard
import com.example.internshala.ui.composables.DatePosted
import com.example.internshala.ui.composables.DescriptionText
import com.example.internshala.ui.composables.SubTitleText
import com.example.internshala.ui.composables.TagChip

@Composable
fun DetailScreen(
    navController:NavHostController,
    backStackEntry: NavBackStackEntry){
    val id = backStackEntry.arguments?.getInt("id")
    val type = backStackEntry.arguments?.getString("type")
    val placement = if(type=="job"){
        ListOfJob.list.find { it.id == id }
    }else{
        ListOfInternship.list.find{it.id == id}
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(12.dp)
    ) {
        if (placement != null) {
                JobTitle(
                    modifier = Modifier
                        .fillMaxWidth(),
                    designation = placement.jobDesignation,
                    companyName = placement.companyName,
                    companyIcon = placement.companyLogo,
                    location = placement.jobLocation,
                    duration = placement.duration,
                    stipend = placement.stipend,
                    salary = placement.salary,
                    experience = placement.requiredExperience,
                    datePosted = placement.datePosted,
                    time = placement.postedTime,
                    applicants = placement.jobDescription.applicants,
                    activelyHiring = placement.activelyHiring,
                    placementType = placement.opportunityType,
                    placementTag = placement.suggestion,
                    applyByDate = placement.jobDescription.lastDateToApply,
                )
                Spacer(modifier = Modifier.height(20.dp))
                PlacementDescription(placementDescription = placement )
            }
        }
    }

@Composable
fun JobTitle(
    modifier: Modifier,
    designation: String,
    companyName: String,
    companyIcon:Int? = null,
    location:String,
    applyByDate:String,
    datePosted:String,
    time:Char,
    placementType:String,
    duration:Int? = null,
    stipend:String? = null,
    salary:String? = null,
    experience:String? = null,
    placementTag:String = "placement",
    applicants:Int = 5,
    activelyHiring:Boolean = true,
    ) {
        Column(
            modifier = modifier
        ) {
            if (activelyHiring) {
                ActivelyHiringChip()
            }
            Spacer(modifier = Modifier.height(5.dp))
            BasicDetails(
                designation = designation,
                companyName = companyName,
                companyIcon = companyIcon
            )
            Spacer(modifier = Modifier.height(5.dp))
            DescriptionText(icon = Icons.Outlined.LocationOn, text = location)
            Spacer(modifier = Modifier.height(5.dp))
            Row {
                DescriptionText(
                    icon = Icons.Outlined.PlayCircleOutline,
                    text = "Starts Immediately"
                )
                Spacer(modifier = Modifier.width(10.dp))
                val durationOrExperience = if(placementType=="internship") "$duration Months" else "$experience experience"
                DescriptionText(icon = Icons.Outlined.CalendarToday, text = durationOrExperience)
            }
            Spacer(modifier = Modifier.height(5.dp))
            val income = if(placementType=="internship") "$stipend/month" else salary
            DescriptionText(icon = Icons.Outlined.Wallet, text = "$ $income")
            Spacer(modifier = Modifier.height(5.dp))
            DescriptionText(
                icon =Icons.Outlined.Timer ,
                text ="Apply by $applyByDate")
            Spacer(modifier = Modifier.height(5.dp))
            TagChip(text = placementTag)
            Spacer(modifier = Modifier.height(2.dp))
            DatePosted(text = datePosted, time = time)
            Spacer(modifier = Modifier.height(10.dp))
            Row {
                DescriptionText(
                    icon = Icons.Outlined.Group,
                    text = "$applicants applicants"
                )
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Outlined.BookmarkBorder,
                    contentDescription = "bookmark",
                    tint = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.width(16.dp))
                Icon(
                    imageVector = Icons.Outlined.Share,
                    contentDescription = "bookmark",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            HorizontalDivider()
        }
    }
@Composable
fun PlacementDescription(placementDescription: PlacementOpportunity){
    Column {
        SubTitleText(text = "About ${placementDescription.companyName}")
        Spacer(modifier = Modifier.height(10.dp))
        BodyText(text = stringResource(placementDescription.jobDescription.aboutEmployer))
        Spacer(modifier = Modifier.height(10.dp))
        CompanyActivityCard(placementDescription = placementDescription.jobDescription)
        Spacer(modifier = Modifier.height(20.dp))
        val placement = if(placementDescription.opportunityType=="internship") "Internship" else "Job"
        SubTitleText(text = "About the $placement")
        Spacer(modifier = Modifier.height(5.dp))
        BodyText(text = stringResource(placementDescription.jobDescription.aboutPlacement))
        Spacer(modifier = Modifier.height(10.dp))
        SubTitleText(text = "Skill(s) required")
        Spacer(modifier = Modifier.height(5.dp))
        Text("Currently Working on this feature")
        Spacer(modifier = Modifier.height(10.dp))
        SubTitleText(text = "Who can apply")
        Spacer(modifier = Modifier.height(5.dp))
        BodyText(text = stringResource(placementDescription.jobDescription.eligibility))
        Spacer(modifier = Modifier.height(10.dp))
        SubTitleText(text = "Number of openings")
        Spacer(modifier = Modifier.height(5.dp))
        BodyText(text = "${placementDescription.jobDescription.numberOfOpenings}")
        Spacer(modifier = Modifier.height(10.dp))
        SubTitleText(text = "Additional Information")
        Spacer(modifier = Modifier.height(5.dp))
        BodyText(text = stringResource(placementDescription.jobDescription.additionalInformation))
        Spacer(modifier = Modifier.height(10.dp))
        val context =  LocalContext.current
        ApplyButton(
            text = "Apply Now",
            modifier = Modifier.fillMaxWidth(),
            onClick = {Toast.makeText(context, "This is a clone app you will not get placed by it!", Toast.LENGTH_LONG).show()}
        )
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DetailScreenPreview(){
    /*PlacementDescription(placementDescription = ListOfInternship.list[7])*/
    /*CompanyActivityCard(placementDescription = ListOfInternship.list[7].jobDescription)*/
}
