package com.baba.utils.page;

import java.io.Serializable;

public class PageBase implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final int DEF_COUNT = 20;
    /**
     * 一共有多少条记录
     */
    protected int totalCount = 0;
    /**
     * 默认每页显示多少条
     */
    protected int pageSize = 20;
    /**
     * 当前显示的页面编码
     */
    protected int pageNo = 1;

    public void setTotalCount(int totalCount) {
        if (totalCount < 0) {
            this.totalCount = 0;
        } else {
            this.totalCount = totalCount;
        }
    }

    public void setPageSize(int pageSize) {
        if (pageSize < 1) {
            this.pageSize = 20;
        } else {
            this.pageSize = pageSize;
        }
    }

    public void setPageNo(int pageNo) {
        if (pageNo < 1) {
            this.pageNo = 1;
        } else {
            this.pageNo = pageNo;
        }
    }

    public int getPageNo() {
        return this.pageNo;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public int getTotalCount() {
        return this.totalCount;
    }


    /**
     * 获取当前的页面编码
     * @param pageNo
     * @return
     */
    public static int cpn(Integer pageNo) {
        return (pageNo == null) || (pageNo.intValue() < 1) ? 1 : pageNo.intValue();
    }

    public PageBase() {
    }

    /**
     *
     * @param pageNo 当前页面编码
     * @param pageSize 每页数据的条数
     * @param totalCount 一共有多少条数据
     */
    public PageBase(int pageNo, int pageSize, int totalCount) {
        setTotalCount(totalCount);
        setPageSize(pageSize);
        setPageNo(pageNo);
        adjustPageNo();
    }

    /**
     * 定位到最后一页
     */
    public void adjustPageNo() {
        if (this.pageNo == 1) {
            return;
        }
        int tp = getTotalPage();
        if (this.pageNo > tp) {
            this.pageNo = tp;
        }
    }

    /**
     * 获取一共有多少页
     * @return
     */
    public int getTotalPage() {
        int totalPage = this.totalCount / this.pageSize;
        if ((totalPage == 0) || (this.totalCount % this.pageSize != 0)) {
            totalPage++;
        }
        return totalPage;
    }

    /**
     * 判断是不是第一页
     * @return 是的话返回true，否则返回false
     */
    public boolean isFirstPage() {
        return this.pageNo <= 1;
    }

    /**
     * 判断是不是最后一页
     * @return 是的话返回true，否则返回false
     */
    public boolean isLastPage() {
        return this.pageNo >= getTotalPage();
    }

    /**
     * 获取下一页的页面
     * @return 下一页的页码，如果当前页是最后一页，直接返回当前页
     */
    public int getNextPage() {
        if (isLastPage()) {
            return this.pageNo;
        }
        return this.pageNo + 1;
    }

    /**
     * 获取上一页的页码
     * @return上一页的页码，如果当前页是第一页，直接返回当前页
     */
    public int getPrePage() {
        if (isFirstPage()) {
            return this.pageNo;
        }
        return this.pageNo - 1;
    }

}
