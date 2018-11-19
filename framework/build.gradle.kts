import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val vaadinonkotlin_version = "0.4.9"
val vaadin10_version = "11.0.1"

plugins {
  kotlin("jvm") version "1.3.0"
}

version = "unspecified"

defaultTasks("clean", "build")

//dependencyManagement {
//  imports { mavenBom("com.vaadin:vaadin-bom:$vaadin10_version") }
//}

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
  compile(kotlin("stdlib-jdk8"))
  //MODEL
  compile("io.ebean:ebean:11.24.1")
  compile("io.ebean:querybean-generator:11.19.1")
  compile("io.ebean:ebean-querybean:11.20.1")
  compile("io.ebean:ebean-annotation:4.2")
  compile("io.ebean.tools:finder-generator:4.2.2")
  compile("org.jetbrains.kotlin:kotlin-reflect:1.3.0")
  compile("mysql:mysql-connector-java:5.1.45")
  //VAADIN
  compile("com.github.vok.karibudsl:karibu-dsl-v10:$vaadinonkotlin_version")

  // the app-layout custom component
  compile("org.webjars.bowergithub.polymerelements:app-layout:2.1.0")
  compile("org.webjars.bowergithub.polymerelements:paper-icon-button:2.2.0")
  // logging
  // currently we are logging through the SLF4J API to LogBack. See src/main/resources/logback.xml file for the logger configuration
  compile("ch.qos.logback:logback-classic:1.2.3")
  compile("org.slf4j:slf4j-api:1.7.25")
  compile("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
  compile("com.github.appreciated:app-layout-addon:2.0.0")
}