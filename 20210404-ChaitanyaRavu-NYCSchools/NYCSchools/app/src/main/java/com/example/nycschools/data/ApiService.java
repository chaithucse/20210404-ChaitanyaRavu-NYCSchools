package com.example.nycschools.data;

import com.example.nycschools.data.model.SchoolDetailResponse;
import com.example.nycschools.data.model.SchoolListResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("resource/s3k6-pzi2.json")
    Call<List<SchoolListResponse>> getSchools();

    @GET("resource/f9bf-2cp4.json")
    Call<List<SchoolDetailResponse>> getSchoolDetails(@Query("dbn") String dbn);
}
