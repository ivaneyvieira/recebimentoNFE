package br.com.astrosoft.entradaNF.model.finder

import br.com.astrosoft.entradaNF.model.ViewNotaSaci
import br.com.astrosoft.entradaNF.model.query.QViewNotaSaci
import io.ebean.Finder

open class ViewNotaSaciFinder : Finder<Long, ViewNotaSaci>(ViewNotaSaci::class.java) {

  val alias = QViewNotaSaci._alias

  /**
   * Start a new typed query.
   */
  fun where(): QViewNotaSaci {
     return QViewNotaSaci(db())
  }

  /**
   * Start a new document store query.
   */
  fun text(): QViewNotaSaci {
     return QViewNotaSaci(db()).text()
  }
}
