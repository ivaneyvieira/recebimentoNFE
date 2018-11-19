import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val vaadinonkotlin_version = "0.4.9"
val vaadin10_version = "11.0.1"

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
  maven { setUrl("https://dl.bintray.com/mvysny/github") }
  maven { setUrl("http://maven.vaadin.com/vaadin-addons") }
}

gretty {
  contextPath = "/"
  servletContainer = "jetty9.4"
}

dependencyManagement {
  imports { mavenBom("com.vaadin:vaadin-bom:$vaadin10_version") }
}
//tasks.withType<Test> {
//  useJUnitPlatform()
//  testLogging {
// to see the exceptions of failed tests in Travis-CI console.
//    exceptionFormat = TestExceptionFormat.FULL
//  }
//}
tasks.withType<KotlinCompile> {
  kotlinOptions.jvmTarget = "1.8"
}
//val staging by configurations.creating
dependencies {
  compile(project(":nfe"))
  compile("com.github.vok.karibudsl:karibu-dsl-v10:$vaadinonkotlin_version")
  providedCompile("javax.servlet:javax.servlet-api:3.1.0")
  // the app-layout custom component
  compile("org.webjars.bowergithub.polymerelements:app-layout:2.1.0")
  compile("org.webjars.bowergithub.polymerelements:paper-icon-button:2.2.0")
  // logging
  // currently we are logging through the SLF4J API to LogBack. See src/main/resources/logback.xml file for the logger configuration
  compile("ch.qos.logback:logback-classic:1.2.3")
  compile("org.slf4j:slf4j-api:1.7.25")

  compile("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

  compile("com.github.appreciated:app-layout-addon:2.0.0")
  // test support
  //testCompile("com.github.kaributesting:karibu-testing-v10:0.5.2")
  //testCompile("com.github.mvysny.dynatest:dynatest-engine:0.11")
  // heroku app runner
  // staging("com.github.jsimone:webapp-runner:9.0.11.0")
}
