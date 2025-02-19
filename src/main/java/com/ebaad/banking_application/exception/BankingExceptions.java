package com.ebaad.banking_application.exception;

public class BankingExceptions {

    public static class InvalidIdException extends RuntimeException {
        public InvalidIdException(String message) {
            super(message);
        }
    }

    public static class InvalidNameException extends RuntimeException {
        public InvalidNameException(String message) {
            super(message);
        }
    }

    public static class InsufficientFundsException extends RuntimeException {
        public InsufficientFundsException(String message) {
            super(message);
        }
    }

    public static class InvalidAmountException extends RuntimeException {
        public InvalidAmountException(String message) {
            super(message);
        }
    }

//    public static class AccessNotAllowedException extends RuntimeException {
//        public AccessNotAllowedException(String message) {
//            super(message);
//        }
//    }
}
