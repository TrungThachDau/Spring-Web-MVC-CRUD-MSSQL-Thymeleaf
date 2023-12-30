package org.mvc.springmvc.controller;

import org.mvc.springmvc.model.Category;
import org.mvc.springmvc.model.Product;
import org.mvc.springmvc.service.CategoryService;
import org.mvc.springmvc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductController{
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/product")
    public String index(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "product/index";
    }
    @GetMapping("/product/create")
    public String create(Model model) {
        Product product = new Product();
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        model.addAttribute("product", product);
        return "/product/create";
    }
    @PostMapping("/saveProduct")
    public String saveEmployee(@ModelAttribute("product") Product product) {
        // save employee to database
        productService.save(product);
        return "redirect:/product";
    }
    @GetMapping("/product/detail/{id}")
    public String detail(@PathVariable(value="id") Long id,Model model) {
        Product product = productService.findById(id);
        if (product == null) {
            // Xử lý khi không tìm thấy sản phẩm
            return "error404"; // Thay thế bằng trang lỗi của bạn
        }

        model.addAttribute("product", product);
        return "/product/detail";
    }
    @GetMapping("/product/edit/{id}")
    public String edit(@PathVariable(value="id") Long id, Model model) {
        Product product = productService.findById(id);
        if (product == null) {
            // Xử lý khi không tìm thấy sản phẩm
            return "error404"; // Thay thế bằng trang lỗi của bạn
        }
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        model.addAttribute("product", product);
        return "/product/edit";
    }
    @PostMapping("/updateProduct")
    public String update(@ModelAttribute("product") Product product) {
        productService.save(product);
        return "redirect:/product";
    }
    @PostMapping("/product/delete/{id}")
    public String delete(@PathVariable Long id) {
        productService.delete(id);
        return "redirect:/product";
    }
    @GetMapping("/product/confirmDelete/{id}")
    public String confirmDelete(@PathVariable("id") Long id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "/product/delete";
    }



}
