package com.solutionists.sandbox.todo.service

import io.ktor.application.call
import io.ktor.application.install
import io.ktor.application.log
import io.ktor.features.CallLogging
import io.ktor.features.ContentNegotiation
import io.ktor.features.DefaultHeaders
import io.ktor.features.StatusPages
import io.ktor.features.toLogString
import io.ktor.http.HttpStatusCode
import io.ktor.locations.Locations
import io.ktor.response.respond
import io.ktor.serialization.json
import io.ktor.serialization.serialization
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import org.slf4j.LoggerFactory
import java.util.UUID

fun main() {
  val server = embeddedServer(Netty, 8080) {
    install(DefaultHeaders)

    install(CallLogging) {
      mdc("request.id") { UUID.randomUUID().toString().substring(0, 8) }
      logger = LoggerFactory.getLogger("com.solutionists.sandbox.todo.service")
    }

    install(ContentNegotiation) {
      json()
    }

    install(Locations)

    install(StatusPages) {
      exception<Throwable> { cause ->
        log.warn("Error processing request: {}", call.request.toLogString(), cause)
        call.respond(HttpStatusCode.InternalServerError, cause.message ?: "Unknown error")
      }
    }

    api()
  }
  server.start(wait = true)
}
