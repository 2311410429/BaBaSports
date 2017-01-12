package com.baba.test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2017/1/10.
 */
public class JerseyTest {
    public static void main(String[] args) throws IOException {
        Client client = new Client();

        String url = "http://localhost:8008/imgs/upload/abc.png";//图片服务器

        WebResource resource = client.resource(url);//设置请求路径
        String path = "D:\\BaBaSports\\src\\main\\webapp\\res\\img\\blue\\backtotop.png";

        byte[] bytes = FileUtils.readFileToByteArray(new File(path));
        resource.put(String.class,bytes);
        System.out.println("success");
    }
}
