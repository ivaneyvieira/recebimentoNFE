package br.com.astrosoft.entradaNF.model.query.assoc

import br.com.astrosoft.entradaNF.model.Loja
import br.com.astrosoft.entradaNF.model.query.QLoja
import io.ebean.typequery.PInteger
import io.ebean.typequery.PLocalDateTime
import io.ebean.typequery.PLong
import io.ebean.typequery.PString
import io.ebean.typequery.TQAssocBean
import io.ebean.typequery.TQProperty
import io.ebean.typequery.TypeQueryBean

/**
 * Association query bean for AssocLoja.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@TypeQueryBean
class QAssocLoja<R>(name: String, root: R) : TQAssocBean<Loja,R>(name, root) {

  lateinit var id: PLong<R>
  lateinit var createdAt: PLocalDateTime<R>
  lateinit var updatedAt: PLocalDateTime<R>
  lateinit var version: PInteger<R>
  lateinit var notas: QAssocNotaFiscal<R>
  lateinit var numero: PInteger<R>
  lateinit var sigla: PString<R>
  lateinit var cnpj: PString<R>

  // type safe fetch(properties) using varargs not supported yet ...
}
