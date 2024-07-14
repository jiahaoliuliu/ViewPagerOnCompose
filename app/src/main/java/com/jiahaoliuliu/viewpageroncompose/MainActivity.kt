package com.jiahaoliuliu.viewpageroncompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jiahaoliuliu.viewpageroncompose.ui.theme.ViewPagerOnComposeTheme
import com.jiahaoliuliu.viewpageroncompose.uicomponents.HorizontalViewPager
import com.jiahaoliuliu.viewpageroncompose.uicomponents.HorizontalViewPagerWithIndicator
import com.jiahaoliuliu.viewpageroncompose.uicomponents.VerticalViewPager

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ViewPagerOnComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val modifier = Modifier.padding(innerPadding)
                    //HorizontalViewPager(Modifier.padding(innerPadding))
//                    VerticalViewPager(Modifier.padding(innerPadding))
                    HorizontalViewPagerWithIndicator(modifier = modifier)
                }
            }
        }
    }
}
