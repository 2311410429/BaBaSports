package com.baba.service.product.impl;

import com.baba.dao.product.BrandDao;
import com.baba.entity.product.Brand;
import com.baba.service.product.BrandService;
import com.baba.utils.page.PageBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2016/12/21.
 */
@Service
@Transactional
public class BrandServiceImpl implements BrandService {

    @Resource
    private BrandDao brandDao;

    @Override
    @Transactional(readOnly = true)
    public PageBean<Brand> findBrandsWidthPage(Brand brand) {
        Integer pageNo = brand.getPageNo(); //1:起始页  startRow = (pageNo - 1)*pageSize
        Integer pageSize = brand.getPageSize();  //2:每页数
        int totalAmount = brandDao.selectBrandAmount(brand);   //3:总记录数

        PageBean pageBean = new PageBean(pageNo, pageSize, totalAmount);
        //Brand集合
        List<Brand> brands = brandDao.selectBrandsWidthPage(brand);

        for (Brand item : brands)
            System.out.println(item);

        pageBean.setData(brands);

        return pageBean;
    }

    @Override
    public List<Brand> findAllBrands() {
        return brandDao.selectAllBrands();
    }

    @Override
    public boolean addBrand(Brand brand) {
        return brandDao.insertSelective(brand) == 1 ? true : false;
    }

    private boolean chageBrandDisplayStateById(Integer id){
        return brandDao.chageBrandDisplayStateById(id) == 1 ? true : false;
    }

    @Override
    public boolean hiddenBrand(Integer id) {
        return chageBrandDisplayStateById(id);
    }
    @Override
    public boolean showBrand(Integer id) {
        return chageBrandDisplayStateById(id);
    }

    private boolean chageBrandsDisplayStateById(Integer[] ids) {
        return brandDao.chageBrandsDisplayStateByIds(ids) >0?true:false;
    }

    @Override
    public boolean hiddenBrands(Integer[] ids) {
        return  chageBrandsDisplayStateById(ids);
    }
    @Override
    public boolean showBrands(Integer[] ids) {
        return  chageBrandsDisplayStateById(ids);
    }

    @Override
    public boolean updateBrand(Brand brand) {
        return brandDao.updateByPrimaryKeySelective(brand)== 1 ? true : false;
    }

    @Override
    public Brand findBrandById(int id) {
        return brandDao.selectByPrimaryKey(id);
    }
}
