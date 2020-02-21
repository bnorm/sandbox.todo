package com.solutionists.sandbox.todo.service

import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.http.content.resolveResource
import io.ktor.http.content.static
import io.ktor.response.respond
import io.ktor.routing.get
import io.ktor.routing.route
import io.ktor.routing.routing
import java.io.File

fun Application.api() {
  routing {
    static("/") {
      val pathParameter = "static-path"

      val resourcePackage = "web-ui"
      val fallbackPath = "index.html"

      get("{$pathParameter...}") {
        val relativePath = call.parameters.getAll(pathParameter)?.joinToString(File.separator) ?: return@get
        val content = call.resolveResource(relativePath, resourcePackage) ?: call.resolveResource(fallbackPath, resourcePackage)
        if (content != null) call.respond(content)
      }
    }

    route("/api/v1") {
      // TODO perform request routing to database
    }
  }
}
