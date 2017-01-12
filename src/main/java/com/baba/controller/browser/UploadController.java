package com.baba.controller.browser;

import com.baba.utils.Constants;
import com.baba.utils.ResponseUtils;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.io.FilenameUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import com.sun.jersey.api.client.Client;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by Administrator on 2017/1/10.
 */
@Controller
@RequestMapping(value = "/upload")
public class UploadController {

    @RequestMapping(value = "/{folder}/uploadPic")
    public void uploadPic(@RequestParam(required = false)MultipartFile pic, @PathVariable String folder, HttpServletResponse response){

        String ext = FilenameUtils.getExtension(pic.getOriginalFilename());   //扩展名

        //图片名称生成策略
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        //图片名称一部分
        String format = df.format(new Date());
        format += (new Random().nextInt(899)+100); //随机三位数

        Client client = new Client();  //实例化一个Jersey
        String path = "upload/"+folder+"/" + format + "." + ext;
        String url = Constants.IMAGE_SERVER_URL + path;
        WebResource resource = client.resource(url);   //设置请求路径
        try {
            resource.put(String.class, pic.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        //返回二个路径
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("url", url);
        jsonObject.put("path",path);

        ResponseUtils.renderJson(response, jsonObject.toString());
    }
}
