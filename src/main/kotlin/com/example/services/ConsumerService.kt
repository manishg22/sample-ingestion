package com.example.services

import com.example.model.BrowseOrder
import com.google.gson.Gson
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class Consumer {

    @Autowired
    lateinit var elasticsearchService: ElasticsearchService

    @KafkaListener(topics = ["sample_topic"])
    fun consumeMessage(content: String){
        println(content)
        val model = Gson().fromJson(content, BrowseOrder::class.java)
        val query: String = constructQuery(content, model)
        elasticsearchService.update(model.id,query)
    }

    fun constructQuery(content: String, model: BrowseOrder): String {

        return StringBuilder()
            .append("{")
            .append("\"script\":{")
            .append("\"source\": \"def targets = ctx._source.categories.findAll(category -> category.id == params.id);")
            .append("for(category in targets) { category.browseOrder = params.browseOrder }\",")
            .append("\"params\":{ \"id\": \"${model.category_id}\",\"browseOrder\": ${model.browse_order}")
            .append("}}}").toString()
    }
}