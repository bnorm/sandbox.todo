plugins {
  kotlin("multiplatform")
  kotlin("plugin.serialization")
}

kotlin {
  jvm()
  js {
    browser()
    nodejs()
  }

  sourceSets {
    val serializationRuntimeVersion: String by rootProject.extra

    named("commonMain") {
      dependencies {
        implementation(kotlin("stdlib"))
        implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime-common:$serializationRuntimeVersion")
      }
    }
    named("jvmMain") {
      dependencies {
        implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime:$serializationRuntimeVersion")
      }
    }
    named("jsMain") {
      dependencies {
        implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime-js:$serializationRuntimeVersion")
      }
    }
  }
}
