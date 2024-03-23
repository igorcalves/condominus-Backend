package br.com.condominus.Condominus.exceptions.exceptionModel;

public class EmailAlreadyExistsException extends RuntimeException {

    private String message;

    public EmailAlreadyExistsException(String msg){
        super(msg);
        this.message = msg;
    }
    
}
