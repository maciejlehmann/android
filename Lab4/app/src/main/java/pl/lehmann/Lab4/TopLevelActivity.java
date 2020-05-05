package pl.lehmann.Lab4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class TopLevelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_level);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        AdapterView.OnItemClickListener itemClickListener =
                new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> listView, View itemView, int position, long id) {
                        if (position == 0) {
                            Intent intent = new Intent(TopLevelActivity.this, NetflixPlatformActivity.class);
                            startActivity(intent);
                        } else if (position == 1) {
                            Intent intent = new Intent(TopLevelActivity.this, HboPlatformActivity.class);
                            startActivity(intent);
                        } else if (position == 2) {
                            Intent intent = new Intent(TopLevelActivity.this, AmazonPlatformActivity.class);
                            startActivity(intent);
                        }
                    }
                };

        ListView listView = (ListView) findViewById(R.id.list_options);
        listView.setOnItemClickListener(itemClickListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_app_info:
                Intent intent = new Intent(this, InfoActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
