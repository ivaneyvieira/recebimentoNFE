import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  kotlin("jvm") version "1.2.71"
}

version = "unspecified"

repositories {
  mavenCentral()

  maven(url = "http://www.autocomsistemas.com.br:8081/nexus/content/repositories/autocom/")
}

dependencies {
  compile(kotlin("stdlib-jdk8"))
  compile("br.com.samuelweb:java-nfe:4.00.8")
  compile("com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.9.6")
  compile("org.apache.commons:commons-lang3:3.4")
}

tasks.withType<KotlinCompile> {
  kotlinOptions.jvmTarget = "1.8"
}