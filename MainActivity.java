package de.polkagris.slapdrumpf;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Handler;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "LOGTAG";
    MediaPlayer slapSoundMP;
    ImageView drumpfImage;
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drumpfImage = (ImageView) findViewById(R.id.drumpf_image);

        slapSoundMP = MediaPlayer.create(this, R.raw.slap_short3);

        index = 0;
    }

    public void slapHim(View view) {
        slapSoundMP.start();
        if(index %2 == 0) {
            drumpfImage.setImageResource(R.drawable.slapped1);
        } else {
            drumpfImage.setImageResource(R.drawable.slapped2);
        }
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                setBackDrumpfImage();
            }
        }, 1300);
        index++;
    }

    public void setBackDrumpfImage() {
        drumpfImage.setImageResource(R.drawable.unslapped1);
    }
}
