package com.example.kafka

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.rudderstack.android.sdk.core.RudderClient
import com.rudderstack.android.sdk.core.RudderConfig
import com.rudderstack.android.sdk.core.RudderIntegration
import com.rudderstack.android.sdk.core.RudderProperty
import com.rudderstack.android.sdk.core.RudderTraits
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.clients.consumer.KafkaConsumer
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.clients.producer.ProducerRecord
import java.time.Duration
import java.util.Properties

class MainActivity : AppCompatActivity() {

    private val portNumber = "localhost:9092"
    private val topicName = "testTopic"
    private lateinit var identify: Button
    private lateinit var track: Button
    private var userCount = 1
    private var eventCount = 1
    private var screenCount = 1
    private var groupCount = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        identify = findViewById<Button>(R.id.indentify)
        track = findViewById<Button>(R.id.track)

        identify.setOnClickListener {
            MainApplication.rudderClient?.identify(
                "user$userCount",
                RudderTraits().putEmail("user$userCount@gmail.com").putName("Mr. User$userCount"),
                null
            )
            Toast.makeText(this, "user$userCount is identified", Toast.LENGTH_LONG).show()
            userCount++;
        }

        track.setOnClickListener {
            val props = RudderProperty()
            val props2 = RudderProperty()
            props2.put("All", true)
            props2.put("topic","topicTesting")
            props2.put("kafka", "kafka")
            props.put("Test Track Key $eventCount", "Test Track Value $eventCount")

            MainApplication.rudderClient!!.track(
                "Test Event $eventCount",
                props,
               null
            )
            eventCount++;
            Toast.makeText(this, "user$eventCount is tracked", Toast.LENGTH_LONG).show()
        }



//        val propertiesProducer = Properties()
//        propertiesProducer.createProducer()
//
//        val propertiesConsumer = Properties()
//        propertiesConsumer.consumeProperties()
    }




//    private fun Properties.createProducer() {
//        this[ProducerConfig.BOOTSTRAP_SERVERS_CONFIG] = portNumber
//        this[ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG] =
//            "org.apache.kafka.common.serialization.StringSerializer"
//        this[ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG] =
//            "org.apache.kafka.common.serialization.StringSerializer"
////            StringSerializer::class.qualifiedName
//
//        val kafkaProducer = KafkaProducer<String, String>(this)
//
//        kafkaProducer.apply {
//            val producerRecord = ProducerRecord(topicName, "key", "value")
//            kafkaProducer.send(producerRecord)
//        }
//        kafkaProducer.close()
//    }
//
//
//    private fun Properties.consumeProperties() {
//
//        this@consumeProperties[ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG] =
//            "localhost:9092" // Replace with your Kafka broker address
//        this@consumeProperties[ConsumerConfig.GROUP_ID_CONFIG] =
//            "my-group" // Use your desired group ID
//        this@consumeProperties[ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG] =
//            "org.apache.kafka.common.serialization.StringDeserializer"
//        this@consumeProperties[ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG] =
//            "org.apache.kafka.common.serialization.StringDeserializer"
//
//
//        val consumer = KafkaConsumer<String, String>(this).apply {
//            subscribe(listOf(topicName))
//        }
//        Log.d("track", "4")
//
//        while (true) {
//            Log.d("track", "5")
//            val records = consumer.poll(Duration.ofMillis(1000))
//            for (record in records) {
//                Log.d("records", record.value().toString())
//            }
//        }
//    }
}





