
package br.edu.mouralacerda.ml23dm03

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text

class edicao_pessoas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edicao_pessoas)
        var listaDaTela: ListView? = null

        val idPessoaSelecionada = intent.getIntExtra("idPessoaSelecionada", -1).toLong()
        val nomePessoaSelecionada = intent.getStringExtra("nomePessoaSelecionada")
        val idadePessoaSelecionada = intent.getIntExtra("idadePessoaSelecionada", -1)
        val cursoPessoaSelecionada = intent.getStringExtra("cursoPessoaSelecionada")

        val btnEditar = findViewById<Button>(R.id.Editar)

            val edtNome2 = findViewById<TextView>(R.id.edtNome2)
            edtNome2.text = nomePessoaSelecionada

            val edtidade2 = findViewById<TextView>(R.id.edtidade2)
            edtidade2.setText(idadePessoaSelecionada.toString())

            val spnCurso2 = findViewById<Spinner>(R.id.spnCurso2)


        btnEditar.setOnClickListener {

            val novoNome = edtNome2.text.toString()
            val novaIdade = edtidade2.text.toString().toInt()
            val novoCurso = spnCurso2.selectedItem.toString()

            Database.getInstance(this)!!.pessoaDAO().atualizar(idPessoaSelecionada , novoNome, novaIdade,novoCurso)
            Log.d("MeuApp", "Novos valores - ID: ${idPessoaSelecionada}, NOME: ${novoNome}, Idade: ${novaIdade}")

            val resultIntent = Intent()
            resultIntent.putExtra("idPessoaSelecionada", idPessoaSelecionada)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}





