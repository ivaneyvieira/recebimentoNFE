package br.com.astrosoft.framework.model

import io.ebean.typequery.generator.Generator
import io.ebean.typequery.generator.GeneratorConfig
import java.io.IOException

object MainQueryBeanGenerator {
  
  @Throws(IOException::class)
  @JvmStatic
  fun main(args: Array<String>) {
    
    val config = GeneratorConfig()
    config.lang = "kt"
    config.classesDirectory = "./model/out/production/classes/"
    //config.classesDirectory = "./model/build/classes/kotlin/main/"
    config.destDirectory = "./model/src/main/kotlin"
    config.destResourceDirectory = "./model/src/main/resources"
  
    config.entityBeanPackage = "br.com.astrosoft.entradaNF.model"
    config.destPackage = "br.com.astrosoft.entradaNF.model.query"
  
    config.isOverwriteExistingFinders = true
    
    val generator = Generator(config)
    generator.generateQueryBeans()
    
    // Additionally generate 'finder's
    generator.generateFinders()
    generator.modifyEntityBeansAddFinderField()
  }
}