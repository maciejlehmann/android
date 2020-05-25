package pl.lehmann.lab6;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

        //Create a cursor
        SQLiteOpenHelper databaseHelper = new DatabaseHelper(this);
        try {
            SQLiteDatabase db = databaseHelper.getReadableDatabase();
            Cursor cursor = db.query("NETFLIX",
                    new String[]{"NAME", "DESCRIPTION", "IMAGE_RESOURCE_ID"},
                    "_id = ?",
                    new String[]{Integer.toString(netflixId)},
                    null, null, null);

            //Move to the first record in the Cursor
            if (cursor.moveToFirst()) {

                //Get the netflix details from the cursor
                String nameText = cursor.getString(0);
                String descriptionText = cursor.getString(1);
//                String seasonsText = cursor.getString(2);
                int photoId = cursor.getInt(2);

                //Populate the series name
                TextView name = (TextView) findViewById(R.id.name);
                name.setText(nameText);

                //Populate the series description
                TextView description = (TextView) findViewById(R.id.description);
                description.setText(descriptionText);

//                //Populate the series seasons
//                TextView seasons = (TextView) findViewById(R.id.seasons);
//                seasons.setText(seasonsText);

                //Populate the series image
                ImageView photo = (ImageView) findViewById(R.id.photo);
                photo.setImageResource(photoId);
                photo.setContentDescription(nameText);
            }
            cursor.close();
            db.close();
        } catch (SQLiteException e) {
            Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
