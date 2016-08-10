package it.moov.moovandroid.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import it.moov.moovandroid.MyApplicationContext;
import it.moov.moovandroid.R;
import it.moov.moovandroid.models.Reservation;
import it.moov.moovandroid.network.myRetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {

    private MyApplicationContext mContext;
    // Firebase
    private FirebaseAuth mFirebaseAuth;
    private FirebaseUser mFirebaseUser;
    private GoogleApiClient mGoogleApiClient;

    //UI
    private TextView mDebugView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mContext = (MyApplicationContext)getApplicationContext();
        mDebugView = (TextView) findViewById(R.id.debugView);

        setupAuth();
        setupGoogle();
    }

    private void setupGoogle() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this /* FragmentActivity */, this /* OnConnectionFailedListener */)
                .addApi(Auth.GOOGLE_SIGN_IN_API)
                .build();
    }

    private void setupAuth() {
        // Initialize Firebase Auth
        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseUser = mFirebaseAuth.getCurrentUser();
        if (mFirebaseUser == null) {
            // Not signed in, launch the Sign In activity
            startActivity(new Intent(this, SignInActivity.class));
            finish();
            return;
        } else {
            //setup username and photoURL
            mContext.setUsername(mFirebaseUser.getDisplayName());
            if (mFirebaseUser.getPhotoUrl() != null) {
                mContext.setPhotoURL(mFirebaseUser.getPhotoUrl().toString());
            }
        }
    }

    //boiler plates

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.sign_out_menu:
                mFirebaseAuth.signOut();
                Auth.GoogleSignInApi.signOut(mGoogleApiClient);
                mContext.setUsername("anonym");
                startActivity(new Intent(this, SignInActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        // An unresolvable error has occurred and Google APIs (including Sign-In) will not
        // be available.
        Log.d("yyy", "onConnectionFailed:" + connectionResult);
        Toast.makeText(this, "Google Play Services error.", Toast.LENGTH_SHORT).show();
    }

    public void requestCarButtonClicked(View view) {
        Reservation aux = new Reservation(170000L,"2","abreu","LARGE","1");
        Call<Reservation> call = myRetrofitClient.createNewReservation(aux);
        call.enqueue(new Callback<Reservation>() {
            @Override
            public void onResponse(Call<Reservation> call, Response<Reservation> response) {
                Reservation aux = response.body();
                mDebugView.setText(aux.toString());
            }

            @Override
            public void onFailure(Call<Reservation> call, Throwable t) {
                // Log error here since request failed
            }
        });
    }
}
