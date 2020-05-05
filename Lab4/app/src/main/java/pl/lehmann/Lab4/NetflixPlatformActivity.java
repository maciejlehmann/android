package pl.lehmann.Lab4;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class NetflixPlatformActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_netflix_platform);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        ArrayAdapter<Netflix> listAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                Netflix.series);
        ListView listNetflix = (ListView) findViewById(R.id.list_netflix);
        listNetflix.setAdapter(listAdapter);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> listNetflix, View itemView, int position, long id) {
                Intent intent = new Intent(NetflixPlatformActivity.this, NetflixActivity.class);
                intent.putExtra(NetflixActivity.EXTRA_NETFLIXID, (int) id);
                startActivity(intent);
            }
        };
        listNetflix.setOnItemClickListener(itemClickListener);
    }
}
