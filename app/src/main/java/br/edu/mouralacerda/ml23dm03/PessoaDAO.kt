package br.edu.mouralacerda.ml23dm03

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface PessoaDAO {

    @Insert
    fun salvar(obj: Pessoa)

    @Delete
    fun apagar(obj: Pessoa)

    @Query("SELECT nome FROM Pessoa WHERE id = :id") // Altere a consulta para incluir o nome
    fun obterNomePorId(id: Long): String // Retorne o nome como uma String

    @Query("SELECT * FROM Pessoa")
    fun listar(): List<Pessoa>

    @Query("SELECT * FROM Pessoa ORDER BY nome")
    fun listarPorNome(): List<Pessoa>

    @Query("SELECT * FROM Pessoa ORDER BY id")
    fun listarPorId(): List<Pessoa>

    @Query("UPDATE Pessoa SET nome = :novoNome, idade = :novaIdade, curso = :novoCurso WHERE id = :idPessoa")
    fun atualizar(idPessoa: Long, novoNome: String, novaIdade: Int, novoCurso: String)
}
