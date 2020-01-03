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
    val ktorVersion: String by rootProject.extra

    val commonMain by getting {
      dependencies {
        implementation(kotlin("stdlib"))

        api(project(":common:model"))
        api("io.ktor:ktor-client-core:$ktorVersion")

        implementation("io.ktor:ktor-client-json:$ktorVersion")
        implementation("io.ktor:ktor-client-serialization:$ktorVersion")
      }
    }
    val jvmMain by getting {
      dependencies {
        implementation(kotlin("stdlib-jdk8"))

        api("io.ktor:ktor-client:$ktorVersion")

        implementation("io.ktor:ktor-client-okhttp:$ktorVersion")
        implementation("io.ktor:ktor-client-json-jvm:$ktorVersion")
        implementation("io.ktor:ktor-client-serialization-jvm:$ktorVersion")
      }
    }
    val jsMain by getting {
      dependencies {
        implementation(kotlin("stdlib-js"))

        api("io.ktor:ktor-client-js:$ktorVersion")

        implementation("io.ktor:ktor-client-json-js:$ktorVersion")
        implementation("io.ktor:ktor-client-serialization-js:$ktorVersion")
      }
    }
  }
}
