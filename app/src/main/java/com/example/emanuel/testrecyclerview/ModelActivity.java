package com.example.emanuel.testrecyclerview;

import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.UUID;

/**
 * Created by Emanuel on 29/08/2015.
 */
public class ModelActivity extends SingleFragmentActivity{

    @Override
    protected Fragment createFragment() {
        UUID uuid = (UUID) getIntent()
                .getSerializableExtra(FragmentModel.EXTRA_UUID);

        return FragmentModel.newInstance(uuid);
    }
}
