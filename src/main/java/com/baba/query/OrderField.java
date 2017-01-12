package com.baba.query;
/**
 *  批量查询时的Order条件顺序设置
 *  用来封装查询语句中order by后面的内容，比如：order by name asc , description desc
 **/
public class OrderField {
        private String fieldName;
        private String order;

        public String getFieldName() {
            return fieldName;
        }

        public OrderField setFieldName(String fieldName) {
            this.fieldName = fieldName;
            return this;
        }

        public String getOrder() {
            return order;
        }

        public OrderField setOrder(String order) {
            this.order = order;
            return this;
        }

        public OrderField() {
        }

        public OrderField(String fieldName, String order) {
            super();
            this.fieldName = fieldName;
            this.order = order;
        }
    }