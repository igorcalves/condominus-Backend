package br.com.condominus.Condominus.exceptions.exceptionModel;

public class InvalidTimeForSchedule extends  RuntimeException{

    private String message;

    public InvalidTimeForSchedule(String msg){
        super(msg);
        this.message = msg;
    }

}
