package com.example.inputpengguna

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Warna kustom sesuai gambar
val LightPurple = Color(0xFFE9E4F0) // Warna ungu muda yang lebih mendekati gambar
val DarkPurple = Color(0xFF4B0082) // Warna Indigo/Ungu Tua yang lebih pekat
val LabelColor = Color.Black.copy(alpha = 0.6f) // Warna untuk teks label

@Composable
fun FormulirPendaftaran(modifier: Modifier = Modifier) {
    // State untuk semua input
    var namaLengkap by remember { mutableStateOf("") }
    var jenisKelamin by remember { mutableStateOf("") }
    var statusPerkawinan by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }

    // Daftar opsi untuk RadioButton
    val listJenisKelamin = listOf("Laki-laki", "Perempuan")
    val listStatus = listOf("Janda", "Lajang", "Duda")

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(LightPurple) // Latar belakang utama
            .padding(24.dp) // Padding sedikit lebih besar agar tidak terlalu mepet
    ) {
        // --- HEADER ---
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(DarkPurple, shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)) // Sudut hanya di atas
                .padding(vertical = 20.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Formulir Pendaftaran",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // --- FORM FIELDS ---

        // NAMA LENGKAP
        FormTextField(
            label = "NAMA LENGKAP",
            value = namaLengkap,
            placeholder = "Isian nama lengkap",
            onValueChange = { namaLengkap = it }
        )

        Spacer(modifier = Modifier.height(20.dp))

        // JENIS KELAMIN
        FormRadioGroup(
            label = "JENIS KELAMIN",
            options = listJenisKelamin,
            selectedOption = jenisKelamin,
            onOptionSelected = { jenisKelamin = it }
        )

        Spacer(modifier = Modifier.height(20.dp))

        // STATUS PERKAWINAN
        FormRadioGroup(
            label = "STATUS PERKAWINAN",
            options = listStatus,
            selectedOption = statusPerkawinan,
            onOptionSelected = { statusPerkawinan = it }
        )

        Spacer(modifier = Modifier.height(20.dp))

        // ALAMAT
        FormTextField(
            label = "ALAMAT",
            value = alamat,
            placeholder = "Alamat",
            onValueChange = { alamat = it }
        )

        Spacer(modifier = Modifier.weight(1f)) // Mendorong tombol ke bawah

        // --- TOMBOL SUBMIT ---
        Button(
            onClick = { /* TODO: Logika untuk submit data */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = CircleShape, // Bentuk tombol lebih bulat
            colors = ButtonDefaults.buttonColors(containerColor = DarkPurple)
        ) {
            Text(text = "Submit", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }
    }
}

// Composable terpisah untuk TextField agar lebih rapi
@Composable
fun FormTextField(label: String, value: String, placeholder: String, onValueChange: (String) -> Unit) {
    Text(text = label, fontWeight = FontWeight.Bold, color = LabelColor, fontSize = 14.sp)
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(placeholder, color = Color.Gray) },
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = Color.Gray.copy(alpha = 0.5f), // Garis bawah saat tidak fokus
            focusedBorderColor = DarkPurple, // Garis bawah saat fokus
            focusedContainerColor = Color.Transparent, // Background transparan
            unfocusedContainerColor = Color.Transparent // Background transparan
        )
    )
}

// Composable terpisah untuk grup RadioButton
@Composable
fun FormRadioGroup(label: String, options: List<String>, selectedOption: String, onOptionSelected: (String) -> Unit) {
    Text(text = label, fontWeight = FontWeight.Bold, color = LabelColor, fontSize = 14.sp)
    Spacer(modifier = Modifier.height(8.dp))
    Column {
        options.forEach { text ->
            Row(
                Modifier
                    .fillMaxWidth()
                    .selectable(
                        selected = (text == selectedOption),
                        onClick = { onOptionSelected(text) }
                    )
                    .padding(vertical = 2.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = (text == selectedOption),
                    onClick = { onOptionSelected(text) },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = DarkPurple,
                        unselectedColor = Color.Gray
                    )
                )
                Text(text = text, modifier = Modifier.padding(start = 8.dp), color = LabelColor)
            }
        }
    }
}
