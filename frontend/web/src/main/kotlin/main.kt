import com.solutionists.sandbox.todo.client.TodoClient
import com.solutionists.sandbox.todo.web.app
import io.ktor.http.Url
import kotlinext.js.require
import kotlinext.js.requireAll
import react.dom.render
import kotlin.browser.document

fun main() {
  requireAll(require.context("/", true, js("/\\.css$/")))

  val client = TodoClient(Url("/api/v1"))
  render(document.getElementById("root")) {
    app(client)
  }
}
