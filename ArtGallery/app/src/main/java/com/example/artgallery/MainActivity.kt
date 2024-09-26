package com.example.artgallery


import androidx.compose.runtime.remember
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.indication
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artgallery.ui.theme.ArtGalleryTheme

data class ArtInfo(
    val imageResourceId : Int,
    val imageName : String,
    val artistName : String,
    val year : String
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtGalleryTheme {

                App()
            }
        }
    }
}

@Composable
fun App(modifier: Modifier = Modifier){
    var currentArt by remember{ mutableIntStateOf(0) }

    val artList = listOf(
        ArtInfo(
            imageResourceId = R.drawable.ic_launcher_background,
            imageName = "Green background",
            artistName = "Who knows",
            year = "2024"
        ),
        ArtInfo(
            imageResourceId = R.drawable.ic_launcher_foreground,
            imageName = "Andorid logo",
            artistName = "Google?",
            year = "2024"
        ),
        ArtInfo(
            imageResourceId = R.drawable.lemon_tree,
            imageName = "Lemon tree",
            artistName = "Idk",
            year = "2024"
        ),
        ArtInfo(
            imageResourceId = R.drawable.lemon_squeeze,
            imageName = "Actual lemon",
            artistName = "isaididk",
            year = "2024"
        ),
        ArtInfo(
            imageResourceId = R.drawable.lemon_drink,
            imageName = "Lemon Juice",
            artistName = "Iwantadrink",
            year = "2024"
        ),
        ArtInfo(
            imageResourceId = R.drawable.lemon_restart,
            imageName = "Empty Glass",
            artistName = "MeaningofLife",
            year = "2024"
        ),
    )

    Scaffold (
        modifier = modifier
            .background(MaterialTheme.colorScheme.background)
            .safeDrawingPadding(),
        bottomBar= {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom =  16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ){
                Button(
                    modifier = modifier
                        .width(140.dp),
                    shape = RoundedCornerShape(6.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.
                    primary),
                    onClick = { currentArt = (currentArt - 1 + artList.size) % artList.size}
                ) {
                    Text(
                        text = "Previous",
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                }
                Button(
                    modifier = modifier
                        .width(140.dp),
                    shape = RoundedCornerShape(6.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.
                        primary),
                    onClick = { currentArt = (currentArt - 1 + artList.size) % artList.size}
                ) {
                    Text(
                        text = "Next",
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }
        }

    ){ innerPadding ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding),
        ) {
            val artWork = artList[currentArt]
            Gallery(
                imageResourceId = artWork.imageResourceId,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            )
            Description(
                ImageName = artWork.imageName,
                ArtistName = artWork.artistName,
                Year = artWork.year,
                modifier = Modifier
            )
        }
    }
}



@Composable
fun Description(
    ImageName : String,
    ArtistName : String,
    Year : String,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier
        .padding(16.dp)
        .background(color = MaterialTheme.colorScheme.surfaceContainer)){
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ){

            Text(
                text = ImageName,
                fontSize = 24.sp
            )
            Row(
                modifier = Modifier,
                horizontalArrangement = Arrangement.Start
            ){
                Text(
                    text = ArtistName,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "($Year)")
            }
        }
    }
}
@Composable
fun Gallery(
    imageResourceId : Int,
    modifier: Modifier = Modifier
){
    Box(modifier = modifier
        .padding(16.dp)
        .shadow(
            elevation = 3.dp,
            shape = RoundedCornerShape(6.dp)
        )
        .background(MaterialTheme.colorScheme.surfaceContainer),
    ){
        Box(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            contentAlignment = Alignment.Center,

        ){
            Image(
                painter = painterResource(imageResourceId),
                contentDescription = null,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtGalleryTheme {
        App()
    }
}