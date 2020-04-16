package com.solutionists.sandbox.todo.web

import org.w3c.dom.Element
import react.dom.render
import react.dom.unmountComponentAtNode
import kotlin.browser.document
import kotlin.properties.Delegates
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test

class ComponentTemplateTest {
  private var container by Delegates.notNull<Element>()

  @BeforeTest fun setup() {
    container = document.createElement("div")
    document.body!!.appendChild(container)
  }

  @AfterTest fun teardown() {
    unmountComponentAtNode(container)
    container.remove()
  }

  @Test fun testComponentTemplate() {
    render(container) {
      Template(listOf("Rodney", "Tom", "Steve", "Brian"))
    }
    println("container.innerHTML: <${container.innerHTML}>")
    println("container.textContent: <${container.textContent}>")
//    TODO()
  }
}
