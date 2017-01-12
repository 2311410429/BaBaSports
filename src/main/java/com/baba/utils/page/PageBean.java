package com.baba.utils.page;

import java.util.ArrayList;
import java.util.List;

public class PageBean<T> extends PageBase {

    /**
     * 每页所显示的数据
     */
    private List<T> data;

    /**
     * 每页所对应的分页视图
     */
    private List<String> pageView;

    /**
     * 获取当前页所显示的数据
     *
     * @return
     */
    public List<T> getData() {
        return this.data;
    }

    /**
     * 设置当前页所显示的数据
     *
     * @param data
     */
    public void setData(List data) {
        this.data = data;
    }

    public List<String> getPageView() {
        return this.pageView;
    }

    public void setPageView(List<String> pageView) {
        this.pageView = pageView;
    }

    public PageBean() {
    }

    /**
     * @param pageNo     当前页面编码
     * @param pageSize   每页数据的条数
     * @param totalCount 一共有多少条数据
     */
    public PageBean(int pageNo, int pageSize, int totalCount) {
        super(pageNo, pageSize, totalCount);
        cpn(pageNo);
    }

    /**
     * @param pageNo     当前页面编码
     * @param pageSize   每页数据的条数
     * @param totalCount 一共有多少条数据
     * @param data       当前页所要显示的数据
     */
    public PageBean(int pageNo, int pageSize, int totalCount, List<T> data) {
        super(pageNo, pageSize, totalCount);
        cpn(pageNo);
        this.data = data;
    }

    /**
     * 获取当前页所要显示的第一条数据的序号
     *
     * @return
     */
    public int getFirstResult() {
        return (this.pageNo - 1) * this.pageSize;
    }



    public void pageView(String url, String params) {
        this.pageView = new ArrayList();
        if (this.pageNo != 1) {
            this.pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo=1'\"><font size=2>首页</font></a>");
            this.pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo=" + (this.pageNo - 1) + "'\"><font size=2>上一页</font></a>");
        } else {//当前显示第一页时，首页和上一页不能单击
            this.pageView.add("<font size=2>首页</font>");
            this.pageView.add("<font size=2>上一页</font>");
        }
        if (getTotalPage() <= 10) {
            for (int i = 0; i < getTotalPage(); i++) {
                if (i + 1 == this.pageNo) {
                    this.pageView.add("<strong>" + this.pageNo + "</strong>");//当前页加粗
                    i++;
                    if (this.pageNo == getTotalPage()) {
                        break;
                    }
                }
                this.pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo=" + (i + 1) + "'\">" + (i + 1) + "</a>");
            }
        } else if (getTotalPage() <= 20) {
            int left = 0;
            int right = 0;
            if (this.pageNo < 5) {
                left = this.pageNo - 1;
                right = 10 - left - 1;
            } else if (getTotalPage() - this.pageNo < 5) {
                right = getTotalPage() - this.pageNo;
                left = 9 - right;
            } else {
                left = 4;
                right = 5;
            }
            int tmp = this.pageNo - left;
            for (int i = tmp; i < tmp + 10; i++) {
                if (i == this.pageNo) {
                    this.pageView.add("<strong>" + this.pageNo + "</strong>");
                    i++;
                    if (this.pageNo == getTotalPage()) {
                        break;
                    }
                }
                this.pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo=" + i + "'\">" + i + "</a>");
            }
        } else {// getTotalPage()> 20
            if (this.pageNo < 7) {
                for (int i = 0; i < 8; i++) {
                    if (i + 1 == this.pageNo) {
                        this.pageView.add("<strong>" + this.pageNo + "</strong>");
                        i++;
                    }
                    this.pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo=" + (i + 1) + "'\">" + (i + 1) + "</a>");
                }
                this.pageView.add("...");
                this.pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo=" + (getTotalPage() - 1) + "'\">" + (getTotalPage() - 1) + "</a>");
                this.pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo=" + getTotalPage() + "'\">" + getTotalPage() + "</a>");
            } else if (this.pageNo > getTotalPage() - 6) {
                this.pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo=" + 1 + "'\">" + 1 + "</a>");
                this.pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo=" + 2 + "'\">" + 2 + "</a>");
                this.pageView.add("...");
                for (int i = getTotalPage() - 8; i < getTotalPage(); i++) {
                    if (i + 1 == this.pageNo) {
                        this.pageView.add("<strong>" + this.pageNo + "</strong>");
                        i++;
                        if (this.pageNo == getTotalPage()) {
                            break;
                        }
                    }
                    this.pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo=" + (i + 1) + "'\">" + (i + 1) + "</a>");
                }
            } else {
                this.pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo=" + 1 + "'\">" + 1 + "</a>");
                this.pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo=" + 2 + "'\">" + 2 + "</a>");
                this.pageView.add("...");

                this.pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo=" + (this.pageNo - 2) + "'\">" + (this.pageNo - 2) + "</a>");
                this.pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo=" + (this.pageNo - 1) + "'\">" + (this.pageNo - 1) + "</a>");
                this.pageView.add("<strong>" + this.pageNo + "</strong>");
                this.pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo=" + (this.pageNo + 1) + "'\">" + (this.pageNo + 1) + "</a>");
                this.pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo=" + (this.pageNo + 2) + "'\">" + (this.pageNo + 2) + "</a>");

                this.pageView.add("...");
                this.pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo=" + (getTotalPage() - 1) + "'\">" + (getTotalPage() - 1) + "</a>");
                this.pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo=" + getTotalPage() + "'\">" + getTotalPage() + "</a>");
            }
        }

        if (this.pageNo != getTotalPage()) {
            this.pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo=" + (this.pageNo + 1) + "'\"><font size=2>下一页</font></a>");
            this.pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo=" + getTotalPage() + "'\"><font size=2>尾页</font></a>");
        } else {
            this.pageView.add("<font size=2>下一页</font>");
            this.pageView.add("<font size=2>尾页</font>");
        }

        this.pageView.add("共<var>" + getTotalPage() + "</var>页 到第<input type='text' id='PAGENO'  size='3' value='"+pageNo+"'/>页 <input type='button' id='skip' class='hand btn60x20' value='确定' onclick=\"javascript:window.location.href = '" + url + "?" + params + "&pageNo=' + $('#PAGENO').val() \"/>");
    }
}