package br.com.condominus.Condominus.exceptions.exceptionModel;

public class ResourceNotFound extends RuntimeException{
    private String message;

    public ResourceNotFound(String msg){
        super(msg);
        this.message = msg;
    }
}
