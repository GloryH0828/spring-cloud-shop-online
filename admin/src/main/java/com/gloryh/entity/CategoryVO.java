package com.gloryh.entity;

import java.util.List;

/**
 * 封装他的分页信息
 *
 * @author 黄光辉
 * @since 2020/11/6
 **/
public class CategoryVO {
    /**
     * 每页显示的条数
     */
    private int pageSize=4;
    /**
     * 当前页的页码
     */
    private int currentPage;

    /**
     * 数据库中查询到的总条数
     */
    private int totalSize;
    /**
     * 总页数
     */
    private int totalPage;
    /**
     * 起始页记录索引
     */
    private int startIndex;
    /**
     * 当前页列表信息
     */
    private List<Category> list;


    /**
     * 定义Page类接收的参数（totalSize和currentPage，即数据总数量和当前页码），用于对其他参数进行操作
     */
    public CategoryVO(int currentPage, int totalSize){
        this.totalSize=totalSize;
        setCurrentPage(currentPage);
    }

    /**
     * 定义为固定值，直接获取
     * @return
     */
    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 由函数作为参数传递进入实体类
     * @return
     */
    public int getCurrentPage() {
        return currentPage;
    }

    public int setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
        return currentPage;
    }

    /**
     * 数据库查询总数后，由函数作为参数传递进入实体类
     * @return
     */
    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    /**
     * 总页码，由totalSize和pageSize计算得到
     * @return
     */
    public int getTotalPage() {
        totalPage=(totalSize%pageSize==0)?(totalSize/pageSize):(totalSize/pageSize+1);

        return totalPage;
    }

    /**
     * 起始记录的索引
     * 第i页   （i-1）*x（分页大小）
     * @return
     */

    public int getStartIndex() {

        return (currentPage-1)*pageSize;
    }


    public List<Category> getList() {
        return list;
    }

    public void setList(List<Category> list) {
        this.list = list;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    @Override
    public String toString() {
        return "CategoryVO{" +
                "pageSize=" + pageSize +
                ", currentPage=" + currentPage +
                ", totalSize=" + totalSize +
                ", totalPage=" + totalPage +
                ", startIndex=" + startIndex +
                ", list=" + list +
                '}';
    }
}
