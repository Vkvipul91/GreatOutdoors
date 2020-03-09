package com.casestudy.greatOutdoors.controller;


import com.casestudy.greatOutdoors.dao.ProductRepository;
import com.casestudy.greatOutdoors.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    ProductRepository productrepo;

    @RequestMapping(value ="/admin/product", method = RequestMethod.GET)
    public String showAvailableProducts(ModelMap model){
        List<Product> products = productrepo.findAll();
        model.put("products",products);
        return "avail_product";
    }

    @RequestMapping(value = "/admin/new_product", method = RequestMethod.GET)
    public String showAddNewProductPage(ModelMap model) {
        model.addAttribute("productForm", new ProductForm("000", "Default"));
        return "product";
    }

    @RequestMapping(value = "/admin/new_product", method = RequestMethod.POST)
    public String addNewProduct(ModelMap model, ProductForm productForm) throws IOException {

        Product product = new Product();
        product.setCode(productForm.getCode());
        product.setName(productForm.getName());
        product.setPrice(productForm.getPrice());
        byte[] image = productForm.getFileData().getBytes();
        product.setImage(image);
        product.setCreateDate(new Date());
        productrepo.save(product);
        return "redirect:/admin/product";
    }
    @RequestMapping(value = { "/get_image" }, method = RequestMethod.GET)
    public void productImage(HttpServletRequest request, HttpServletResponse response, Model model,
                             @RequestParam("code") String code) throws IOException {
        Product product = null;
        if (code != null) {
            product = productrepo.findById(code).get();
        }
        if (product != null && product.getImage() != null) {
            response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
            response.getOutputStream().write(product.getImage());
        }
        response.getOutputStream().close();
    }
}


