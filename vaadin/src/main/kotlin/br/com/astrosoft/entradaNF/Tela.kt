package br.com.astrosoft.entradaNF

import br.com.astrosoft.nfe.Config
import br.com.astrosoft.nfe.NFE
import br.com.astrosoft.nfe.model.Produto
import br.com.astrosoft.nfe.model.Volume
import br.com.samuelweb.nfe.util.Estados.SP
import com.vaadin.flow.component.icon.VaadinIcon
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.router.Route
import com.github.appreciated.app.layout.annotations.MenuCaption
import com.github.appreciated.app.layout.annotations.MenuIcon
import com.github.vok.karibudsl.flow.addColumnFor
import com.github.vok.karibudsl.flow.button
import com.github.vok.karibudsl.flow.grid
import com.github.vok.karibudsl.flow.horizontalLayout
import com.github.vok.karibudsl.flow.label
import com.github.vok.karibudsl.flow.textField
import com.vaadin.flow.component.grid.Grid
import com.vaadin.flow.component.notification.Notification
import com.vaadin.flow.component.notification.Notification.Position.TOP_END
import com.vaadin.flow.component.textfield.TextField
import com.vaadin.flow.data.provider.DataProvider
import com.vaadin.flow.data.provider.ListDataProvider
import java.lang.Exception

@Route(value = "", layout = MainAppLayout::class)
@MenuCaption("Home")
@MenuIcon(VaadinIcon.HOME)
class Tela : VerticalLayout() {
  private var textCodigo: TextField? = null
  private lateinit var gridVolumes: Grid<Volume>
  private lateinit var gridProdutos: Grid<Produto>
  private lateinit var cnpjEmitente: TextField
  private lateinit var nomeEmitente: TextField

  init {
    horizontalLayout {
      textCodigo = textField("Nota Fiscal") {
        width = "500px"
      }
      button("Consulta") {
        addClickListener {
          try {
            val chave = textCodigo?.value?.replace(" ", "") ?: ""
            val nota = NFE.consultaNota("07483654000405", chave)
            cnpjEmitente.value = nota?.cnpjEmitente ?: ""
            nomeEmitente.value = nota?.emitente ?: ""
            gridVolumes.dataProvider = ListDataProvider(nota?.volumes.orEmpty())
            gridProdutos.dataProvider = ListDataProvider(nota?.produtos.orEmpty())
          } catch (e: Exception) {
            Notification.show(e.message, 3000, TOP_END)
          }
        }
      }
    }
    horizontalLayout {
      cnpjEmitente = textField("CNPJ") {
        isReadOnly = true
      }
      nomeEmitente = textField("Emitente") {
        isReadOnly = true
        width = "500px"
      }
    }
    label("Volumes")
    gridVolumes = grid(ListDataProvider(listOf<Volume>())) {
      height = "200px"
      addColumnFor(Volume::quantidade) {
        setHeader("Quantidade")
      }
      addColumnFor(Volume::especie) {
        setHeader("Unidade")
      }
      addColumnFor(Volume::peseoBruto) {
        setHeader("Peso Bruto")
      }
      addColumnFor(Volume::pesoLiquido) {
        setHeader("Peso Líquido")
      }
    }
    label("Produtos")
    gridProdutos = grid(ListDataProvider(listOf<Produto>())) {
      height = "200px"
      addColumnFor(Produto::codigo) {
        setHeader("Código")
      }
      addColumnFor(Produto::descricao) {
        setHeader("Descrição")
      }
      addColumnFor(Produto::ean) {
        setHeader("EAN")
      }
      addColumnFor(Produto::quantidade) {
        setHeader("Quantidade")
      }
      addColumnFor(Produto::unidade) {
        setHeader("Unidade")
      }
      addColumnFor(Produto::valorUnitario) {
        setHeader("Valor Unitário")
      }
    }
  }
}