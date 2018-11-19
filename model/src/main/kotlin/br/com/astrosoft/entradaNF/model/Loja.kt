package br.com.astrosoft.entradaNF.model

import br.com.astrosoft.entradaNF.model.finder.LojaFinder
import br.com.astrosoft.framework.model.BaseModel
import io.ebean.annotation.Index
import io.ebean.annotation.Length
import javax.persistence.CascadeType.MERGE
import javax.persistence.CascadeType.PERSIST
import javax.persistence.CascadeType.REFRESH
import javax.persistence.Entity
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "lojas")
class Loja(
  @Index(unique = true)
  var numero: Int = 0,
  @Length(2)
  var sigla: String = ""
          ) : BaseModel(){
  @OneToMany(mappedBy = "loja", cascade = [PERSIST, MERGE, REFRESH])
  var notas: List<NotaFiscal> = emptyList()

  companion object Find : LojaFinder()
}
