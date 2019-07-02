/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.domain;

import java.util.Date;

/**
 *
 * @author tellw
 */
public class Film {
    private int filmId;
    private String filmName;
    private int duration;
    private String filmAbstract;
    private String directive;
    private Date releaseDate;

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getFilmAbstract() {
        return filmAbstract;
    }

    public void setFilmAbstract(String filmAbstract) {
        this.filmAbstract = filmAbstract;
    }

    public String getDirective() {
        return directive;
    }

    public void setDirective(String directive) {
        this.directive = directive;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDurationType() {
        return durationType;
    }

    public void setDurationType(String durationType) {
        this.durationType = durationType;
    }
    private String durationType;
}
