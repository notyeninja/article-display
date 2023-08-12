package com.example.articledisplay

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.articledisplay.ui.theme.ArticleDisplayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArticleDisplayTheme {
                // A surface container using the 'background' color from the theme
                val title = stringResource(id = R.string.article_title)
                val paraOne = stringResource(id = R.string.article_para_one)
                val paraTwo = stringResource(id = R.string.article_para_two)

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArticleView(title, paraOne, paraTwo)
                }
            }
        }
    }
}

@Composable
fun ArticleView(title: String, paraOne: String, paraTwo: String, modifier: Modifier = Modifier) {
    Column (
    ) {
        HeaderImage()
        Text(
            text = title,
            modifier = modifier.padding(16.dp),
            fontSize = 24.sp
        )
        Text(
            text = paraOne,
            modifier = modifier.padding(start = 16.dp, end = 16.dp),
        )
        Text(
            text = paraTwo,
            modifier = modifier.padding(16.dp),
        )
    }

}

@Composable
fun HeaderImage() {
    var image = painterResource(id = R.drawable.bg_compose_background)
    Image(
        painter = image,
        contentDescription = null,
        contentScale = ContentScale.FillWidth
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val title = stringResource(id = R.string.article_title)
    val paraOne = stringResource(id = R.string.article_para_one)
    val paraTwo = stringResource(id = R.string.article_para_two)
    ArticleDisplayTheme {
        ArticleView(title, paraOne, paraTwo)
    }
}