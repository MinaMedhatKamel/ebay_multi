package com.ebayk.ads.ui.sections

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ebayk.data.model.DetailsSection

@Composable
fun DetailsListView(
    items: DetailsSection,
) {
    Scaffold() {
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(items.detailsList) {
                SimpleDetailsRow(it.lable, it.value)
            }
        }
    }
}

