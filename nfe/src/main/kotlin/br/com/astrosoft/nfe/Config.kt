import br.com.samuelweb.certificado.Certificado
import br.com.samuelweb.nfe.dom.ConfiguracoesIniciaisNfe
import br.com.samuelweb.nfe.util.ConstantesUtil
import br.com.samuelweb.nfe.util.Estados
import br.com.samuelweb.certificado.CertificadoService

object Config {
  val caminhoCertificado = "/home/ivaneyvieira/git/nfe/download/engecopi.pfx"
  val senha = "ENGDEL3010"
  val cnpj = "07483654000162"
  val cnpj2 = "07483654000405"

  fun iniciaConfiguracoes(): ConfiguracoesIniciaisNfe {
    val certificado: Certificado = certifidoA1Pfx()
    println("Alias Certificado :" +certificado.getNome())
    println("Dias Restantes Certificado :" +certificado.getDiasRestantes())
    println("Validade Certificado :" +certificado.getVencimento())
    val schema = "/home/ivaneyvieira/git/nfe/download/schemas"
    return ConfiguracoesIniciaisNfe.iniciaConfiguracoes(Estados.SP,
                                                        ConstantesUtil.AMBIENTE.PRODUCAO,
                                                        certificado,
                                                        schema)
  }

  private fun certifidoA1Pfx(): Certificado {
    return CertificadoService.certificadoPfx(caminhoCertificado, senha)
  }
}
