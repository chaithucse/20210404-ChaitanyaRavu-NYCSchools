package com.example.nycschools.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.nycschools.data.model.SchoolListResponse;
import com.example.nycschools.databinding.FragmentSchoolListBinding;
import com.example.nycschools.viewmodel.SchoolsViewModel;

import java.util.List;

public class SchoolListFragment extends Fragment {
    private FragmentSchoolListBinding mBinding;
    private DataAdapter adapter;
    private RecyclerView listView;
    private SwipeRefreshLayout mRefreshView;
    private ProgressBar mProgressBar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = FragmentSchoolListBinding.inflate(inflater, container, false);

        adapter = new DataAdapter(getActivity());
        listView = mBinding.list;
        listView.setLayoutManager(new LinearLayoutManager(getActivity()));
        listView.setAdapter(adapter);

        mProgressBar = mBinding.progress;
        mProgressBar.setVisibility(View.VISIBLE);
        mRefreshView = mBinding.swipeContainer;
        mRefreshView.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                fetchData();
                mRefreshView.setRefreshing(false);
                mProgressBar.setVisibility(View.GONE);
            }
        });
        fetchData();

        return mBinding.getRoot();
    }

    private void fetchData() {
        SchoolsViewModel viewModel = new ViewModelProvider(this).get(SchoolsViewModel.class);
        viewModel.getSchoolsList().observe(requireActivity(), new Observer<List<SchoolListResponse>>() {
            @Override
            public void onChanged(List<SchoolListResponse> listResponseItems) {
                adapter.setData(listResponseItems);
                mRefreshView.setRefreshing(false);
                mProgressBar.setVisibility(View.GONE);
            }
        });
    }
}
