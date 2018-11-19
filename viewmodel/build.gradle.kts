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
  compile(project(":model"))
}