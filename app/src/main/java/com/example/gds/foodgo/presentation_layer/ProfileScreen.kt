package com.example.gds.foodgo.presentation_layer

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import com.example.gds.foodgo.R
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ProfileScreen(navController: NavController) {
    val context = LocalContext.current
    Scaffold {innerPadding->
        Column(modifier = Modifier.padding(innerPadding)) {
            var nameTF by remember { mutableStateOf("Surendra Mahato") }
            var emailTF by remember { mutableStateOf("xinghsurendra2@gmail.com") }
            var addressTF by remember { mutableStateOf("Bateshwar bazar - 04 Dhanusha Nepal") }
            var passwordTF by remember { mutableStateOf("passWord@123") }
            var isEditable by remember { mutableStateOf(true) }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.LightGray)
            ) {
                Column(
                ) {
                    // Red Card at the top
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.Red),
                        shape = RoundedCornerShape(0.dp)
                    ) {
                        Box(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 12.dp, vertical = 12.dp),
                                horizontalArrangement = Arrangement.Start
                            ) {
                                Icon(
                                    Icons.Default.ArrowBack,
                                    contentDescription = "Arrow_back icon",
                                    tint = Color.White.copy(0.8f),
                                    modifier = Modifier.size(32.dp)
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(100.dp)) // Just spacing if needed
                }

                // Green Card overlapping the Red Card
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .align(Alignment.TopCenter)
                        .offset(y = 150.dp), // Overlapping
//            colors = CardDefaults.cardColors(containerColor = Color.Green),
                    shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
                ) {

                    Column(
                        modifier = Modifier.padding(horizontal = 12.dp)
                    ) {
                        Spacer(modifier = Modifier.height(80.dp))

                        OutlinedTextField(
                            value = nameTF,
                            onValueChange = { nameTF = it },
                            label = { Text("Name") },
                            readOnly = isEditable, // ✅ Makes it non-editable but looks like a field
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier.fillMaxWidth(),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = Color.LightGray,
                                unfocusedBorderColor = Color.Gray
                            ),
                            textStyle = TextStyle(fontWeight = FontWeight.Bold, letterSpacing = 1.sp) // ✅ Bold text
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        OutlinedTextField(
                            value = emailTF,
                            onValueChange = { emailTF = it },
                            label = { Text("Email") },
                            readOnly = isEditable, // ✅ Makes it non-editable but looks like a field
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier.fillMaxWidth(),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = Color.LightGray,
                                unfocusedBorderColor = Color.Gray
                            ),
                            textStyle = TextStyle(fontWeight = FontWeight.Bold, letterSpacing = 1.sp) // ✅ Bold text
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        OutlinedTextField(
                            value = addressTF,
                            onValueChange = { addressTF = it },
                            label = { Text("Delivery Address") },
                            readOnly = isEditable, // ✅ Makes it non-editable but looks like a field
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier.fillMaxWidth(),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = Color.LightGray,
                                unfocusedBorderColor = Color.Gray
                            ),
                            textStyle = TextStyle(fontWeight = FontWeight.Bold, letterSpacing = 1.sp) // ✅ Bold text
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        OutlinedTextField(
                            value = passwordTF,
                            onValueChange = { passwordTF = it },
                            label = { Text("Password") },
                            readOnly = isEditable, // ✅ Makes it non-editable but looks like a field
                            shape = RoundedCornerShape(12.dp),
                            visualTransformation = PasswordVisualTransformation(),
                            modifier = Modifier.fillMaxWidth(),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = Color.LightGray,
                                unfocusedBorderColor = Color.Gray
                            ),
                            textStyle = TextStyle(fontWeight = FontWeight.Bold, fontSize = 24.sp, letterSpacing = 1.sp) // ✅ Bold text
                        )
                        Spacer(modifier = Modifier.height(20.dp))


                        // bottom section before button
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Column(
                                modifier = Modifier.width(300.dp)
                            ) {
                                HorizontalDivider(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(2.dp),
                                    color = Color.LightGray.copy(0.6f)
                                )
                                Spacer(modifier = Modifier.height(12.dp))

                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(
                                        "Payment Details",
                                        fontSize = 18.sp,
                                        color = Color.Gray,
                                        fontWeight = FontWeight.SemiBold
                                    )
                                    Icon(
                                        Icons.Default.KeyboardArrowRight,
                                        tint = Color.Gray,
                                        contentDescription = "Right_arrow Icon",
                                        modifier = Modifier.size(32.dp)
                                    )
                                }

                                Spacer(modifier = Modifier.height(12.dp))
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(
                                        "Order History",
                                        fontSize = 18.sp,
                                        color = Color.Gray,
                                        fontWeight = FontWeight.SemiBold
                                    )
                                    Icon(
                                        Icons.Default.KeyboardArrowRight,
                                        tint = Color.Gray,
                                        contentDescription = "Right_arrow Icon",
                                        modifier = Modifier.size(32.dp)
                                    )
                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(18.dp))
                        // bottom button section
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.BottomCenter
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Button(
                                    onClick = {isEditable = false},
                                    modifier = Modifier
                                        .width(140.dp)
                                        .height(50.dp),
                                    shape = RoundedCornerShape(12.dp),
                                    colors = ButtonDefaults.buttonColors().copy(
                                        containerColor = Color(0xFF3B2F2F)
                                    )
                                ) {
                                    Row(
                                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Text("Edit Profile")
                                        Icon(
                                            Icons.Default.Edit,
                                            contentDescription = "Edit Icon",
                                            modifier = Modifier.size(24.dp)
                                        )
                                    }
                                }
                                OutlinedButton(
                                    onClick = {
                                        Toast.makeText(context, "Saved", Toast.LENGTH_SHORT).show()
                                        /*navController.navigate(Routes.HomeScreen){
                                            popUpTo(Routes.HomeScreen){
                                                inclusive = true
                                            }
                                        }*/
                                    },
                                    modifier = Modifier
                                        .width(140.dp)
                                        .height(50.dp),
                                    shape = RoundedCornerShape(12.dp),
                                    border = BorderStroke(
                                        2.dp,
                                        Color.Red
                                    ) // ✅ Red border with increased stroke
                                ) {
                                    Row(
                                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Text("Save", color = Color.Red)
                                        Icon(
                                            Icons.Default.ThumbUp,
                                            contentDescription = "Save Icon",
                                            tint = Color.Red.copy(0.8f),
                                            modifier = Modifier.size(24.dp)
                                        )
                                    }
                                }
                            }
                        }

                    }
                }


                // Center Floating Card (like profile image or small info box)
                Card(
                    modifier = Modifier
                        .size(130.dp)
                        .align(Alignment.TopCenter)
                        .offset(y = 80.dp) // Adjust to be centered where overlap happens
                        .border(
                            width = 4.dp,
                            color = Color.Red,
                            shape = RoundedCornerShape(12.dp)
                        ), // ✅ Stroke added here
                    shape = RoundedCornerShape(12.dp),
                    elevation = CardDefaults.cardElevation(8.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.profile_image),
                            modifier = Modifier.size(160.dp),
                            contentDescription = "Profile Image",
                            contentScale = ContentScale.Crop
                        )
                    }
                }
            }
        }
    }

}