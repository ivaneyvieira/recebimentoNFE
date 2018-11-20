package br.com.astrosoft.entradaNF.model

import br.com.astrosoft.entradaNF.model.finder.ViewNotaSaciFinder
import io.ebean.annotation.Cache
import io.ebean.annotation.View
import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.Id

@Cache(enableQueryCache = false)
@Entity
@View(name = "v_notas")
class ViewNotaSaci(
  @Id
  val invno: Int,
  val dtEmissao: LocalDate,
  val dtEntrada: LocalDate,
  val nfno: String,
  val nfse: String,
  val chave: String,
  val cnpjDest: String,
  val cnpjEmit: String,
  val fornecedor: String
                  ) {
  companion object Find : ViewNotaSaciFinder()
}
