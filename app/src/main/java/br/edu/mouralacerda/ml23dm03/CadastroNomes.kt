package br.edu.mouralacerda.ml23dm03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner

class CadastroNomes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_nomes)

        val botaoSalvar = findViewById<Button>(R.id.btnSalvar)
        val texto = findViewById<EditText>(R.id.edtNome)
        val idade = findViewById<EditText>(R.id.edtIdade)
        val spinner = findViewById<Spinner>(R.id.spnCurso)


        botaoSalvar.setOnClickListener {
            val p = Pessoa(texto.text.toString(), idade.text.toString().toInt(), spinner.selectedItem.toString())

            Database.getInstance(this)!!.pessoaDAO().salvar(p)

            finish()
        }
    }
}
