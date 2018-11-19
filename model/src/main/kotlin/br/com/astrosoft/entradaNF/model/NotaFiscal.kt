package br.com.astrosoft.entradaNF.model

import br.com.astrosoft.framework.model.BaseModel
import io.ebean.annotation.Length
import javax.persistence.CascadeType.MERGE
import javax.persistence.CascadeType.PERSIST
import javax.persistence.CascadeType.REFRESH
import javax.persistence.Entity
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "notas")
class NotaFiscal(
  @Length(50)
  var chave: String,
  @Length(32)
  var nfno: String,
  @Length(4)
  var nfse: String,
  @Length(20)
  var cnpjEmitente: String,
  @Length(100)
  var emitente: String,
  @Length(20)
  var cnpjDestinatario: String,
  @Length(100)
  var destinatario: String
                ) : BaseModel() {
  @ManyToOne(cascade = [PERSIST, MERGE, REFRESH])
  var loja: Loja? = null
  @OneToMany(mappedBy = "notas", cascade = [PERSIST, MERGE, REFRESH])
  var produtos: List<Produto> = emptyList()
    set(value) {
      field = value
      value.forEach { it.nota = this }
    }
  @OneToMany(mappedBy = "notas", cascade = [PERSIST, MERGE, REFRESH])
  var volumes: List<Volume> = emptyList()
    set(value) {
      field = value
      value.forEach { it.nota = this }
    }
}