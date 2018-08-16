package com.differz.paychecker.rest;

import java.time.LocalDate;

/**
 *  Project | Code | Number | Expire
 */
public class ItsDetails {

    private String name;
    private String edrpou;
    private String number;
    private LocalDate lastMonth;
    private LocalDate expireDate;
    private int projectId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEdrpou() {
        return edrpou;
    }

    public void setEdrpou(String edrpou) {
        this.edrpou = edrpou;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDate getLastMonth() {
        return lastMonth;
    }

    public void setLastMonth(LocalDate lastMonth) {
        this.lastMonth = lastMonth;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }
}
