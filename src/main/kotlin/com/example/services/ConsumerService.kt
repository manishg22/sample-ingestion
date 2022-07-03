package com.example.services

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class Consumer {

    @KafkaListener(topics = ["sample_topic"])
    fun consumeMessage(content: String){
        println(content)
    }
}