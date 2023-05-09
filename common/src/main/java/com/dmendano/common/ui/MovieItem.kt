package com.dmendano.common.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.dmendano.common.model.MovieItemUiModel

@Composable
fun MovieItem(movie: MovieItemUiModel, onLikeClicked: () -> Unit) {
    Card(
        Modifier
            .fillMaxWidth(0.5f)
            .aspectRatio(0.75f)
            .padding(8.dp),
        elevation = 4.dp
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            MovieImage(movie.urlImage)
            MovieDetails(movie, onLikeClicked)
        }
    }
}

@Composable
fun MovieImage(urlImage: String) {
    AsyncImage(
        model = urlImage,
        contentDescription = "Image",
        contentScale = ContentScale.Crop
    )
}

@Composable
private fun MovieDetails(movie: MovieItemUiModel, onLikeClicked: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color.Transparent,
                        Color.Black
                    ),
                    startY = 300f
                )
            )
            .padding(bottom = 12.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        MovieLike(movie, onLikeClicked)
        MovieTitle(movie)
    }
}

@Composable
private fun MovieLike(movie: MovieItemUiModel, onLikeClicked: () -> Unit) {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
        val iconColor = ColorFilter.tint(if (movie.favourite) Color.Red else Color.White)
        Image(
            modifier = Modifier
                .padding(8.dp)
                .clickable(onClick = onLikeClicked),
            imageVector = Icons.Filled.Favorite,
            contentDescription = "Favourite",
            colorFilter = iconColor,
            alignment = Alignment.Center,
        )
    }
}

@Composable
private fun MovieTitle(movie: MovieItemUiModel) {
    Text(
        text = movie.title,
        modifier = Modifier.padding(8.dp),
        textAlign = TextAlign.Center,
        color = Color.White,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        maxLines = 2,
        overflow = TextOverflow.Ellipsis
    )
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFF, heightDp = 1000, widthDp = 500)
@Composable
fun MyPreview() {
    MovieItem(fakeModel) { }
}

private val fakeModel = MovieItemUiModel(
    0,
    "",
    "Spider-man",
    true
)
