package com.example.internshala.ui.composables

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.outlined.AccessTime
import androidx.compose.material.icons.outlined.CalendarToday
import androidx.compose.material.icons.outlined.EditCalendar
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.PersonAddAlt1
import androidx.compose.material.icons.outlined.PlayCircleOutline
import androidx.compose.material.icons.outlined.PostAdd
import androidx.compose.material.icons.outlined.Wallet
import androidx.compose.material.icons.outlined.Work
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.internshala.R
import androidx.compose.material3.Text
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.internshala.data.model.BasicCourse
import com.example.internshala.data.model.PlacementDescription
import com.example.internshala.nav.IconWithText
import com.example.internshala.ui.theme.darkYellow
import com.example.internshala.ui.theme.lightYellow

@Composable
fun InternshipCard(
    designation: String,
    companyName: String,
    companyIcon:Int? = null,
    location:String,
    duration:Int,
    onClick: () -> Unit,
    stipend:String? = null,
    internshipTag:String = "Internship",
    datePosted:String,
    time:Char,
    activelyHiring:Boolean = true,

){
    Card(
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.background),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RectangleShape
    ){
        val context = LocalContext.current
        Column(modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(8.dp)){
            if(activelyHiring){ ActivelyHiringChip() }
            Spacer(modifier = Modifier.height(5.dp))
            BasicDetails(
                designation = designation,
                companyName = companyName,
                companyIcon = companyIcon)
            Spacer(modifier = Modifier.height(5.dp))
            DescriptionText(icon = Icons.Outlined.LocationOn, text = location)
            Spacer(modifier = Modifier.height(5.dp))
            Row{
                DescriptionText(icon = Icons.Outlined.PlayCircleOutline, text ="Starts Immediately")
                Spacer(modifier = Modifier.width(10.dp))
                DescriptionText(icon = Icons.Outlined.CalendarToday, text ="$duration Months")
            }
            Spacer(modifier = Modifier.height(5.dp))
            DescriptionText(icon = Icons.Outlined.Wallet, text ="$ $stipend/month")
            Spacer(modifier = Modifier.height(5.dp))
            TagChip(text = internshipTag)
            Spacer(modifier = Modifier.height(5.dp))
            DatePosted(text = datePosted , time =time )
            Spacer(modifier = Modifier.height(5.dp))
            HorizontalDivider()
            Spacer(modifier = Modifier.height(5.dp))
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ){
                ViewDetailsButton(text = "View Details",onClick = onClick)
                Spacer(modifier = Modifier.width(5.dp))
                ApplyButton(
                    text = "Apply now",
                    onClick = { Toast.makeText(context, "This is a clone app you will not get placed by it!", Toast.LENGTH_LONG).show()}
                )
            }
        }
    }
}
@Composable
fun JobCard(
    designation: String,
    companyName: String,
    companyIcon:Int? = null,
    location:String,
    requiredExperience:String? = null,
    salary:String? = null,
    jobTag:String = "Job",
    datePosted:String,
    time:Char,
    activelyHiring:Boolean = true,
    onClick: () -> Unit
){
    Card(
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surface),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RectangleShape
    ){
        val context = LocalContext.current
        Column(modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(8.dp)){
            if(activelyHiring){ ActivelyHiringChip() }
            Spacer(modifier = Modifier.height(5.dp))
            BasicDetails(
                designation = designation,
                companyName = companyName,
                companyIcon = companyIcon)
            Spacer(modifier = Modifier.height(5.dp))
            DescriptionText(icon = Icons.Outlined.LocationOn, text = location)
            Spacer(modifier = Modifier.height(5.dp))
            DescriptionText(icon = Icons.Outlined.Wallet, text ="$ $salary/year")
            Spacer(modifier = Modifier.height(5.dp))
            DescriptionText(icon = Icons.Outlined.PlayCircleOutline, text ="$requiredExperience experience")
            Spacer(modifier = Modifier.height(5.dp))
            TagChip(text = jobTag)
            Spacer(modifier = Modifier.height(5.dp))
            DatePosted(text = datePosted , time =time )
            Spacer(modifier = Modifier.height(5.dp))
            HorizontalDivider()
            Spacer(modifier = Modifier.height(5.dp))
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ){
                ViewDetailsButton(text = "View Details",onClick = onClick)
                Spacer(modifier = Modifier.width(5.dp))
                ApplyButton(
                    text = "Apply now",
                    onClick = { Toast.makeText(context, "This is a clone app you will not get placed by it!", Toast.LENGTH_LONG).show()}
                )

            }
        }
    }
}
@Composable
fun PlacementCourseCard(
    modifier: Modifier,
    title:String,
    imageId:Int,
    duration:Int,
    income:String,
    numberOfJobs:String,
    onClick: () -> Unit = {}
){
    Card(
        modifier = modifier,
        shape =  RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(2.dp)
    ){
        Column(modifier = Modifier.fillMaxSize()) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.3f),
                painter = painterResource(id = imageId),
                contentDescription = "",
                contentScale = ContentScale.FillWidth
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = MaterialTheme.colorScheme.background)
                    .padding(12.dp)){
                Spacer(modifier = Modifier.height(10.dp))
                CardTitle(text = title)
                Spacer(modifier = Modifier.height(8.dp))
                TagChip(
                    text = "course with guarantee job",
                    textColor = darkYellow,
                    backgroundColor = lightYellow)
                Spacer(modifier = Modifier.height(12.dp))
                DescriptionText(
                    icon=Icons.Outlined.AccessTime,
                    text = "$duration months course",
                    textStyle = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.height(12.dp))
                DescriptionText(
                    icon =Icons.Outlined.Wallet,
                    text = income,
                    textStyle = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.height(12.dp))
                DescriptionText(
                    icon =Icons.Outlined.Work,
                    text = numberOfJobs,
                    textStyle = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.weight(1f))
                ClickableButton(
                    buttonText = "Know more",
                    onClick = onClick,
                    icon = Icons.AutoMirrored.Filled.ArrowForwardIos
                )
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}
@Composable
fun YourPreferenceCard(
    modifier:Modifier,
    designation: String,
    companyName: String,
    location:String,
    duration:Int,
    stipend:String? = null,
    onClick:()->Unit,
    activelyHiring:Boolean = true,
){
    Card(
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.background),
        modifier = modifier,
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(16.dp)
    ){
        Column(modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(12.dp)){
            Column(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.45f)) {
                if (activelyHiring) {
                    ActivelyHiringChip()
                }
                Spacer(modifier = Modifier.height(5.dp))
                PreferenceBasicDetails(
                    designation = designation,
                    companyName = companyName
                )
                Spacer(modifier = Modifier.weight(1f))
                HorizontalDivider(
                    color = MaterialTheme.colorScheme.secondary,
                    thickness = 0.5f.dp)
            }
            Spacer(modifier = Modifier.height(15.dp))
            DescriptionText(icon = Icons.Outlined.LocationOn, text = location)
            Spacer(modifier = Modifier.height(10.dp))
            DescriptionText(icon = Icons.Outlined.Wallet, text ="$ $stipend/month")
            Spacer(modifier = Modifier.height(10.dp))
            DescriptionText(icon = Icons.Outlined.CalendarToday, text ="$duration Months")
            Spacer(modifier = Modifier.weight(1f))
            ClickableButton(
                buttonText = "View details",
                onClick =  onClick,
                icon = Icons.AutoMirrored.Filled.ArrowForwardIos)
            }
        }
    }
