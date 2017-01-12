package com.baba.test;

import com.baba.entity.product.Brand;
import com.baba.entity.product.Product;
import com.baba.query.PageQuery;
import com.baba.query.product.ProductQuery;
import com.baba.service.product.BrandService;
import com.baba.service.product.ProductService;
import com.baba.utils.SpringJunitTestUtil;
import com.baba.utils.page.PageBean;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Administrator on 2017/1/9.
 */

public class ServiceTest extends SpringJunitTestUtil {

    @Autowired
    private ProductService productService;

    @Autowired
    private BrandService brandService;

    @Test
    public void fun1() throws Exception {
        List<Brand> allBrands = brandService.findAllBrands();
        for (Brand brand : allBrands) {
            System.out.println(brand);
        }
    }
    @Test
    public void fun2() throws Exception {

        ProductQuery productQuery = new ProductQuery();
        PageQuery pageQuery = new PageQuery();
        pageQuery.setPageNo(2);
        productQuery.setPageQuery(pageQuery);

        PageBean<Product> pageBean= productService.getProductListWithPage(productQuery);
        for (Product product : pageBean.getData()) {
            System.out.println(product);
        }
    }

}