package com.eslam.kreazrx.api;


import com.eslam.kreazrx.ui.offer.OfferResponse;


import io.reactivex.Single;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {

//    @FormUrlEncoded
//    @POST("notes/new")
//    Single<ContactsContract.CommonDataKinds.Note> createNote(@Field("note") String note);

    // Fetch all offers
    @GET("index.php")
    Single<OfferResponse> fetchOfferList(
            @Query("mode") String mode,
            @Query("type") String type
    );
}
