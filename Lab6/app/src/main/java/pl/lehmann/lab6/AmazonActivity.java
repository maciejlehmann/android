package pl.lehmann.lab6;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

public class AmazonActivity extends AppCompatActivity {

    public static final String EXTRA_AMAZONID = "amazonId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_netflix);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        int amazonId = (Integer) getIntent().getExtras().get(EXTRA_AMAZONID);
        Amazon amazon = Amazon.series[amazonId];

        TextView name = (TextView) findViewById(R.id.name);
        name.setText(amazon.getName());

        TextView seasons = (TextView) findViewById(R.id.seasons);
        seasons.setText(amazon.getSeasons());

        TextView description = (TextView) findViewById(R.id.description);
        description.setText(amazon.getDescription());

        ImageView photo = (ImageView) findViewById(R.id.photo);
        photo.setImageResource(amazon.getImageResourceId());
        photo.setContentDescription(amazon.getName());
    }
}
