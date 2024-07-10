package com.example.internshala.ui.screens

import android.util.Log
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.AssistChip
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.dokar.chiptextfield.Chip
import com.dokar.chiptextfield.ChipTextFieldState
import com.dokar.chiptextfield.m3.ChipTextField
import com.dokar.chiptextfield.rememberChipTextFieldState
import com.example.internshala.R
import com.example.internshala.data.ListOfInternship
import com.example.internshala.ui.composables.InternshipCard
import com.example.internshala.ui.composables.ViewDetailsButton
import com.example.internshala.viewModel.InternShipViewModel


@Composable
fun InternshipScreen(
    navController: NavHostController,
    modifier:Modifier = Modifier,
    viewModel:InternShipViewModel = InternShipViewModel()
){
    var showSheet by remember { mutableStateOf(false) }

    if (showSheet) {
        BottomSheet {
            showSheet = false
        }
    }
    Column(modifier){
        Filters(onClick = {showSheet = true})

        InternshipList(navController)
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet(onDismiss: () -> Unit) {
    val modalBottomSheetState = rememberModalBottomSheetState()
    ModalBottomSheet(
        modifier = Modifier.fillMaxSize(),
        onDismissRequest = onDismiss,
        sheetState = modalBottomSheetState,
        dragHandle = {BottomSheetDefaults.DragHandle()}
    ) {
        var value by remember { mutableStateOf("") }
        val state = rememberChipTextFieldState<Chip>()
        ChipTextField(
            state = state,
            value = value,
            onValueChange = { value = it },
            onSubmit = { text -> Chip(text) },
            placeholder = {Text("Profile")}
        )
        ViewDetailsButton(text = "Clear Filters") {
            value = ""
        }
    }

}

@Composable
fun InternshipList(navController: NavHostController){
    val internshipList = ListOfInternship.list
    LazyColumn(
        modifier = Modifier
            /*.padding(top = filterBarHeight)*/
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(8.dp)
    ) {
        items(internshipList.size){
            val internship = internshipList[it]
                InternshipCard(
                    designation = internship.jobDesignation,
                    companyName = internship.companyName,
                    companyIcon = internship.companyLogo,
                    location = internship.jobLocation,
                    duration = internship.duration,
                    stipend = internship.stipend,
                    internshipTag = internship.suggestion,
                    datePosted = internship.datePosted,
                    time = internship.postedTime,
                    activelyHiring = internship.activelyHiring,
                    onClick = {
                        Log.d("NavigatingFromInternShip", "ID:${internship.id}, TYPE:${internship.opportunityType}")
                        navController.navigate("details"+"/${internship.id}/"+internship.opportunityType)
                    }
                )
            }
        }

    }

@Composable
fun Filters(onClick: () -> Unit){
    Row{
        AssistChip(
            modifier = Modifier
                .padding(4.dp),
            onClick = onClick,
            label = { Text("All Filters") }
        )
        Row(modifier = Modifier
            .padding(4.dp)
            .horizontalScroll(rememberScrollState())
            .fillMaxWidth()){

        }
    }
}
@Preview(showBackground = true)
@Composable
fun InternshipScreenPreview(){
    InternshipScreen(navController = rememberNavController())
}