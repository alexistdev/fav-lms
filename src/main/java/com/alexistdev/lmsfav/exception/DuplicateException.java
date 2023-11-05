package com.alexistdev.lmsfav.exception;

import java.util.ResourceBundle;

public class DuplicateException extends Exception{

    public DuplicateException(String name,ResourceBundle resourceBundle) {
        super("Role "+name + " " + resourceBundle.getString("duplicate"));
    }
}
