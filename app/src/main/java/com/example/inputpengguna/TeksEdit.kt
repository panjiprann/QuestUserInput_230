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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Warna kustom sesuai gambar
val LightPurple = Color(0xFFE9E4F0)
val DarkPurple = Color(0xFF4B0082)
val LabelColor = Color.Black.copy(alpha = 0.6f)

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
            .background(LightPurple) // Latar belakang utama ungu muda
    ) {
        // --- HEADER ---
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp) // Beri padding agar tidak menempel ke tepi
                .padding(top = 24.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Formulir Pendaftaran",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(DarkPurple, shape = RoundedCornerShape(16.dp))
                    .padding(vertical = 20.dp)
            )
        }

        // --- WADAH FORM PUTIH (PERBAIKAN PELETAKAN) ---
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp) // Padding untuk memberi jarak dari tepi
                .clip(RoundedCornerShape(16.dp)) // Membuat sudut rounded
                .background(Color.White) // Memberi latar belakang putih
                .padding(horizontal = 24.dp, vertical = 32.dp) // Padding di dalam wadah putih
        ) {
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
}


// --- Composable lainnya tidak berubah ---

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
            unfocusedBorderColor = Color.Gray.copy(alpha = 0.5f),
            focusedBorderColor = DarkPurple,
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent
        )
    )
}

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
