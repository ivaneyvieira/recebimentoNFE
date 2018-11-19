package br.com.astrosoft.entradaNF.model.query.assoc

import br.com.astrosoft.entradaNF.model.Volume
import br.com.astrosoft.entradaNF.model.query.QVolume
import io.ebean.typequery.PDouble
import io.ebean.typequery.PInteger
import io.ebean.typequery.PLocalDateTime
import io.ebean.typequery.PLong
import io.ebean.typequery.PString
import io.ebean.typequery.TQAssocBean
import io.ebean.typequery.TQProperty
import io.ebean.typequery.TypeQueryBean

/**
 * Association query bean for AssocVolume.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@TypeQueryBean
class QAssocVolume<R>(name: String, root: R) : TQAssocBean<Volume,R>(name, root) {

  lateinit var id: PLong<R>
  lateinit var createdAt: PLocalDateTime<R>
  lateinit var updatedAt: PLocalDateTime<R>
  lateinit var version: PInteger<R>
  lateinit var nota: QAssocNotaFiscal<R>
  lateinit var quantidade: PInteger<R>
  lateinit var especie: PString<R>
  lateinit var pesoLiquido: PDouble<R>
  lateinit var peseoBruto: PDouble<R>

  // type safe fetch(properties) using varargs not supported yet ...
}
