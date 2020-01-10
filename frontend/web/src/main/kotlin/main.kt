import com.solutionists.sandbox.todo.client.TodoClient
import com.solutionists.sandbox.todo.web.app
import io.ktor.http.Url
import kotlinext.js.require
import kotlinext.js.requireAll
import mu.KotlinLogging
import react.dom.render
import kotlin.browser.document

private val log = KotlinLogging.logger {}

fun main() {
  log.info { "Starting Web UI" }

  requireAll(require.context("/", true, js("/\\.css$/")))

  val client = TodoClient(Url("/api/v1"))
  render(document.getElementById("root")) {
    app(client)
  }
}
