package br.com.astrosoft.entradaNF.model.query.assoc

import br.com.astrosoft.entradaNF.model.NotaFiscal
import br.com.astrosoft.entradaNF.model.query.QNotaFiscal
import io.ebean.typequery.PInteger
import io.ebean.typequery.PLocalDateTime
import io.ebean.typequery.PLong
import io.ebean.typequery.PString
import io.ebean.typequery.TQAssocBean
import io.ebean.typequery.TQProperty
import io.ebean.typequery.TypeQueryBean

/**
 * Association query bean for AssocNotaFiscal.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@TypeQueryBean
class QAssocNotaFiscal<R>(name: String, root: R) : TQAssocBean<NotaFiscal,R>(name, root) {

  lateinit var id: PLong<R>
  lateinit var createdAt: PLocalDateTime<R>
  lateinit var updatedAt: PLocalDateTime<R>
  lateinit var version: PInteger<R>
  lateinit var loja: QAssocLoja<R>
  lateinit var produtos: QAssocProduto<R>
  lateinit var volumes: QAssocVolume<R>
  lateinit var chave: PString<R>
  lateinit var nfno: PString<R>
  lateinit var nfse: PString<R>
  lateinit var cnpjEmitente: PString<R>
  lateinit var emitente: PString<R>
  lateinit var cnpjDestinatario: PString<R>
  lateinit var destinatario: PString<R>

  // type safe fetch(properties) using varargs not supported yet ...
}
