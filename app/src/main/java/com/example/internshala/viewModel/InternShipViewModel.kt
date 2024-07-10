package com.example.internshala.viewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.dokar.chiptextfield.Chip
import com.dokar.chiptextfield.ChipTextFieldState
import com.dokar.chiptextfield.rememberChipTextFieldState

class InternShipViewModel: ViewModel() {
    var value : MutableState<String> = mutableStateOf("")
    val state : ChipTextFieldState<Chip> = ChipTextFieldState()

}