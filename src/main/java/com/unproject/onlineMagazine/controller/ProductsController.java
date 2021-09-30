package com.unproject.onlineMagazine.controller;

import com.unproject.onlineMagazine.model.dao.Product;
import com.unproject.onlineMagazine.model.dto.ProductDto;
import com.unproject.onlineMagazine.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("api/products")
public class ProductsController {

    private final ProductRepo productRepo;

    @Autowired
    public ProductsController(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @GetMapping("/all")
    public String findAllProducts(Model model){
        List<Product> products = productRepo.getAll();
        model.addAttribute("products",products);
        return "products";
    }

    @GetMapping("/addproduct")
    public String addProduct(Model model){
        Product product = new Product();
        model.addAttribute("productDto",product);
        return "addproducts";
    }

    @PostMapping("/addproduct")
    public String saveProduct(
            Model model,
            @ModelAttribute("productDto")ProductDto productDto
            ) {
        productRepo.insert(new Product(
                productDto.getProduct_type(),
                productDto.getDescription(),
                productDto.getWeight()
        ));
        model.addAttribute("products",productRepo.getAll());
        return "products";

    }




}
