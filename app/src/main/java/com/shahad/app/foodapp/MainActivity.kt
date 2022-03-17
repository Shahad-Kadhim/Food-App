package com.shahad.app.foodapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shahad.app.foodapp.ui.theme.FoodAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    AppBar()
}

@Composable
fun DefaultPreview() {
    FoodAppTheme {
        Greeting("Android")
    }
}

@Preview(showBackground = true)
@Composable
fun AppBar() {
    Scaffold {
        Column {
            TopAppBar(
                title = {
                    Text(
                        text = "FoodApp",
                        style = TextStyle(
                            color = Color.White,
                            fontFamily = FontFamily.Monospace,
                            fontSize = 25.sp,
                        )
                    ,modifier = Modifier.padding(0.dp)
                    )
                },
                backgroundColor = Color(33, 84, 160),
                contentColor = Color.White,
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_fluent_food_16_filled),
                            contentDescription = ""
                        )
                    }
                }
            )

            LazyColumn(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            ) {
                firstItem("Best Dishes"){
                    SmallCard(
                        it,
                        painterResource(id = R.drawable.image)
                    )
                }
                secondItem(
                    Modifier
                        .height(140.dp)
                        .width(140.dp)
                )
            }
        }
    }
}

fun LazyListScope.firstItem(title: String,card: @Composable (Modifier) -> Unit){
    item {
        Text(
            text = title,
            style = TextStyle(
                color = Color.Black,
                fontFamily = FontFamily.SansSerif,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.padding(start = 8.dp,top = 16.dp,bottom = 8.dp)
        )
    }
    item {
        LazyRow(){
            items(count = 3) {
                card(
                    Modifier
                        .fillParentMaxWidth()
                        .height(160.dp)
                )
            }
        }
    }
}



fun LazyListScope.secondItem(modifier: Modifier){
    firstItem("First Category"){
        SmallCard(
            modifier = modifier,
            painterResource(id = R.drawable.image)
        )
    }
    firstItem("Second Category"){
        SmallCard(
            modifier = modifier,
            painterResource(id = R.drawable.image)
        )
    }
    firstItem("Third Category"){
        SmallCard(
            modifier = modifier,
            painterResource(id = R.drawable.image)
        )
    }
    firstItem("Fourth Category"){
        SmallCard(
            modifier = modifier,
            painterResource(id = R.drawable.image)
        )
    }
}

@Composable
fun SmallCard(modifier: Modifier,image: Painter){
    Card(
        modifier = modifier.padding(8.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Box(modifier = Modifier.fillMaxWidth()){
            Image(
                painter = image,
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
//            Text(
//                text = "  hfdghfdghd",
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(30.dp)
//                    .background(Color(0, 0, 0, 87))
//                    .align(Alignment.BottomCenter),
//            )
        }
    }

}
