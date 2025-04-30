package com.example.spendwise.ui.view.setup

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Balance(modifier: Modifier = Modifier) {

    val bottomSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    var showSheet by remember { mutableStateOf(false) }
    val inputText = remember { mutableStateOf("") }

    if (showSheet) {
        ModalBottomSheet(
            onDismissRequest = { showSheet = false },
            sheetState = bottomSheetState,
            shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
            containerColor = MaterialTheme.colorScheme.surface
        ) {
            OutlinedTextField(
                value = inputText.value,
                onValueChange = {},
                readOnly = true,
                placeholder = { Text(text = "$0") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Numpad(
                crossAxisCount = 3,
                children = buildNumpadChildren { key ->
                    when (key) {
                        "⌫" -> {
                            if (inputText.value.isNotEmpty()) {
                                inputText.value = inputText.value.dropLast(1)
                            }
                        }
                        else -> {
                            inputText.value += key
                        }
                    }
                }
            )
            Spacer(modifier = Modifier.height(24.dp))
        }
    }

    Column(
        modifier = modifier
            .padding(top = 20.dp)
            .clickable { showSheet = true },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "$0.00", fontSize = 40.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = modifier.height(8.dp))
        Text(text = "Update balance", fontSize = 16.sp, style = MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.colorScheme.primary))
    }
}

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
            Box(modifier = Modifier.size(buttonSize)) {
                children[index]()
            }
        }
    }
}

@Composable
fun buildNumpadChildren(onClick: (String) -> Unit): List<@Composable () -> Unit> {
    val numberList = listOf("1", "2", "3", "4", "5", "6", "7", "8", "9", ".", "0", "⌫", "✅")

    return numberList.map { label ->
        {
            NumpadButton(onClick = { onClick(label) }) {
                Text(
                    text = label,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
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
