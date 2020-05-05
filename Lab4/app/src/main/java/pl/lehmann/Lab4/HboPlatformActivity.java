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

public class HboPlatformActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hbo_platform);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        ArrayAdapter<Hbo> listAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                Hbo.series);
        ListView listHbo = (ListView) findViewById(R.id.list_hbo);
        listHbo.setAdapter(listAdapter);

        AdapterView.OnItemClickListener itemClickListener =
                new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> listHbo, View itemView, int position, long id) {
                        Intent intent = new Intent(HboPlatformActivity.this, HboActivity.class);
                        intent.putExtra(HboActivity.EXTRA_HBOID, (int) id);
                        startActivity(intent);
                    }
                };

        listHbo.setOnItemClickListener(itemClickListener);
    }
}
