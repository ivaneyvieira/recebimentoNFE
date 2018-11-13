allprojects {
  repositories {
    jcenter()
    maven(url = "http://www.autocomsistemas.com.br:8081/nexus/content/repositories/autocom/")
  }
}

subprojects {
  version = "1.0"
}