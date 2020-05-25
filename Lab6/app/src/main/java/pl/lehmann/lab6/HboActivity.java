package pl.lehmann.lab6;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

public class HboActivity extends AppCompatActivity {

    public static final String EXTRA_HBOID = "hboId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_netflix);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        int hboId = (Integer) getIntent().getExtras().get(EXTRA_HBOID);
        Hbo hbo = Hbo.series[hboId];

        TextView name = (TextView) findViewById(R.id.name);
        name.setText(hbo.getName());

        TextView seasons = (TextView) findViewById(R.id.seasons);
        seasons.setText(hbo.getSeasons());

        TextView description = (TextView) findViewById(R.id.description);
        description.setText(hbo.getDescription());

        ImageView photo = (ImageView) findViewById(R.id.photo);
        photo.setImageResource(hbo.getImageResourceId());
        photo.setContentDescription(hbo.getName());
    }
}
