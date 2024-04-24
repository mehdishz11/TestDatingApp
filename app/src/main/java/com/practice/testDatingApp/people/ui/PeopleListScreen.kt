package com.practice.testDatingApp.people.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemContentType
import androidx.paging.compose.itemKey
import com.practice.testDatingApp.R
import com.practice.testDatingApp.ui.theme.spacing


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PeopleListScreen(

) {
    val peopleViewModel = hiltViewModel<PeopleViewModel>()
    val peopleProfiles = peopleViewModel.getPeopleList().collectAsLazyPagingItems()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.secondary,
                ),
                title = {
                    Text(
                        stringResource(
                            R.string.spotlight
                        ),
                        style = MaterialTheme.typography.titleMedium,
                    )
                },
                navigationIcon = {

                },
                actions = {
                    IconButton(onClick = { /* do something */ }) {
                        FilledIconButton(
                            content = {
                                Icon(
                                    modifier = Modifier.padding(6.dp),
                                    painter = painterResource(id = R.drawable.ic_bookmark),
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme.primary
                                )
                            },
                            modifier = Modifier.padding(MaterialTheme.spacing.small),
                            shape = IconButtonDefaults.filledShape,
                            onClick = {},
                            colors = IconButtonColors(
                                containerColor = MaterialTheme.colorScheme.secondary,
                                contentColor = MaterialTheme.colorScheme.primary,
                                disabledContainerColor = MaterialTheme.colorScheme.surface,
                                disabledContentColor = MaterialTheme.colorScheme.secondary

                            )
                        )
                    }
                }
            )
        },

        ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            when (peopleProfiles.loadState.refresh) {
                is LoadState.Loading -> {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .background(Color.Transparent),
                        color = MaterialTheme.colorScheme.secondary,
                        strokeWidth = 2.dp,
                    )
                }

                is LoadState.Error -> {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            modifier = Modifier
                                .background(Color.Transparent)
                                .clickable {
                                    peopleProfiles.retry()
                                }
                                .width(50.dp)
                                .height(50.dp),
                            tint = MaterialTheme.colorScheme.secondary,
                            imageVector = Icons.Default.Refresh,
                            contentDescription = null,
                        )

                        Text(
                            modifier = Modifier
                                .padding(top = MaterialTheme.spacing.extraSmall),
                            text = (peopleProfiles.loadState.refresh as LoadState.Error).error.message
                                ?: stringResource(
                                    R.string.error_try_again
                                ),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.error
                        )
                    }
                }

                else -> {
                    val state = rememberLazyGridState()
                    LazyVerticalGrid(
                        modifier = Modifier
                            .fillMaxSize(),
                        columns = GridCells.Fixed(count = 3),
                        state = state
                    ) {

                        items(
                            count = peopleProfiles.itemCount,
                            key = peopleProfiles.itemKey(),
                            contentType = peopleProfiles.itemContentType()
                        ) { index ->
                            peopleProfiles[index]?.let { peopleProfiles ->
                                PeopleRow(peopleModel = peopleProfiles)
                            }
                        }
                        if (peopleProfiles.loadState.append is LoadState.Loading) {
                            item { ProgressRow() }
                        } else if (peopleProfiles.loadState.append is LoadState.Error) {
                            item {
                                ErrorRow {
                                    peopleProfiles.retry()
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
