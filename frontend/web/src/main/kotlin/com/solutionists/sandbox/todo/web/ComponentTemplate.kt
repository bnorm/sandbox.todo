package com.solutionists.sandbox.todo.web

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.br
import react.dom.div

interface TemplateProps : RProps {
  var values: List<String>
}

@Suppress("FunctionName") // Factory
fun RBuilder.Template(values: List<String>) = child(TemplateComponent::class) {
  attrs.values = values
}

interface TemplateState : RState {
  var values: List<String>
}

class TemplateComponent(props: TemplateProps) : RComponent<TemplateProps, TemplateState>(props) {

  override fun TemplateState.init(props: TemplateProps) {
    values = props.values
  }

  override fun RBuilder.render() {
    val state = state
    div("col-md-4 list-group") {
      state.values.map {
        +it
        br {}
      }
    }
  }
}
