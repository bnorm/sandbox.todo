package com.solutionists.sandbox.todo.client

import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.http.Url

@Suppress("FunctionName") // Factory
fun TodoClient(url: Url): TodoClient {
  val client = HttpClient {
    install(JsonFeature) {
      serializer = KotlinxSerializer()
    }
  }

  return TodoClient(url, client)
}

class TodoClient internal constructor(
  private val url: Url,
  private val client: HttpClient
) {
  // TODO create API client
}
