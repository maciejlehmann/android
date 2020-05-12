package pl.lehmann.lab5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class NetflixActivity extends AppCompatActivity {

    public static final String EXTRA_NETFLIX_ID = "id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_netflix);
        NetflixFragment frag = (NetflixFragment)
                getSupportFragmentManager().findFragmentById(R.id.detail_frag);
        int workoutId = (int) getIntent().getExtras().get(EXTRA_NETFLIX_ID);
        frag.setNetflix(workoutId);
    }
}
