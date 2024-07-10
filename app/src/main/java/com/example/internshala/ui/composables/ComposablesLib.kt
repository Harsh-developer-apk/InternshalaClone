package com.example.internshala.ui.composables

import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.automirrored.filled.TrendingUp
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.AutoGraph
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.TrendingUp
import androidx.compose.material.icons.outlined.AccessTime
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.SuggestionChipDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.internshala.R
import com.example.internshala.ui.theme.bgBlue
import com.example.internshala.ui.theme.bgGreen
import com.example.internshala.ui.theme.darkYellow
import com.example.internshala.ui.theme.lightGrey
import com.example.internshala.ui.theme.skyBlue
import com.example.internshala.ui.theme.textBlue
import com.example.internshala.ui.theme.textGreen

@Composable
fun DescriptionText(
    icon: ImageVector,
    text:String,
    textStyle: TextStyle = MaterialTheme.typography.bodyLarge,
    color:Color = MaterialTheme.colorScheme.secondary
){
    Row{
        Icon(
            modifier = Modifier
                .size(20.dp)
                .padding(top = 2.dp, start = 2.dp),
            imageVector = icon ,
            contentDescription = text,
            tint = color
        )
        Spacer(modifier = Modifier.width(5.dp))
        Text(
            text = text,
            style = textStyle,
            color = color
        )
    }
}

@Composable
fun ActivelyHiringChip(){
    AssistChip(
        onClick = {},
        label = { Text(text = "Actively Hiring",style = MaterialTheme.typography.labelSmall)},
        leadingIcon = {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.TrendingUp,
                contentDescription ="Actively hiring",
                tint = skyBlue)
        }
    )
}
@Composable
fun BasicDetails(designation:String,companyName:String,companyIcon:Int? = null){
    Row(modifier = Modifier.fillMaxWidth()){
        Column{
            Text(
                modifier = Modifier
                    .widthIn(min = 200.dp, max = 250.dp)
                    .heightIn(30.dp),
                text = designation,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                modifier = Modifier
                    .widthIn(min = 200.dp, max = 250.dp)
                    .heightIn(30.dp, max = 40.dp),
                text = companyName,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.secondary)

        }
        Spacer(modifier = Modifier.weight(1f))
        if(companyIcon!=null) {
            Image(
                modifier = Modifier
                    .size(50.dp)
                    .padding(top = 8.dp, end = 8.dp),
                painter = painterResource(id = companyIcon),
                contentDescription = "company Name",
                contentScale = ContentScale.Crop
            )
        }
    }
}
@Composable
fun PreferenceBasicDetails(designation:String,companyName:String){
    Row(modifier = Modifier.fillMaxWidth()){
        Column{
            Text(
                modifier = Modifier
                    .widthIn(min = 200.dp, max = 250.dp)
                    .heightIn(30.dp),
                text = designation,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                modifier = Modifier
                    .widthIn(min = 200.dp, max = 250.dp)
                    .heightIn(30.dp, max = 40.dp),
                text = companyName,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.secondary)

        }
        Spacer(modifier = Modifier.weight(1f))
    }
}
@Composable
fun TagChip(
    text:String,
    textColor:Color = MaterialTheme.colorScheme.onSurface,
    backgroundColor:Color = MaterialTheme.colorScheme.onSecondaryContainer){
     SuggestionChip(
         onClick = { /*TODO*/ },
         label = { Text(
             text = text,
             style = MaterialTheme.typography.labelSmall,
             color = textColor,
         )},
         border = BorderStroke(width = 1.dp,color = backgroundColor),
         colors = SuggestionChipDefaults.suggestionChipColors(backgroundColor))
}
@Composable
fun DatePosted(text:String,time:Char){
    val textColor =
        when(time){
            'h' -> textGreen
            'w' -> textBlue
            else -> MaterialTheme.colorScheme.onSurface
        }
    val backgroundColor =
        when(time){
            'h' -> bgGreen
            'w' -> bgBlue
            else -> lightGrey
        }
    SuggestionChip(
        onClick = { /*TODO*/ },
        label = { Text(
            text = text,
            style = MaterialTheme.typography.labelSmall,
            color = textColor
        )},
        icon = {
               Icon(
                   imageVector = Icons.Outlined.AccessTime ,
                   contentDescription = "date posted",
                   tint = textColor )
        },
        border = BorderStroke(width = 1.dp,color = backgroundColor),
        colors = SuggestionChipDefaults.suggestionChipColors(backgroundColor))
}

