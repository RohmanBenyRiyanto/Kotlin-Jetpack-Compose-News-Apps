package com.learncompose.presentation.common

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.learncompose.R
import com.learncompose.domain.model.Article
import com.learncompose.domain.model.Source
import com.learncompose.presentation.Dimens.ArticleCardSize
import com.learncompose.presentation.Dimens.ExtraSmallPadding
import com.learncompose.presentation.Dimens.ExtraSmallPadding2
import com.learncompose.presentation.Dimens.SmallIconSize
import com.learncompose.ui.theme.LearnComposeTheme

@Composable
fun ArticleCard(
    modifier: Modifier = Modifier, article: Article, onClick: () -> Unit
) {
    val context = LocalContext.current

    Row(modifier = modifier.clickable { onClick() }) {
        AsyncImage(
            modifier = Modifier
                .size(ArticleCardSize)
                .clip(
                    shape = MaterialTheme.shapes.medium
                ),
            model = ImageRequest.Builder(context).data(article.urlToImage).build(),
            contentDescription = null,
        )

        Column(
            verticalArrangement = Arrangement.SpaceAround, modifier = Modifier
                .padding(
                    horizontal = ExtraSmallPadding
                )
                .height(ArticleCardSize)
        ) {
            Text(
                text = article.title,
                style = MaterialTheme.typography.bodyMedium,
                color = colorResource(id = R.color.text_title),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = article.source.name,
                    style = MaterialTheme.typography.labelMedium.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    color = colorResource(id = R.color.body),
                )
                Spacer(modifier = Modifier.size(ExtraSmallPadding2))
                Icon(
                    painter = painterResource(id = R.drawable.ic_time),
                    contentDescription = "Time Icon",
                    modifier = Modifier.size(SmallIconSize),
                    tint = colorResource(id = R.color.body)
                )
                Spacer(modifier = Modifier.size(ExtraSmallPadding2))
                Text(
                    text = article.publishedAt,
                    style = MaterialTheme.typography.labelMedium.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    color = colorResource(id = R.color.body),
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun ArticleCardPreview() {
    LearnComposeTheme {
        ArticleCard(
            article = Article(
                author = "",
                content = "",
                description = "",
                publishedAt = "1 hour ago",
                source = Source("", "ABC News"),
                title = "This is a very long title that should be truncated to two lines max, and should be ellipsized if it exceeds the max lines",
                url = "",
                urlToImage = ""
            ), onClick = {}
        )
    }
}