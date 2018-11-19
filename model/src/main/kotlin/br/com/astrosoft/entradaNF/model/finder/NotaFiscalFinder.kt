package br.com.astrosoft.entradaNF.model.finder

import br.com.astrosoft.entradaNF.model.NotaFiscal
import br.com.astrosoft.entradaNF.model.query.QNotaFiscal
import io.ebean.Finder

open class NotaFiscalFinder : Finder<Long, NotaFiscal>(NotaFiscal::class.java) {

  val alias = QNotaFiscal._alias

  /**
   * Start a new typed query.
   */
  fun where(): QNotaFiscal {
     return QNotaFiscal(db())
  }

  /**
   * Start a new document store query.
   */
  fun text(): QNotaFiscal {
     return QNotaFiscal(db()).text()
  }
}
