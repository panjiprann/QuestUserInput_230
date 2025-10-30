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

        HorizontalDivider(
            modifier = Modifier.padding(
                bottom = dimensionResource( id = R.dimen.padding_medium),
                top = dimensionResource(
                id = R.dimen.padding_medium
            )),
            thickness = dimensionResource(id = R.dimen.divider_tipis)
            color = Color.DarkGray
        )
        Button(
            modifier = Modifier.fillMaxWidth(fraction = 1f),
            //
            enabled = textAlamat.isNotEmpty(),
            onClick = {
                nama = textNama
                jenis = textJK
                alamat = textAlamat
            }
        ) {
            Text(text = stringResource(id = R.string.submit))
        }

        HorizontalDivider(
            modifier = Modifier.padding(
                bottom = dimensionResource( id = R.dimen.padding_medium),
                top = dimensionResource(
                    id = R.dimen.padding_medium
                )),
                thickness = dimensionResource(1dp),
                color = Color.DarkGray
            )

        ElevatedCard (
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
            colors = CardDefaults.cardColors(containerColor = Color.Black),
            modifier = Modifier
                .height(100.dp)
                .width(300.dp)
        ) {
            Column (modifier = Modifier.padding(horizontal = 5.dp, vertical = 15.dp),){
                Text(text = "Nama   : "+nama, color = Color.White )
                Text(text = "Gender : "+jenis, color = Color.White )
                Text(text = "Alamat : "+alamat, color = Color.White)
            }
        }
    }
}