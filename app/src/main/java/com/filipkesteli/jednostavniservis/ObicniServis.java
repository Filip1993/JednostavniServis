package com.filipkesteli.jednostavniservis;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by Filip on 19.5.2016..
 */
public class ObicniServis extends Service {

    //standardni boolean varijablica koja osigurava da me ne moze netko vise puta zvati bezveze (servis):
    private boolean serviceOn;

    //ONbind -> metoda kao komunikacijski kanal sa servisom
    /*Return the communication channel to the service. May return null if clients can not bind to the service. The returned IBinder is usually for a complex interface that has been described using aidl.*/
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    /*Called by the system every time a client explicitly starts the service by calling Context.startService, providing the arguments it supplied and a unique integer token representing the start request. Do not call this method directly.
    For backwards compatibility, the default implementation calls onStart and returns either START_STICKY or START_STICKY_COMPATIBILITY.
    If you need your application to run on platform versions prior to API level 5, you can use the following model to handle the older onStart callback in that case. The handleCommand method is implemented by you as appropriate:
    Note that the system calls this on your service's main thread. A service's main thread is the same thread where UI operations take place for Activities running in the same process. You should always avoid stalling the main thread's event loop. When doing long-running operations, network calls, or heavy disk I/O, you should kick off a new thread, or use android.os.AsyncTask.*/
//Kada se rade long-running operacije, Network calls, Heavy disk I/O, odnosno skidanje i uploadanje slika, za to se sve mora rabiti posebna dretva
    //Znaci startam ObicniServis iz MainActivityja:
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //provjeravamo da li je service startan:
        if (!serviceOn) {
            //service ima Context kao handler...
            Toast.makeText(ObicniServis.this, "Obicni Service Started", Toast.LENGTH_SHORT).show();
            //stavljamo zastavicu na true, kao da je startana:
            serviceOn = true;
        } else {
            Toast.makeText(ObicniServis.this, "Obicni Service already Started", Toast.LENGTH_SHORT).show();
        }
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        Toast.makeText(ObicniServis.this, "Obicni Service Stopped", Toast.LENGTH_SHORT).show();
        super.onDestroy(); //ne moramo tako nuzno postaviti
        //onDestroy ce sve pocistiti, a onda ce se i on pocistiti
    }
}
