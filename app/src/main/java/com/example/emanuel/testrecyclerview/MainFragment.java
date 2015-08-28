package com.example.emanuel.testrecyclerview;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.lucasr.twowayview.widget.TwoWayView;

/**
 * Created by Emanuel on 28/08/2015.
 */
public class MainFragment extends Fragment {

    private TwoWayView mRecyclerView;

    public static MainFragment newInstance() {
        return new MainFragment();
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ModelLab.get(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recyclerview, container, false);

        mRecyclerView = (TwoWayView) view.findViewById(R.id.recyclerView);
        //mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //mRecyclerView.setHasFixedSize(true);

        DemoAdapter adapter = new DemoAdapter(ModelLab.get(getActivity()).getModels(), getActivity());
        mRecyclerView.setAdapter(adapter);

        return view;
    }


}
