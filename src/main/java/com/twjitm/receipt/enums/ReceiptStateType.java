package com.twjitm.receipt.enums;

/**
 * Created by 文江 on 2017/9/6.
 */
public enum ReceiptStateType {
    DOING((short) 0, "未结算"),
    FINUSH((short) 1, "已结算");
    private short value;
    private String context;

    ReceiptStateType(short value, String context) {
        this.value = value;
        this.context = context;
    }

    public short getValue() {
        return value;
    }

    public void setValue(short value) {
        this.value = value;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
