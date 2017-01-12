package com.baba.test;

import com.baba.dao.product.BrandDao;
import com.baba.dao.product.ProductDao;
import com.baba.entity.product.Product;
import com.baba.query.PageQuery;
import com.baba.query.product.ProductQuery;
import com.baba.utils.SpringJunitTestUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Administrator on 2017/1/11.
 */
public class DaoTest extends SpringJunitTestUtil {

    @Autowired
    private SqlSessionFactory sessionFactory;

    @Test
    public void fun() {
        SqlSession session = sessionFactory.openSession();

        ProductDao productDao = session.getMapper(ProductDao.class);

        ProductQuery productQuery = new ProductQuery();
        PageQuery pageQuery = new PageQuery();
        pageQuery.setPageNo(2);
        productQuery.setPageQuery(pageQuery);

        List<Product> productList = productDao.getProductListWithPage(productQuery);
        for (Product product : productList) {
            System.out.println(product);
        }

    }

}
