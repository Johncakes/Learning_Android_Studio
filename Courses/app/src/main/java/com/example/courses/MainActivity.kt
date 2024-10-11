package com.example.courses

import android.os.Bundle
import android.provider.ContactsContract.Data
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
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.courses.datasource.DataSource
import com.example.courses.model.Course
import com.example.courses.ui.theme.CoursesTheme
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.dimensionResource

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoursesTheme {
                Surface(modifier = Modifier
                    .fillMaxHeight()
                    .background(color = MaterialTheme.colorScheme.surface)
                    .statusBarsPadding()

                ) {

                    CourseList(courseList = DataSource.topics,
                        modifier = Modifier
                            .padding(
                                start = dimensionResource(R.dimen.padding_small),
                                end = dimensionResource(R.dimen.padding_small),
                                top = dimensionResource(R.dimen.padding_small),
                            )
                    )
                }
            }
        }
    }
}

@Composable
fun CourseCard(course: Course, modifier: Modifier = Modifier){
   Card {
       Row{
           Box{
               Image(
                   modifier = Modifier
                   .size(width = 68.dp, height = 68.dp)
                   .aspectRatio(1f),
                   painter = painterResource(id = course.imageResourceId),
                   contentDescription = null,
                   contentScale = ContentScale.Crop
               )
           }
           Column{
               Text(
                   modifier = Modifier
                       .padding(top = 16.dp, start = 16.dp, end = 16.dp,
                           bottom = 8.dp
                       ),
                   style = MaterialTheme.typography.bodyMedium,
                   text = stringResource(course.stringResourceId)
               )
               Row(
                   verticalAlignment = Alignment.CenterVertically) {
                   Icon(
                       imageVector = Icons.Filled.Home,
                       contentDescription = "Contents Icon",
                       modifier = Modifier
                           .scale(0.7f)
                           .padding(start = dimensionResource(R.dimen.padding_medium))
                   )
                   Text(
                       text = course.relatedCourse.toString(),
                       style = MaterialTheme.typography.labelMedium,
                       modifier = Modifier.padding(start = dimensionResource(R.dimen.padding_small))
                   )
               }
           }
       }
   }
}
@Composable
fun CourseList(courseList : List<Course>, modifier: Modifier = Modifier){
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        items(DataSource.topics) { course ->
            CourseCard(course)
        }
    }

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CoursesTheme {
        CourseList(courseList = DataSource.topics)
    }
}