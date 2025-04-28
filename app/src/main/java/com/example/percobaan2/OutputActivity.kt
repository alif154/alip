package com.example.percobaan2

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class OutputActivity : AppCompatActivity() {

    private lateinit var txtHasil: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.output_activity)

        txtHasil = findViewById(R.id.txt_hasil)

        // Ambil data yang diteruskan dari InputActivity
        val angka1 = intent.getStringExtra("angka1")?.toDoubleOrNull()
        val angka2 = intent.getStringExtra("angka2")?.toDoubleOrNull()
        val operator = intent.getStringExtra("operator")

        if (angka1 != null && angka2 != null && operator != null) {
            val hasil = when (operator) {
                "+" -> angka1 + angka2
                "-" -> angka1 - angka2
                "*" -> angka1 * angka2
                "/" -> if (angka2 != 0.0) angka1 / angka2 else null
                else -> null
            }

            txtHasil.text = when {
                hasil != null -> "Hasil: $hasil"
                operator == "/" && angka2 == 0.0 -> "Tidak bisa dibagi 0"
                else -> "Operasi tidak valid"
            }
        } else {
            txtHasil.text = "Input tidak valid"
        }
    }
}