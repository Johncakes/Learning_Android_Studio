package com.example.superheros

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheros.model.Hero
import com.example.superheros.model.HeroesRepository
import com.example.superheros.ui.theme.SuperherosTheme

data class SuperHero(val name:String, val description:String)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SuperherosTheme {
                App()
            }
        }
    }
}

@Composable
fun App(){
    Scaffold(
        topBar = {
            SuperheroTopBar()
        },
    ) { innerPadding ->
        Surface(modifier = Modifier
            .padding(innerPadding)
            .padding(16.dp)
        ) {
            SuperHeroList()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperheroTopBar(){
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.displayLarge
            )
        }
    )
}

@Composable
fun SuperHeroList(){
    val superheros = HeroesRepository.heroes

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ){
        itemsIndexed(superheros){ index, superhero ->
            SuperHeroInfo(superhero)
        }
    }

}

@Composable
fun SuperHeroInfo(superhero: Hero, modifier: Modifier = Modifier){
    Card(
        modifier = modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary)
    ){
        Row (
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Column(
                modifier = Modifier
                    .weight(1f)
            ){
                Text(
                    text = stringResource(superhero.nameRes),
                    style = MaterialTheme.typography.displaySmall
                )
                Text(
                    text = stringResource(superhero.descriptionRes),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Spacer(modifier = Modifier.padding(16.dp))
            Box(
                modifier =Modifier
                    .size(72.dp)
                    .clip(RoundedCornerShape(8.dp))
            ){
                Image(
                    painter = painterResource(id = superhero.imageRes),
                    contentDescription = null,
                    )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SuperherosTheme(darkTheme = false) {
        App()
    }
}

@Preview(showBackground = true)
@Composable
fun DarkmodeGreetingPreview() {
    SuperherosTheme(darkTheme = true) {
        App()
    }
}
