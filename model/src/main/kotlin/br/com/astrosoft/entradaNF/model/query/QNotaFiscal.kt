package br.com.astrosoft.entradaNF.model.query

import br.com.astrosoft.entradaNF.model.NotaFiscal
import br.com.astrosoft.entradaNF.model.query.assoc.QAssocLoja
import br.com.astrosoft.entradaNF.model.query.assoc.QAssocProduto
import br.com.astrosoft.entradaNF.model.query.assoc.QAssocVolume
import io.ebean.EbeanServer
import io.ebean.typequery.PInteger
import io.ebean.typequery.PLocalDateTime
import io.ebean.typequery.PLong
import io.ebean.typequery.PString
import io.ebean.typequery.TQRootBean
import io.ebean.typequery.TypeQueryBean

/**
 * Query bean for NotaFiscal.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@TypeQueryBean
class QNotaFiscal : TQRootBean<NotaFiscal, QNotaFiscal> {

  companion object {
    /**
     * shared 'Alias' instance used to provide
     * properties to select and fetch clauses
     */
    val _alias = QNotaFiscal(true)
  }

  lateinit var id: PLong<QNotaFiscal>
  lateinit var createdAt: PLocalDateTime<QNotaFiscal>
  lateinit var updatedAt: PLocalDateTime<QNotaFiscal>
  lateinit var version: PInteger<QNotaFiscal>
  lateinit var loja: QAssocLoja<QNotaFiscal>
  lateinit var produtos: QAssocProduto<QNotaFiscal>
  lateinit var volumes: QAssocVolume<QNotaFiscal>
  lateinit var chave: PString<QNotaFiscal>
  lateinit var nfno: PString<QNotaFiscal>
  lateinit var nfse: PString<QNotaFiscal>
  lateinit var cnpjEmitente: PString<QNotaFiscal>
  lateinit var emitente: PString<QNotaFiscal>
  lateinit var cnpjDestinatario: PString<QNotaFiscal>
  lateinit var destinatario: PString<QNotaFiscal>


  /**
   * Construct with a given EbeanServer.
   */
  constructor(server: EbeanServer) : super(NotaFiscal::class.java, server)

  /**
   * Construct using the default EbeanServer.
   */
  constructor() : super(NotaFiscal::class.java)

  /**
   * Construct for Alias.
   */
  private constructor(dummy: Boolean) : super(dummy)
}
