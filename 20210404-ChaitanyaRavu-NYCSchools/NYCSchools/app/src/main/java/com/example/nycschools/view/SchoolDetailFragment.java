package com.example.nycschools.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.nycschools.MainActivity;
import com.example.nycschools.common.AppConstants;
import com.example.nycschools.data.model.SchoolDetailResponse;
import com.example.nycschools.databinding.FragmentSchoolDetailsBinding;
import com.example.nycschools.viewmodel.SchoolsViewModel;

import java.util.List;

/**
 * Display School details information
 */
public class SchoolDetailFragment extends Fragment {

    private String schoolDbn = "";
    private String schoolName = "";
    private String schoolAddress = "";
    private String schoolEmail = "";
    private String schoolContact = "";
    private String schoolWebsite = "";
    private String schoolCity = "";
    private FragmentSchoolDetailsBinding mBinding;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            schoolDbn = getArguments().getString(AppConstants.SCHOOL_ID);
            schoolName = getArguments().getString(AppConstants.SCHOOL_NAME);
            schoolAddress = getArguments().getString(AppConstants.SCHOOL_ADDRESS);
            schoolEmail = getArguments().getString(AppConstants.SCHOOL_EMAIL);
            schoolContact = getArguments().getString(AppConstants.SCHOOL_CONTACT);
            schoolWebsite = getArguments().getString(AppConstants.SCHOOL_WEBSITE);
            schoolCity = getArguments().getString(AppConstants.SCHOOL_CITY);
        }

        ((MainActivity) getActivity()).getSupportActionBar().setTitle(schoolName);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = FragmentSchoolDetailsBinding.inflate(inflater, container, false);

        mBinding.address.setText("Address: " + schoolAddress + ", " + schoolCity);
        mBinding.phone.setText("Contact: " + schoolContact);
        mBinding.email.setText("Email: " + schoolEmail);
        mBinding.website.setText("Website: " + schoolWebsite);

        fetchSchoolDetails();

        return mBinding.getRoot();
    }

    private void fetchSchoolDetails() {
        SchoolsViewModel viewModel = new ViewModelProvider(this).get(SchoolsViewModel.class);
        viewModel.getSchoolDetails(schoolDbn).observe(requireActivity(), new Observer<List<SchoolDetailResponse>>() {
            @Override
            public void onChanged(List<SchoolDetailResponse> schoolDetails) {
                if(schoolDetails.size() > 0) {
                    updateViews(schoolDetails.get(0));
                }
            }
        });
    }

    /**
     * Update the views
     * @param schoolDetails
     */
    private void updateViews(SchoolDetailResponse schoolDetails) {
        //TODO We cam move below hard coded test to strings.xml
        getActivity().setTitle(schoolDetails.getSchoolName());
        mBinding.satTotal.setText("Total SAT Takers: " + schoolDetails.getNumOfSatTestTakers());
        mBinding.readingAvg.setText("Critical reading Avg Score: " + schoolDetails.getSatCriticalReadingAvgScore());
        mBinding.mathAvg.setText("Math Avg Score: " + schoolDetails.getSatMathAvgScore());
        mBinding.writingAvg.setText("WritingAvg Score: " + schoolDetails.getSatWritingAvgScore());
    }
}
