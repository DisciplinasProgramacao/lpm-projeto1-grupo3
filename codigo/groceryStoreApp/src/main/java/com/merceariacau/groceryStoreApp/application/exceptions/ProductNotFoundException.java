package com.merceariacau.groceryStoreApp.application.exceptions;

import com.merceariacau.groceryStoreApp.application.utils.MessageUtils;

public class ProductNotFoundException extends HttpException {

    private static final String MESSAGE = MessageUtils.getMessage("exception.response.product.not.found.message");

    public ProductNotFoundException() {
        super(MESSAGE);
    }

}
