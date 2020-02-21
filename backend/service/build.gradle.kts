import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  kotlin("jvm")
  application
}

dependencies {
  val coroutinesVersion: String by rootProject.extra
  val ktorVersion: String by rootProject.extra
  val log4jVersion: String by rootProject.extra
  val exposedVersion: String by rootProject.extra
  val h2Version: String by rootProject.extra

  implementation(kotlin("stdlib"))
  implementation(kotlin("reflect"))

  implementation(project(":common:model"))

  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-jdk8:$coroutinesVersion")

  implementation("io.ktor:ktor-server-netty:$ktorVersion")
  implementation("io.ktor:ktor-locations:$ktorVersion")
  implementation("io.ktor:ktor-websockets:$ktorVersion")
  implementation("io.ktor:ktor-serialization:$ktorVersion")

  implementation("org.jetbrains.exposed:exposed-core:$exposedVersion")
  implementation("org.jetbrains.exposed:exposed-jdbc:$exposedVersion")
  implementation("org.jetbrains.exposed:exposed-dao:$exposedVersion")
  implementation("org.jetbrains.exposed:exposed-java-time:$exposedVersion")
  runtimeOnly("com.h2database:h2:$h2Version")

  implementation("org.apache.logging.log4j:log4j-api:${log4jVersion}")
  runtimeOnly("org.apache.logging.log4j:log4j-slf4j-impl:${log4jVersion}")
  runtimeOnly("org.apache.logging.log4j:log4j-core:${log4jVersion}")
}

tasks.withType<KotlinCompile>().configureEach {
  kotlinOptions.jvmTarget = "1.8"
}

tasks.processResources.configure {
  from(tasks.getByPath(":frontend:web:jsBundle")) {
    into("web-ui")
  }
}

application {
  mainClassName = "com.solutionists.sandbox.todo.service.MainKt"
  applicationDefaultJvmArgs = listOf("-Dkotlinx.coroutines.debug=on")
}