@Composable
fun BasicCourseCard(
    modifier: Modifier,
    title:String,
    imageId:Int,
    duration:String,
    enrolledStudents:Int,
    rating:Float,
    onClick:()->Unit = {}
){
    Card(
        modifier = modifier,
        shape =  RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(2.dp)
    ){
        Column(modifier = Modifier.fillMaxSize()) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.4f),
                painter = painterResource(id = imageId),
                contentDescription = "",
                contentScale = ContentScale.FillWidth
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = MaterialTheme.colorScheme.background)
                    .padding(12.dp)){
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = duration,
                style = MaterialTheme.typography.displaySmall,
                color = MaterialTheme.colorScheme.secondary
            )
            Spacer(modifier = Modifier.height(5.dp))
            CardTitle(text = title)
            Spacer(modifier = Modifier.height(8.dp))
            CourseBasicDetail(
                enrolledStudents = enrolledStudents,
                rating = rating
            )
            Spacer(modifier = Modifier.height(20.dp))
            ClickableButton(
                buttonText = "Know more",
                onClick = onClick,
                icon = Icons.AutoMirrored.Filled.ArrowForwardIos
            )
                Spacer(modifier = Modifier.height(10.dp))
        }
        }
    }
}
@Composable
fun CompanyActivityCard(placementDescription: PlacementDescription,modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(1.dp),
        shape = RoundedCornerShape(4.dp),
        border = BorderStroke(width = 0.dp, color = MaterialTheme.colorScheme.secondary),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surface)
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
            .padding(12.dp)) {
            Text("Activity on Internshala",
                fontSize = 20.sp, color = MaterialTheme.colorScheme.secondary,
                fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(5.dp))
            DescriptionText(
                icon = Icons.Outlined.EditCalendar,
                text = placementDescription.companyRegistrationDate)
            Spacer(modifier = Modifier.height(5.dp))
            DescriptionText(
                icon = Icons.Outlined.PostAdd,
                text = "${placementDescription.postedOpportunities} opportunities posted")
            Spacer(modifier = Modifier.height(5.dp))
            DescriptionText(
                icon = Icons.Outlined.PersonAddAlt1,
                text = "${placementDescription.hiredCandidates} candidates hired")
            Spacer(modifier = Modifier.height(5.dp))

        }
    }
}
@Preview(showBackground = true)
@Composable
fun CardPreview(){
   /* YourPreferenceCard(
        designation = "Stripper in the bar",
        companyName = "Swiggy",
        activelyHiring = true,
        location = "Delhi",
        duration = 3,
        stipend = "20,000",
        modifier = Modifier.padding(12.dp)
    )*/
    PlacementCourseCard(
        title = "Full Stack Development Course",
        imageId = R.drawable.full_stack_course,
        numberOfJobs = "1.08 Lac job/internship opportunities",
        income = "Confirmed 4 LPA salary",
        duration = 8,
        modifier = Modifier
            .heightIn(300.dp)
            .widthIn(200.dp)
            .padding(12.dp)
    )
}