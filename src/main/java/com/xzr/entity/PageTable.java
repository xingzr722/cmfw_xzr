package com.xzr.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by F on 2017/10/25.
 */
public class PageTable<T> implements Serializable{
    private Integer total;
    private List<T> rows;

    public PageTable() {
    }

    public PageTable(Integer total, List<T> rows) {

        this.total = total;
        this.rows = rows;
    }

    public Integer getTotal() {

        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "PageTable{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }
}
