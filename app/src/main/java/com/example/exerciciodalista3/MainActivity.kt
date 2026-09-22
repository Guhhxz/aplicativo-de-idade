package com.example.exerciciodalista3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.exerciciodalista3.ui.theme.ExercicioDaLista3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExercicioDaLista3Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GreetingPreview(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}



@Preview
@Composable
fun GreetingPreview(modifier: Modifier = Modifier) {

    var idade by remember { mutableStateOf(120) }


    Column(modifier = modifier
        .fillMaxSize()
        .background(Color.White),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {

        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {

            Text(
                text = "Qual é a sua idade?",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1908f9),
                modifier = Modifier
                    .padding(top = 30.dp)
            )
            Text(
                text = "Aperte os botões para informar a sua idade",
                fontSize = 16.sp,
                color = Color.Black,
                modifier = Modifier
                    .offset(y = (-4).dp)
            )

            Text(
                text = idade.toString(),
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .padding(top = 30.dp)

            )

            Row(
                modifier = Modifier
                    .padding(40.dp)
            ) {
                Button(
                    modifier = Modifier
                        .width(90.dp)
                        .height(80.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF060298),
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(30),
                    onClick = {
                        if (idade > 0) idade--
                    },

                    ) {
                    Text(text = "-",
                        fontSize = 58.sp,)
                }

                Spacer(modifier=modifier.size(70.dp))

                Button(
                    modifier = Modifier
                        .width(90.dp)
                        .height(80.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF060298),
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(30),
                    onClick = {
                        idade++
                    },

                ) {
                    Icon(
                        modifier= Modifier.size(40.dp),
                        imageVector = Icons.Default.Add,
                        contentDescription = "Adicionar"
                    )
                }


            }

            Text(
                when {
                    idade > 122 -> {
                        "UUUUQUEEEEEE"
                    }

                    idade <= 14 -> {
                        "você é MENOR de idade (criança)"
                    }

                    idade < 18 -> {
                        "você é MENOR de idade (adolescente)"
                    }

                    idade < 60 -> {
                        "Você é MAIOR de idade (adulto)"
                    }

                    else -> {
                        "Você é MAIOR de idade (idoso)"
                    }
                },

                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1908f9),
                modifier = Modifier
            )

        }
    }
}