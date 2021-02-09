package com.rosregistry.readofsndb.exception;

import feign.Response;

public class OfsnImporterException extends RuntimeException{
    public OfsnImporterException(String message) {
        super(message);
    }

    public static OfsnImporterException databaseServiceException(String methodKey, Response response){
        String message = String.format("Error during execute request '%s', error code: %s, response:%n %s", methodKey,
                response.status(), response.toString());
        return new OfsnImporterException(message);
    }
}
