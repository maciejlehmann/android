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

public class AmazonPlatformActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amazon_platform);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        ArrayAdapter<Amazon> listAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                Amazon.series);
        ListView listAmazon = (ListView) findViewById(R.id.list_amazon);
        listAmazon.setAdapter(listAdapter);

        AdapterView.OnItemClickListener itemClickListener =
                new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> listAmazon, View itemView, int position, long id) {
                        Intent intent = new Intent(AmazonPlatformActivity.this, AmazonActivity.class);
                        intent.putExtra(AmazonActivity.EXTRA_AMAZONID, (int) id);
                        startActivity(intent);
                    }
                };

        listAmazon.setOnItemClickListener(itemClickListener);
    }
}
