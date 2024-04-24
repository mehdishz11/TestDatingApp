package com.practice.testDatingApp.people.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.practice.testDatingApp.R
import com.practice.testDatingApp.ui.theme.DatingTestAppTheme
import com.practice.testDatingApp.ui.theme.spacing

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun PeopleDetailsScreen(
    imageId: String,
    onDismissedDialog: () -> Unit
) {

    Dialog(
        onDismissRequest = onDismissedDialog,
        properties = DialogProperties(
            usePlatformDefaultWidth = false,
        )
    ) {
        Card(
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier
                .fillMaxWidth(0.95f)
                .fillMaxHeight(0.8f)
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.background)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()

                ) {
                    GlideImage(
                        model = imageId,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxSize()
                    )

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.TopStart)
                            .background(
                                brush = Brush.verticalGradient(
                                    listOf(
                                        Color.Black,
                                        Color.Transparent
                                    )
                                )
                            )
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 10.dp, vertical = 20.dp)
                        ) {
                            Text(
                                "Nisa 26",
                                modifier = Modifier
                                    .padding(bottom = MaterialTheme.spacing.small),
                                style = MaterialTheme.typography.titleMedium,
                                color = Color.White
                            )

                            Text(
                                "Front-End Developer",
                                style = MaterialTheme.typography.bodyMedium,
                                color = Color.White
                            )
                        }
                    }

                    Row(
                        modifier = Modifier
                            .width(200.dp)
                            .align(Alignment.BottomCenter)
                            .padding(horizontal = 10.dp, vertical = 20.dp),
                        horizontalArrangement = Arrangement.Absolute.SpaceAround
                    ) {


                        //chat card button
                        FilledIconButton(
                            onClick = { },
                            modifier = Modifier
                                .size(45.dp),
                            colors = IconButtonColors(
                                containerColor =MaterialTheme.colorScheme.primary,
                                contentColor =MaterialTheme.colorScheme.secondary,
                                disabledContainerColor =MaterialTheme.colorScheme.surface,
                                disabledContentColor =MaterialTheme.colorScheme.primary

                            )
                        ) {
                            Icon(
                                modifier = Modifier.size(20.dp),
                                painter = painterResource(id = R.drawable.ic_chat),
                                contentDescription = "content description"
                            )
                        }

                        // fork and spoon card button
                        FilledIconButton(
                            onClick = { },
                            modifier = Modifier
                                .size(45.dp),
                            colors = IconButtonColors(
                                containerColor =MaterialTheme.colorScheme.primary,
                                contentColor =MaterialTheme.colorScheme.secondary,
                                disabledContainerColor =MaterialTheme.colorScheme.surface,
                                disabledContentColor =MaterialTheme.colorScheme.primary

                            )

                        ) {
                            Icon(
                                modifier = Modifier.size(20.dp),
                                painter = painterResource(id = R.drawable.ic_spoon_fork),
                                contentDescription = "content description"
                            )
                        }

                        // Like card button
                        FilledIconButton(
                            onClick = { },
                            modifier = Modifier
                                .size(45.dp),
                            colors = IconButtonColors(
                                containerColor =MaterialTheme.colorScheme.primary,
                                contentColor =MaterialTheme.colorScheme.secondary,
                                disabledContainerColor =MaterialTheme.colorScheme.surface,
                                disabledContentColor =MaterialTheme.colorScheme.primary

                            )

                        ) {
                            Icon(
                                modifier = Modifier.size(15.dp),
                                painter = painterResource(id = R.drawable.ic_like),
                                contentDescription = "content description"
                            )
                        }


                    }

                }


            }
        }
    }

}

@Composable
@Preview
fun PeopleDetailsScreenPreview() {
    DatingTestAppTheme {
        PeopleDetailsScreen(imageId = "https://cdn2.thecatapi.com/images/asg.jpg") {}
    }
}