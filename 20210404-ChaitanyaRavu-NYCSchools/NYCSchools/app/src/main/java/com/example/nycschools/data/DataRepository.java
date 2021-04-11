package com.example.nycschools.data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.nycschools.data.model.SchoolDetailResponse;
import com.example.nycschools.data.model.SchoolListResponse;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Repository layer for School data
 */
public class DataRepository {
    private final ApiService apiService;

    public DataRepository() {
        apiService = ApiClient.getClient().create(ApiService.class);
    }

    /**
     * Get the number of schools list from REST API
     *
     * @return
     */
    public LiveData<List<SchoolListResponse>> getSchools() {
        final MutableLiveData<List<SchoolListResponse>> schoolList = new MutableLiveData<>();

        apiService.getSchools().enqueue(new Callback<List<SchoolListResponse>>() {
            @Override
            public void onResponse(@NotNull Call<List<SchoolListResponse>> call, @NotNull Response<List<SchoolListResponse>> response) {
                if (response.isSuccessful()) {
                    schoolList.setValue(response.body());
                }
            }

            @Override
            public void onFailure(@NotNull Call<List<SchoolListResponse>> call, @NotNull Throwable t) {
            }
        });

        return schoolList;
    }

    /**
     * Get the School details from REST API
     *
     * @param schoolName
     * @return
     */
    public LiveData<List<SchoolDetailResponse>> getSchoolDetails(String schoolName) {
        final MutableLiveData<List<SchoolDetailResponse>> schoolDetails = new MutableLiveData<>();

        apiService.getSchoolDetails(schoolName).enqueue(new Callback<List<SchoolDetailResponse>>() {
            @Override
            public void onResponse(@NotNull Call<List<SchoolDetailResponse>> call, @NotNull Response<List<SchoolDetailResponse>> response) {
                if (response.isSuccessful()) {
                    schoolDetails.setValue(response.body());
                }
            }

            @Override
            public void onFailure(@NotNull Call<List<SchoolDetailResponse>> call, @NotNull Throwable t) {
            }
        });

        return schoolDetails;
    }
}