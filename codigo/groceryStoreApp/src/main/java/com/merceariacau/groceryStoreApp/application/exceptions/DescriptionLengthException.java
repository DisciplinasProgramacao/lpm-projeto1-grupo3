package com.merceariacau.groceryStoreApp.application.exceptions;

import com.merceariacau.groceryStoreApp.application.utils.MessageUtils;

public class DescriptionLengthException extends HttpException{

    private static final String MESSAGE = MessageUtils.getMessage("exception.response.description.length.message");

    public DescriptionLengthException() {
        super(MESSAGE);
    }
}
