package br.com.astrosoft.entradaNF.model.finder

import br.com.astrosoft.entradaNF.model.Produto
import br.com.astrosoft.entradaNF.model.query.QProduto
import io.ebean.Finder

open class ProdutoFinder : Finder<Long, Produto>(Produto::class.java) {

  val alias = QProduto._alias

  /**
   * Start a new typed query.
   */
  fun where(): QProduto {
     return QProduto(db())
  }

  /**
   * Start a new document store query.
   */
  fun text(): QProduto {
     return QProduto(db()).text()
  }
}
