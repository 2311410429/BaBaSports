package com.baba.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2016/12/15.
 */
public class CustomerDateCoverter implements Converter<String, Date> {

    @Override
    public Date convert(String source) {
        if (source != null && source != "") {
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                return simpleDateFormat.parse(source);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return  new Date();
            }
        }else {
            return new Date();
        }
    }
}

