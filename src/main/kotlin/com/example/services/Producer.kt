package com.example.services

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service


@Service
class Producer(private val kafkaTemplate: KafkaTemplate<String, String>) {

    public fun sendMessage(message: String){
        kafkaTemplate.send("sample_topic",message)
    }
}