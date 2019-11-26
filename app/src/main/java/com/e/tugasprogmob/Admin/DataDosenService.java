package com.e.tugasprogmob.Admin;

import com.e.tugasprogmob.Model.Dosen;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface DataDosenService {
    @GET("api/progmob/dosen/{nim_progmob}")
    Call<List<Dosen>> getDosenAll(@Path("nim_progmob") String nimProgmob);
    @POST("api/progmob/dosen/{nim_progmob}")
    Call<Dosen> postDosen(@Path("nim_progmob") String nimProgmob,
                                @Field("id") String id,
                                @Field("nama") String nama,
                                @Field("nidn") String nidn,
                                @Field("alamat") String alamat,
                                @Field("email") String email,
                                @Field("gelar") String gelar,
                                @Field("foto") String foto);
}
