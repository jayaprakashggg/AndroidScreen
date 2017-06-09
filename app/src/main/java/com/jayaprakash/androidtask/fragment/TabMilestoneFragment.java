package com.jayaprakash.androidtask.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jayaprakash.androidtask.R;
import com.jayaprakash.androidtask.adapter.FragmentViewAdapter;
import com.jayaprakash.androidtask.data.FragmentData;

import java.util.ArrayList;

public class TabMilestoneFragment extends Fragment implements FragmentViewAdapter.ItemClickListener{

    RecyclerView recyclerView;
    FragmentViewAdapter customListAdapter;
    ArrayList<FragmentData> servicesDatas = new ArrayList<>();
    Integer id[] = {R.mipmap.sliding_three,R.mipmap.sliding_two,R.mipmap.sliding_one,R.mipmap.sliding_four};
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_tab_video, container, false);

        for (int i=0;i<4;i++){
            FragmentData data = new FragmentData();
            data.setTitle("Milestone Details data "+i);
            data.setTime(""+(i+3)+" days ago");
            data.setContent("Android is a mobile operating system developed by Google. It is used by several smartphones and tablets.");
            data.setId(id[i]);
            servicesDatas.add(data);
        }

        recyclerView = (RecyclerView) view.findViewById(R.id.rvNumbers);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        customListAdapter = new FragmentViewAdapter(getActivity(), servicesDatas);
        customListAdapter.setClickListener(TabMilestoneFragment.this);
        recyclerView.setAdapter(customListAdapter);
        return view;
    }

    @Override
    public void onItemClick(View view, int position, String s) {

    }
}
