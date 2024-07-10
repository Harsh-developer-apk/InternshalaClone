package com.example.internshala.ui.screens

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.dokar.chiptextfield.Chip
import com.dokar.chiptextfield.ChipTextFieldState
import com.dokar.chiptextfield.m3.OutlinedChipTextField
import com.dokar.chiptextfield.rememberChipTextFieldState
import com.example.internshala.ui.theme.INTERNSHALATheme
import com.example.internshala.ui.theme.skyBlue


private class CollapsingAppBarNestedScrollConnection(
    val appBarMaxHeight: Int
) : NestedScrollConnection {

    var filterBarOffset: Int by mutableIntStateOf(0)
        private set

    override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
        val delta = available.y.toInt()
        val newOffset = filterBarOffset + delta
        val previousOffset = filterBarOffset
        filterBarOffset = newOffset.coerceIn(-appBarMaxHeight, 0)
        val consumed = filterBarOffset - previousOffset
        return Offset(0f, consumed.toFloat())
    }
}
@Composable
fun NotUsedInternshipScreen(modifier: Modifier = Modifier){

    val profileState = rememberChipTextFieldState<Chip>()
    val cityState = rememberChipTextFieldState<Chip>()
    val filterBarHeight = 260.dp
    val filterBarOffset by remember { mutableIntStateOf(0) }
    val appBarMaxHeightPx = with(LocalDensity.current) { filterBarHeight.roundToPx() }
    val connection = remember(appBarMaxHeightPx) {
        CollapsingAppBarNestedScrollConnection(appBarMaxHeightPx)
    }
    val density = LocalDensity.current
    val spaceHeight by remember(density) {
        derivedStateOf {
            with(density) {
                (appBarMaxHeightPx + connection.filterBarOffset).toDp()
            }
        }
    }
    Box(
        modifier = Modifier
            .nestedScroll(connection)
            .fillMaxSize()
            .padding(12.dp)
    ) {
        Column {
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(spaceHeight)
            )
            //Spacer(modifier = Modifier.height(10.dp))
            FilterList(profileState = profileState , cityState = cityState)
            LazyColumn(
                modifier = Modifier
                    /*.padding(top = filterBarHeight)*/
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {
                items(100) {
                    Text(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                        text = "Item $it"
                    )
                }
            }
        }
        SearchBar(
            profileState =profileState,
            cityState = cityState,
            modifier = Modifier
                .offset { IntOffset(0, connection.filterBarOffset) }
                .fillMaxWidth())
    }
    }


@Composable
fun SearchBar(
    profileState: ChipTextFieldState<Chip>,
    cityState: ChipTextFieldState<Chip>,
    modifier: Modifier){
    var profile by remember { mutableStateOf("") }
    var city by remember { mutableStateOf("") }
    Column(modifier = modifier) {
        Spacer(modifier = Modifier.height(5.dp))
            OutlinedChipTextField(
                //modifier = Modifier.padding(8.dp),
                state = profileState,
                value = profile,
                onValueChange = { profile = it },
                onSubmit = { text -> Chip(text) },
                innerModifier = Modifier
                    .padding(1.dp)
                    .height(60.dp)
                    .verticalScroll(state = rememberScrollState()),
                placeholder = {
                        Text("Enter Profile")
                              },
                chipVerticalSpacing = 2.dp,
                chipHorizontalSpacing = 2.dp,
                leadingIcon = {
                    Icon(
                        imageVector =Icons.Outlined.Person,
                        contentDescription ="profile icon")
                }

            )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedChipTextField(
            //  modifier = Modifier.padding(8.dp).fillMaxWidth(),
            state = cityState,
            value = city,
            onValueChange = { city = it },
            onSubmit = { text -> Chip(text) },
            innerModifier = Modifier
                .height(60.dp)
                .verticalScroll(state = rememberScrollState()),
            placeholder = { Text("Enter City") },
            chipVerticalSpacing = 2.dp,
            chipHorizontalSpacing = 2.dp,
            leadingIcon = {
                Icon(
                    imageVector =Icons.Outlined.LocationOn,
                    contentDescription ="city icon")
            }

        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp, bottom = 5.dp),
            horizontalArrangement = Arrangement.Center) {
            Button(
                modifier = Modifier.padding(start = 8.dp,end = 8.dp),
                shape = RectangleShape,
                colors = ButtonDefaults.buttonColors(skyBlue),
                onClick = { /*TODO*/ }) {
                Text("Search")
            }
        }
    }
}
@Composable
fun FilterList(profileState: ChipTextFieldState<Chip>,cityState: ChipTextFieldState<Chip>){
    Row{
        AssistChip(
            modifier = Modifier
                .padding(4.dp),
            onClick = {},
            label = { Text("All Filters") }
        )
    Row(modifier = Modifier
        .padding(4.dp)
        .horizontalScroll(rememberScrollState())
        .fillMaxWidth()){
        //val chipText = mutableListOf("")
            FilterChips(state = profileState)
        if(cityState.chips.isNotEmpty()){
            FilterChips(state = cityState)}
    }
    }

}
@Composable
fun FilterChips(state: ChipTextFieldState<Chip>){
    state.chips.forEach { chip ->
        val selected  = remember{mutableStateOf(true)}
        InputChip(
            modifier = Modifier.padding(start = 4.dp,end = 4.dp),
            selected = selected.value,
            onClick = { selected.value = !selected.value },
            label = { Text(text = chip.text) }
        )
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    INTERNSHALATheme {
        NotUsedInternshipScreen(modifier = Modifier
            .fillMaxSize()
            .padding(12.dp))
    }
}