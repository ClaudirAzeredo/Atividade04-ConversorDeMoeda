package br.unipar.atividade04_conversordemoeda

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editTextValor: EditText
    private lateinit var editTextTaxa: EditText
    private lateinit var buttonConverter: Button
    private lateinit var textViewResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextValor = findViewById(R.id.editTextValor)
        editTextTaxa = findViewById(R.id.editTextTaxa)
        buttonConverter = findViewById(R.id.buttonConverter)
        textViewResultado = findViewById(R.id.textViewResultado)

        buttonConverter.setOnClickListener {
            converterMoeda()
        }
    }


    private fun converterMoeda() {

        val valorInserido = editTextValor.text.toString()
        val taxaConversao = editTextTaxa.text.toString()

        if (valorInserido.isEmpty() || taxaConversao.isEmpty()) {
            Toast.makeText(this, "Por favor, preencha todos os campos!", Toast.LENGTH_SHORT).show()
            return
        }

        val valor = valorInserido.toDoubleOrNull()
        val taxa = taxaConversao.toDoubleOrNull()

        if (valor == null || taxa == null) {
            Toast.makeText(this, "Por favor, insira valores válidos!", Toast.LENGTH_SHORT).show()
            return
        }

        val valorConvertido = valor * taxa

        textViewResultado.text = "Valor convertido: R$ %.2f".format(valorConvertido)
    }
}
