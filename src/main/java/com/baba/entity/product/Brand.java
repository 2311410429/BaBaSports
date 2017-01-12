package com.baba.entity.product;

import com.baba.utils.Constants;

public class Brand {
    private Integer id;

    private String name;

    private String description;

    private String imgUrl;

    private String webSite;

    private Integer sort;

    private Boolean isDisplay; //true(1)表示显示；false(0)表示不显示

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite == null ? null : webSite.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Boolean getIsDisplay() {
        return isDisplay;
    }

    public void setIsDisplay(Boolean isDisplay) {
        this.isDisplay = isDisplay;
    }

    public Brand() {
    }

    public Brand(Integer id, String name, String description, String imgUrl, String webSite, Integer sort, Boolean isDisplay) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imgUrl = imgUrl;
        this.webSite = webSite;
        this.sort = sort;
        this.isDisplay = isDisplay;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", webSite='" + webSite + '\'' +
                ", sort=" + sort +
                ", isDisplay=" + isDisplay +
                '}';
    }

    ///////////////////////////////////////////////////

    private Integer pageNo = 1; //页号
    private Integer pageSize = 10;  //每页数

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {  //计算一次开始行
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {   //计算一次开始行
        this.pageSize = pageSize;
    }

    /**
     * 商标所对应的图片在图片服务器中的网址
     */
    private String imageServerImgUrl;

    public String getImageServerImgUrl() {
        return Constants.IMAGE_SERVER_URL+imgUrl;
    }

    public void setImageServerImgUrl(String imageServerImgUrl) {
        this.imageServerImgUrl = imageServerImgUrl;
    }

}