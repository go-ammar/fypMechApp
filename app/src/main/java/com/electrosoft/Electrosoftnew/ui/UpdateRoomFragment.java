package com.electrosoft.Electrosoftnew.ui;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.electrosoft.Electrosoftnew.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class UpdateRoomFragment extends Fragment {


    public UpdateRoomFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate( R.layout.fragment_update_room, container, false );
    }

}
