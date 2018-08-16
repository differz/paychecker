package com.differz.paychecker.data.gsheet;

public enum SheetHeader {

    PROJECT(1, "Project"),
    EDRPOU(2, "Code"),
    NUMBER(3, "Number"),
    EXPIRE(4, "Expiration month");

    private final int code;
    private final String name;

    SheetHeader(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public final int getCode() {
        return code;
    }

    public final String getName() {
        return name;
    }

    public static SheetHeader byCode(int code) {
        switch (code) {
            case 1:
                return PROJECT;
            case 2:
                return EDRPOU;
            case 3:
                return NUMBER;
            case 4:
                return EXPIRE;
        }
        return null;
    }
}
