package com.ebayk.ads.ui.sections

import Document
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ebayk.ads.R
import com.ebayk.data.model.DocumentsSection
import com.ebayk.data.model.FeaturesSection
import com.ebayk.theme.bodyMediumBlack14

@Composable
fun DocumentRow(
    text: String,
    modifier: Modifier = Modifier.padding(8.dp)
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
    ) {
        Image(
            painter = painterResource(R.drawable.ic_document),
            contentDescription = null,modifier
        )
        Text(
            text = text,
            style = bodyMediumBlack14,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .padding(start = 8.dp)
                .weight(1f)
        )
        Image(
            painter = painterResource(R.drawable.chevron),
            contentDescription = null,modifier
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DocumentsListView(docs: DocumentsSection, onclick: (Document) -> Unit) {
    LazyColumn(modifier = Modifier.fillMaxWidth().padding(8.dp)
    ) {
        items(docs.documentList) { it ->
            DocumentRow(text = it.title, modifier = Modifier.padding(vertical = 8.dp).clickable {
                onclick(it)
            })
        }
    }
}