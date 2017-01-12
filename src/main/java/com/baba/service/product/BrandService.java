package com.baba.service.product;

import com.baba.entity.product.Brand;
import com.baba.utils.page.PageBean;

import java.util.List;

/**
 * Created by Administrator on 2017/1/9.
 */
public interface BrandService {
    PageBean<Brand> findBrandsWidthPage(Brand brand);

    List<Brand> findAllBrands();

    boolean addBrand(Brand brand);

    /**
     * 删除Brand，仅仅是改变指定id的Brand的isDisplay状态
     *
     * @param id
     * @return
     */
    boolean hiddenBrand(Integer id);

    boolean showBrand(Integer id);

    boolean hiddenBrands(Integer[] ids);

    boolean showBrands(Integer[] ids);

    boolean updateBrand(Brand brand);

    Brand findBrandById(int id);
}
