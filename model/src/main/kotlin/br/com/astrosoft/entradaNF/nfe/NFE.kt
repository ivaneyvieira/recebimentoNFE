package br.com.astrosoft.entradaNF.nfe

import br.com.astrosoft.entradaNF.nfe.Parser.toDoc
import br.com.astrosoft.entradaNF.model.NotaFiscal
import br.com.astrosoft.entradaNF.model.Produto
import br.com.astrosoft.entradaNF.model.Volume
import br.com.samuelweb.nfe.NfeWeb
import br.com.samuelweb.nfe.dom.Enum.StatusEnum
import br.com.samuelweb.nfe.util.ConstantesUtil
import br.com.samuelweb.nfe.util.Estados
import br.com.samuelweb.nfe.util.XmlUtil
import org.w3c.dom.Document
import org.w3c.dom.Node
import org.w3c.dom.NodeList
import org.xml.sax.InputSource
import java.io.StringReader
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.xpath.XPathConstants
import javax.xml.xpath.XPathFactory
import br.com.samuelweb.nfe.Nfe



object NFE {
  fun consultaNota(cnpj: String, chave: String, estado: Estados): NotaFiscal? {
    return consultaXML(cnpj, chave, estado).firstOrNull()?.let { xml ->
      println(xml)
      xmlToNota(chave, xml)
    }
  }

  private fun xmlToNota(chave : String, xml: String): NotaFiscal? {
    return toDoc(xml)?.let { doc ->
      val mapIde = doc
        .query("/nfeProc/NFe/infNFe/ide")
        .findOne()
      val mapEmit = doc
        .query("/nfeProc/NFe/infNFe/emit")
        .findOne()
      val mapDest = doc
        .query("/nfeProc/NFe/infNFe/dest")
        .findOne()
      val produtos = doc.query("/nfeProc/NFe/infNFe/det/prod").toProdutos()
      val volumes = doc.query("/nfeProc/NFe/infNFe/transp/vol").toVolumes()
      val nota = NotaFiscal(
        chave = chave,
        nfno = mapIde["nNF"] ?: "",
        nfse = mapIde["serie"] ?: "",
        cnpjDestinatario = mapDest["CNPJ"] ?: "",
        cnpjEmitente = mapEmit["CNPJ"] ?: "",
        destinatario = mapDest["xNome"] ?: "",
        emitente = mapEmit["xNome"] ?: ""
                                                            )
      nota.produtos =produtos
      nota.volumes = volumes
      nota
    }
  }

  fun consultaXML(cnpj: String, chave: String, estado: Estados): List<String> {
    val config = Config.iniciaConfiguracoesWeb(estado)
    val consulta = NfeWeb.consultaXml(config, chave, ConstantesUtil.NFE)
    System.out.println("Status:" + consulta?.cStat)
    System.out.println("Motivo:" + consulta?.xMotivo)
    System.out.println("Data:" + consulta?.protNFe?.infProt?.dhRecbto)

    val retorno = NfeWeb.distribuicaoDfe(config, ConstantesUtil.TIPOS.CNPJ,
                                         cnpj, ConstantesUtil.TIPOS.CHAVE, chave)
    return if (StatusEnum.DOC_LOCALIZADO_PARA_DESTINATARIO.codigo == retorno.cStat) {
      val listaDoc = retorno.loteDistDFeInt.docZip
      listaDoc.asSequence().map { docZip ->
        XmlUtil.gZipToXml(docZip.value)
      }.toList()
    } else throw Exception(retorno.xMotivo)
  }

  fun Document.query(xpath: String): List<Map<String, String>> {
    val doc = this
    return sequence {
      val xpFactory = XPathFactory.newInstance()
      val xPath = xpFactory.newXPath()
      val itens = xPath.evaluate(xpath, doc, XPathConstants.NODESET) as NodeList
      for (i in 0 until itens.length) {
        val item = itens.item(i)
        yield(item)
      }
    }.map { node ->
      node.findMapValue().toMap()
    }.toList()
  }

  fun Node.findMapValue(): Map<String, String> {
    val node = this
    return sequence {
      val itens = node.childNodes
      for (i in 0 until itens.length) {
        val item = itens.item(i)
        yield(item)
      }
    }.map { it.nodeName to it.textContent }
      .toMap()
  }
}

private fun     List<Map<String, String>>.toVolumes(): List<Volume> {
  return this.map { map->
    Volume(
      quantidade = map["qVol"]?.toIntOrNull() ?: 0,
      especie = map["esp"] ?: "",
      peseoBruto = map["pesoB"]?.toDoubleOrNull() ?: 0.00,
      pesoLiquido = map["pesoL"]?.toDoubleOrNull() ?: 0.00
                                           )
  }
}

private fun List<Map<String, String>>.toProdutos(): List<Produto> {
  return this.map { map ->
    Produto(
      codigo = map["cProd"] ?: "",
      descricao = map["xProd"] ?: "",
      ean = map["cEAN"] ?: "",
      quantidade = map["qCom"]?.toDoubleOrNull() ?: 0.00,
      unidade = map["uCom"] ?: "",
      valorUnitario = map["vUnCom"]?.toDoubleOrNull() ?: 0.00
                                            )
  }
}

private fun List<Map<String, String>>?.findOne(): Map<String, String> {
  return this?.firstOrNull() ?: mapOf()
}

object Parser {
  val dbFactory = DocumentBuilderFactory.newInstance()
  val dBuilder = dbFactory.newDocumentBuilder()

  fun toDoc(xml: String): Document? {
    val xmlInput = InputSource(StringReader(xml))
    return dBuilder.parse(xmlInput)
  }
}