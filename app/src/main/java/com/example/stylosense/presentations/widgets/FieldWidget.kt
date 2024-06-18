package com.example.stylosense.presentations.widgets

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FieldWidget(
    placeholder: String, trailingIcon: Int, label: String,
    keyboardType: KeyboardType,
    visualTransformation: VisualTransformation,
    errorState: MutableState<Boolean>,
    onChanged: (TextFieldValue) -> Unit
) {
    //state
    var text by remember {
        mutableStateOf(TextFieldValue(""))
    }

    OutlinedTextField(
        value = text,
        onValueChange = { newText ->
            text = newText
            onChanged(newText)
        },
        placeholder = {
//            Text(text = placeholder)
        },
        label = {
//            Text(text = label)
        },
        shape = RoundedCornerShape(1.dp),
        trailingIcon = {
            Icon(
                painter = painterResource(id = trailingIcon),
                contentDescription = "TextField Email"
            )
        },
        singleLine = true,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedTrailingIconColor = if (text.text.isNotEmpty()) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.primary,
            cursorColor = MaterialTheme.colorScheme.primary, //PrimaryColor
            focusedBorderColor = MaterialTheme.colorScheme.primary,
            focusedLabelColor = MaterialTheme.colorScheme.primary,
            focusedTextColor = MaterialTheme.colorScheme.primary
        ),
        visualTransformation = visualTransformation,
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = keyboardType),
        isError = errorState.value,
        modifier = Modifier
            .fillMaxWidth()
    )
}