package br.com.condominus.Condominus.exceptions.exceptionModel;

public class UserNotFoundException extends RuntimeException{
    private String message;

    public UserNotFoundException(String msg){
        super(msg);
        this.message = msg;
    }
}
