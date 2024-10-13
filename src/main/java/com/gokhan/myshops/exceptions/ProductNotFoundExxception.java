package com.gokhan.myshops.exceptions;

public class ProductNotFoundExxception extends RuntimeException{
    public ProductNotFoundExxception (String message)  {
        super(message);
    }
}
