package it.moov.moovandroid;

import android.app.Application;

import com.facebook.stetho.Stetho;

import it.moov.moovandroid.network.myRetrofitClient;


public class MyApplicationContext extends Application {

    private String _username;
    private String _photoURL;

    @Override
    public void onCreate() {
        super.onCreate();
        _username = "anonym";
        Stetho.initializeWithDefaults(this);
        myRetrofitClient.init();
    }

    public String getUsername() {
        return _username;
    }

    public void setUsername(String _username) {
        this._username = _username;
    }

    public String getPhotoURL() {
        return _photoURL;
    }

    public void setPhotoURL(String _photoURL) {
        this._photoURL = _photoURL;
    }
}
