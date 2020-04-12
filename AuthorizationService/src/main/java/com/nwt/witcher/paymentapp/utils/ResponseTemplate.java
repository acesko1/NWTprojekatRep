package com.nwt.witcher.paymentapp.utils;

import java.util.Date;

public class ResponseTemplate<T> {

    private Date timestamp;
    private T item;

    public ResponseTemplate(T item) {
        this.item = item;
    }
}
