package com.example.pantallaprincipal


import android.R.attr.checked
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.Center
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation

import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pantallaprincipal.ui.theme.PantallaPrincipalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PantallaPrincipalTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomeScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier){
    Box(
        modifier = Modifier.background(Color(0xff4f4ab1))
    ){
        Column(
            verticalArrangement = Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier  = Modifier
                .padding(16.dp)
                .clip(RoundedCornerShape(12))
                .background(Color(0xFFFFFFFF))
        ){
            Image(
                painter  = painterResource(id = R.drawable.imagen_inicio),
                contentDescription = null,
                modifier = Modifier.size(300.dp)
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 25.dp)){
                Text("Hello",
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    fontSize = 40.sp)
                Text("Welcome to Little Drop, where\n you managed your daily tasks",
                    textAlign = TextAlign.Center,
                    fontSize = 18.sp,
                    color = Color(0xFF464646))
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(vertical = 12.dp)) {
                Button(onClick = {},
                    modifier = Modifier.size(width = 250.dp, height = 50.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xff4f4ab1))) {
                    Text("Login",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold)
                }
                OutlinedButton(onClick = {},
                    modifier = Modifier.size(width = 250.dp, height = 50.dp),
                    border = BorderStroke(2.dp, Color(0xff4f4ab1))) {
                    Text("Sign Up",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xff4f4ab1))
                }
            }
            Text("Sign up using",
                color = Color(0xFF555555))
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier.padding(16.dp)) {
                Image(
                    painter  = painterResource(id = R.drawable.facebook),
                    contentDescription = null
                )
                Image(
                    painter  = painterResource(id = R.drawable.google_plus_144),
                    contentDescription = null
                )
                Image(
                    painter  = painterResource(id = R.drawable.linkedin_144),
                    contentDescription = null
                )
            }
        }
    }

}

@Composable
@Preview (showBackground = true, showSystemUi = false)
fun HomeScreenPreview(){
    PantallaPrincipalTheme {
        HomeScreen()
    }
}

@Composable
fun LoginScreen(modifier: Modifier = Modifier){
    Box(
        modifier = Modifier.background(Color(0xff4f4ab1))
    ){
        Column(
            verticalArrangement = Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier  = Modifier
                .padding(16.dp)
                .clip(RoundedCornerShape(12))
                .background(Color(0xFFFFFFFF))
        ){
            Image(
                painter  = painterResource(id = R.drawable.login_access),
                contentDescription = null,
                modifier = Modifier.size(300.dp)
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 18.dp)){
                Text("Login",
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    fontSize = 40.sp)
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(12.dp)) {

                Column(
                    verticalArrangement = Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text("Name", modifier = Modifier.padding(start = 12.dp))
                    var name by remember { mutableStateOf("")}
                    OutlinedTextField(
                        value = name,
                        onValueChange = {name = it}
                    )
                }
                Column(
                    verticalArrangement = Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text("Email", modifier = Modifier.padding(start = 12.dp))
                    var email by remember { mutableStateOf("")}
                    OutlinedTextField(
                        value = email,
                        onValueChange = {email = it}
                    )
                }
                Column(
                    verticalArrangement = Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text("Password", modifier = Modifier.padding(start = 12.dp))
                    var password by remember { mutableStateOf("")}
                    OutlinedTextField(
                        value = password,
                        onValueChange = {password = it},
                        visualTransformation = PasswordVisualTransformation()
                    )
                }

                Column(
                    verticalArrangement = Center,
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Forgot password?", modifier = Modifier.padding(start = 30.dp),
                        color = Color(0xFF555555),
                        fontSize = 12.sp)
                }

                Column(
                    verticalArrangement = Center,
                    horizontalAlignment = Alignment.End,
                    modifier = Modifier
                        .padding(end = 35.dp, bottom = 14.dp)
                        .fillMaxWidth()) {

                    Button( onClick = {},
                        modifier = Modifier.size(width = 125.dp, height = 50.dp),
                        colors = ButtonDefaults.buttonColors(Color(0xff4f4ab1)),
                    ) {
                        Text("Sign In",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp)
                    }
                }
            }

        }
    }
}
@Composable
@Preview (showBackground = true, showSystemUi = false)
fun LoginScreenPreview(){
    PantallaPrincipalTheme {
        LoginScreen()
    }
}

@Composable
fun SignUpScreen(){
    Box(
        modifier = Modifier.background(Color(0xff4f4ab1))
    ){
        Column(
            verticalArrangement = Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier  = Modifier
                .padding(16.dp)
                .clip(RoundedCornerShape(12))
                .background(Color(0xFFFFFFFF))
        ){
            Column(
                verticalArrangement = Arrangement.spacedBy(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 18.dp)){
                Text("Sign Up",
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    fontSize = 40.sp)
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(12.dp)) {

                Column(
                    verticalArrangement = Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text("Email", modifier = Modifier.padding(start = 12.dp))
                    var email by remember { mutableStateOf("")}
                    OutlinedTextField(
                        value = email,
                        onValueChange = {email = it}
                    )
                }
                Column(
                    verticalArrangement = Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text("Name", modifier = Modifier.padding(start = 12.dp))
                    var name by remember { mutableStateOf("")}
                    OutlinedTextField(
                        value = name,
                        onValueChange = {name = it}
                    )
                }
                Column(
                    verticalArrangement = Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text("Password", modifier = Modifier.padding(start = 12.dp))
                    var password by remember { mutableStateOf("")}
                    OutlinedTextField(
                        value = password,
                        onValueChange = {password = it},
                        visualTransformation = PasswordVisualTransformation()
                    )
                }

                Column(
                    verticalArrangement = Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text("Confirm password", modifier = Modifier.padding(start = 12.dp))
                    var password by remember { mutableStateOf("")}
                    OutlinedTextField(
                        value = password,
                        onValueChange = {password = it},
                        visualTransformation = PasswordVisualTransformation()
                    )
                }

                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(vertical = 12.dp)
                ){
                    var checked by remember {mutableStateOf(false)}
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ){
                        Checkbox(
                            checked = checked,
                            onCheckedChange = { checked = it }
                        )
                        Text("I have read and accept\nthe terms and conditions",
                            textAlign = TextAlign.Left)
                    }
                }


                Column(
                    verticalArrangement = Center,
                    horizontalAlignment = Alignment.End,
                    modifier = Modifier
                        .padding(end = 35.dp, bottom = 14.dp)
                        .fillMaxWidth()) {

                    Button( onClick = {},
                        modifier = Modifier.size(width = 125.dp, height = 50.dp),
                        colors = ButtonDefaults.buttonColors(Color(0xff4f4ab1)),
                    ) {
                        Text("Sign Up",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp)
                    }
                }
            }

        }
    }
}
@Composable
@Preview (showBackground = true, showSystemUi = false)
fun SignUpScreenPreview(){
    PantallaPrincipalTheme {
        SignUpScreen()
    }
}
