package br.com.condominus.Condominus.exceptions.exceptionModel;

public class ValidationException extends  RuntimeException{

    private String message;

    public ValidationException(String msg){
        super(msg);
        this.message = msg;
    }
}
