package com.example.inputpengguna

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

    column(modifier = Modifier.padding(16.dp)) {)



}