package com.example.internshala.nav

import android.provider.CalendarContract
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsEndWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Approval
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Flight
import androidx.compose.material.icons.filled.QuestionMark
import androidx.compose.material.icons.filled.ScreenSearchDesktop
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Tv
import androidx.compose.material.icons.filled.Work
import androidx.compose.material.icons.outlined.ChatBubbleOutline
import androidx.compose.material.icons.outlined.Tv
import androidx.compose.material.icons.outlined.Work
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.internshala.R
import com.example.internshala.ui.composables.ApplicationContainer
import com.example.internshala.ui.theme.INTERNSHALATheme
import com.example.internshala.ui.theme.darkYellow
import com.example.internshala.ui.theme.nunitoFont
import com.example.internshala.ui.theme.skyBlue
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun NavDrawerLayout(){
    Column(modifier = Modifier.padding(12.dp)){
        ExitButton()
        ProfileSection()
        Spacer(modifier = Modifier.height(10.dp))
        HorizontalDivider(color = MaterialTheme.colorScheme.secondary)
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState())
        ) {
            ExploreSection()
            HelpAndSupportSection()
        }
    }
}
@Composable
fun ExitButton(){
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ){
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Default.Clear ,
                contentDescription = "exit navigation drawer")
        }
    }
}
@Composable
fun ProfileSection(){
    Column(modifier = Modifier
       // .fillMaxWidth()
             ) {
        Row {
            Column(modifier = Modifier) {
                Row {
                    Text(
                        modifier = Modifier.align(Alignment.CenterVertically),
                        text = "Harsh Sharma",
                        style = MaterialTheme.typography.displayMedium,
                       // fontFamily = nunitoFont,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    OutlinedButton(
                        modifier = Modifier,
                        contentPadding = PaddingValues(4.dp),
                        onClick = { /*TODO*/ },
                    ) {
                        Icon(
                            modifier = Modifier.size(ButtonDefaults.IconSize),
                            imageVector = Icons.Default.Star,
                            contentDescription = "Rating",
                            tint = darkYellow
                        )
                        Text(text = "4.1",
                            style = MaterialTheme.typography.bodySmall)
                        Icon(
                            modifier = Modifier.size(ButtonDefaults.IconSize),
                            imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                            contentDescription = "Arrow"
                        )
                    }
                }
                // Spacer(modifier = Modifier.height(5.dp))
                Row {
                    Text(
                        text = "harsh.sh.3878@gmail.com",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.secondary
                    )
                }
            }
            //Spacer(modifier = Modifier.weight(1f))
        }
        Spacer(modifier = Modifier.height(15.dp))
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    IconButton(
                        modifier = Modifier
                            .background(shape = RoundedCornerShape(50), color = MaterialTheme.colorScheme.primary),
                        onClick = { /*TODO*/ }) {
                        Icon(
                            modifier = Modifier,
                            imageVector = Icons.Filled.Book,
                            contentDescription = "Applications",
                            tint = Color.White
                        )
                    }
                    Text("Preferences",style = MaterialTheme.typography.bodyMedium)
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    IconButton(
                        modifier = Modifier
                            .background(shape = RoundedCornerShape(50), color = MaterialTheme.colorScheme.primary),
                        onClick = { /*TODO*/ }) {
                        Icon(
                            modifier = Modifier,
                            imageVector = Icons.Filled.Book,
                            contentDescription = "Applications",
                            tint = Color.White
                        )
                    }
                    Text("Resume",style = MaterialTheme.typography.bodyMedium)
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    IconButton(
                        modifier = Modifier
                            .background(shape = RoundedCornerShape(50), color = MaterialTheme.colorScheme.primary),
                        onClick = { /*TODO*/ }) {
                        Icon(
                            modifier = Modifier,
                            imageVector = Icons.Filled.Book,
                            contentDescription = "Applications",
                            tint = Color.White
                        )
                    }
                    Text("Applications",style = MaterialTheme.typography.bodyMedium)
                }
            }
        }
    }
    }
@Composable
fun ExploreSection(){
    Column{
        Spacer(modifier = Modifier.height(15.dp))
        Text("EXPLORE",style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.secondary)
        IconWithText(imageVector = Icons.Filled.Book,"Internships")
        IconWithText(imageVector = Icons.Outlined.Work,"Jobs")
        IconWithText(imageVector = Icons.Outlined.Tv,"Courses")
        IconWithText(imageVector = Icons.Filled.Tv,"Placement Guarantee Courses")
        IconWithText(imageVector = Icons.Filled.Flight,"Study Abroad")
        IconWithText(imageVector = Icons.Filled.AccountBalance,"Study in India")
        IconWithText(imageVector = Icons.Filled.ScreenSearchDesktop,"Online Degree")

    }
}
@Composable
fun HelpAndSupportSection() {
    Column {
        Spacer(modifier = Modifier.height(15.dp))
        Text("HELP & SUPPORT", style =MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.secondary)
        IconWithText(imageVector = Icons.Filled.QuestionMark, "Help Center")
        IconWithText(imageVector = Icons.Outlined.ChatBubbleOutline, "Report a Complaint")
        IconWithText(imageVector = Icons.Filled.Add,"More")
    }
}
@Composable
fun IconWithText(imageVector: ImageVector,title:String){
    Row(
        modifier = Modifier.padding(top = 10.dp,end = 10.dp),horizontalArrangement = Arrangement.Start){
        Icon(imageVector = imageVector,
            contentDescription =title,
            tint = MaterialTheme.colorScheme.secondary)
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = title,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.secondary)
    }
}
@Composable
fun testing(){
        IconButton(
            modifier = Modifier.background(shape = RoundedCornerShape(50),color = skyBlue),
            onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Filled.Book,
                contentDescription = "Applications",
                tint = Color.White
            )
        }
}

@Preview(showBackground = true, showSystemUi = false)
@Composable
fun ComposablePreview() {
    INTERNSHALATheme {
        /*IconWithText(Icons.Default.Approval,"Application")*/
        NavDrawerLayout()
    }
}

