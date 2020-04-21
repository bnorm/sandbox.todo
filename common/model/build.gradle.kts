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
        runtimeOnly("org.jetbrains.kotlinx:kotlinx-serialization-runtime-common:$serializationRuntimeVersion")
      }
    }
    named("jvmMain") {
      dependencies {
        runtimeOnly("org.jetbrains.kotlinx:kotlinx-serialization-runtime:$serializationRuntimeVersion")
      }
    }
    named("jsMain") {
      dependencies {
        runtimeOnly("org.jetbrains.kotlinx:kotlinx-serialization-runtime-js:$serializationRuntimeVersion")
      }
    }
  }
}
