package com.spxflow.pe60;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;

import com.spxflow.pe60.Fragments.FirstFragment;
import com.spxflow.pe60.Fragments.FourthFragment;
import com.spxflow.pe60.Fragments.SecondFragment;
import com.spxflow.pe60.Fragments.ThirdFragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_fragment, new FirstFragment());
        fragmentTransaction.commit();

        //TODO: start bluetooth connection
        if (false) { //if error received from bluetooth
            showErrorDialog();
            //update notification page
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //int id = item.getItemId();

        switch (item.getItemId()){
            case R.id.action_connection:
                FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                fragmentTransaction1.replace(R.id.nav_host_fragment, new FirstFragment());
                fragmentTransaction1.commit();
                break;
            case R.id.action_operation:
                FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                fragmentTransaction2.replace(R.id.nav_host_fragment, new SecondFragment());
                fragmentTransaction2.commit();
                break;
            case R.id.action_notification:
                FragmentTransaction fragmentTransaction3 = getSupportFragmentManager().beginTransaction();
                fragmentTransaction3.replace(R.id.nav_host_fragment, new ThirdFragment());
                fragmentTransaction3.commit();
                break;
            case R.id.action_support:
                FragmentTransaction fragmentTransaction4 = getSupportFragmentManager().beginTransaction();
                fragmentTransaction4.replace(R.id.nav_host_fragment, new FourthFragment());
                fragmentTransaction4.commit();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void showErrorDialog(){
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(this);
        }
        builder.setTitle("If an error is received, display the error message as alert. Error will be displayed on notification page too.")
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