package br.com.astrosoft.entradaNF.model

import io.ebean.annotation.Cache
import io.ebean.annotation.View
import javax.persistence.Entity
import javax.persistence.Id

@Cache(enableQueryCache = false)
@Entity
@View(name = "v_produto")
class ViewProdutoSaci (
  @Id
  val prdno : String,
  val name : String,
  val grade : String,
  val codigo : String,
  val ean : String,
  val qtPacote: Double
                      ){
}