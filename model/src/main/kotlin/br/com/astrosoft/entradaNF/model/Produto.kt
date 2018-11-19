package br.com.astrosoft.entradaNF.model

import br.com.astrosoft.framework.model.BaseModel
import io.ebean.annotation.Length
import javax.persistence.CascadeType.MERGE
import javax.persistence.CascadeType.PERSIST
import javax.persistence.CascadeType.REFRESH
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "produtos")
class Produto(
  @Length(60)
  var codigo: String,
  @Length(14)
  var ean: String,
  @Length(120)
  var descricao: String,
  @Column(precision = 10, scale = 4)
  var quantidade: Double,
  @Column(precision = 10, scale = 2)
  var valorUnitario: Double,
  @Length(6)
  var unidade: String
             ) : BaseModel() {
  @ManyToOne(cascade = [PERSIST, MERGE, REFRESH])
  var nota: NotaFiscal? = null
}