@Composable
fun ViewDetailsButton(
    text:String,
    onClick:()->Unit){
    Log.d("Navigating", "ViewDetailsButton:$text")
    OutlinedButton(
        onClick = onClick,
        border = BorderStroke(width = 1.dp,color = MaterialTheme.colorScheme.primary),
        shape = RoundedCornerShape(4.dp)
    ) {
        Text(
            text = text,
            color = MaterialTheme.colorScheme.primary)
    }
}
@Composable
fun ApplyButton(
    text:String,
    onClick:()->Unit,
    modifier:Modifier = Modifier){
    Button(
        modifier = modifier,
        onClick =  onClick ,
        shape = RoundedCornerShape(4.dp),
        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary)
        ) {
        Text(
            text = text,
            color = Color.White)
    }
}
@Composable
fun TrendingCard(modifier :Modifier,imageId:Int,imageContent:String){
    Card (
        modifier = modifier,
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ){
        Image(
            painter = painterResource(imageId),
            contentDescription = imageContent,
            contentScale = ContentScale.FillBounds)
    }
}
@Composable
fun EmojiView(
    emoji: String,
) {
    AndroidView(
        factory = { context ->
            AppCompatTextView(context).apply {
                setTextColor(Black.toArgb())
                text = emoji ?: "😟"
                textSize = 26.0F
                textAlignment = View.TEXT_ALIGNMENT_CENTER
            }
        },
        update = {
            it.apply {
                text = emoji ?: "😟"
            }
        },
    )
}
@Composable
fun TitleText(text: String){
    Text(
        text = text,
        style = MaterialTheme.typography.titleLarge,
        fontWeight = FontWeight.Black
    )
}
@Composable
fun BodyText(text: String,
             color: Color=MaterialTheme.colorScheme.secondary) {
    Text(
        text = text,
        style = MaterialTheme.typography.bodyMedium,
        color = color,)
}
@Composable
fun SalutationText(text: String,
             color: Color=MaterialTheme.colorScheme.secondary) {
    Text(
        text = text,
        style = MaterialTheme.typography.displayMedium,
        color = color,)
}
@Composable
fun CardTitle(text: String) {
    Text(
        modifier = Modifier.fillMaxWidth(),
        text = text,
        style = MaterialTheme.typography.displayMedium)
}
@Composable
fun ClickableButton(
    buttonText:String,
    onClick: () -> Unit,
    icon: ImageVector ?= null,
){
    Log.d("Clickable Row","In the clickable row")
    Row(
        modifier = Modifier.clickable(onClick = onClick),
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(
            text = buttonText,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Bold
        )
        if (icon != null) {
            Icon(
                modifier = Modifier.size(15.dp),
                imageVector = icon,
                contentDescription = buttonText,
                tint = MaterialTheme.colorScheme.primary
            )
        }
    }
}
@Composable
fun CourseBasicDetail(
    enrolledStudents:Int,
    rating:Float
){
    Row(modifier = Modifier
        .height(20.dp),
        verticalAlignment = Alignment.CenterVertically){
        Icon(
            modifier = Modifier.size(25.dp),
            imageVector = Icons.Filled.Star ,
            contentDescription = "enrolled students",
            tint = darkYellow
        )
        Spacer(modifier = Modifier.width(1.dp))
        Text(
            text = "$rating",
            color = MaterialTheme.colorScheme.secondary
        )
        Spacer(modifier = Modifier.width(6.dp))
        VerticalDivider(color = MaterialTheme.colorScheme.primary)
        Spacer(modifier = Modifier.width(6.dp))
        Text(
            text = "%,d".format(enrolledStudents),
            color = MaterialTheme.colorScheme.secondary)
    }
}
@Composable
fun SubTitleText(text:String){
    Text(
        text = text,
        style = MaterialTheme.typography.titleMedium
    )
}
@Composable
fun prefereceJobCard(){

}
/*@Preview(showBackground = true)
@Composable
fun ComposablePreview(){
    TagChip(text = "InterShip with job offer")
}*/
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DarkComposablePreview(){
    /*EmojiView(emoji = "\uD83D\uDC4B")*/
    /*CourseBasicDetail(enrolledStudents = 34554, rating =4.1f)*/
    ClickableButton(
        buttonText = "Know more" ,
        onClick = { /*TODO*/ },
        icon = Icons.AutoMirrored.Filled.ArrowForwardIos
    )
}