package com.example.unsplasssh

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.google.accompanist.coil.rememberCoilPainter

@Composable
fun ImagesScreen(mainViewModel: MainViewModel = hiltViewModel()) {
    val photos = mainViewModel.photos.collectAsLazyPagingItems()

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        items(photos) { photo ->
            ImageComponent(imageUrl = photo!!.urls.regular)
        }

        photos.apply {
            when {
                loadState.refresh is LoadState.Loading -> {
                    item { LoadingComponent(Modifier.fillParentMaxSize()) }
                }

                loadState.append is LoadState.Loading -> {
                    item { CircularProgressIndicator() }
                }
            }
        }
    }
}

@Composable
private fun LoadingComponent(modifier: Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator(modifier = Modifier.wrapContentSize(Alignment.Center))
    }
}

@Composable
private fun ImageComponent(imageUrl: String) {
    Card(
        elevation = 0.dp,
        shape = RoundedCornerShape(10.dp),
        backgroundColor = Color.DarkGray,
        modifier = Modifier
                .height(150.dp)
                .fillMaxWidth()
    ) {
        Image(
            painter = rememberCoilPainter(request = imageUrl),
            contentDescription = "Unsplash image",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
    }
}

