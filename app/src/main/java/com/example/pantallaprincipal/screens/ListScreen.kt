package com.example.pantallaprincipal.screens

import android.R.attr.enabled
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.pantallaprincipal.components.Contact


@Composable
fun ListScreen(navController: NavController){
    val contacts = listOf(
        Pair("Juan", "6121714294"),
        Pair("María García", "6125551234"),
        Pair("Carlos Rodríguez", "6241234567"))

    val contactsList = remember{ mutableStateListOf<Pair<String,String>>().apply { addAll(contacts) } }
    var name by remember { mutableStateOf("") }
    var phone by remember {mutableStateOf("")}


    Column(modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(12))
            .background(Color(0xFFFFFFFF))
            .padding(20.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "New Contact",
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp,
            modifier = Modifier.padding(vertical = 14.dp)
        )
        Column(verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start) {
            Text("Name", modifier = Modifier.padding(start = 12.dp))
            OutlinedTextField(
                value = name,
                onValueChange = {
                    name = it }
            )
            Spacer(modifier = Modifier.padding(vertical = 14.dp))
            Text("Phone", modifier = Modifier.padding(start = 12.dp))
            OutlinedTextField(
                value = phone,
                onValueChange = {
                    phone = it }
            )
        }
        Column(verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment =  Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(vertical=8.dp)
                .fillMaxWidth()) {
            Button(onClick = {
                if(name.isNotBlank() && phone.isNotBlank()){
                    contactsList.add(Pair(name, phone))
                    name =""
                    phone =""
                }
            }, modifier = Modifier.size(width = 280.dp, height = 50.dp))  {
                Text(text="Save Contact",
                    fontWeight = FontWeight.Bold)
            }
            OutlinedButton(onClick = {
                name =""
                phone =""
            },modifier = Modifier.size(width = 280.dp, height = 50.dp)){
                Text(text = "Clean Fields",
                    fontWeight = FontWeight.Bold)
            }
        }
        Spacer(modifier = Modifier.padding(vertical = 12.dp))
        Text(
            text = "Contact List",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.padding(vertical = 12.dp))
        LazyColumn(horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxWidth()) {

            items(contactsList){
                    contact ->
                Contact(name = contact.first, phone = contact.second)
            }
        }
    }

}

@Preview
@Composable
fun ListScreenPreview(){
    val navController = rememberNavController()
    ListScreen(navController)
}