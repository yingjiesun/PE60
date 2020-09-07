package com.spxflow.pe60.Fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.Toast;

import com.spxflow.pe60.R;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class SecondFragment extends Fragment implements View.OnClickListener {

    SeekBar sb;
    ImageButton off, on, advance, reset;
    AlertDialog alert_off, alert_on, alert_advance, alert_reset;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sb = (SeekBar)  view.findViewById(R.id.myseek);
        off = (ImageButton)  view.findViewById(R.id.off);
        on = (ImageButton)  view.findViewById(R.id.on);
        advance = (ImageButton)  view.findViewById(R.id.advance);
        reset = (ImageButton)  view.findViewById(R.id.reset);

        disableButtons();

        view.findViewById(R.id.off).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (off.isEnabled()) showOffDialog();
            }
        });

        view.findViewById(R.id.on).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (on.isEnabled()) showOnDialog();
            }
        });

        view.findViewById(R.id.advance).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (advance.isEnabled()) showAdvanceDialog();
            }
        });

        view.findViewById(R.id.reset).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (reset.isEnabled()) showResetDialog();
               // NavHostFragment.findNavController(SecondFragment.this)
                 //       .navigate(R.id.action_SecondFragment_to_ThirdFragment);
            }
        });

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                if (seekBar.getProgress() > 95) {
                    seekBar.setThumb(getResources().getDrawable(R.drawable.ok));
                    enableButtons();
                } else {
                    seekBar.setThumb(getResources().getDrawable(R.drawable.arrow_right));
                    disableButtons();
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {


            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                if(progress>95){
                    seekBar.setThumb(getResources().getDrawable(R.drawable.ok));
                } else {
                    seekBar.setThumb(getResources().getDrawable(R.drawable.arrow_right));
                }

            }
        });

    }

    public void enableButtons(){
        on.setImageResource(R.drawable.power);
        off.setImageResource(R.drawable.stop);
        advance.setImageResource(R.drawable.advance);
        reset.setImageResource(R.drawable.refresh);
        on.setEnabled(true);
        off.setEnabled(true);
        advance.setEnabled(true);
        reset.setEnabled(true);
    }

    public void disableButtons(){
        on.setImageResource(R.drawable.power_gray);
        off.setImageResource(R.drawable.stop_gray);
        advance.setImageResource(R.drawable.advance_gray);
        reset.setImageResource(R.drawable.refresh_gray);
        on.setEnabled(false);
        off.setEnabled(false);
        advance.setEnabled(false);
        reset.setEnabled(false);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.reset:
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_ThirdFragment);
                break;
            default:
                break;
        }
    }

    public void showOffDialog(){
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(getActivity(), android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(getActivity());
        }
        builder.setTitle("Turn off device?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getActivity(), "Turn off device",
                                Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    public void showOnDialog(){
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(getActivity(), android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(getActivity());
        }
        builder.setTitle("Turn on device?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getActivity(), "Turn on device",
                                Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    public void showAdvanceDialog(){
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(getActivity(), android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(getActivity());
        }
        builder.setTitle("Solenoid Momentary Advance?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getActivity(), "Solenoid Momentary Advance",
                                Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    public void showResetDialog(){
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(getActivity(), android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(getActivity());
        }
        builder.setTitle("Reset Device?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getActivity(), "Reset Device",
                                Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }


}