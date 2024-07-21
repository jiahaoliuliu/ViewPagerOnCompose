package com.jiahaoliuliu.viewpageroncompose.uicomponents

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.PagerDefaults
import androidx.compose.foundation.pager.PagerSnapDistance
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@ExperimentalFoundationApi
@Composable
fun HorizontalViewPagerWithMoreSnapDistance(modifier: Modifier) {
    val pagerState = rememberPagerState(pageCount = { 10 })

    val fling = PagerDefaults.flingBehavior(state = pagerState,
        pagerSnapDistance = PagerSnapDistance.atMost(10))

    HorizontalPager(
        state = pagerState,
        beyondBoundsPageCount = 10,
        modifier = modifier.fillMaxSize(),
        flingBehavior = fling
        ) { page ->
          Text(text = "Page: $page", modifier = Modifier.fillMaxWidth(),
              textAlign = TextAlign.Center
          )
    }
}