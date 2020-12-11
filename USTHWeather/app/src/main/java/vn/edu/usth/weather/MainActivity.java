package vn.edu.usth.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private static final String info_app="USTH Weather App";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(info_app, "onCreate!");
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        Log.i(info_app, "on Start!");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.i(info_app, "on Resume!");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.i(info_app, "on Pause!");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i(info_app, "on Stop!");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.i(info_app, "on Destroy!");
        super.onDestroy();
    }
}