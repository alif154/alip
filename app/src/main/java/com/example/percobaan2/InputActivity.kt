package com.example.percobaan2
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class InputActivity : AppCompatActivity() {

    private lateinit var edtAngka1: EditText
    private lateinit var edtAngka2: EditText
    private lateinit var btnTambah: Button
    private lateinit var btnKurang: Button
    private lateinit var btnKali: Button
    private lateinit var btnBagi: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.input_activity)

        edtAngka1 = findViewById(R.id.edt_angka1)
        edtAngka2 = findViewById(R.id.edt_angka2)
        btnTambah = findViewById(R.id.btn_tambah)
        btnKurang = findViewById(R.id.btn_kurang)
        btnKali = findViewById(R.id.btn_kali)
        btnBagi = findViewById(R.id.btn_bagi)

        btnTambah.setOnClickListener {
            kirimData("+")
        }

        btnKurang.setOnClickListener {
            kirimData("-")
        }

        btnKali.setOnClickListener {
            kirimData("*")
        }

        btnBagi.setOnClickListener {
            kirimData("/")
        }
    }

    private fun kirimData(operator: String) {
        val angka1 = edtAngka1.text.toString()
        val angka2 = edtAngka2.text.toString()

        // Kirim data ke OutputActivity dengan operator yang dipilih
        val intent = Intent(this, OutputActivity::class.java).apply {
            putExtra("angka1", angka1)
            putExtra("angka2", angka2)
            putExtra("operator", operator)
        }
        startActivity(intent)
    }
}