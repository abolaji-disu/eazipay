package com.eazipay.eazipaytask.exception;

import graphql.GraphQLException;

public class AppUserExistException extends GraphQLException {
    public AppUserExistException(String s) {
        super (s);
    }
}
