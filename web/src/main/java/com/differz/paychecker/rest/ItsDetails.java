package com.differz.paychecker.rest;

import java.time.LocalDate;

/**
 * Project | Code | Number | Expire
 */
public class ItsDetails {

    private String service;
    private String name;
    private String edrpou;
    private String number;
    private LocalDate lastMonth;
    private LocalDate expireDate;
    private LocalDate currentDate;
    private boolean expired;
    private int projectId;

    public ItsDetails() {
        this.service = "ITS";
        this.expired = true;
        this.currentDate = LocalDate.now();
    }

    public String getService() {
        return service;
    }

    public LocalDate getCurrentDate() {
        return currentDate;
    }

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
        setExpired();
    }

    public boolean isExpired() {
        return expired;
    }

    private void setExpired() {
        this.expired = !getCurrentDate().isBefore(getExpireDate());
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }
}
