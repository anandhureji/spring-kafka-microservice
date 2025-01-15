package com.kafkaspring.kafkatutorial.service;

import com.kafkaspring.kafkatutorial.controller.CreateProductRestModel;

public interface ProductService {

    String createProduct(CreateProductRestModel createProductRestModel);
}
