package com.example.controller

import com.example.services.Producer
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/source")
class HttpSourceController(private val producer: Producer) {

    @RequestMapping("/event", method = [RequestMethod.POST])
    fun handleRequest(
        @RequestBody body: String,
        @RequestHeader("Content-Type") contentType: String,
        @RequestHeader("X-Event-Type") eventType: String,
    ) {
        producer.sendMessage(body)
    }
}