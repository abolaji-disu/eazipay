package com.eazipay.eazipaytask.exception;

import graphql.GraphQLException;

public class AppUserException extends GraphQLException {
    public AppUserException(String s) {
        super (s);
    }
}
