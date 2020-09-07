package com.spxflow.pe60.Fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import com.spxflow.pe60.R;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


public class FirstFragment extends Fragment {

    ProgressBar loading;
    TextView pairing;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        loading = (ProgressBar) view.findViewById(R.id.loading);
        pairing = (TextView) view.findViewById(R.id.pairing);

        view.findViewById(R.id.bluetooth).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              /*  NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
               */

              //for demo

                loading.setVisibility(View.INVISIBLE);
                pairing.setText("Paired");
                showErrorDialog();

            }
        });


    }

    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.bluetooth:
                Toast.makeText(getActivity(), "Blue clicked", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void showErrorDialog(){
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(getActivity(), android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(getActivity());
        }
        builder.setTitle("If fault condition is received, display this alert.")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Toast.makeText(getActivity(), "",
                        //       Toast.LENGTH_SHORT).show();
                    }
                })
                /*     .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                         public void onClick(DialogInterface dialog, int which) {

                         }
                     })

                 */
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

}