package com.learncompose.presentation.onboarding

import androidx.annotation.DrawableRes
import com.learncompose.R

data class Page(
    val title: String,
    val subtitle: String,
    @DrawableRes val image: Int
)

val pages  = listOf(
    Page(
        title = "Welcome to Learn Compose",
        subtitle = "Learn Compose is a sample app that demonstrates how to use Jetpack Compose",
        image = R.drawable.onboarding1
    ),
    Page(
        title = "Compose Basics",
        subtitle = "Learn Compose is a sample app that demonstrates how to use Jetpack Compose",
        image = R.drawable.onboarding2
    ),
    Page(
        title = "Compose Layouts",
        subtitle = "LeLearn Compose is a sample app that demonstrates how to use Jetpack Compose",
        image = R.drawable.onboarding3
    ),
)