package com.lhyzp.base;

import java.util.List;

/**
 * Created by Administrator on 2017-9-23.
 */
public class DataTable {
    private Long total;//总记录数

    private Integer page;//当前页

    private Long records;//查询出的记录数

    private List<?> rows;//数据

    private Object data;//其他数据

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Long getRecords() {
        return records;
    }

    public void setRecords(Long records) {
        this.records = records;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
