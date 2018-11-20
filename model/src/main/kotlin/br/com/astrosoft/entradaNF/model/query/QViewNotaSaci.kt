package br.com.astrosoft.entradaNF.model.query

import br.com.astrosoft.entradaNF.model.ViewNotaSaci
import io.ebean.EbeanServer
import io.ebean.typequery.PInteger
import io.ebean.typequery.PLocalDate
import io.ebean.typequery.PLocalDateTime
import io.ebean.typequery.PLong
import io.ebean.typequery.PString
import io.ebean.typequery.TQRootBean
import io.ebean.typequery.TypeQueryBean

/**
 * Query bean for ViewNotaSaci.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@TypeQueryBean
class QViewNotaSaci : TQRootBean<ViewNotaSaci, QViewNotaSaci> {

  companion object {
    /**
     * shared 'Alias' instance used to provide
     * properties to select and fetch clauses
     */
    val _alias = QViewNotaSaci(true)
  }

  lateinit var id: PLong<QViewNotaSaci>
  lateinit var createdAt: PLocalDateTime<QViewNotaSaci>
  lateinit var updatedAt: PLocalDateTime<QViewNotaSaci>
  lateinit var version: PInteger<QViewNotaSaci>
  lateinit var invno: PInteger<QViewNotaSaci>
  lateinit var dtEmissao: PLocalDate<QViewNotaSaci>
  lateinit var dtEntrada: PLocalDate<QViewNotaSaci>
  lateinit var nfno: PString<QViewNotaSaci>
  lateinit var nfse: PString<QViewNotaSaci>
  lateinit var chave: PString<QViewNotaSaci>
  lateinit var cnpjDest: PString<QViewNotaSaci>
  lateinit var cnpjEmit: PString<QViewNotaSaci>
  lateinit var fornecedor: PString<QViewNotaSaci>


  /**
   * Construct with a given EbeanServer.
   */
  constructor(server: EbeanServer) : super(ViewNotaSaci::class.java, server)

  /**
   * Construct using the default EbeanServer.
   */
  constructor() : super(ViewNotaSaci::class.java)

  /**
   * Construct for Alias.
   */
  private constructor(dummy: Boolean) : super(dummy)
}
