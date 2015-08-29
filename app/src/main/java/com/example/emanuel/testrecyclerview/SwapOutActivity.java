package com.example.emanuel.testrecyclerview;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Emanuel on 29/08/2015.
 */
/*public class SwapOutActivity
        extends AppCompatActivity
        implements MainFragment.Callbacks{

    private static final String FRAGMENT_MENU = "menu";
    private static final String FRAGMENT_DETAIL = "detail";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragmentContainer);

        if (fragment == null) {
            fragment = MainFragment.newInstance();
            fm.beginTransaction()
                    .setCustomAnimations(R.anim.slide_up, R.anim.slide_down)
                    .add(R.id.fragmentContainer, fragment, FRAGMENT_MENU)
                    .commit();
        }
    }

    @Override
    public void onCardSelected(Model model) {
        Fragment fragment = FragmentModel.newInstance(model.getUUID());
        Fragment menuFragment = getSupportFragmentManager().findFragmentByTag(FRAGMENT_MENU);

        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.slide_left, R.anim.slide_left)
                .remove(menuFragment)
                .commit();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, fragment, FRAGMENT_DETAIL)
                .commit();
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() != 0) {
            getSupportFragmentManager().popBackStack();
        } else
            this.finish();
    }
}*/
