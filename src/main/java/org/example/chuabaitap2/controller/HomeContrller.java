package org.example.chuabaitap2.controller;

import org.example.chuabaitap2.model.Product;
import org.example.chuabaitap2.service.IProductService;
import org.example.chuabaitap2.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/products")
public class HomeContrller {
    private IProductService productService = new ProductService();

    @GetMapping("")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("/home");
        List<Product> productList = productService.findAll();
        modelAndView.addObject("productList", productList);
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showCreate(){
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }
    @GetMapping("{id}/view")
    public ModelAndView showView(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("/view");
        modelAndView.addObject("product", productService.findById(id));
        return modelAndView;
    }
    @GetMapping("{id}/edit")
    public ModelAndView showEdit(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("product", productService.findById(id));
        return modelAndView;
    }
    @GetMapping("{id}/delete")
    public ModelAndView showDelete(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("/delete");
        modelAndView.addObject("product", productService.findById(id));
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView create(Product product){
        ModelAndView modelAndView = new ModelAndView("redirect:/products");
        product.setId((int) (Math.random() * 10000));
        productService.create(product);
        return modelAndView;
    }
    @PostMapping("/edit")
    public ModelAndView edit(Product product){
        ModelAndView modelAndView = new ModelAndView("redirect:/products");
        productService.edit(product.getId(), product);
        return modelAndView;
    }
    @PostMapping("/delete")
    public ModelAndView delete(Product product){
        ModelAndView modelAndView = new ModelAndView("redirect:/products");
        productService.delete(product.getId());
        return modelAndView;
    }
    @PostMapping("/search")
    public ModelAndView search(@RequestParam("searchMSG") String searchMSG){
        ModelAndView modelAndView = new ModelAndView("/home");
        List<Product> productList = productService.search(searchMSG);
        modelAndView.addObject("productList", productList);
        return modelAndView;
    }
}
