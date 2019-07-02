/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.domain;

import java.sql.Timestamp;

/**
 *
 * @author tellw
 */
public class Notice {
    private int noticeId;
    private String noticeContent;
    private Timestamp noticeTime;

    public int getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(int noticeId) {
        this.noticeId = noticeId;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    public Timestamp getNoticeTime() {
        return noticeTime;
    }

    public void setNoticeTime(Timestamp noticeTime) {
        this.noticeTime = noticeTime;
    }
}
