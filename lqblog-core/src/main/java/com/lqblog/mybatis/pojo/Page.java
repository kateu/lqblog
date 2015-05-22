package com.lqblog.mybatis.pojo;


import java.util.Collections;
import java.util.List;

public class Page {

    private int pageSize;
    private int totalRecord;
    private int currentPage;
    private int totalPage;

    public Page() {
        this.pageSize = 10;
        this.totalRecord = 0;
        this.currentPage = 1;
    }

    public Page(int currentPage, int totalRecord, int pageSize) {
        this.pageSize = 10;

        this.totalRecord = 0;

        this.currentPage = 1;

        this.currentPage = currentPage;
        this.totalRecord = totalRecord;
        this.pageSize = pageSize;
    }

    public int getRecordIndex() {
        if (this.currentPage > 0)
            return ((this.currentPage - 1) * this.pageSize);

        return 0;
    }

    public int getRecordStart() {
        if (this.currentPage > 0)
            return ((this.currentPage - 1) * this.pageSize + 1);

        return 0;
    }

    public int getRecordEnd() {
        if (this.currentPage > 0)
            return (this.currentPage * this.pageSize);

        return 0;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalRecord() {
        return this.totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getCurrentPage() {
        return this.currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        this.totalPage = (int) Math.floor(this.totalRecord * 1D / this.pageSize);
        if (this.totalRecord % this.pageSize != 0)
            this.totalPage = (this.totalPage + 1);

        if (this.totalPage == 0)
            return 1;

        return this.totalPage;
    }

    public static class FieldDomain {
        public static final String RECORD_START = "recordStart";
        public static final String RECORD_INDEX = "recordIndex";
        public static final String RECORD_END = "recordEnd";
        public static final String PAGE_SIZE = "pageSize";
        public static final String TOTAL_RECORD = "totalRecord";
        public static final String CURRENT_PAGE = "currentPage";
        public static final String TOTAL_PAGE = "totalPage";
        public static final String RECORDS = "records";
    }
}