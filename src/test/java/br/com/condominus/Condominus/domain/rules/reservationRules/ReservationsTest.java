package br.com.condominus.Condominus.domain.rules.reservationRules;


import org.junit.jupiter.api.Test;


import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;


class ReservationsTest {


    Reservations r = new Reservations();


    @Test
    void canYouScheduleOpenClose() {
        Boolean t1 = r.canYouScheduleOpenClose(
                LocalTime.of(12,0),
                LocalTime.of(18,0),
                LocalTime.of(12,0),
                LocalTime.of(22,0));
        Boolean t2 = r.canYouScheduleOpenClose(
                LocalTime.of(12,0),
                LocalTime.of(18,0),
                LocalTime.of(12,0),
                LocalTime.of(22,0));
        Boolean t3 = r.canYouScheduleOpenClose(
                LocalTime.of(12,0),
                LocalTime.of(22,0),
                LocalTime.of(12,0),
                LocalTime.of(22,0));

        Boolean t4 = r.canYouScheduleOpenClose(LocalTime.of(11,0),
                LocalTime.of(18,0),
                LocalTime.of(10,0),
                LocalTime.of(15,0));


        assertTrue(t1);
        assertTrue(t2);
        assertTrue(t3);

        assertFalse(t4);
    }

    @Test
    void canYouSchedule(){
        assertTrue(
              r.canYouSchedule(
                      LocalTime.of(14,0),
                      LocalTime.of(18,0),
                      LocalTime.of(11,0),
                      LocalTime.of(13,50)
              )

        );

        assertFalse(
                r.canYouSchedule(
                        LocalTime.of(11,0),
                        LocalTime.of(22,0),
                        LocalTime.of(7,0),
                        LocalTime.of(13,50)
                )
        );

    }
}