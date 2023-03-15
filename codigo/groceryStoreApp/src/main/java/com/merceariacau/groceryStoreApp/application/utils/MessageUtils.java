package com.merceariacau.groceryStoreApp.application.utils;

import lombok.experimental.UtilityClass;

import java.util.ResourceBundle;

@UtilityClass
public class MessageUtils {

    public static String getMessage(String key){
        ResourceBundle resourceBundle = ResourceBundle.getBundle("messages");
        return resourceBundle.getString(key);
    }
}
