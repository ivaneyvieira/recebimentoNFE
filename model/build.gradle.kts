import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  kotlin("jvm") version "1.3.0"
}

version = "unspecified"

defaultTasks("clean", "build")

repositories {
  jcenter()
  maven { setUrl("https://dl.bintray.com/mvysny/github") }
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
  compile(kotlin("stdlib-jdk8"))
  compile("io.ebean:ebean:11.24.1")
  compile("io.ebean:querybean-generator:11.19.1")
  compile("io.ebean:ebean-querybean:11.20.1")
  compile("io.ebean:ebean-annotation:4.2")
  compile("io.ebean.tools:finder-generator:4.2.2")
  compile("org.jetbrains.kotlin:kotlin-reflect:1.3.0")
}