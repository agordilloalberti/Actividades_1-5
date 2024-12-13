package com.example.actividades_1_5.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/*
Actividad 1:
Hacer que el texto del botón muestre "Cargar perfil", pero cambie a "Cancelar"
cuando se muestre la línea de progreso... Cuando pulsemos "Cancelar" vuelve al texto por defecto.
*/
@Preview(showBackground = true)
@Composable
fun Actividad1() {
    var showLoading by rememberSaveable { mutableStateOf(false) }
    var buttonText by rememberSaveable { mutableStateOf("Cargar perfil") }

    Column(
        Modifier
            .padding(24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        if (showLoading) {
            buttonText="Cancelar"
            CircularProgressIndicator(
                color = Color.Red,
                strokeWidth = 10.dp
            )
            LinearProgressIndicator(
                modifier = Modifier.padding(top = 32.dp),
                color = Color.Red,
                trackColor = Color.LightGray
            )
        }else{
            buttonText="Cargar Perfil"
        }

        Button(
            onClick = { showLoading = !showLoading }
        ) {
            Text(text = buttonText)
        }
    }
}

/*
Actividad 2:
Modifica ahora también que se separe el botón de la línea de progreso 30 dp,
pero usando un estado... es decir, cuando no sea visible no quiero que tenga la separación
aunque no se vea.
*/
@Composable
fun Actividad2() {
    var showLoading by rememberSaveable { mutableStateOf(false) }
    var buttonText by rememberSaveable { mutableStateOf("Cargar perfil") }
    var space by rememberSaveable { mutableStateOf(30.dp)}

    Column(
        Modifier
            .padding(24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        if (showLoading) {
            buttonText="Cancelar"
            space=30.dp
            CircularProgressIndicator(
                color = Color.Red,
                strokeWidth = 10.dp,
            )
            LinearProgressIndicator(
                modifier = Modifier.padding(top = 32.dp, bottom = space),
                color = Color.Red,
                trackColor = Color.LightGray
            )
        }else{
            space=0.dp
            buttonText="Cargar Perfil"
        }

        Button(
            onClick = { showLoading = !showLoading }
        ) {
            Text(text = buttonText)
        }
    }
}

/*
Actividad 3:
- Separar los botones entre ellos 10 dp, del indicador de progreso 15 dp y centrarlos horizontalmente.
- Cuando se clique el botón Incrementar, debe añadir 0.1 a la propiedad progress y quitar 0.1
  cuando se pulse el botón Decrementar.
- Evitar que nos pasemos de los márgenes de su propiedad progressStatus (0-1)
*/
@Composable
fun Actividad3() {
    var progress by rememberSaveable { mutableFloatStateOf(0f) }
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
    ) {
        LinearProgressIndicator(
            progress = {progress},
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Row(Modifier.wrapContentWidth().align(Alignment.CenterHorizontally)) {
            Button(
                modifier = Modifier.alignByBaseline().padding(5.dp,15.dp),
                onClick = {if (progress<1f) progress += 0.1f }
            ) {
                Text(text = "Incrementar")
            }
            Button(
                modifier = Modifier.alignByBaseline().padding(5.dp,15.dp),
                onClick = {if (progress>0.1f)progress-=0.1f}
            ) {
                Text(text = "Reducir")
            }
        }
    }
}


/*
Actividad 4:
Sitúa el TextField en el centro de la pantalla y haz que reemplace el valor de una coma por un punto
y que no deje escribir más de un punto decimal...
*/
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Actividad4() {
    var myVal by rememberSaveable { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize().padding(20.dp)) {
        TextField(
            modifier = Modifier.align(Alignment.Center),
            value = myVal,
            onValueChange =
            {
                var s = it
                s=s.replace(',','.')
                var dec = false
                s=s.filter { char ->
                    if (char=='.'){
                        if (dec){
                            false
                        }else {
                            dec = true
                            true
                        }
                    }else{
                        true
                    }
                }
                myVal = s
            },
            label = { Text(text = "Importe") }
        )
    }
}


/*
Actividad 5:
Haz lo mismo, pero elevando el estado a una función superior y usando un componente OutlinedTextField
al que debes añadir un padding alrededor de 15 dp y establecer colores diferentes en los bordes
cuando tenga el foco y no lo tenga.
A nivel funcional no permitas que se introduzcan caracteres que invaliden un número decimal.
*/
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Actividad5() {
    var myVal by rememberSaveable { mutableStateOf("") }

    OutlinedTextField(
        value = myVal,
        onValueChange = { myVal = it },
        label = { Text(text = "Importe") }
    )
}
