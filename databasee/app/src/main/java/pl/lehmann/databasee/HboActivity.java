package pl.lehmann.databasee;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class HboActivity extends AppCompatActivity {

    public static final String EXTRA_HBOID = "hboId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hbo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        int hboId = (Integer) getIntent().getExtras().get(EXTRA_HBOID);

        //Create a cursor
        SQLiteOpenHelper databaseHelper = new DatabaseHelper(this);
        try {
            SQLiteDatabase db = databaseHelper.getReadableDatabase();
            Cursor cursor = db.query("HBO",
                    new String[]{"NAME", "DESCRIPTION", "SEASONS", "IMAGE_RESOURCE_ID", "WATCHED"},
                    "_id = ?",
                    new String[]{Integer.toString(hboId)},
                    null, null, null);

            //Move to the first record in the Cursor
            if (cursor.moveToFirst()) {

                //Get the netflix details from the cursor
                String nameText = cursor.getString(0);
                String descriptionText = cursor.getString(1);
                String seasonsText = cursor.getString(2);
                int photoId = cursor.getInt(3);
                boolean isWatched = (cursor.getInt(4) == 1);

                //Populate the series name
                TextView name = (TextView) findViewById(R.id.name);
                name.setText(nameText);

                //Populate the series description
                TextView description = (TextView) findViewById(R.id.description);
                description.setText(descriptionText);

                //Populate the series seasons
                TextView seasons = (TextView) findViewById(R.id.seasons);
                seasons.setText(seasonsText);

                //Populate the series image
                ImageView photo = (ImageView) findViewById(R.id.photo);
                photo.setImageResource(photoId);
                photo.setContentDescription(nameText);

                //Populate the favorite checkbox
                CheckBox favorite = (CheckBox) findViewById(R.id.watched);
                favorite.setChecked(isWatched);
            }
            cursor.close();
            db.close();
        } catch (SQLiteException e) {
            Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    //Update the database when the checkbox is clicked
    public void onWatchedClicked(View view) {
        int hboId = (Integer) getIntent().getExtras().get(EXTRA_HBOID);

        //Get the value of the checkbox
        CheckBox watched = (CheckBox) findViewById(R.id.watched);
        ContentValues hboValues = new ContentValues();
        hboValues.put("WATCHED", watched.isChecked());

        //Get a reference to the database and update the FAVORITE column
        SQLiteOpenHelper databaseHelper = new DatabaseHelper(this);
        try {
            SQLiteDatabase db = databaseHelper.getWritableDatabase();
            db.update("HBO",
                    hboValues,
                    "_id = ?",
                    new String[]{Integer.toString(hboId)});
            db.close();
        } catch (SQLiteException e) {
            Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}