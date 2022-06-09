package com.ebayk.ads.ui.sections

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ebayk.theme.black_transparent
import com.ebayk.theme.bodyMediumWite12
import com.ebayk.ads.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import com.skydoves.landscapist.glide.GlideImage

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ImagesSection(images: List<String>, shareClickListener: (Int) -> Unit) {
    Box(
        Modifier
            .fillMaxWidth()
            .height(300.dp)
    ) {
        val pagerState = rememberPagerState()
        val currentPage = remember { mutableStateOf(0) }
        LaunchedEffect(pagerState) {
            snapshotFlow { pagerState.currentPage }.collect { page ->
                currentPage.value = page
            }
        }
        HorizontalPager(
            count = images.size,
            state = pagerState,
            modifier = Modifier.height(300.dp)
        ) { page ->
            GlideImage(
                imageModel = images[page],
                // Crop, Fit, Inside, FillHeight, FillWidth, None
                contentScale = ContentScale.Crop,
                // shows a placeholder while loading the image.
                placeHolder = ImageBitmap.imageResource(R.drawable.bg),
                // shows an error ImageBitmap when the request failed.
            )
        }
        Image(
            painter = painterResource(R.drawable.share),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.TopEnd)
                .clickable {
                    shareClickListener(currentPage.value)
                }
        )
        Card(
            shape = RoundedCornerShape(4.dp),
            backgroundColor = black_transparent, modifier = Modifier
                .padding(16.dp)
                .align(Alignment.BottomEnd)
        ) {
            Row(
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.End,
                modifier = Modifier.padding(8.dp)
            ) {
                Text(
                    text = currentPage.value.toString(),
                    style = bodyMediumWite12,
                )
                Text(
                    text = "/",
                    style = bodyMediumWite12,
                )
                Text(
                    text = (images.size - 1).toString(),
                    style = bodyMediumWite12,
                )
            }
        }
    }
}

@Preview()
@Composable
fun DefaultPreview() {
    ImagesSection(
        listOf(
            "https://gateway.ebay-kleinanzeigen.de/coding-challenge/img/9NEAAOSw6xNhSgCC_57.jpeg",
            "https://gateway.ebay-kleinanzeigen.de/coding-challenge/img/21YAAOSwYEFhSgCC_57.jpeg",
            "https://gateway.ebay-kleinanzeigen.de/coding-challenge/img/21YAAOSwYEFhSgCC_40.jpeg",
        )
    ){

    }
}