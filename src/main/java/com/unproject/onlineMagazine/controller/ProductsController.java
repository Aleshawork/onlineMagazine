package com.unproject.onlineMagazine.controller;

import com.unproject.onlineMagazine.model.dao.Product;
import com.unproject.onlineMagazine.model.dto.ProductDto;
import com.unproject.onlineMagazine.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping("/product")
    public String addProduct(Model model){
        Product product = new Product();
        model.addAttribute("productDto",product);
        model.addAttribute("mainurl",url);
        return "addproducts";
    }

    @PostMapping("/product")
    public String saveProduct(
            Model model,
            @ModelAttribute("productDto")Product product
            ) {
        ProductDto productDto = new ProductDto(
                product.getProductType(),
                product.getDescription(),
                product.getWeight()
        );
        productsService.save(productDto);
        model.addAttribute("products",productsService.getAll());
        model.addAttribute("mainurl",url);
        return "products";

    }

    @GetMapping("/{id}")
    public String product(
            @PathVariable int id,
            Model model
    ){
        model.addAttribute("products",productsService.getById(id));
        model.addAttribute("mainurl",url);
        return "product";
    }

    @GetMapping("/sort/{parametr}")
    public String sortedProduct(
            @PathVariable int parametr,
            Model model
    ){
        if(parametr==1){
            model.addAttribute("products",productsService.getAll().stream().sorted(Comparator.comparingDouble(Product::getWeight)).collect(Collectors.toList()));
        }else if(parametr==2){
            model.addAttribute("products",productsService.getAll().stream().sorted(Comparator.comparingDouble(Product::getPrice)).collect(Collectors.toList()));

        }else{
            model.addAttribute("products",productsService.getAll());
        }
        model.addAttribute("mainurl",url);
        return "products";
    }

    @GetMapping("/filter/{type}")
    public String filterByIncomeParametr(
            @PathVariable int type,
            Model model
    ){
        System.out.println(type);
        if(type==2){
            model.addAttribute("products",productsService.getAll().stream().filter(el->{
                return el.getProductType().equals("Food/drinks");
            }
        ).collect(Collectors.toList()));
        }else if(type==4){
            model.addAttribute("products",productsService.getAll().stream().filter(el->{
            return el.getProductType().equals("Electronics");
            }
        ).collect(Collectors.toList()));
        }else if(type==1){
            model.addAttribute("products",productsService.getAll().stream().filter(el->{
                return el.getProductType().equals("Home/Garden");
            }
            ).collect(Collectors.toList()));
        }else if(type==3) {
            model.addAttribute("products", productsService.getAll().stream().filter(el -> {
                        return el.getProductType().equals("Clothes");
                    }
            ).collect(Collectors.toList()));
        }else{
            model.addAttribute("products",productsService.getAll());
        }
        model.addAttribute("mainurl",url);
        return "products";
    }




}
