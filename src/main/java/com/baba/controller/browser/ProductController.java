package com.baba.controller.browser;


import com.baba.entity.product.Brand;
import com.baba.service.product.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private BrandService brandService;

    @RequestMapping("/list")
    public String list(String name, Integer brandId, Integer isShow, ModelMap modelMap){

        List<Brand> allBrands = brandService.findAllBrands();

        return "";
    }
}
