package br.com.alura.orgs.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import br.com.alura.orgs.R
import br.com.alura.orgs.dao.ProdutoDao
import br.com.alura.orgs.model.Produto
import java.math.BigDecimal

class FormularioProdutoActivity : AppCompatActivity(R.layout.activity_formulario_produto) {


    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)


        val botaoSalvar =findViewById<Button>(R.id.botao_salvar)

        botaoSalvar.setOnClickListener{

            val campoNome = findViewById<EditText>(R.id.nome)
            val nome = campoNome.text.toString()
            val campoDescricao = findViewById<EditText>(R.id.descricao)
            val descricao = campoDescricao.text.toString()
            val campoValor = findViewById<EditText>(R.id.valor)
            val valorEmTexto = campoValor.text.toString()

            val valor = if(valorEmTexto.isBlank()) {
                BigDecimal.ZERO
            } else {
                BigDecimal(valorEmTexto)
            }

        val produtoNovo = Produto(
                nome = nome ,
               descricao= descricao ,
                valor = valor
            )

            Log.i("FormularioProduto" , "onCreate : $produtoNovo")
            val dao = ProdutoDao()
            dao.adiciona(produtoNovo)

            Log.i("Formulario Produto", "onCreate${dao.buscaTodos()}")

            finish()

        }
    }

}