package br.com.astrosoft.entradaNF.model

import br.com.astrosoft.entradaNF.model.finder.VolumeFinder
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
@Table(name = "volumes")
class Volume(
  val quantidade: Int,
  @Length(60)
  val especie: String,
  @Column(precision = 10, scale = 4)
  val pesoLiquido: Double,
  @Column(precision = 10, scale = 4)
  val peseoBruto: Double
                 ) : BaseModel(){
  @ManyToOne(cascade = [PERSIST, MERGE, REFRESH])
  var nota: NotaFiscal? = null

  companion object Find : VolumeFinder()
}
