package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Main()
            }
        }
    }
}

@Composable
fun Main( modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xffd2e7d4)),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Introduction(
            modifier = Modifier
                .weight(1f)
                .padding(bottom = 50.dp)
        )
        Contacts(
            modifier = Modifier
                .padding(bottom = 24.dp)
        )
    }
}
@Composable
fun Introduction(modifier: Modifier=Modifier){
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = null,
            modifier = Modifier
                .background(Color(0xff082f47))
                .size(100.dp, 100.dp)
        )
        Text(
            text = "Sim Hyeok",
            fontSize = 32.sp,
            modifier = Modifier.padding(vertical = 8.dp)

        )
        Text(
            text="Junior Software Developer",
            fontSize = 12.sp,
            color = Color(0xff5ba95b)
        )
        
    }
}

@Composable
fun Contacts(modifier:Modifier = Modifier){
   Column (modifier = modifier
   ){
       ContactOption(
           icon = Icons.Default.Phone,
           contentDescription = "Number Icon",
           option = stringResource(R.string.contact_number)
       )
       ContactOption(
           icon = Icons.Default.Share,
           contentDescription = "Share Icon",
           option = stringResource(R.string.contact_social_media)
       )
       ContactOption(
           icon = Icons.Default.MailOutline,
           contentDescription = "Email Icon",
           option = stringResource(R.string.contact_email)
       )
   }
}

@Composable
fun ContactOption(icon: ImageVector, option: String, contentDescription : String,  modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ){
        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
            tint = Color(0xff5ba95b)
        )
        Text(
            text = option,
            fontSize = 12.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        Main()
    }
}