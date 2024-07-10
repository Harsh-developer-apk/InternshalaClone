package com.example.internshala.ui.screens

import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.compose.material3.Text
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.internshala.R
import com.example.internshala.data.ListOfBasicCourse
import com.example.internshala.data.ListOfPlacementCourses
import com.example.internshala.data.PreferenceList
import com.example.internshala.data.model.TrendingList
import com.example.internshala.ui.composables.BasicCourseCard
import com.example.internshala.ui.composables.BodyText
import com.example.internshala.ui.composables.EmojiView
import com.example.internshala.ui.composables.PlacementCourseCard
import com.example.internshala.ui.composables.SalutationText
import com.example.internshala.ui.composables.SubTitleText
import com.example.internshala.ui.composables.TitleText
import com.example.internshala.ui.composables.TrendingCard
import com.example.internshala.ui.composables.YourPreferenceCard
import com.example.internshala.ui.composables.prefereceJobCard

@Composable
fun HomeScreen(navController: NavHostController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())){
        Greetings(modifier = Modifier.padding(12.dp),text = "Harsh")
        Spacer(modifier = Modifier.height(10.dp))
        TrendingList(modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp))
        Spacer(modifier = Modifier.height(30.dp))
        PreferenceJobSection(
            navController,
            modifier = Modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colorScheme.tertiary))
        Spacer(modifier = Modifier.height(30.dp))
        BasicCourseSection(modifier = Modifier.padding(12.dp))
        Spacer(modifier = Modifier.height(30.dp))
        PlacementCourseSection(modifier = Modifier.padding(12.dp))

    }

}

@Composable
fun TrendingList(modifier:Modifier = Modifier){
    val context = LocalContext.current
    val trendingList = TrendingList.list
    Column(modifier = modifier){
        Row(verticalAlignment = Alignment.CenterVertically) {
            SubTitleText(text = "Trending on Internshala")
            EmojiView(emoji = "\uD83D\uDD25")
        }
        Spacer(modifier = Modifier.height(10.dp))
        LazyRow(modifier = Modifier.fillMaxWidth()) {
            items(trendingList.size){
                val trendingCard = trendingList[it]
                val intent = remember { Intent(Intent.ACTION_VIEW, Uri.parse(trendingCard.url)) }
                TrendingCard(
                    modifier = Modifier
                        .size(height = 260.dp, width = 340.dp)
                        .padding(8.dp)
                        .clickable {
                            context.startActivity(intent)
                        },
                    imageId = trendingCard.imageId ,
                    imageContent = trendingCard.imageDescription)
            }
        }

}
}
@Composable
fun Greetings(modifier:Modifier = Modifier,text:String){
    Column(modifier = modifier){
        Row {
            TitleText(text = "Hi, $text")
            EmojiView(emoji = "\uD83D\uDC4B")
        }
        Spacer(modifier = Modifier.height(10.dp))
        SalutationText(text = "Let's help you land your dream career")
    }
}
@Composable
fun PreferenceJobSection(navController: NavHostController,modifier:Modifier = Modifier){
    Column(modifier = modifier) {
        Spacer(modifier = Modifier.height(20.dp))
        Column(modifier = Modifier.padding(12.dp)) {
            SubTitleText(text = "Recommended for you")
            Spacer(modifier = Modifier.height(10.dp))
            Row {
                BodyText(text = "as per your")
                BodyText(text = " preferences", color = MaterialTheme.colorScheme.primary)
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        PreferenceJobList(navController)
        Spacer(modifier = Modifier.height(30.dp))
    }
}
@Composable
fun PreferenceJobList(navController: NavHostController){
    val listOfPreference = PreferenceList.list
    LazyRow {
        items(listOfPreference.size){
            val preference = listOfPreference[it]
            YourPreferenceCard(
                modifier = Modifier
                    .heightIn(330.dp, 340.dp)
                    .widthIn(310.dp, 320.dp)
                    .padding(12.dp),
                designation = preference.jobDesignation,
                companyName = preference.companyName,
                location = preference.jobLocation,
                duration = preference.duration,
                stipend = preference.stipend,
                onClick = {
                    Log.d("NavigatingFrom", "ID:${preference.id}, TYPE:${preference.opportunityType}")
                    navController.navigate("details"+"/${preference.id}/"+preference.opportunityType)
                }
            )
        }
    }
}
@Composable
fun BasicCourseSection(modifier: Modifier = Modifier){
    val context = LocalContext.current
    val basicCourseList = ListOfBasicCourse.list
    Column(modifier = modifier){
        SubTitleText(text = "Popular Certification courses")
        Spacer(modifier = Modifier.height(20.dp))
        LazyRow(
            modifier = Modifier.fillMaxWidth()
        ){
            items(basicCourseList.size){
                val basicCourse = basicCourseList[it]
                val intent = remember { Intent(Intent.ACTION_VIEW, Uri.parse(basicCourse.courseUrl)) }
                BasicCourseCard(
                    modifier = Modifier
                        .size(height = 270.dp, width = 300.dp)
                        .padding(8.dp),
                    title = basicCourse.courseTitle,
                    imageId = basicCourse.courseImageId,
                    duration = basicCourse.courseDuration,
                    enrolledStudents = basicCourse.enrolledStudent,
                    rating = basicCourse.courseRating,
                    onClick = {
                        context.startActivity(intent)
                    }
                )
            }
        }
    }
}
@Composable
fun PlacementCourseSection(modifier:Modifier){
    val context = LocalContext.current
    val placementCourseList = ListOfPlacementCourses.list
    Column(modifier) {
            SubTitleText(text = "Placement guarantee course")
        Spacer(modifier = Modifier.height(20.dp))
        LazyRow(modifier = Modifier.fillMaxWidth()) {
            items(placementCourseList.size){
                val placementCourse = placementCourseList[it]
                val intent = remember { Intent(Intent.ACTION_VIEW, Uri.parse(placementCourse.courseUrl)) }
                PlacementCourseCard(
                    modifier = Modifier
                        .size(height = 450.dp, width = 330.dp)
                        .padding(12.dp),
                    title = placementCourse.courseTitle,
                    imageId = placementCourse.courseImageId,
                    duration =placementCourse.courseDuration ,
                    income = placementCourse.confirmedSalary,
                    numberOfJobs = placementCourse.numberOfJobs,
                    onClick = {
                        context.startActivity(intent)
                    }
                )
            }
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview(){
    HomeScreen(navController = rememberNavController())
}