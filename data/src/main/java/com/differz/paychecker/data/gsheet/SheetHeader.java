package com.differz.paychecker.data.gsheet;

public enum SheetHeader {

    NUMBER(1, "Number"),
    CLNAME(2, "Project"),
    EDRPOU(3, "Code"),
    REGNUM(4, "Reg.num"),
    EXPIRE(5, "Expiration month");

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
                return NUMBER;
            case 2:
                return CLNAME;
            case 3:
                return EDRPOU;
            case 4:
                return REGNUM;
            case 5:
                return EXPIRE;
            default:
                return null;
        }
    }
}
