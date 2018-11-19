package br.com.astrosoft.entradaNF.model.query

import br.com.astrosoft.entradaNF.model.Produto
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
 * Query bean for Produto.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@TypeQueryBean
class QProduto : TQRootBean<Produto, QProduto> {

  companion object {
    /**
     * shared 'Alias' instance used to provide
     * properties to select and fetch clauses
     */
    val _alias = QProduto(true)
  }

  lateinit var id: PLong<QProduto>
  lateinit var createdAt: PLocalDateTime<QProduto>
  lateinit var updatedAt: PLocalDateTime<QProduto>
  lateinit var version: PInteger<QProduto>
  lateinit var nota: QAssocNotaFiscal<QProduto>
  lateinit var codigo: PString<QProduto>
  lateinit var ean: PString<QProduto>
  lateinit var descricao: PString<QProduto>
  lateinit var quantidade: PDouble<QProduto>
  lateinit var valorUnitario: PDouble<QProduto>
  lateinit var unidade: PString<QProduto>


  /**
   * Construct with a given EbeanServer.
   */
  constructor(server: EbeanServer) : super(Produto::class.java, server)

  /**
   * Construct using the default EbeanServer.
   */
  constructor() : super(Produto::class.java)

  /**
   * Construct for Alias.
   */
  private constructor(dummy: Boolean) : super(dummy)
}
