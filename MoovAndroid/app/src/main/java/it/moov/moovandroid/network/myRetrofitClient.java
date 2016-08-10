package it.moov.moovandroid.network;

import it.moov.moovandroid.models.Reservation;
import it.moov.moovandroid.network.endpoints.ReservationsEndpointInterface;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class myRetrofitClient {

    public static final String BASE_URL = "http://10.0.3.2:9999/";
    private static ReservationsEndpointInterface reservationsAPI;

    public static void init() {
        Retrofit my_client = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        reservationsAPI = my_client.create(ReservationsEndpointInterface.class);
    }

    public static Call<Reservation> createNewReservation(Reservation r) {
        return reservationsAPI.createNewReservation(r);
    }

}
