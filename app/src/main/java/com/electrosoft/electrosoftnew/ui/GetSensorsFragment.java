package com.electrosoft.electrosoftnew.ui;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.electrosoft.electrosoftnew.R;
import com.electrosoft.electrosoftnew.databinding.FragmentGetSensorsBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class GetSensorsFragment extends Fragment {


    private static final String TAG = "GetSensorsFragment";
    private String URL;
    NavController navController;
    FragmentGetSensorsBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_get_sensors, container, false );
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        actionViews();
    }

    private void actionViews(){}

    private void getsensor (){
        StringRequest stringRequest = new StringRequest( Request.Method.POST, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("Response", response);
                        Toast.makeText(requireContext(), response, Toast.LENGTH_SHORT).show();

                        if (response.equals("[]"))
                        {

                            Toast.makeText(requireContext(), " access wali", Toast.LENGTH_SHORT).show();
                            //a.setVisibility(View.VISIBLE);
                            //neww();
                            //builder.setTitle("sorry");
                            //displayAlert("there is no data");
                        }
                        else {
                            //a.setVisibility(View.INVISIBLE);
                            try {
                                JSONArray jsonArray = new JSONArray(response);
                                for (int i = 0; i < response.length(); i++) {
                                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                                   // modelsensor s = new modelsensor();
                                    //s.setSensor_id(jsonObject.getInt("ID"));
                                    //s.setSensor_name(jsonObject.getString("name"));
                                    //s.setSensor_maxvalue(jsonObject.getInt("avg"));
                                    //lst_sens.add(s);

                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            //sadapter = new sensoradapter(Sensors.this, lst_sens);
                            //recyclerV.setAdapter(sadapter);
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(requireContext(), error+"not access", Toast.LENGTH_SHORT).show();


            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<String, String>();

               // params.put("roomno",String.valueOf(getid));

                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(requireContext());
        requestQueue.add(stringRequest);

    }

}
