package br.com.condominus.Condominus.domain.rules.reservationRules;

import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.List;

@Component
public class Reservations {

    public boolean canYouScheduleOpenClose(LocalTime startSchdule,LocalTime endSchdule,LocalTime open,LocalTime close){
        return (startSchdule.isAfter(open) || startSchdule.equals(open) ) && (endSchdule.isBefore(close) || endSchdule.equals(close) );
    }

    public boolean canYouSchedule(LocalTime startScheduleTime,LocalTime endScheduleTime,LocalTime startSchedule,LocalTime endSchedule){
        if (startSchedule.isAfter(startScheduleTime) && startScheduleTime.isBefore(endScheduleTime)) return false;
        return !endSchedule.isAfter(startScheduleTime) || !endSchedule.isBefore(endScheduleTime);
    }




}
