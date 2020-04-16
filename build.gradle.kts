buildscript {
  extra["coroutinesVersion"] = "1.3.5"
  extra["ktorVersion"] = "1.3.2"
  extra["log4jVersion"] = "2.11.2"
  extra["exposedVersion"] = "0.19.1"
  extra["h2Version"] = "1.4.200"
  extra["serializationRuntimeVersion"] = "0.20.0"
}

plugins {
  val kotlinVersion = "1.3.72"

  kotlin("jvm") version kotlinVersion apply false
  kotlin("js") version kotlinVersion apply false
  kotlin("multiplatform") version kotlinVersion apply false
  kotlin("plugin.serialization") version kotlinVersion apply false
}

allprojects {
  group = "com.solutionists.sandbox.kotlin"
  version = "0.1-SNAPSHOT"

  repositories {
    mavenCentral()
    jcenter()
    maven { setUrl("https://kotlin.bintray.com/kotlinx") }
    maven { setUrl("https://dl.bintray.com/kotlin/kotlin-js-wrappers") }
  }
}

tasks.register("runService") {
  dependsOn(tasks.findByPath(":backend:service:run"))
}

tasks.register("runWeb") {
  dependsOn(tasks.findByPath(":frontend:web:run"))
}
