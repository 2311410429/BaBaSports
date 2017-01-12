package com.baba.controller.browser;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/1/9.
 */
@Controller
public class CenterController {

    @RequestMapping("/back")
    public String frame(String url) {
        System.out.println("url "+url);
        return url;
    }

}
