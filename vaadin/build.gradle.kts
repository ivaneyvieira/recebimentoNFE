import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  kotlin("jvm") version "1.3.0"
  id("org.gretty") version "2.2.0"
  id("io.spring.dependency-management") version "1.0.6.RELEASE"
  war
}

version = "unspecified"

defaultTasks("clean", "build")

repositories {
  jcenter()
}

gretty {
  contextPath = "/"
  servletContainer = "jetty9.4"
}

tasks.withType<KotlinCompile> {
  kotlinOptions.jvmTarget = "1.8"
}

dependencies {
  compile(project(":framework"))
  compile(project(":model"))
  providedCompile("javax.servlet:javax.servlet-api:3.1.0")
}
