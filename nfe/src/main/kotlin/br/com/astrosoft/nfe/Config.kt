package br.com.astrosoft.nfe

import br.com.samuelweb.certificado.Certificado
import br.com.samuelweb.certificado.CertificadoService
import br.com.samuelweb.nfe.dom.ConfiguracoesIniciaisNfe
import br.com.samuelweb.nfe.dom.ConfiguracoesWebNfe
import br.com.samuelweb.nfe.util.ConstantesUtil
import br.com.samuelweb.nfe.util.Estados
import java.io.FileInputStream
import java.lang.invoke.MethodHandles
import java.util.*

object Config {
  val EMPRESA= "engecopi"
  val HOME_DIR = System.getProperty("user.home") ?: "."
  val caminhoCertificado = "$HOME_DIR/certificados/$EMPRESA.pfx"
  val properties = Properties().apply {
    load(FileInputStream("$HOME_DIR/certificados/password.properties"))
  }
  val senha = properties["$EMPRESA.password"]?.toString() ?: ""
  val schemaDir = "$HOME_DIR/certificados/schemas"

  fun iniciaConfiguracoesWeb(estado : Estados): ConfiguracoesWebNfe {
    val certificado: Certificado = certifidoA1Pfx()

    return ConfiguracoesWebNfe.iniciaConfiguracoes(estado,
                                                   ConstantesUtil.AMBIENTE.PRODUCAO,
                                                   certificado,
                                                   schemaDir,
                                                   false)
  }

  fun iniciaConfiguracoes(estado : Estados): ConfiguracoesIniciaisNfe {
    val certificado: Certificado = certifidoA1Pfx()

    return ConfiguracoesIniciaisNfe.iniciaConfiguracoes(estado, ConstantesUtil.AMBIENTE.PRODUCAO,
                                                        certificado, schemaDir)
  }

  fun certifidoA1Pfx(): Certificado {
    return CertificadoService.certificadoPfx(caminhoCertificado, senha)
  }
}
