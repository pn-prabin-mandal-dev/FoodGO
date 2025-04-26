package com.example.gds.foodgo.core.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gds.foodgo.R

@Composable
fun PrimaryButton(onClick: () -> Unit = {}, text: String) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .width(180.dp)
            .height(50.dp),
        colors = ButtonDefaults.buttonColors().copy(
            containerColor = colorResource(id = R.color.gradient_end_color)
        ),
        shape = RoundedCornerShape(12.dp)
    ) { Text(text = text, fontSize = 16.sp, fontWeight = FontWeight.SemiBold) }

}