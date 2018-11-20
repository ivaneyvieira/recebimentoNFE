package br.com.astrosoft.entradaNF.model.query.assoc

import br.com.astrosoft.entradaNF.model.ViewNotaSaci
import br.com.astrosoft.entradaNF.model.query.QViewNotaSaci
import io.ebean.typequery.PInteger
import io.ebean.typequery.PLocalDate
import io.ebean.typequery.PLocalDateTime
import io.ebean.typequery.PLong
import io.ebean.typequery.PString
import io.ebean.typequery.TQAssocBean
import io.ebean.typequery.TQProperty
import io.ebean.typequery.TypeQueryBean

/**
 * Association query bean for AssocViewNotaSaci.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@TypeQueryBean
class QAssocViewNotaSaci<R>(name: String, root: R) : TQAssocBean<ViewNotaSaci,R>(name, root) {

  lateinit var id: PLong<R>
  lateinit var createdAt: PLocalDateTime<R>
  lateinit var updatedAt: PLocalDateTime<R>
  lateinit var version: PInteger<R>
  lateinit var invno: PInteger<R>
  lateinit var dtEmissao: PLocalDate<R>
  lateinit var dtEntrada: PLocalDate<R>
  lateinit var nfno: PString<R>
  lateinit var nfse: PString<R>
  lateinit var chave: PString<R>
  lateinit var cnpjDest: PString<R>
  lateinit var cnpjEmit: PString<R>
  lateinit var fornecedor: PString<R>

  // type safe fetch(properties) using varargs not supported yet ...
}
