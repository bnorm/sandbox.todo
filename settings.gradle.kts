pluginManagement {
  repositories {
    gradlePluginPortal()
    mavenCentral()
    jcenter()
    maven { setUrl("https://kotlin.bintray.com/kotlinx") }
    maven { setUrl("https://dl.bintray.com/kotlin/kotlin-eap") }
  }
}

rootProject.name = "sandbox.todo"

include(":backend:service")
include(":common:client")
include(":common:model")
include(":frontend:web")
