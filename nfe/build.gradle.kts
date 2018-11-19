import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  kotlin("jvm") version "1.3.0"
}

version = "unspecified"

repositories {
  mavenCentral()
  maven(url = "http://www.autocomsistemas.com.br:8081/nexus/content/repositories/autocom/")
}

tasks.withType(org.jetbrains.kotlin.gradle.tasks.KotlinCompile::class.java).all {
  sourceCompatibility = "1.8"
  targetCompatibility = "1.8"

  kotlinOptions {
    jvmTarget = "1.8"
    apiVersion = "1.3"
    languageVersion = "1.3"
  }
}

dependencies {
  compile(project(":model"))
  compile(kotlin("stdlib-jdk8"))
  compile("br.com.samuelweb:java-nfe:4.00.8")
  compile("com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.9.7")
  compile("com.fasterxml.jackson.module:jackson-module-kotlin:2.9.7")
  compile("org.apache.commons:commons-lang3:3.8.1")
}

tasks.withType<KotlinCompile> {
  kotlinOptions.jvmTarget = "1.8"
}