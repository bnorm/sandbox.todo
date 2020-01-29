package com.solutionists.sandbox.todo.service

import io.ktor.application.Application
import io.ktor.http.content.resource
import io.ktor.http.content.static
import io.ktor.http.content.staticBasePackage
import io.ktor.routing.route
import io.ktor.routing.routing

fun Application.api() {
  routing {
    static("/") {
      staticBasePackage = "web-ui"
      resource("web.js")
      resource("{...}", "index.html")
    }

    route("/api/v1") {
      // TODO perform request routing to database
    }
  }
}
