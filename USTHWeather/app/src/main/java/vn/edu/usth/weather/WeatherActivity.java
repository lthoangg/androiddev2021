package vn.edu.usth.weather;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.Toast;

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
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }
    private void downloadImage(){
        AsyncTask<String, Integer, Bitmap> task = new AsyncTask<String, Integer, Bitmap>() {
            @Override
            protected Bitmap doInBackground(String... strings) {
                try{
                    Thread.sleep(5000);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Bitmap bitmap) {
                Toast.makeText(getBaseContext(), "I did it again!!!!", Toast.LENGTH_SHORT).show();
            }
        };
        task.execute("https://www.gannett-cdn.com/-mm-/ae811a38ccb7ca7681c5cd9edc7e0bae36516e06/c=261-0-2174-2550/local/-/media/2015/10/08/Phoenix/Phoenix/635799268539755113-ae-lennon09e.jpg");
    }

    private void sendMessage(String msg) {
        final Handler handler = new Handler(Looper.getMainLooper()){
            @Override
            public void handleMessage(@NonNull Message msg) {
                String content = msg.getData().getString("server_response");
                Toast.makeText(WeatherActivity.this, content, Toast.LENGTH_SHORT).show();
            }
        };
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Bundle bundle = new Bundle();
                bundle.putString("server_response", msg);

                Message msg = new Message();
                msg.setData(bundle);
                handler.sendMessage(msg);
            }
        });
        t.start();
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
        Log.i("inserted", "Added song to path: " + musicFile.getAbsolutePath());
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.refresh:
//                sendMessage("I did it");
                downloadImage();

                return true;
            case R.id.settings:
                startActivity(new Intent(WeatherActivity.this, PrefActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}