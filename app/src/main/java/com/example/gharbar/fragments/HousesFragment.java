package com.example.gharbar.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarChangeListener;
import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarFinalValueListener;
import com.crystal.crystalrangeseekbar.widgets.CrystalRangeSeekbar;
import com.example.gharbar.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HousesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HousesFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HousesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HousesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HousesFragment newInstance(String param1, String param2) {
        HousesFragment fragment = new HousesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_houses, container, false);

        final CrystalRangeSeekbar rangeSeekbar = (CrystalRangeSeekbar) rootView.findViewById(R.id.price);
        final TextView tvMin = (TextView) rootView.findViewById(R.id.min);
        final TextView tvMax = (TextView) rootView.findViewById(R.id.max);
        // set listener
        rangeSeekbar.setOnRangeSeekbarChangeListener(new OnRangeSeekbarChangeListener() {

        @Override
        public void valueChanged(Number minValue, Number maxValue) {

            tvMin.setText(String.valueOf(minValue));

            tvMax.setText(String.valueOf(maxValue));


        }

    }
);
    // set final value listener
        rangeSeekbar.setOnRangeSeekbarFinalValueListener(new OnRangeSeekbarFinalValueListener() {

    @Override
    public void finalValue(Number minValue, Number maxValue) {

        Log.d("CRS=>", String.valueOf(minValue) + " : " + String.valueOf(maxValue));


    }

}
);


        return rootView;

    }
}