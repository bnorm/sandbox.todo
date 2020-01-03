package com.solutionists.sandbox.todo.service

import io.ktor.application.Application
import io.ktor.http.content.defaultResource
import io.ktor.http.content.resources
import io.ktor.http.content.static
import io.ktor.routing.route
import io.ktor.routing.routing

fun Application.api() {
  routing {
    static("/") {
      resources("web-ui")
      defaultResource("web-ui/index.html")
    }

    route("/api/v1") {
      // TODO perform request routing to database
    }
  }
}
