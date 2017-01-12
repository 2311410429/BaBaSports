package com.baba.dao.product;

import com.baba.entity.product.Brand;

import java.util.List;

public interface BrandDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Brand record);

    int insertSelective(Brand record);

    Brand selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Brand record);

    int updateByPrimaryKey(Brand record);

    ///////////////////////////////////////////
    int selectBrandAmount(Brand brand);

    List<Brand> selectBrandsWidthPage(Brand brand);

    List<Brand> selectAllBrands();

    /**
     * 更改Brand的显示状态为相反
     * @param id
     * @return 成功返回1，否则返回0
     */
    int chageBrandDisplayStateById(Integer id);

    /**
     * 更改Brand的显示状态为相反
     * @param ids
     * @return 成功返回所操作的记录的个数的和，也即大于0；如果全部失败返回值为0
     */
    int chageBrandsDisplayStateByIds(Integer[] ids);
}
