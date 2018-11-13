package br.com.astrosoft.nfe.model

import br.com.samuelweb.nfe.util.validators.impl.ValidarIndIeDestinatario

data class NotaFiscal(
  val nfno : String,
  val nfse : String,
  val cnpjEmitente : String,
  val emitente : String,
  val cnpjDestinatario : String,
  val destinatario : String,
  val produtos : List<Produto>,
  val volumes : List<Volume>
                     )