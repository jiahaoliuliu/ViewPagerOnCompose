package com.jiahaoliuliu.viewpageroncompose.uicomponents

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import kotlin.random.Random

@ExperimentalFoundationApi
@Composable
fun HorizontalViewPagerWithScrollButton(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        val pagerState = rememberPagerState(pageCount = {
            pages.size
        })
        val showButton by remember {
            derivedStateOf {
                pagerState.currentPage != 0
            }
        }
        HorizontalPager(state = pagerState) { pageIndex ->
            when(pages[pageIndex]) {
                Page.Feed -> Page("Feed")
                Page.Search -> Page("Search")
                Page.Profile -> Page("Profile")
                Page.Settings -> Page("Settings")
            }
        }

        val scope = rememberCoroutineScope()
        AnimatedVisibility(visible = showButton,
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.BottomStart),
            enter = slideInVertically { it } + fadeIn(),
            exit = slideOutVertically { it } + fadeOut()
        ) {
            Button(
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(0)
                    }
                }
            ) {
                Text(text = "Scroll to start")
            }
        }

    }
}

sealed class Page {
    data object Feed: Page()
    data object Profile: Page()
    data object Search: Page()
    data object Settings: Page()
}

val pages = listOf(
    Page.Feed, Page.Profile, Page.Search, Page.Settings
)

@Composable
fun Page(title: String) {
    Box(modifier = Modifier
        .padding(20.dp)
        .fillMaxSize()
        .background(Color(Random.nextInt(256), Random.nextInt(256), Random.nextInt(256))),
        contentAlignment = Alignment.Center) {
        Text(text = title)
    }
}