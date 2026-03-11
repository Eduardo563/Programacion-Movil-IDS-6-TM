package com.example.pantallaprincipal.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.Center
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.InputTransformation.Companion.keyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@Composable
fun SignUpScreen(navController: NavController){

    // Estado
    var name by remember{mutableStateOf("")}
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var checked by remember { mutableStateOf(false) }

    var nameError by remember { mutableStateOf(false) }
    var emailError by remember{mutableStateOf(false)}
    var phoneError by remember { mutableStateOf(false) }
    var confirmPasswordError by remember {mutableStateOf(false) }

    fun isValidEmail (email:String): Boolean{
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun isValidName (name: String): Boolean{
        return name.matches(Regex("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$"))
    }

    fun isValidPhone (phone: String): Boolean{
        return  phone.matches(Regex("^\\d{10}$"))
    }

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
                Text(text = "Sign Up",
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
                    OutlinedTextField(
                        value = email,
                        onValueChange = {
                            email = it
                            emailError = !isValidEmail(it)
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Email
                        )
                    )
                }
                Column(
                    verticalArrangement = Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text("Name", modifier = Modifier.padding(start = 12.dp))
                    OutlinedTextField(
                        value = name,
                        onValueChange = {
                            name = it
                            nameError = !isValidName(it)}
                    )
                }

                Column(
                    verticalArrangement = Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text("Phone", modifier = Modifier.padding(start = 12.dp))
                    OutlinedTextField(
                        value = phone,
                        onValueChange = {
                            phone = it
                            phoneError = !isValidPhone(it)},
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Phone
                        )
                    )
                }
                Column(
                    verticalArrangement = Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text("Password", modifier = Modifier.padding(start = 12.dp))
                    OutlinedTextField(
                        value = password,
                        onValueChange = {
                            password = it },
                        visualTransformation = PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Password
                        )
                    )

                }

                Column(
                    verticalArrangement = Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text("Confirm password", modifier = Modifier.padding(start = 12.dp))
                    OutlinedTextField(
                        value = confirmPassword,
                        onValueChange = {
                            confirmPassword = it
                            confirmPasswordError = (it != password)},
                        visualTransformation = PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Password
                        )
                    )
                }

                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(vertical = 12.dp)
                ){
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

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ){
                        OutlinedButton( onClick = {
                            navController.navigate("welcome")
                        },
                            modifier = Modifier.size(width = 125.dp, height = 50.dp),
                            border = BorderStroke(2.dp, Color(0xff4f4ab1)),
                        ) {
                            Text("Cancel",
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp)
                        }
                        Button( onClick = {},
                            enabled = !nameError && !name.isBlank() && !emailError && phoneError &&
                                        !confirmPasswordError && checked,
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
}
@Composable
@Preview (showBackground = true, showSystemUi = false)
fun SignUpScreenPreview(){

    val navController = rememberNavController()
    SignUpScreen(navController = navController)

}