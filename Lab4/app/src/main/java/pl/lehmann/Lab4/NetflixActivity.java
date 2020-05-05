package pl.lehmann.Lab4;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

public class NetflixActivity extends AppCompatActivity {

    public static final String EXTRA_NETFLIXID = "netflixId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_netflix);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        int netflixId = (Integer) getIntent().getExtras().get(EXTRA_NETFLIXID);
        Netflix netflix = Netflix.series[netflixId];

        TextView name = (TextView) findViewById(R.id.name);
        name.setText(netflix.getName());

        TextView seasons = (TextView) findViewById(R.id.seasons);
        seasons.setText(netflix.getSeasons());

        TextView description = (TextView) findViewById(R.id.description);
        description.setText(netflix.getDescription());

        ImageView photo = (ImageView) findViewById(R.id.photo);
        photo.setImageResource(netflix.getImageResourceId());
        photo.setContentDescription(netflix.getName());
    }
}
