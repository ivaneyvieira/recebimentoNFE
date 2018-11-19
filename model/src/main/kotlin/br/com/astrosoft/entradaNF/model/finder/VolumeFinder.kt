package br.com.astrosoft.entradaNF.model.finder

import br.com.astrosoft.entradaNF.model.Volume
import br.com.astrosoft.entradaNF.model.query.QVolume
import io.ebean.Finder

open class VolumeFinder : Finder<Long, Volume>(Volume::class.java) {

  val alias = QVolume._alias

  /**
   * Start a new typed query.
   */
  fun where(): QVolume {
     return QVolume(db())
  }

  /**
   * Start a new document store query.
   */
  fun text(): QVolume {
     return QVolume(db()).text()
  }
}
