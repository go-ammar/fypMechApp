package com.electrosoft.electrosoftnew.ui;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.electrosoft.electrosoftnew.R;
import com.electrosoft.electrosoftnew.databinding.FragmentContactBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Objects;

import static androidx.core.content.PermissionChecker.checkSelfPermission;


public class ContactFragment extends Fragment {

    private GoogleMap mMap;
    NavController navController;
    FragmentContactBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_contact, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        actionViews();
    }

    private void actionViews() {
        binding.fab1.setOnClickListener(view -> {

            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:03402211539"));
            startActivity(intent);

        });

        binding.link.setMovementMethod(LinkMovementMethod.getInstance());

        binding.fab.setOnClickListener(v -> {


            Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);

            String[] aEmailList = {"electrosoft.tech@gmail.com"};

            emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, aEmailList);

            emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Query/Information");

            emailIntent.setType("plain/text");
            emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "");

            startActivity(emailIntent);

        });


    }


}