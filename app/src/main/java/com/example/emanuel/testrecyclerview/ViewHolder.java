package com.example.emanuel.testrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Emanuel on 28/08/2015.
 */
public class ViewHolder extends RecyclerView.ViewHolder
        implements View.OnClickListener, View.OnTouchListener{

    private TextView mTextView;
    private RelativeLayout mRelativeLayout;
    private Context mContext;
    private int number;
    private Model mModel;

    public ViewHolder(View itemView, Context context) {
        super(itemView);
        mContext = context;

        mTextView = (TextView) itemView.findViewById(R.id.textView);
        mRelativeLayout = (RelativeLayout) itemView.findViewById(R.id.relativeLayout);
        //itemView.setOnClickListener(this);
        //itemView.setOnTouchListener(this);
        mRelativeLayout.setOnTouchListener(this);
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(mContext, "You pressed " + number, Toast.LENGTH_SHORT).show();
    }

    public void bindModel(Model model) {
        mTextView.setText(model.getName());
        number = model.getNumber();
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            String message = "You pressed \nx:" + x + "\ny:" + y;
            mTextView.setText(message);
        }
        return true;
    }
}
