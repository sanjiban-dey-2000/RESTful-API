package com.sanjiban.restapi.service.Impl;

import com.sanjiban.restapi.dto.ProductDto;
import com.sanjiban.restapi.entities.Product;
import com.sanjiban.restapi.respository.ProductRepository;
import com.sanjiban.restapi.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    @Override
    public Product addProduct(ProductDto productDto, MultipartFile image) throws IOException {
        Product product=modelMapper.map(productDto,Product.class);
        product.setImageName(image.getOriginalFilename());
        product.setImageType(image.getContentType());
        product.setImageData(image.getBytes());

        Product newProduct=productRepository.save(product);
        return newProduct;
    }
}
