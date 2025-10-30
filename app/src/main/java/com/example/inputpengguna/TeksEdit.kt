package com.example.inputpengguna

import androidx.compose.material3.OutlinedTextField
import androidx.compose.ui.Modifier

@composable
fun formDataDiri(modifier: Modifier
){
    //
    var textNama by remember { mutableStateOf(value="")}
    var textAlamat by remember { mutableStateOf(value="")}
    var textJK by remember { mutableStateOf(value="")}

    //
    var nama by remember { mutableStateOf(value="")}
    var alamat by remember { mutableStateOf(value="")}
    var jenis by remember { mutableStateOf(value="")}

    val gender:List<String> = listOf("Laki-laki","Perempuan")

    column(modifier = Modifier.padding(top = 50.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally) {
        OutlinedTextField(
            value = textNama,
            singleLine = true,
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.width(width = 250.dp),
            label = { Text(text = "Nama Lengkap") },
            onValueChange = {
                textNama = it
            }
        )
        Row {
            gender.forEach { item ->
                Row(
                    modifier = Modifier.selectable(
                        selected = { textJK == item },
                    ), verticalAlignment = Alignment.CenterVertically {
                    RadioButton(
                        selected = textJK == item,
                        onClick = {
                            textJK = item
                        })
                    Text(text = item)
                }
            }
        }
        OutlinedTextField(
            value = textAlamat,
            singleLine = true,
            modifier = Modifier.width(width = 250.dp),
            label = { Text(text = "Alamat Lengkap") },
            onValueChange = {
                textAlamat = it
            }
        )


                }
        }

    }




}