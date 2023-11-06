package com.example.myapplication

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.util.Log
import com.example.myapplication.R.raw

class AlarmService : Service() {
    
    private lateinit var mp: MediaPlayer
    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        val action = intent.getStringExtra("AlarmService")
        mp = MediaPlayer.create(this, raw.alarm)
        if(action == "Play" && !mp.isPlaying){
            Log.i("AlarmService","Play")
            mp.start() }
        else if(action == "Stop" && mp.isPlaying){
            mp.stop() }
        else{
            mp.stop() }
        return START_STICKY }
    override fun onDestroy() {
        mp.stop()
        mp.release()
        super.onDestroy() }
    override fun onBind(intent: Intent?): IBinder? {
        return null }}
