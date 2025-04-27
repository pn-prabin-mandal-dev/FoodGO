package com.example.gds.foodgo.presentation_layer

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import com.example.gds.foodgo.R
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
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
import com.example.gds.foodgo.core.components.PrimaryButton
import com.example.gds.foodgo.core.navigation.Routes
@Composable
fun LoginScreen(navController: NavController) {
    var name by remember { mutableStateOf("") }
    var emailOrPhone by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isPasswordVisible by remember { mutableStateOf(false) }
    val context = LocalContext.current

    // Error state variables
    var nameError by remember { mutableStateOf(false) }
    var emailOrPhoneError by remember { mutableStateOf(false) }
    var passwordError by remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 18.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(40.dp))
            Image(
                painter = painterResource(id = R.drawable.login_screen_burger_img),
                contentDescription = "Login burger",
                modifier = Modifier.size(140.dp)
            )

            Text(
                text = "Login Page",
                style = TextStyle(
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.gradient_end_color)
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            Column(
                modifier = Modifier,
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                OutlinedTextField(
                    value = name,
                    onValueChange = {
                        name = it
                        if (nameError) nameError = false
                    },
                    label = { Text(text = "Name") },
                    isError = nameError,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = colorResource(id = R.color.gradient_end_color),
                        unfocusedBorderColor = colorResource(id = R.color.gradient_end_color),
                        errorBorderColor = Color.Red
                    ),
                    placeholder = { Text("Enter your Name") },
                    leadingIcon = { Icon(Icons.Default.Person, contentDescription = "") },
                    modifier = Modifier.fillMaxWidth()
                )
                if (nameError) {
                    Text(
                        text = "Name cannot be empty",
                        color = Color.Red,
                        fontSize = 12.sp,
                        modifier = Modifier.padding(start = 12.dp, top = 2.dp)
                    )
                }

                OutlinedTextField(
                    value = emailOrPhone,
                    onValueChange = {
                        emailOrPhone = it
                        if (emailOrPhoneError) emailOrPhoneError = false
                    },
                    label = { Text(text = "Email or Phone") },
                    isError = emailOrPhoneError,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = colorResource(id = R.color.gradient_end_color),
                        unfocusedBorderColor = colorResource(id = R.color.gradient_end_color),
                        errorBorderColor = Color.Red
                    ),
                    placeholder = { Text("Enter your Email or Phone") },
                    leadingIcon = { Icon(Icons.Default.Email, contentDescription = "") },
                    modifier = Modifier.fillMaxWidth()
                )
                if (emailOrPhoneError) {
                    Text(
                        text = "Email or Phone cannot be empty",
                        color = Color.Red,
                        fontSize = 12.sp,
                        modifier = Modifier.padding(start = 12.dp, top = 2.dp)
                    )
                }

                OutlinedTextField(
                    value = password,
                    onValueChange = {
                        password = it
                        if (passwordError) passwordError = false
                    },
                    visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    label = { Text(text = "Password") },
                    isError = passwordError,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = colorResource(id = R.color.gradient_end_color),
                        unfocusedBorderColor = colorResource(id = R.color.gradient_end_color),
                        errorBorderColor = Color.Red
                    ),
                    placeholder = { if (isPasswordVisible) Text("Enter your Password") else Text("Show Password") },
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
                    modifier = Modifier.fillMaxWidth()
                )
                if (passwordError) {
                    Text(
                        text = "Password cannot be empty",
                        color = Color.Red,
                        fontSize = 12.sp,
                        modifier = Modifier.padding(start = 12.dp, top = 2.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                var isChecked by remember { mutableStateOf(true) }
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = isChecked,
                        onCheckedChange = { isChecked = it },
                        colors = CheckboxDefaults.colors(
                            checkedColor = colorResource(id = R.color.gradient_end_color),
                            uncheckedColor = Color.Unspecified
                        )
                    )
                    Text(
                        text = "Remember Me",
                        style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
                    )
                }
                Text(text = "Forgot Password?", color = Color.Blue)
            }

            Spacer(modifier = Modifier.height(34.dp))

            PrimaryButton(
                onClick = {
                    nameError = name.isEmpty()
                    emailOrPhoneError = emailOrPhone.isEmpty()
                    passwordError = password.isEmpty()

                    if (!nameError && !emailOrPhoneError && !passwordError) {
                        navController.navigate(Routes.HomeScreen)
                        Toast.makeText(context, "Login Successful!", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(context, "Please fix the errors!", Toast.LENGTH_SHORT).show()
                    }
                },
                text = "Login"
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Don't have an account? ")
                TextButton(
                    onClick = {
                        navController.navigate(Routes.SignUpScreen)
                    }
                ) {
                    Text(
                        text = "Sign Up",
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Blue
                    )
                }
            }
        }
    }
}