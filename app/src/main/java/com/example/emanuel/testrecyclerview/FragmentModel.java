package com.example.emanuel.testrecyclerview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.UUID;

/**
 * Created by Emanuel on 29/08/2015.
 */
public class FragmentModel extends Fragment {

    public static final String EXTRA_UUID =
            "com.example.emanuel.testrecyclerview.uuid";

    private TextView mTextViewUUID;
    private TextView mTextViewName;
    private TextView mTextViewNumber;
    private Model mModel;

    public static FragmentModel newInstance(UUID uuid){
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_UUID, uuid);

        FragmentModel fragment = new FragmentModel();
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_model, container, false);

        UUID uuid = (UUID) getArguments().getSerializable(EXTRA_UUID);
        mModel = ModelLab.get(getActivity()).getModelWithUUID(uuid);
        String name = mModel.getName();
        int number = mModel.getNumber();

        mTextViewUUID = (TextView) view.findViewById(R.id.uuid);
        mTextViewName = (TextView) view.findViewById(R.id.name);
        mTextViewNumber = (TextView) view.findViewById(R.id.number);

        mTextViewUUID.setText(uuid.toString());
        mTextViewName.setText(name);
        mTextViewNumber.setText(Integer.toString(number));

        return view;
    }

}
