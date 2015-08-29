package com.example.emanuel.testrecyclerview;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import java.util.List;

/**
 * Created by Emanuel on 28/08/2015.
 */
public class DemoAdapter
        extends RecyclerView.Adapter<ViewHolder> {

    private List<Model> mModels;
    private SparseBooleanArray selectedItems;
    private Context mContext;

    public DemoAdapter(List<Model> models, Context context) {
        mModels = models;
        mContext = context;
        selectedItems = new SparseBooleanArray();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card, parent, false);

        return new ViewHolder(view, mContext);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Model model = mModels.get(position);
        holder.bindModel(model);
    }

    @Override
    public int getItemCount() {
        return mModels.size();
    }
}
