package com.baba.controller.browser;

import com.baba.entity.product.Brand;
import com.baba.service.product.BrandService;
import com.baba.utils.Constants;
import com.baba.utils.page.PageBean;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @RequestMapping(value = "/edit")
    public String edit(Brand brand){
        boolean res = brandService.updateBrand(brand);
        return "redirect:/brand/list.do";
    }
    @RequestMapping(value = "/toEdit")
    public String toEdit(int id, ModelMap modelMap){
        Brand brand = brandService.findBrandById(id);
        modelMap.addAttribute("brand",brand);
        return "brand/edit";
    }

    @RequestMapping(value = "/deletes")
    public String deletes(Integer[] ids, String name, Boolean isDisplay, ModelMap modelMap) {
        boolean res = brandService.hiddenBrands(ids);
        if(res) {
            if (StringUtils.isNotBlank(name)) {
                modelMap.addAttribute("name", name);
            }
            if (null != isDisplay) {
                modelMap.addAttribute("isDisplay", isDisplay);
            }
            return "redirect:/brand/list.do";
        }else {
            return "redirect:/brand/list.do";
        }
    }

    @RequestMapping(value = "/delete")
    public String delete(Integer id, String name, Boolean isDisplay, ModelMap modelMap) {
        boolean res = brandService.hiddenBrand(id);
        if(res) {
            if (StringUtils.isNotBlank(name)) {
                modelMap.addAttribute("name", name);
            }
            if (null != isDisplay) {
                modelMap.addAttribute("isDisplay", isDisplay);
            }
            return "redirect:/brand/list.do";
        }else {
            return "redirect:/brand/list.do";
        }
    }

    @RequestMapping(value = "/add")
    public String add(Brand brand, HttpServletRequest request) {
        boolean res = brandService.addBrand(brand);
        if (res) {
            return "redirect:/brand/list.do"; //重定向，不携带数据
        } else {
            //其实应该：将对应图片服务器上的图片给删除掉；
            // 当然也可以创建定时任务：在空闲时间比对图片和数据库，将没有位于数据库中的图片删除
            return "brand/add";
        }
    }

    //品牌列表页面
    @RequestMapping(value = "/list")
    public String list(String name, Boolean isDisplay, Integer pageNo, ModelMap model) {
        StringBuffer params = new StringBuffer();
        //参数
        Brand brand = new Brand();
        if (StringUtils.isNotBlank(name)) {
            brand.setName(name);
            params.append("name=").append(name);
        }
        if (null != isDisplay) {
            brand.setIsDisplay(isDisplay);
            params.append("&isDisplay=").append(isDisplay);
        } else {
            brand.setIsDisplay(true);
            params.append("&isDisplay=").append(1);
        }

        //页号
        brand.setPageNo(PageBean.cpn(pageNo));

        //每页数
        brand.setPageSize(Constants.PER_PAGE_SIZE);

        //分页对象
        PageBean pageBean = brandService.findBrandsWidthPage(brand);

        pageBean.pageView("/brand/list.do", params.toString());

        model.addAttribute("pageBean", pageBean);//request.setAttribute
        model.addAttribute("name", name);
        model.addAttribute("isDisplay", isDisplay);
        return "brand/list";
    }

}
