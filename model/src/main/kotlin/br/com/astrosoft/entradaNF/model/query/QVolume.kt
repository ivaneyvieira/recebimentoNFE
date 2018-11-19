package br.com.astrosoft.entradaNF.model.query

import br.com.astrosoft.entradaNF.model.Volume
import br.com.astrosoft.entradaNF.model.query.assoc.QAssocNotaFiscal
import io.ebean.EbeanServer
import io.ebean.typequery.PDouble
import io.ebean.typequery.PInteger
import io.ebean.typequery.PLocalDateTime
import io.ebean.typequery.PLong
import io.ebean.typequery.PString
import io.ebean.typequery.TQRootBean
import io.ebean.typequery.TypeQueryBean

/**
 * Query bean for Volume.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@TypeQueryBean
class QVolume : TQRootBean<Volume, QVolume> {

  companion object {
    /**
     * shared 'Alias' instance used to provide
     * properties to select and fetch clauses
     */
    val _alias = QVolume(true)
  }

  lateinit var id: PLong<QVolume>
  lateinit var createdAt: PLocalDateTime<QVolume>
  lateinit var updatedAt: PLocalDateTime<QVolume>
  lateinit var version: PInteger<QVolume>
  lateinit var nota: QAssocNotaFiscal<QVolume>
  lateinit var quantidade: PInteger<QVolume>
  lateinit var especie: PString<QVolume>
  lateinit var pesoLiquido: PDouble<QVolume>
  lateinit var peseoBruto: PDouble<QVolume>


  /**
   * Construct with a given EbeanServer.
   */
  constructor(server: EbeanServer) : super(Volume::class.java, server)

  /**
   * Construct using the default EbeanServer.
   */
  constructor() : super(Volume::class.java)

  /**
   * Construct for Alias.
   */
  private constructor(dummy: Boolean) : super(dummy)
}
