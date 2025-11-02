package com.example.inputpengguna

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.inputpengguna.ui.theme.InputPenggunaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            InputPenggunaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // 1. Panggil Composable yang benar di sini
                    FormulirPendaftaran()
                }
            }
        }
    }
}

// 2. Blok setContent yang salah di bawah sudah dihapus
//    Fungsi preview di bawah ini opsional, bisa dihapus jika tidak perlu

@Preview(showBackground = true)
@Composable
fun FormulirPendaftaranPreview() { // Nama diubah agar lebih deskriptif
    InputPenggunaTheme {
        FormulirPendaftaran()
    }
}
