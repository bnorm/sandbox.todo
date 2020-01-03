package com.solutionists.sandbox.todo.web

import com.solutionists.sandbox.todo.client.TodoClient
import react.RBuilder
import react.dom.div

fun RBuilder.app(client: TodoClient) = div(classes = "App") {
  div(classes = "container-fluid") {
  }
}

