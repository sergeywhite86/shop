package org.skypro.skyshop.exception;

public class BestResultNotFound extends Exception {
    public BestResultNotFound(String inputRequest) {
        super(String.format("Best result not found for %s",inputRequest));
    }
}
