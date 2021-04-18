package com.waverly.graduateProject.entity;

/**
 * 封装分页 组件
 */
public class Page {
    private int current = 1;//当前页
    private int limit = 10;//每页数量限制
    private int rows;//数据总数，计算页码
    private String path;//查询路径
    private int from;
    private int to;

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        if (current >= 1) this.current = current;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        if (current >= 1 && current <= 100) this.limit = limit;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        if (current >= 0)
            this.rows = rows;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 获取当前页的起始行
     *
     * @return
     */
    public int getOffset() {
        return (current - 1) * limit;
    }

    /**
     * 获取总页数
     *
     * @return
     */
    public int getTotal() {
        if (rows % limit == 0) return rows / limit;
        else return rows / limit + 1;
    }

    /**
     * 获取起始行
     *
     * @return
     */
    public int getFrom() {
        int from = current - 2;
        this.from = from < 1 ? 1 : from;
        return this.from;
    }

    /**
     * 获获取结束页码
     *
     * @return
     */
    public int getGo() {
        int go = current + 2;
        int total = getTotal();
        this.to = go > total ? total : go;
        return this.to;
    }
}
