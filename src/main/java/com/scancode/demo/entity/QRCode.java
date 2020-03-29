package com.scancode.demo.entity;

import java.util.Date;

public class QRCode {
    private String id;
    private String code;
    private Date createTime;
    private Date scanTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getScanTime() {
        return scanTime;
    }

    public void setScanTime(Date scanTime) {
        this.scanTime = scanTime;
    }
}
