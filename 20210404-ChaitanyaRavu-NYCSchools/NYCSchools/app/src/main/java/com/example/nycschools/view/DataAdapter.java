package com.example.nycschools.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nycschools.R;
import com.example.nycschools.common.AppConstants;
import com.example.nycschools.data.model.SchoolListResponse;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textview.MaterialTextView;

import java.util.List;

/**
 * Data adapter for ListView of Schools
 */
public class DataAdapter extends RecyclerView.Adapter<DataAdapter.CustomViewHolder> {
    private final Context mContext;
    private List<SchoolListResponse> schoolsList;

    public DataAdapter(Context context) {
        this.mContext = context;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(mContext).inflate(R.layout.list_view_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.titleView.setText(schoolsList.get(position).getSchoolName());
        holder.addressView.setText(schoolsList.get(position).getPrimaryAddressLine1());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString(AppConstants.SCHOOL_ID, schoolsList.get(position).getDbn());
                bundle.putString(AppConstants.SCHOOL_NAME, schoolsList.get(position).getSchoolName());
                bundle.putString(AppConstants.SCHOOL_ADDRESS, schoolsList.get(position).getPrimaryAddressLine1());
                bundle.putString(AppConstants.SCHOOL_EMAIL, schoolsList.get(position).getSchoolEmail());
                bundle.putString(AppConstants.SCHOOL_CONTACT, schoolsList.get(position).getPhoneNumber());
                bundle.putString(AppConstants.SCHOOL_WEBSITE, schoolsList.get(position).getWebsite());
                bundle.putString(AppConstants.SCHOOL_CITY, schoolsList.get(position).getCity());
                Navigation.findNavController(holder.itemView).navigate(R.id.action_schoolListFragment_to_schoolDetailFragment, bundle);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (schoolsList != null) {
            return schoolsList.size();
        }
        return 0;
    }

    public void setData(List<SchoolListResponse> list) {
        schoolsList = list;
        notifyDataSetChanged();
    }

    static class CustomViewHolder extends RecyclerView.ViewHolder {
        MaterialTextView titleView;
        MaterialTextView addressView;
        MaterialCardView cardView;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.card_view);
            titleView = itemView.findViewById(R.id.school_title);
            addressView = itemView.findViewById(R.id.school_address);
        }
    }
}