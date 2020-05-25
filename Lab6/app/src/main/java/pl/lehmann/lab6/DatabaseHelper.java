package pl.lehmann.lab6;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "series"; // the name of our database
    private static final int DB_VERSION = 5; // the version of the database

    DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        updateMyDatabase(db, 0, DB_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        updateMyDatabase(db, oldVersion, newVersion);
    }

    private static void insertNetflix(SQLiteDatabase db, String name, String description, int resourceId) {
        ContentValues netflixValues = new ContentValues();
        netflixValues.put("NAME", name);
        netflixValues.put("DESCRIPTION", description);
//        netflixValues.put("SEASONS", seasons);
        netflixValues.put("IMAGE_RESOURCE_ID", resourceId);
        db.insert("NETFLIX", null, netflixValues);
    }

    private void updateMyDatabase(SQLiteDatabase db, int oldVersion, int newVersion) {

        if (oldVersion < 1) {
            db.execSQL("CREATE TABLE NETFLIX (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "NAME TEXT, "
                    + "DESCRIPTION TEXT, "
//                    + "SEASONS TEXT, "
                    + "IMAGE_RESOURCE_ID INTEGER);");
            insertNetflix(db, "Stranger Things",
                    "Podczas powrotu do domu znika dwunastoletni Will Byers. Zaginięcie chłopca jest początkiem dziwnych i niebezpiecznych wydarzeń trapiących prowincjonalne miasteczko.",
                    R.drawable.strangerthings);
            insertNetflix(db, "La Casa De Papel",
                    "Ośmioro zamaskowanych przestępców napada na hiszpańską mennicę narodową. Ich przedstawicielem jest tajemniczy Profesor, który prowadzi negocjacje z policją.",
                     R.drawable.lacasa);
            insertNetflix(db, "House of Cards",
                    "Francis Underwood jest bezwzględnym politykiem próbującym się zemścić na prezydencie, który pominął go przy obsadzeniu stanowiska sekretarza stanu.",
                     R.drawable.houseofcards);
            insertNetflix(db, "Narcos",
                    "Dwaj agenci zostają wysłani do Kolumbii, aby zakończyć działalność handlarza narkotyków.",
                     R.drawable.narcos);
            insertNetflix(db, "Dark",
                    "Zaginięcie dzieci ujawnia podwójne życie i nadszarpnięte relacje członków czterech rodzin, łącząc się z wydarzeniami sprzed trzydziestu lat.",
                     R.drawable.dark);
            insertNetflix(db, "The Crown",
                    "Po śmierci króla Jerzego VI nową władczynią Wielkiej Brytanii zostaje jego córka Elżbieta II. Kobieta obejmuje tron w momencie, kiedy imperium chyli się ku upadkowi.",
                     R.drawable.thecrown);
        }
    }
}