package br.com.astrosoft.nfe

import br.com.samuelweb.certificado.Certificado
import br.com.samuelweb.certificado.CertificadoService
import br.com.samuelweb.nfe.dom.ConfiguracoesWebNfe
import br.com.samuelweb.nfe.util.ConstantesUtil
import br.com.samuelweb.nfe.util.Estados
import java.io.FileInputStream
import java.util.*

object Config {
  val EMPRESA= "engecopi"
  val HOME_DIR = System.getProperty("user.home") ?: "."
  val caminhoCertificado = "$HOME_DIR/certificado/$EMPRESA.pxf"
  val properties = Properties().apply {
    load(FileInputStream("$HOME_DIR/certificado/password.properties"))
  }
  val senha = properties["$EMPRESA.password"]?.toString() ?: ""
  val schemaDir = "$HOME_DIR/certificado/schemas"

  fun iniciaConfiguracoes(estado : Estados): ConfiguracoesWebNfe {
    val certificado: Certificado = certifidoA1Pfx()
    println("Alias Certificado :" +certificado.nome)
    println("Dias Restantes Certificado :" +certificado.diasRestantes)
    println("Validade Certificado :" +certificado.vencimento)

    return ConfiguracoesWebNfe.iniciaConfiguracoes(estado,
                                                   ConstantesUtil.AMBIENTE.PRODUCAO,
                                                   certificado,
                                                   schemaDir)
  }

  fun certifidoA1Pfx(): Certificado {
    return CertificadoService.certificadoPfx(caminhoCertificado, senha)
  }
}
