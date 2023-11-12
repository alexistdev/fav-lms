package com.alexistdev.lmsfav.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseData<T> {
    private boolean status;
    private String messages="";

    private T data;

    public boolean isStatus() {
        return status;
    }
}
