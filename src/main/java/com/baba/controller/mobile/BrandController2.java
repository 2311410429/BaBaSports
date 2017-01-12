package com.baba.controller.mobile;

import com.baba.entity.product.Brand;
import com.baba.utils.ResponseUtils;
import org.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/11.
 */
@Controller
@RequestMapping(value = "/brand")
public class BrandController2 {

    @RequestMapping(value = "/showBrands.apk")
    public void showBrands(HttpServletResponse response){
        String data = "[{\"imgUrl\":\"brand/aa.jpg\",\"webSite\":\"http://www.aa.html\",\"imageServerImgUrl\":\"http://172.16.16.160:8008/imgs/brand/aa.jpg\",\"pageNo\":1,\"name\":\"aa\",\"description\":\"aaaaaaa\",\"pageSize\":10,\"id\":1,\"sort\":11,\"isDisplay\":true},{\"imgUrl\":\"brand/bb.jpg\",\"webSite\":\"http://www.bb.html\",\"imageServerImgUrl\":\"http://172.16.16.160:8008/imgs/brand/bb.jpg\",\"pageNo\":1,\"name\":\"bb\",\"description\":\"bbbbbbb\",\"pageSize\":10,\"id\":2,\"sort\":22,\"isDisplay\":true},{\"imgUrl\":\"brand/cc.jpg\",\"webSite\":\"http://www.cc.html\",\"imageServerImgUrl\":\"http://172.16.16.160:8008/imgs/brand/cc.jpg\",\"pageNo\":1,\"name\":\"cc\",\"description\":\"ccccccc\",\"pageSize\":10,\"id\":3,\"sort\":33,\"isDisplay\":true},{\"imgUrl\":\"brand/dd.jpg\",\"webSite\":\"http://www.dd.html\",\"imageServerImgUrl\":\"http://172.16.16.160:8008/imgs/brand/dd.jpg\",\"pageNo\":1,\"name\":\"dd\",\"description\":\"ddddddd\",\"pageSize\":10,\"id\":4,\"sort\":44,\"isDisplay\":true}]\n";
        ResponseUtils.renderJson(response,data);
    }

    public static void main(String[] args) {
        List<Brand> list = new ArrayList<>();
        list.add(new Brand(1,"aa","aaaaaaa","brand/aa.jpg","http://www.aa.html",11,true));
        list.add(new Brand(2,"bb","bbbbbbb","brand/bb.jpg","http://www.bb.html",22,true));
        list.add(new Brand(3,"cc","ccccccc","brand/cc.jpg","http://www.cc.html",33,true));
        list.add(new Brand(4,"dd","ddddddd","brand/dd.jpg","http://www.dd.html",44,true));

        JSONArray array = new JSONArray(list);
        System.out.println(array.toString());
    }
}
