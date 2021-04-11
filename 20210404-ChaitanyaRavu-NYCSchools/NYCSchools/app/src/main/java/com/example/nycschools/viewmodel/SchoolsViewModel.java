package com.example.nycschools.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.nycschools.data.DataRepository;
import com.example.nycschools.data.model.SchoolDetailResponse;
import com.example.nycschools.data.model.SchoolListResponse;

import java.util.List;

public class SchoolsViewModel extends ViewModel {

    private final DataRepository repository;

    public SchoolsViewModel() {
        repository = new DataRepository();
    }

    /**
     * Get School List from repository
     * @return
     */
    public LiveData<List<SchoolListResponse>> getSchoolsList() {
        return repository.getSchools();
    }

    /**
     * Get School details based on school dbn ID
     * @param schoolName
     * @return
     */
    public LiveData<List<SchoolDetailResponse>> getSchoolDetails(String schoolName) {
        return repository.getSchoolDetails(schoolName);
    }
}
