package pl.lehmann.databasee;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class TopLevelActivity extends AppCompatActivity {

    private SQLiteDatabase db;
    private Cursor watchedCursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_level);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setupOptionsListView();
        setupWatchedListViewNetflix();
        setupWatchedListViewHbo();
        setupWatchedListViewAmazon();
    }

    private void setupOptionsListView() {
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
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

    private void setupWatchedListViewNetflix() {

        //Populate the list_watched ListView from a cursor
        ListView listWatched = (ListView) findViewById(R.id.list_watched_netflix);
        try {
            SQLiteOpenHelper databaseHelper = new DatabaseHelper(this);
            db = databaseHelper.getReadableDatabase();
            watchedCursor = db.query("NETFLIX",
                    new String[]{"_id", "NAME"},
                    "WATCHED = 1",
                    null, null, null, null);
            CursorAdapter favoriteAdapter = new SimpleCursorAdapter(TopLevelActivity.this,
                    android.R.layout.simple_list_item_1,
                    watchedCursor,
                    new String[]{"NAME"},
                    new int[]{android.R.id.text1}, 0);
            listWatched.setAdapter(favoriteAdapter);
        } catch (SQLiteException e) {
            Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }

        //Navigate to DrinkActivity if a drink is clicked
        listWatched.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> listView, View v, int position, long id) {
                Intent intent = new Intent(TopLevelActivity.this, NetflixActivity.class);
                intent.putExtra(NetflixActivity.EXTRA_NETFLIXID, (int) id);
                startActivity(intent);
            }
        });
    }

    private void setupWatchedListViewHbo() {

        //Populate the list_watched ListView from a cursor
        ListView listWatched = (ListView) findViewById(R.id.list_watched_hbo);
        try {
            SQLiteOpenHelper databaseHelper = new DatabaseHelper(this);
            db = databaseHelper.getReadableDatabase();
            watchedCursor = db.query("HBO",
                    new String[]{"_id", "NAME"},
                    "WATCHED = 1",
                    null, null, null, null);
            CursorAdapter favoriteAdapter = new SimpleCursorAdapter(TopLevelActivity.this,
                    android.R.layout.simple_list_item_1,
                    watchedCursor,
                    new String[]{"NAME"},
                    new int[]{android.R.id.text1}, 0);
            listWatched.setAdapter(favoriteAdapter);
        } catch (SQLiteException e) {
            Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }

        //Navigate to DrinkActivity if a drink is clicked
        listWatched.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> listView, View v, int position, long id) {
                Intent intent = new Intent(TopLevelActivity.this, HboActivity.class);
                intent.putExtra(HboActivity.EXTRA_HBOID, (int) id);
                startActivity(intent);
            }
        });
    }

    private void setupWatchedListViewAmazon() {

        //Populate the list_watched ListView from a cursor
        ListView listWatched = (ListView) findViewById(R.id.list_watched_amazon);
        try {
            SQLiteOpenHelper databaseHelper = new DatabaseHelper(this);
            db = databaseHelper.getReadableDatabase();
            watchedCursor = db.query("AMAZON",
                    new String[]{"_id", "NAME"},
                    "WATCHED = 1",
                    null, null, null, null);
            CursorAdapter favoriteAdapter = new SimpleCursorAdapter(TopLevelActivity.this,
                    android.R.layout.simple_list_item_1,
                    watchedCursor,
                    new String[]{"NAME"},
                    new int[]{android.R.id.text1}, 0);
            listWatched.setAdapter(favoriteAdapter);
        } catch (SQLiteException e) {
            Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }

        //Navigate to DrinkActivity if a drink is clicked
        listWatched.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> listView, View v, int position, long id) {
                Intent intent = new Intent(TopLevelActivity.this, AmazonActivity.class);
                intent.putExtra(AmazonActivity.EXTRA_AMAZONID, (int) id);
                startActivity(intent);
            }
        });
    }

    //Close the cursor and database in the onDestroy() method
    @Override
    public void onDestroy() {
        super.onDestroy();
        watchedCursor.close();
        db.close();
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