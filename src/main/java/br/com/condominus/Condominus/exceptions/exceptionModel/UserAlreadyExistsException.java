package br.com.condominus.Condominus.exceptions.exceptionModel;

public class UserAlreadyExistsException extends  RuntimeException{

    private String message;

    public UserAlreadyExistsException(String msg){
        super(msg);
        this.message = msg;
    }

}
