package com.example.jetpackcomposeexampletest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposeexampletest.ui.theme.JetpackComposeExampleTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeExampleTestTheme {
                Surface (modifier = Modifier.fillMaxSize()){
                    Base()
                }
            }
        }
    }
}

@Composable
fun Base( modifier: Modifier = Modifier) {
    Column(modifier.fillMaxSize()){
        Image(
            painter = painterResource(id = R.drawable.bg_compose_background),
            contentDescription = null
        )
        Text(
            text = stringResource(R.string.Title),
            modifier = modifier.padding(16.dp),
            fontSize = 24.sp
        )
        Text(
            text = stringResource(R.string.Summary),
            modifier = modifier.padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify
        )
        Text(
            text = stringResource(R.string.Explanation),
            modifier = modifier.padding(16.dp),
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun CheckMark( modifier: Modifier = Modifier){
    Column(
        modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Image(
            painter = painterResource(id = R.drawable.ic_task_completed),
            contentDescription = null
        )
        Text(
            text = stringResource(R.string.completion_text),
            modifier = modifier.padding(top = 24.dp, bottom = 8.dp),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = stringResource(R.string.compliment),
            fontSize = 16.sp
            )
    }
}

@Composable
fun ComposeQuadrant(modifier: Modifier = Modifier){
    Column(modifier.fillMaxWidth()){
        Row(Modifier.weight(1f)){
            CardInfo(
                title = stringResource(R.string.first_title),
                description = stringResource(R.string.first_description),
                bgcolor = Color(0xFFEADDFF),
                modifier = Modifier.weight(1f),
            )
            CardInfo(
                title = stringResource(R.string.second_title),
                description = stringResource(R.string.second_description),
                bgcolor = Color(0xFFD0BCFF),
                modifier = Modifier.weight(1f),
            )
        }
        Row(Modifier.weight(1f)){
            CardInfo(
                title = stringResource(R.string.third_title),
                description = stringResource(R.string.third_description),
                bgcolor = Color(0xFFB69DF8),
                modifier = Modifier.weight(1f),
            )
            CardInfo(
                title = stringResource(R.string.fourth_title),
                description = stringResource(R.string.fourth_description),
                bgcolor = Color(0xFFF6EDFF),
                modifier = Modifier.weight(1f),
            )
        }
    }
}

@Composable
fun CardInfo(title: String, description: String, bgcolor : Color, modifier: Modifier = Modifier){
    Column(modifier = modifier
        .fillMaxSize()
        .background(bgcolor)
        .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ){
        Text(
            text = title,
            modifier = Modifier.padding(bottom = 16.dp),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = description,
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeExampleTestTheme {
//        Base()
//        CheckMark()
//        ComposeQuadrant()
    }
}