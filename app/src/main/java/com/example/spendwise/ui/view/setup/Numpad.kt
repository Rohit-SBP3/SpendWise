package com.example.spendwise.ui.view.setup

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Numpad(
    modifier: Modifier = Modifier,
    crossAxisCount: Int = 4,
    spacing: Dp = 8.dp,
    padding: Dp = 16.dp,
    children: List<@Composable () -> Unit>
) {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val buttonSize = (screenWidth - (padding * 2) - (spacing * (crossAxisCount - 1))) / crossAxisCount

    LazyVerticalGrid(
        columns = GridCells.Fixed(crossAxisCount),
        verticalArrangement = Arrangement.spacedBy(spacing),
        horizontalArrangement = Arrangement.spacedBy(spacing),
        modifier = modifier.padding(horizontal = padding)
    ) {
        items(children.size) { index ->
            Box(
                modifier = Modifier.size(buttonSize)
            ) {
                children[index]()
            }
        }
    }
}

@Composable
fun buildNumpadChildren(onClick: (String) -> Unit): List<@Composable () -> Unit> {
    val numberList = listOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "0", ".", "⌫")

    return numberList.map { label ->
        {
            if (label.isNotEmpty()) {
                NumpadButton(
                    onClick = { onClick(label) }
                ) {
                    Text(
                        text = label,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            } else {
                Spacer(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NumpadButton(
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colorScheme.secondary,
    borderRadius: Dp = 16.dp,
    onClick: (() -> Unit)? = null,
    onLongClick: (() -> Unit)? = null,
    content: @Composable () -> Unit
) {
    Surface(
        color = backgroundColor,
        shape = RoundedCornerShape(borderRadius),
        modifier = modifier
            .aspectRatio(1f)
            .clip(RoundedCornerShape(borderRadius))
            .combinedClickable(
                onClick = { onClick?.invoke() },
                onLongClick = onLongClick
            )
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            content()
        }
    }
}
