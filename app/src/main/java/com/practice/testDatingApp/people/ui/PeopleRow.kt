package com.practice.testDatingApp.people.ui


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.practice.testDatingApp.people.useCase.models.PeopleModel
import com.practice.testDatingApp.ui.theme.DatingTestAppTheme
import com.practice.testDatingApp.ui.theme.spacing

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun PeopleRow(
    modifier: Modifier = Modifier,
    peopleModel: PeopleModel
) {
    val showDialog = remember { mutableStateOf(false) }

    if (showDialog.value) {
        PeopleDetailsScreen(peopleModel.url) {
            showDialog.value = false
        }
    }


    Column(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable {
                showDialog.value = true
            },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        GlideImage(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .clip(shape = MaterialTheme.shapes.medium)
                .background(color = MaterialTheme.colorScheme.primary),
            model = peopleModel.url,
            contentDescription = null,
            contentScale = ContentScale.Crop
            )

        Text(
            modifier=Modifier
                .padding(top = MaterialTheme.spacing.extraSmall),
            text ="Nill",
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.titleSmall,
            color=MaterialTheme.colorScheme.secondary
        )

        Text(
            modifier=Modifier
                .padding(top = MaterialTheme.spacing.extraSmall),
            text ="Some details",
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.bodySmall,
            color=MaterialTheme.colorScheme.secondary
        )
    }
}


@Composable
@Preview(widthDp = 150, showBackground = true)
fun PeopleRowPreview() {
    DatingTestAppTheme {
        PeopleRow(
            modifier = Modifier
                .width(350.dp),
            peopleModel = PeopleModel(
                id = "gravida",
                url = "https://cdn2.thecatapi.com/images/asg.jpg"
            )
        )
    }
}
