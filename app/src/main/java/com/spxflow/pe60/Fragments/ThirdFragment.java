package com.spxflow.pe60.Fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.spxflow.pe60.R;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class ThirdFragment extends Fragment {

    private TableLayout mTableLayout;
    String allStatus = "Motor Run Time,Power Disruption,A port Solenoid,B port Solenoid,Power up cyles,BrushInspect,Brush Replace,Faults,Power On,HighPresuure,Oil Replace";
    private String[] status = allStatus.split(",");

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mTableLayout = (TableLayout) view.findViewById(R.id.table);
        mTableLayout.setStretchAllColumns(true);
        startLoadData();

/*
        view.findViewById(R.id.button_third).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ThirdFragment.this)
                        .navigate(R.id.action_ThirdFragment_to_FourthFragment);
            }
        });

 */
    }



    //TODO: update this function to use data received from bluetooth
    public void startLoadData(){
        for (int i=0; i < status.length; i++) {
            TableRow row = new TableRow(getActivity());
            TextView tv = new TextView(getActivity());
            tv.setText(status[i]);
            tv.setTextSize(16);
            tv.setPadding(5, 15, 0, 15);
            if (i%2 == 0 ) tv.setBackgroundColor(Color.parseColor("#f0f0f0"));
            else tv.setBackgroundColor(Color.parseColor("#ffffff"));
            row.addView(tv);
            TextView tv2 = new TextView(getActivity());
            tv2.setText("100");
            tv2.setTextSize(16);
            tv2.setPadding(5, 15, 0, 15);
            if (i%2 == 0 ) tv2.setBackgroundColor(Color.parseColor("#f0f0f0"));
            else tv2.setBackgroundColor(Color.parseColor("#ffffff"));
            row.addView(tv2);
            mTableLayout.addView(row);
        }
    }
}