package olimp.bet.olimpbet.bk.app

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import olimp.bet.olimpbet.model.ItemRowModel

@Composable
fun MyRow(item: ItemRowModel) {
    var isExpanded by remember {
        mutableStateOf(false)
    }
    Row(
        modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth()
            .background(Color.White)
    ) {
        Image(
            painter = painterResource(id = item.imageId),
            contentDescription = "image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(3.dp)
                .size(110.dp)
        )
        Column(
            modifier = Modifier
                .padding(start = 15.dp, top = 25.dp)
        ) {
            Text(text = item.title)
            Text(modifier = Modifier.clickable {
                isExpanded = !isExpanded
            }, maxLines = if (isExpanded) 10 else 1, text = item.content)
        }
    }
}