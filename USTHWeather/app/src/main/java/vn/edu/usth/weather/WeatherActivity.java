package vn.edu.usth.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class WeatherActivity extends AppCompatActivity {
    private static final String info_app="USTH Weather App";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(info_app, "onCreate!");
        setContentView(R.layout.weather_activity);
        ForecastFragment firstFragment = new ForecastFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.weatherActivity, firstFragment, null).commit();
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