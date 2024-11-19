package com.stepikcourses.ui.screens.enter

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.stepikcourses.R


@Composable
fun RegistrationScreen(
    paddingValues: PaddingValues,
    onFieldsEmpty: () -> Unit,
    onPasswordDismiss: () -> Unit,
    onRegistrate: (email: String, password: String) -> Unit,
    onSignIn: () -> Unit,
) {

    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val copyPassword = remember { mutableStateOf("") }

    val emailError = remember { mutableStateOf(false) }
    val passwordError = remember { mutableStateOf(false) }
    val copyPasswordError = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.background))
            .padding(horizontal = 16.dp)
            .padding(paddingValues = paddingValues),
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Регистрация", fontSize = 32.sp, color = Color.White, modifier = Modifier.padding(bottom = 22.dp))

        Text(text = "Email", fontSize = 18.sp, color = Color.White)
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp, bottom = 16.dp),
            value = email.value,
            onValueChange = {email.value = it},
            label = { Text("example@gmail.com", fontSize = 20.sp, color = Color.Gray) },
            shape = RoundedCornerShape(60.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = colorResource(R.color.elements),
                unfocusedContainerColor = colorResource(R.color.elements)
            ),
            isError = emailError.value

        )

        Text(text = "Пароль", fontSize = 18.sp, color = Color.White)
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp, bottom = 16.dp),
            value = password.value,
            onValueChange = {password.value = it},
            label = { Text("Введите пароль", fontSize = 20.sp, color = Color.Gray) },
            shape = RoundedCornerShape(60.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = colorResource(R.color.elements),
                unfocusedContainerColor = colorResource(R.color.elements)
            ),
            visualTransformation = PasswordVisualTransformation(),
            isError = passwordError.value
        )

        Text(text = "Повторите пароль", fontSize = 18.sp, color = Color.White)
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp, bottom = 16.dp),
            value = copyPassword.value,
            onValueChange = {copyPassword.value = it},
            label = { Text("Введите пароль еще раз", fontSize = 20.sp, color = Color.Gray) },
            shape = RoundedCornerShape(60.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = colorResource(R.color.elements),
                unfocusedContainerColor = colorResource(R.color.elements)
            ),
            visualTransformation = PasswordVisualTransformation(),
            isError = copyPasswordError.value
        )

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                if (email.value.isEmpty() || password.value.isEmpty() || copyPassword.value.isEmpty()) {
                    onFieldsEmpty.invoke()
                    passwordError.value = password.value.isEmpty()
                    emailError.value = email.value.isEmpty()
                    copyPasswordError.value = copyPassword.value.isEmpty()
                } else if(password.value != copyPassword.value)
                    onPasswordDismiss.invoke()
                else
                    onRegistrate(email.value, password.value)
            },
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.green))
        ) {
            Text("Регистрация", fontSize = 18.sp, color = Color.White)
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text("У вас уже есть аккаунт?", color = Color.White)
            Text(
                "Войти",
                color = colorResource(R.color.green),
                modifier = Modifier.clickable {
                    onSignIn.invoke()
                }
            )
        }


    }
}