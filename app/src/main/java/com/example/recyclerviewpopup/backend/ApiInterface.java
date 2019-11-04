package com.example.recyclerviewpopup.backend;

import com.example.recyclerviewpopup.Model.Anggota;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("anggota.php")
    Call<Anggota> viewAnggota();

}
