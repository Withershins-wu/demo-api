package com.zy.entity;

public class Product {
    private Long id;

    private String proName;

    private Byte proSort;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName == null ? null : proName.trim();
    }

    public Byte getProSort() {
        return proSort;
    }

    public void setProSort(Byte proSort) {
        this.proSort = proSort;
    }
}