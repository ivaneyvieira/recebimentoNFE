package br.com.astrosoft.nfe.model

data class Produto(
  val codigo : String,
  val ean : String,
  val descricao : String,
  val quantidade : Double,
  val valorUnitario : Double,
  val unidade : String
                  )