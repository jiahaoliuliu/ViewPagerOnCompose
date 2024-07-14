package com.jiahaoliuliu.viewpageroncompose.uicomponents

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@ExperimentalFoundationApi
@Composable
fun VerticalViewPager(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        // Display 10 items
        val pagerState = rememberPagerState(pageCount = {
            10
        })

        LaunchedEffect(key1 = pagerState) {
            // Collect from a snapshot flow reading the current page
            snapshotFlow { pagerState.currentPage }.collect {
                page ->
                // Do something with each page change, for example
                // viewModel.sendPageSelectedEvent(page)
                Log.d("Page change", "Current page changed to $page")
            }

            // Collect from a snapshot flow reading the current page
            snapshotFlow { pagerState.settledPage }.collect {
                    page ->
                // Do something with each page change, for example
                // viewModel.sendPageSelectedEvent(page)
                Log.d("Page change", "Settle page changed to $page")
            }
        }

        VerticalPager(state = pagerState) { page ->
            // Our page content
            Text(
                text = "page: $page",
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Blue)
                    .height(200.dp)
            )
        }

        // Scroll to page
        val coroutineScope = rememberCoroutineScope()
        Button(onClick = {
            coroutineScope.launch {
                // Call scroll to on pagerState
//                pagerState.scrollToPage(5)
                pagerState.animateScrollToPage(5)
            }
        }, modifier = Modifier.align(Alignment.BottomCenter)) {
            Text(text = "Jump to Page 5")
        }
    }
}