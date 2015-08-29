package com.example.emanuel.testrecyclerview;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Emanuel on 28/08/2015.
 */
public class ModelLab {

    private ArrayList<Model> mModels;
    private Context mContext;
    private static ModelLab sModelLab;

    public ModelLab(Context context) {
        mModels = new ArrayList<>();
        mContext = context;
        /*for (int i = 0; i <= 10; i++) {
            Model model = new Model(i + " bottles of beer", i);
            mModels.add(model);
        }*/
    }

    public static ModelLab get(Context c) {
        if (sModelLab == null)
            sModelLab = new ModelLab(c.getApplicationContext());
        return sModelLab;
    }

    public ArrayList<Model> getModels() {
        return mModels;
    }

    public void addModel() {
        int i = getModels().size();
        Model model = new Model(i + " bottles of beer", i);
        mModels.add(model);
    }

    public void addModel(Model model) {
        mModels.add(model);
    }

    public void removeModel(Model m) {
        mModels.remove(m);
    }

    public void removeModel(int index) {
        mModels.remove(index);
    }

    public void removeModel(UUID uuid) {
        mModels.remove(getModelWithUUID(uuid));
    }

    public void setModels(ArrayList<Model> models) {
        mModels = models;
    }

    public Model getModelAtIndex(int index) {
        return mModels.get(index);
    }

    public Model getModelWithUUID(UUID uuid) {
        for (Model model : mModels) {
            if (model.getUUID().equals(uuid)) {
                return model;
            }
        }

        return null;
    }
}
