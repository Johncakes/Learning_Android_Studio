package com.example.pettracker.ui
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pettracker.R
import com.example.pettracker.data.TimerData
import com.example.pettracker.ui.theme.PetTrackerTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App() {

    val timers = remember { mutableStateListOf<TimerData>() }
    var nextId by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(
                    text = " ",
                    color = MaterialTheme.colorScheme.onSurface
                )},
                navigationIcon = { /*TODO*/ },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surfaceContainerHigh,
                ),
            )
        },
        floatingActionButton = {
            Box(){
                FloatingActionButton(
                    onClick = { },
                    modifier = Modifier.align(Alignment.BottomEnd)
                ){
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add"
                    )
                }
            }
        }
    ) {
        Surface(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.surface)
                .fillMaxSize()
                .padding(it)

        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ){
                TimerList(timers,modifier = Modifier)
            }
        }
    }
}

@Composable
fun TimerList(timers : List<TimerData>, modifier: Modifier){
   LazyColumn(
       modifier = Modifier
           .fillMaxWidth()
   ){
    items(timers){timer ->
    TimerInfo(
        modifier = Modifier.padding(bottom = 8.dp),
        timerData = timer
    )
}
   }
}

@Composable
fun TimerInfo(timerData : TimerData, modifier: Modifier){
    Column (
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clip(MaterialTheme.shapes.medium)
            .background(MaterialTheme.colorScheme.surfaceContainerHigh)
            .padding(8.dp)
    ){
        TimerPlayerInfo(
            playerName = timerData.playerName,
            playerImage = R.drawable.peticon,
            modifier = Modifier
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ){
            TimerPetInfo(
                onClick = { /*TODO*/ },
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(8.dp))
            TimerPetInfo(
                onClick = { /*TODO*/ },
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun TimerPlayerInfo(playerName: String, playerImage: Int, modifier: Modifier) {
    Row(
        modifier = modifier.padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Card(
            modifier = Modifier,
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceContainerLowest
            )
        ){
            Image(
                painter = painterResource(id = playerImage),
                contentDescription = "Pet Icon",
                modifier = Modifier
                    .size(48.dp)
                    .padding(8.dp),
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = playerName)
    }
}

@Composable
fun TimerPetInfo(onClick: () -> Unit, modifier: Modifier) {
    var checked by remember { mutableStateOf(false) }
    Row(
        modifier = modifier
            .clip(MaterialTheme.shapes.medium)
            .background(MaterialTheme.colorScheme.secondaryContainer)
            .padding(8.dp)
            .clickable { onClick() }
            ,

        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Card(
            modifier = Modifier,
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceContainerLowest
            )
        ) {
            Image(
                painter = painterResource(id = R.drawable.peticon),
                contentDescription = "Pet Icon",
                modifier = Modifier
                    .size(48.dp)
                    .padding(8.dp),
            )
        }
        Spacer(modifier = Modifier.width(4.dp))
        Text(buildAnnotatedString {
            append("13:57")
            withStyle(style = SpanStyle(fontSize = 12.sp)) {
                append("PM")
            }
        })
        Switch(
            checked = checked,
            onCheckedChange = {
                checked = it
            },
            modifier = Modifier.scale(0.6f),
            colors = SwitchDefaults.colors(
                checkedThumbColor = MaterialTheme.colorScheme.primary,
                checkedTrackColor = MaterialTheme.colorScheme.primaryContainer,
                uncheckedThumbColor = MaterialTheme.colorScheme.secondary,
                uncheckedTrackColor = MaterialTheme.colorScheme.secondaryContainer,
            )
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PetTrackerTheme {
        App()
    }
}
