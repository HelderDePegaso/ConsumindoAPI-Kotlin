package com.tarefa.com

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
//noinspection UsingMaterialAndMaterial3Libraries
import  androidx.compose.material3.Button
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material3.MaterialTheme
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.tarefa.com.servicos.RetrofitInstance
import kotlinx.coroutines.launch
import java.time.format.TextStyle

//const val globalUrlDaImagem = "https://images.dog.ceo/breeds/husky/n02110185_10047.jpg"
//const val globalNomeDoCao = "Husky"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                DogImageScreen()
            }
        }
    }
}

@Preview
@Composable
fun DogImageScreen() {
    var imageUrl by remember { mutableStateOf<String?>("https://images.dog.ceo/breeds/husky/n02110185_10047.jpg") }
    val coroutineScope = rememberCoroutineScope()
    var nomeDaRacaDoCao by remember { mutableStateOf<String?>("Husky")}

    // Iniciais
//    imageUrl = globalUrlDaImagem;
//    var nomeDoCao = globalNomeDoCao

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        //
        Text("Implementando API Dog CEO")
        Spacer(modifier = Modifier.height(40.dp))
        
        // Exibe a imagem se estiver disponível
        if (imageUrl != null) {
            Image(
                painter = rememberAsyncImagePainter(imageUrl),
                contentDescription = "Imagem de Cachorro",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            )

            Spacer(modifier = Modifier.height(14.dp) )
            Text("Nome da Raça: $nomeDaRacaDoCao", modifier = Modifier.align(Alignment.Start), textAlign = TextAlign.Left)
            Spacer(modifier = Modifier.height(11.dp))
            Text("Link da Imagem do cão: $imageUrl", modifier = Modifier.align(Alignment.Start), textAlign = TextAlign.Left)
        } else {
            Text("Clique no botão para carregar uma imagem.")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botão para buscar a imagem
        Button(onClick = {
            coroutineScope.launch {
                try {
                    // Utilizando Retrofit Aqui
                    val response = RetrofitInstance.api.obterAutomaticamenteImagensDeCaes()
                    if (response.status == "success") {
                        imageUrl = response.message
                        nomeDaRacaDoCao = f(imageUrl.toString())
//                        println("Testando")
//                        println(imageUrl!!)
//                        println(imageUrl)
//                        println(imageUrl.toString())

                    } else {
                        imageUrl = null
                    }
                } catch (e: Exception) {
                    imageUrl = null
                }
            }
        }) {
            Text("Buscar Imagem")
        }
    }
}

val f = fun(imageUrl: String): String  {

    if (imageUrl != "") {
        val pLIOF = imageUrl.lastIndexOf('/')
        val imageUrl2 = imageUrl.substring(0, pLIOF)
        val sLIOF = imageUrl2.lastIndexOf('/')

        val substring = imageUrl.substring(sLIOF + 1, pLIOF)

        return substring.replaceFirstChar { it.uppercaseChar() }
    }

    return imageUrl

}

@Composable
fun DefaultPreview() {
    MaterialTheme {
        DogImageScreen()
    }
}
