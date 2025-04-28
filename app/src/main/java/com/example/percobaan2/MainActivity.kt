package com.example.percobaan2

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.percobaan2.ui.theme.Percobaan2Theme
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class MainActivity : ComponentActivity() {
    private lateinit var edtAngka1: EditText
    private lateinit var edtAngka2: EditText
    private lateinit var txtHasil: TextView

    private fun getInputValues(): Pair<Double, Double>? {
        val input1 = edtAngka1.text.toString()
        val input2 = edtAngka2.text.toString()

        return try {
            Pair(input1.toDouble(), input2.toDouble())
        } catch (e: NumberFormatException) {
            txtHasil.text = "Input tidak valid"
            null
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtAngka1 = findViewById(R.id.edt_angka1)
        edtAngka2 = findViewById(R.id.edt_angka2)
        txtHasil = findViewById(R.id.txt_hasil)

        val btnClear = findViewById<Button>(R.id.btn_clear)
        val btnTambah = findViewById<Button>(R.id.btn_tambah)
        val btnKurang = findViewById<Button>(R.id.btn_kurang)
        val btnKali = findViewById<Button>(R.id.btn_kali)
        val btnBagi = findViewById<Button>(R.id.btn_bagi)
        val btnModulus = findViewById<Button>(R.id.btn_modulus)

        btnClear.setOnClickListener {
            edtAngka1.text.clear()
            edtAngka2.text.clear()
            txtHasil.text = "0"
        }

        btnTambah.setOnClickListener {
            getInputValues()?.let {
                txtHasil.text = (it.first + it.second).toString()
            }
        }

        btnKurang.setOnClickListener {
            getInputValues()?.let {
                txtHasil.text = (it.first - it.second).toString()
            }
        }

        btnKali.setOnClickListener {
            getInputValues()?.let {
                txtHasil.text = (it.first * it.second).toString()
            }
        }

        btnBagi.setOnClickListener {
            getInputValues()?.let {
                if (it.second == 0.0) {
                    txtHasil.text = "Tidak bisa dibagi 0"
                } else {
                    txtHasil.text = (it.first / it.second).toString()
                }
            }
        }

        btnModulus.setOnClickListener {
            getInputValues()?.let {
                if (it.second == 0.0) {
                    txtHasil.text = "Tidak bisa modulus 0"
                } else {
                    txtHasil.text = (it.first % it.second).toString()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Percobaan2Theme {
        Greeting("Android")
    }
}