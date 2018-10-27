package br.com.astrosoft.nfe

import br.com.samuelweb.nfe.NfeWeb
import br.com.samuelweb.nfe.dom.Enum.StatusEnum
import br.com.samuelweb.nfe.util.ConstantesUtil
import br.com.samuelweb.nfe.util.Estados.SP
import br.com.samuelweb.nfe.util.XmlUtil
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import org.w3c.dom.NodeList
import org.xml.sax.InputSource
import java.io.StringReader
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.xpath.XPathConstants
import javax.xml.xpath.XPathFactory

fun main(args: Array<String>) {
  val config = Config.iniciaConfiguracoes(SP)
  val chave = "4318 0893 6828 5400 0186 5500 1000 0333 7519 1155 4380".replace(" ", "")
  val retorno = NfeWeb.distribuicaoDfe(config, ConstantesUtil.TIPOS.CNPJ, "cnpj", ConstantesUtil.TIPOS.CHAVE, chave)
  println("Status:" + retorno.cStat)
  println("Motivo:" + retorno.xMotivo)
  println("NSU:" + retorno.ultNSU)
  println("Max NSU:" + retorno.maxNSU)

  if (StatusEnum.DOC_LOCALIZADO_PARA_DESTINATARIO.codigo == retorno.cStat) {
    val listaDoc = retorno.loteDistDFeInt.docZip

    println("Encontrado " + listaDoc.size + " Notas.")
    for (docZip in listaDoc) {
      println("Schema: " + docZip.schema)
      println("NSU:" + docZip.nsu)
      val xml = XmlUtil.gZipToXml(docZip.value)
      System.out.println("XML: $xml")


      val dbFactory = DocumentBuilderFactory.newInstance()
      val dBuilder = dbFactory.newDocumentBuilder()
      val xmlInput = InputSource(StringReader(xml))
      val doc = dBuilder.parse(xmlInput)

      val xpath = "/nfeProc/NFe/infNFe/det/prod"
      val xpFactory = XPathFactory.newInstance()
      val xPath = xpFactory.newXPath()
      val itemsTypeT1 = xPath.evaluate(xpath, doc, XPathConstants.NODESET) as NodeList
      for (i in 0 until itemsTypeT1.length) {
        val item =itemsTypeT1.item(i)
        val cmp1 = item.childNodes.item(1)
        println("${cmp1.nodeName}: ${item.childNodes.item(1).textContent}")
        println("cProd: ${item.childNodes.item(2).textContent}")
      }
    }
  }
}

fun convertXmlString2DataObject(xmlString: String, cls: Class<*>): Any {
  val xmlMapper = XmlMapper()
  return xmlMapper.readValue(xmlString, cls)
}