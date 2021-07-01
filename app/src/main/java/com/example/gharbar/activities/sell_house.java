package com.example.gharbar.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.example.gharbar.AddImages;
import com.example.gharbar.R;
import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.widget.Autocomplete;
import com.google.android.libraries.places.widget.AutocompleteActivity;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.jar.Attributes;

public class sell_house extends AppCompatActivity  {

    EditText et_city, et_Location;
    AutoCompleteTextView garden, porch, storey;
    final int AUTOCOMPLETE_REQUEST_CODE = 111;
    ArrayList<String> options = new ArrayList<>();
    String Selection;
    Button btn_addImages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_sell_house);
        et_city=findViewById(R.id.et_city_name);
        btn_addImages=findViewById(R.id.btn_addImages);
        et_Location = findViewById(R.id.et_loc);
        garden=findViewById(R.id.et_garden);
        porch=findViewById(R.id.et_porch);
        storey=findViewById(R.id.et_storey);

//code for selection od places
        String api_key = getString(R.string.google_api_key);
        if(!Places.isInitialized()){
            Places.initialize(getApplicationContext(), api_key);
        }
//        PlacesClient placesClient = Places.createClient(this);

        et_city.setFocusable(false);
        et_city.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    List<Place.Field> fields = Arrays.asList(Place.Field.ID, Place.Field.NAME, Place.Field.ADDRESS, Place.Field.LAT_LNG);
                    Intent intent = new Autocomplete.IntentBuilder(AutocompleteActivityMode.OVERLAY, fields).setCountry("Pak").build(sell_house.this);
                    startActivityForResult(intent, AUTOCOMPLETE_REQUEST_CODE);


            }
        });
        et_Location.setFocusable(true);
        et_Location.setFocusableInTouchMode(true);
        garden.setFocusableInTouchMode(false);
        //list for gardens
        options.add("No");
        options.add("One");
        options.add("Two");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, options);
        garden.setAdapter(adapter);

        garden.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                garden.showDropDown();
                Selection=  (String)adapterView.getItemAtPosition(i);
                garden.setText(options.get(i));
                garden.dismissDropDown();
            }
        });
        garden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                garden.showDropDown();
            }
        });
        btn_addImages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(sell_house.this, AddImages.class));
            }
        });

    }

//code for search city
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == AUTOCOMPLETE_REQUEST_CODE && resultCode == RESULT_OK)
        {
            //initialize places
            Place place = Autocomplete.getPlaceFromIntent(data);
            //place it on edit text
            et_city.setText(place.getAddress());
        }
        else if (resultCode == AutocompleteActivity.RESULT_ERROR){
            //initialize status
            Status status = Autocomplete.getStatusFromIntent(data);
            Toast.makeText(sell_house.this, status.getStatusMessage(), Toast.LENGTH_SHORT).show();
        }
    }



}