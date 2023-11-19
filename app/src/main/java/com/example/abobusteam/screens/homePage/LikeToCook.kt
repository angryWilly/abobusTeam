package com.example.abobusteam.screens.homePage

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.abobusteam.R

@Composable
fun SetupWouldYouWantToCook() {
    Text(
        text = "Что хотите приготовить?",
        fontSize = 22.sp,
        fontWeight = FontWeight.SemiBold,
        modifier = Modifier
            .padding(start = 12.dp)
    )

    val categoryItems = listOf(
        Category(painterResource(id = R.drawable.breakfast), "Завтрак"),
        Category(painterResource(id = R.drawable.lunch), "Обед"),
        Category(painterResource(id = R.drawable.dinner), "Ужин"),
        Category(painterResource(id = R.drawable.salad), "Салаты"),
        Category(painterResource(id = R.drawable.snacks), "Закуски"),
        Category(painterResource(id = R.drawable.deserts), "Десерты"),
    )

    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(3),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalItemSpacing = 16.dp
    ) {
        items(categoryItems) {
            item -> StepsCategory(item = item)
        }

    }

}

@Composable
fun StepsCategory(item: Category) {
    Column {
        val context = LocalContext.current
        Image(
            painter = item.image,
            contentDescription = item.name,
            modifier = Modifier
                .height(80.dp)
                .width(100.dp)
                .clip(shape = RoundedCornerShape(size = 8.dp))
                .clickable {
                    Toast
                        .makeText(context, item.name, Toast.LENGTH_SHORT)
                        .show()
                }
        )

        Text(
            text = item.name,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .padding(3.dp)
        )
    }
}

data class Category(
    val image: Painter,
    val name: String
)