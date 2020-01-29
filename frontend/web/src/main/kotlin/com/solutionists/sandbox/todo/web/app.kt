package com.solutionists.sandbox.todo.web

import com.solutionists.sandbox.todo.client.TodoClient
import org.w3c.dom.url.URLSearchParams
import react.RBuilder
import react.RProps
import react.dom.br
import react.dom.div
import react.dom.h2
import react.dom.hr
import react.dom.li
import react.dom.ul
import react.router.dom.browserRouter as Router
import react.router.dom.route as Route
import react.router.dom.routeLink as Link
import react.router.dom.switch as Switch

interface IdProps : RProps {
  var id: Int
}

fun RBuilder.app(client: TodoClient) = Router {
  div {
    ul {
      li { Link("/") { +"Home" } }
      li { Link("/about") { +"About" } }
      li { Link("/dashboard") { +"Dashboard" } }
    }

    hr {}

    Switch {
      Route(exact = true, path = "/") {
        home()
      }
      Route<RProps>(path = "/about") { props -> about() }
      Route<RProps>(path = "/dashboard") { props -> dashboard() }
      Route<IdProps>("/user/:id") { props ->
        div {
          +"User id: ${props.match.params.id}"
          br {}
          +"Search: ${URLSearchParams(props.location.search)}"
        }
      }
    }
  }
}

fun RBuilder.home() = div { h2 { +"Home" } }
fun RBuilder.about() = div { h2 { +"About" } }
fun RBuilder.dashboard() = div { h2 { +"Dashboard" } }
