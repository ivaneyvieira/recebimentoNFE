package br.com.astrosoft.nfe

import br.com.samuelweb.nfe.util.Estados

fun main(args: Array<String>) {
  val nota = NFE.consultaNota("07483654000405",
                              "4318 0893 6828 5400 0186 5500 1000 0333 7519 1155 4380".replace(" ", ""), Estados.PI)
  println(nota)
}