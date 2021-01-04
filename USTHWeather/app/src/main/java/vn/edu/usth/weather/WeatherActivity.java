package vn.edu.usth.weather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class WeatherActivity extends AppCompatActivity {
    private static final String info_app="USTH Weather App";
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(info_app, "onCreate!");
        setContentView(R.layout.weather_activity);
//        setContentView(R.layout.fragment_weather_and_forecast);
//        ForecastFragment firstFragment = new ForecastFragment();
//        getSupportFragmentManager().beginTransaction().add(R.id.weatherActivity, firstFragment, null).commit();
        PagerAdapter adapter = new HomeFragmentPagerAdapter(getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.pager);
        viewPager.setOffscreenPageLimit(3);
        viewPager.setAdapter(adapter);
        TabLayout tableLayout = findViewById(R.id.tabLayout);
        tableLayout.setupWithViewPager(viewPager);



    }

    @Override
    protected void onStart() {
        Log.i(info_app, "on Start!");
        super.onStart();

        InputStream is = this.getApplicationContext().getResources().openRawResource(R.raw.vedithienduong);
        byte[] buffer = new byte[7000000];
        File sdCard = this.getApplicationContext().getExternalFilesDir(Environment.DIRECTORY_MUSIC);
        File musicFile = new File(sdCard, "pr0.wav");
        try {
            OutputStream outputStream = new FileOutputStream(musicFile);
            int length = is.read(buffer);
            outputStream.write(buffer, 0, length);
        } catch (IOException e) {
            e.printStackTrace();
        }

        mp = MediaPlayer.create(this, R.raw.vedithienduong);
        mp.start();
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