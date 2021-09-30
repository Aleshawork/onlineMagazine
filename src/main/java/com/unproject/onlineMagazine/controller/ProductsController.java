package com.unproject.onlineMagazine.controller;

import com.unproject.onlineMagazine.model.dao.Product;
import com.unproject.onlineMagazine.model.dto.ProductDto;
import com.unproject.onlineMagazine.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${web.main.url}")
    private String url;
    private final ProductsService productsService;

    @Autowired
    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }


    @GetMapping("/all")
    public String findAllProducts(Model model){
        List<Product> products = productsService.getAll();
        model.addAttribute("products",products);
        model.addAttribute("mainurl",url);
        return "products";
    }

    @GetMapping("/addproduct")
    public String addProduct(Model model){
        Product product = new Product();
        model.addAttribute("productDto",product);
        model.addAttribute("mainurl",url);
        return "addproducts";
    }

    @PostMapping("/addproduct")
    public String saveProduct(
            Model model,
            @ModelAttribute("productDto")ProductDto productDto
            ) {
        productsService.save(productDto);
        model.addAttribute("products",productsService.getAll());
        model.addAttribute("mainurl",url);
        return "products";

    }




}
