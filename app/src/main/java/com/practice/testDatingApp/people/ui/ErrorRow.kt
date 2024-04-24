package com.practice.testDatingApp.people.ui


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.practice.testDatingApp.ui.theme.DatingTestAppTheme
import com.practice.testDatingApp.ui.theme.spacing

@Composable
fun ErrorRow(
    onClick:()->Unit
) {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {

        Image(
            imageVector = Icons.Default.Refresh,
            contentDescription = null,
            modifier = Modifier
                .background(Color.Transparent)
                .clickable {
                    onClick()
                }
        )

        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            VerticalDivider(
                modifier = Modifier
                    .height(180.dp),
                color = Color.Transparent
            )

            Text(
                modifier = Modifier
                    .padding(top = MaterialTheme.spacing.extraSmall),
                text = "",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.secondary
            )

            Text(
                modifier = Modifier
                    .padding(top = MaterialTheme.spacing.extraSmall),
                text = "",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.secondary
            )
        }
    }

}


@Composable
@Preview(widthDp = 150, showBackground = true)
fun ErrorRowPreview() {
    DatingTestAppTheme {
        ErrorRow({})
    }
}
