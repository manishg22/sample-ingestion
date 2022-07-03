package com.example.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

@Service
class ElasticsearchService {

    @Value("http://localhost:9200")
    lateinit var elasticsearchURL: String

    @Autowired
    lateinit var elasticsearchClient: HttpClient

    fun update(id: String, query: String) {
        val request: HttpRequest = HttpRequest.newBuilder()
            .POST(HttpRequest.BodyPublishers.ofString(query))
            .uri(URI.create("$elasticsearchURL/product-argos-v7/_update/${id}"))
            .setHeader("Content-Type", "application/json")
            .build()

        val response: HttpResponse<String> = elasticsearchClient.send(request, HttpResponse.BodyHandlers.ofString())
        println(response.statusCode())
        println(response.body())
    }

}