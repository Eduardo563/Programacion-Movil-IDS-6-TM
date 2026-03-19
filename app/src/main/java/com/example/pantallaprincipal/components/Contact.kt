package com.example.pantallaprincipal.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pantallaprincipal.R

@Composable
fun Contact (name: String, phone: String){
    Row(verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(10.dp)) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = null,
            modifier = Modifier.size(64.dp)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Column() {
            Text(
                text = name,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.padding(vertical = 4.dp))
            Text(
                text = phone,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }

}
@Preview(showBackground = true)
@Composable
fun ContactPreview(){
    Contact("David Olivas", phone = "6127590274")
}