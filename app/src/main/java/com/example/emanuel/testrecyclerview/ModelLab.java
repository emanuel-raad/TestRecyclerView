package com.example.emanuel.testrecyclerview;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by Emanuel on 28/08/2015.
 */
public class ModelLab {

    private ArrayList<Model> mModels;
    private static ModelLab sModelLab;

    public ModelLab(Context c) {
        mModels = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            Model model = new Model(i + " bottles of beer", i);
            mModels.add(model);
        }
    }

    public static ModelLab get(Context c) {
        if (sModelLab == null)
            sModelLab = new ModelLab(c.getApplicationContext());
        return sModelLab;
    }

    public ArrayList<Model> getModels() {
        return mModels;
    }
}
