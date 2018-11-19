allprojects {
  repositories {
    jcenter()
    maven(url = "http://www.autocomsistemas.com.br:8081/nexus/content/repositories/autocom/")
    maven { setUrl("https://dl.bintray.com/mvysny/github") }
    maven { setUrl("http://maven.vaadin.com/vaadin-addons") }
  }
}

subprojects {
  version = "1.0"
}