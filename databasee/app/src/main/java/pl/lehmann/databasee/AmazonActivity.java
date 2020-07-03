package pl.lehmann.databasee;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

        //Create a cursor
        SQLiteOpenHelper databaseHelper = new DatabaseHelper(this);
        try {
            SQLiteDatabase db = databaseHelper.getReadableDatabase();
            Cursor cursor = db.query("AMAZON",
                    new String[]{"NAME", "DESCRIPTION", "SEASONS", "IMAGE_RESOURCE_ID", "WATCHED"},
                    "_id = ?",
                    new String[]{Integer.toString(amazonId)},
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
        int amazonId = (Integer) getIntent().getExtras().get(EXTRA_AMAZONID);
        new UpdateAmazonTask().execute(amazonId);
    }

    private class UpdateAmazonTask extends AsyncTask<Integer, Void, Boolean> {
        private ContentValues amazonValues;

        protected void onPreExecute() {
            CheckBox watched = (CheckBox) findViewById(R.id.watched);
            amazonValues = new ContentValues();
            amazonValues.put("WATCHED", watched.isChecked());
        }

        protected Boolean doInBackground(Integer... amazon) {
            int amazonId = amazon[0];
            SQLiteOpenHelper databaseHelper = new DatabaseHelper(AmazonActivity.this);
            try {
                SQLiteDatabase db = databaseHelper.getWritableDatabase();
                db.update("AMAZON", amazonValues, "_id = ?", new String[]{Integer.toString(amazonId)});
                db.close();
                return true;
            } catch (SQLiteException e) {
                return false;
            }
        }

        protected void onPostExecute(Boolean success) {
            if (!success) {
                Toast toast = Toast.makeText(AmazonActivity.this, "Database unavailable", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }
}

