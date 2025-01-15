package com.kafkaspring.kafkatutorial.service;

import com.kafkaspring.kafkatutorial.controller.CreateProductRestModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class ProductServiceImpl implements ProductService{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    KafkaTemplate<String,ProductCreatedEvent> kafkaTemplate;

    public ProductServiceImpl(KafkaTemplate<String,ProductCreatedEvent> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }


    @Override
    public String createProduct(CreateProductRestModel createProductRestModel) {
        String productId = UUID.randomUUID().toString();

        ProductCreatedEvent  productCreatedEvent = new ProductCreatedEvent(productId,
                createProductRestModel.getTitle(),createProductRestModel.getPrice(),
                createProductRestModel.getPrice());
        CompletableFuture<SendResult<String,ProductCreatedEvent>> future =
        kafkaTemplate.send("new-product-created-events-topic",productId,productCreatedEvent);
        future.whenComplete((result,exception)->{
            if(exception!=null){
                logger.error("Failed to send message",exception.getMessage());

            }else {
                logger.info("Message sent succesfully",result.getRecordMetadata());

            }
        });

        return productId;
    }
}
