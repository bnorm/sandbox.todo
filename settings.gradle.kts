pluginManagement {
  repositories {
    gradlePluginPortal()
    mavenCentral()
    jcenter()
    maven { setUrl("https://kotlin.bintray.com/kotlinx") }
  }
}

rootProject.name = "sandbox.todo"

include(":backend:service")
include(":common:client")
include(":common:model")
include(":frontend:web")
