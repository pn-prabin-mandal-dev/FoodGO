package com.example.gds.foodgo.presentation_layer

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.gds.foodgo.R
import com.example.gds.foodgo.core.navigation.Routes

@Composable
fun SignUpScreen(navController: NavController) {
    var name by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isPasswordVisible by remember { mutableStateOf(false) }

    var nameError by remember { mutableStateOf(false) }
    var addressError by remember { mutableStateOf(false) }
    var emailError by remember { mutableStateOf(false) }
    var phoneError by remember { mutableStateOf(false) }
    var passwordError by remember { mutableStateOf(false) }
    val context = LocalContext.current

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 18.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.height(40.dp))
            Image(
                painter = painterResource(id = R.drawable.login_screen_burger_img),
                contentDescription = "Login burger",
                modifier = Modifier.size(140.dp)
            )

            Text(
                text = "Sign Up Page",
                style = TextStyle(
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.gradient_end_color)
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                OutlinedTextField(
                    value = name,
                    onValueChange = {
                        name = it
                        nameError = false
                    },
                    label = { Text(text = "Name") },
                    placeholder = { Text("Enter your Name") },
                    leadingIcon = {
                        Icon(
                            Icons.Default.Person,
                            contentDescription = "person icon"
                        )
                    },
                    isError = nameError,
                    supportingText = {
                        if (nameError) Text("Name cannot be empty", color = Color.Red)
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = colorResource(id = R.color.gradient_end_color),
                        unfocusedBorderColor = colorResource(id = R.color.gradient_end_color),
                    ),
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = address,
                    onValueChange = {
                        address = it
                        addressError = false
                    },
                    label = { Text(text = "Address") },
                    placeholder = { Text("Enter your Address") },
                    leadingIcon = {
                        Icon(
                            Icons.Default.AddLocation,
                            contentDescription = "location Icon"
                        )
                    },
                    isError = addressError,
                    supportingText = {
                        if (addressError) Text("Address cannot be empty", color = Color.Red)
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = colorResource(id = R.color.gradient_end_color),
                        unfocusedBorderColor = colorResource(id = R.color.gradient_end_color),
                    ),
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = email,
                    onValueChange = {
                        email = it
                        emailError = false
                    },
                    label = { Text(text = "Email") },
                    placeholder = { Text("Enter your Email") },
                    leadingIcon = { Icon(Icons.Default.Mail, contentDescription = "mail icon") },
                    isError = emailError,
                    supportingText = {
                        if (emailError) Text("Enter a valid email", color = Color.Red)
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = colorResource(id = R.color.gradient_end_color),
                        unfocusedBorderColor = colorResource(id = R.color.gradient_end_color),
                    ),
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = phone,
                    onValueChange = {
                        phone = it
                        phoneError = false
                    },
                    label = { Text(text = "Phone") },
                    placeholder = { Text("Enter your Phone Number") },
                    leadingIcon = { Icon(Icons.Default.Phone, contentDescription = "phone icon") },
                    isError = phoneError,
                    supportingText = {
                        if (phoneError) Text(
                            "Enter a valid 10-digit phone number",
                            color = Color.Red
                        )
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = colorResource(id = R.color.gradient_end_color),
                        unfocusedBorderColor = colorResource(id = R.color.gradient_end_color),
                    ),
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = password,
                    onValueChange = {
                        password = it
                        passwordError = false
                    },
                    label = { Text(text = "Password") },
                    placeholder = {
                        Text("Enter your Password")
                    },
                    leadingIcon = { Icon(Icons.Default.Lock, contentDescription = "") },
                    trailingIcon = {
                        IconButton(
                            onClick = { isPasswordVisible = !isPasswordVisible }
                        ) {
                            Icon(
                                if (isPasswordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                                contentDescription = "Password Visibility Icon"
                            )
                        }
                    },
                    isError = passwordError,
                    supportingText = {
                        if (passwordError) Text("Password cannot be empty", color = Color.Red)
                    },
                    visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = colorResource(id = R.color.gradient_end_color),
                        unfocusedBorderColor = colorResource(id = R.color.gradient_end_color),
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Spacer(modifier = Modifier.height(34.dp))

            Card(
                onClick = { /* No action here, handle inside TextButton */ },
                modifier = Modifier
                    .width(180.dp)
                    .height(50.dp),
                colors = CardDefaults.cardColors().copy(
                    containerColor = colorResource(id = R.color.gradient_end_color)
                ),
                shape = RoundedCornerShape(12.dp)
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    TextButton(
                        onClick = {
                            nameError = name.isBlank()
                            addressError = address.isBlank()
                            emailError = !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
                            phoneError = phone.length != 10
                            passwordError = password.isBlank()

                            val isFormValid = !(nameError || addressError || emailError || phoneError || passwordError)

                            if (isFormValid) {
                                Toast.makeText(context, "Account Created Successfully!", Toast.LENGTH_SHORT).show()
                                navController.navigate(Routes.LoginScreen)
                            } else {
                                Toast.makeText(context, "Please fill the details correctly!", Toast.LENGTH_SHORT).show()
                            }
                        }
                    ) {
                        Text(
                            text = "Create Account",
                            color = Color.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }


            Spacer(modifier = Modifier.height(12.dp))

            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Already have an account? ")
                Text(
                    text = "Login here",
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Blue,
                    modifier = Modifier.clickable {navController.navigate(Routes.LoginScreen) }  // Handle Login click
                )
            }
        }
    }
}
