/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.domain;

/**
 *
 * @author tellw
 */
public class FilmComment {
    private int filmCommentId;
    private int filmId;
    private String commentBuyerId;
    private String comment;
    private String filmCommentTime;

    public int getFilmCommentId() {
        return filmCommentId;
    }

    public void setFilmCommentId(int filmCommentId) {
        this.filmCommentId = filmCommentId;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public String getCommentBuyerId() {
        return commentBuyerId;
    }

    public void setCommentBuyerId(String commentBuyerId) {
        this.commentBuyerId = commentBuyerId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getFilmCommentTime() {
        return filmCommentTime;
    }

    public void setFilmCommentTime(String filmCommentTime) {
        this.filmCommentTime = filmCommentTime;
    }
}
