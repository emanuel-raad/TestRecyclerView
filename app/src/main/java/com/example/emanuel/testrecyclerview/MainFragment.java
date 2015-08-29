package com.example.emanuel.testrecyclerview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.lucasr.twowayview.ItemClickSupport;
import org.lucasr.twowayview.ItemSelectionSupport;
import org.lucasr.twowayview.widget.TwoWayView;

import java.util.UUID;

/**
 * Created by Emanuel on 28/08/2015.
 */
public class MainFragment
        extends Fragment
        implements View.OnClickListener,
        ItemClickSupport.OnItemClickListener, ItemClickSupport.OnItemLongClickListener {

    private TwoWayView mRecyclerView;
    private ItemSelectionSupport mItemSelectionSupport;
    private ItemClickSupport mItemClickSupport;
    private ActionMode mActionMode;
    private FloatingActionButton mFloatingActionButton;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recyclerview, container, false);

        mRecyclerView = (TwoWayView) view.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        DemoAdapter adapter = new DemoAdapter(ModelLab.get(getActivity()).getModels(), getActivity());
        mRecyclerView.setAdapter(adapter);

        mItemSelectionSupport = ItemSelectionSupport.addTo(mRecyclerView);

        mItemClickSupport = ItemClickSupport.addTo(mRecyclerView);
        mItemClickSupport.setOnItemClickListener(this);
        mItemClickSupport.setOnItemLongClickListener(this);

        mFloatingActionButton = (FloatingActionButton) view.findViewById(R.id.floating_action_button);
        mFloatingActionButton.setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.floating_action_button:
                int size = mRecyclerView.getAdapter().getItemCount();
                Model model = new Model(size + " bottles of beer", size);
                ModelLab.get(getActivity()).addModel(model);
                int position = ModelLab.get(getActivity()).getModels().indexOf(model);
                mRecyclerView.getAdapter().notifyItemInserted(position);
                mRecyclerView.smoothScrollToPosition(position);
                break;
            default:
                break;
        }
    }

    private ActionMode.Callback mCallback = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            getFragmentActivity().getMenuInflater().inflate(R.menu.menu_action, menu);
            mFloatingActionButton.setVisibility(View.GONE);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            switch (item.getItemId()) {
                case R.id.menu_delete:
                    SparseBooleanArray selectedItemPositions =
                            mItemSelectionSupport.getCheckedItemPositions();
                    int currPos;
                    String message = "";

                    for (int i = selectedItemPositions.size() - 1; i >= 0; i--) {
                        currPos = selectedItemPositions.keyAt(i);
                        Model model = ModelLab.get(getActivity()).getModelAtIndex(currPos);
                        ModelLab.get(getActivity()).removeModel(model.getUUID());
                        mRecyclerView.getAdapter().notifyItemRemoved(currPos);
                        message += currPos + " ";
                    }

                    Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
                    mode.finish();
                    return true;
                default:
                    return false;
            }
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            mActionMode = null;
            mItemSelectionSupport.clearChoices();
            mItemSelectionSupport.setChoiceMode(ItemSelectionSupport.ChoiceMode.NONE);
            mFloatingActionButton.setVisibility(View.VISIBLE);
        }
    };

    @Override
    public void onItemClick(RecyclerView recyclerView, View view, int position, long l) {
        if (mActionMode != null) {
            updateSubtitleSelected();
        } else {
            Toast.makeText(getActivity(), "Not in action mode. You pressed: " + position, Toast.LENGTH_SHORT)
                    .show();
            UUID uuid = ModelLab.get(getActivity()).getModelAtIndex(position).getUUID();
            Intent intent = new Intent(getActivity(), ModelActivity.class);
            intent.putExtra(FragmentModel.EXTRA_UUID, uuid);
            startActivity(intent);
        }
    }

    @Override
    public boolean onItemLongClick(RecyclerView recyclerView, View view, int position, long l) {
        if (mActionMode != null) {
            return false;
        }

        mActionMode = getFragmentActivity().startSupportActionMode(mCallback);
        mItemSelectionSupport.setChoiceMode(ItemSelectionSupport.ChoiceMode.MULTIPLE);
        mItemSelectionSupport.setItemChecked(position, true);
        updateSubtitleSelected();
        return true;
    }

    private void updateSubtitleSelected() {
        String title = getString(R.string.selected_count, mItemSelectionSupport.getCheckedItemCount());
        mActionMode.setTitle(title);
    }

    private AppCompatActivity getFragmentActivity() {
        return (AppCompatActivity) getActivity();
    }

}