package com.example.dumnezeu.gridlayout;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mplayer;
    AudioManager audioManager;

    public void buttonTapped(View view) {

        int id = view.getId();
        String ourId = "";

        ourId = view.getResources().getResourceEntryName(id);
        int resoursceID = getResources().getIdentifier(ourId, "raw", "com.example.dumnezeu.gridlayout");
        MediaPlayer mPlayer = MediaPlayer.create(this, resoursceID);
        mPlayer.start();
        Log.i("Button tapped", ourId);

        // switch (view.getId())

//        {
//            case R.id.button1:
//                mplayer = MediaPlayer.create(this,R.raw.doyouspeakenglish);
//                mplayer.start();
//                break;
//            case R.id.button2:
//                mplayer = MediaPlayer.create(this,R.raw.ilivein);
//                mplayer.start();
//                break;
//            case R.id.button3:
//                mplayer = MediaPlayer.create(this,R.raw.goodevening);
//                mplayer.start();
//                break;
//            case R.id.button4:
//                mplayer = MediaPlayer.create(this,R.raw.mynameis);
//                mplayer.start();
//                break;
//            case R.id.button5:
//                mplayer = MediaPlayer.create(this,R.raw.hello);
//                mplayer.start();
//                break;
//            case R.id.button6:
//                mplayer = MediaPlayer.create(this,R.raw.please);
//                mplayer.start();
//                break;
//            case R.id.button7:
//                mplayer = MediaPlayer.create(this,R.raw.howareyou);
//                mplayer.start();
//                break;
//            case R.id.button8:
//                mplayer = MediaPlayer.create(this,R.raw.welcome);
//                mplayer.start();
//                break;
//
//        }

//        mplayer = MediaPlayer.create(this,R.raw.doyouspeakenglish);
//        mplayer.start();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
