package com.sanjiban.restapi.service;

import com.sanjiban.restapi.dto.ProductDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ProductService {
    Object addProduct(ProductDto productDto, MultipartFile image) throws IOException;
}
