package it.moov.moovandroid.network.endpoints;

import it.moov.moovandroid.models.Reservation;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ReservationsEndpointInterface {

    @POST("reservations/")
    Call<Reservation> createNewReservation(@Body Reservation reservation);

}
