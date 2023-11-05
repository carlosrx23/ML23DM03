package br.edu.mouralacerda.ml23dm03

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Pessoa(
    val nome: String,
    val idade: Int = 0,
    val curso: String = "Carlos",
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0

) : Serializable



{

    override fun toString(): String {
//        return "ID: " + id + " / NOME: " + nome
        return "ID: $id / NOME: $nome / IDADE: $idade / CURSO: $curso"
    }

}