package com.jiahaoliuliu.viewpageroncompose.uicomponents

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@ExperimentalFoundationApi
@Composable
fun HorizontalViewPager(modifier: Modifier = Modifier) {
    // Display 10 items
    val pagerState = rememberPagerState (pageCount = {
        10
    })

    HorizontalPager(state = pagerState, modifier = modifier) {
        page ->
        //  Our page content
        Text(
            text = "Page: $page",
            modifier = Modifier.fillMaxWidth()
                .height(200.dp)
                .background(Color.Gray)
        )
    }
}