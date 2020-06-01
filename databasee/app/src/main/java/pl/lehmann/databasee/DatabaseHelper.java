package pl.lehmann.databasee;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "series"; // the name of our database
    private static final int DB_VERSION = 3; // the version of the database

    DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        updateMyDatabase(db, 0, DB_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        updateMyDatabase(db, 2, DB_VERSION);
    }

    private static void insertNetflix(SQLiteDatabase db, String name, String description, String seasons, int resourceId) {
        ContentValues netflixValues = new ContentValues();
        netflixValues.put("NAME", name);
        netflixValues.put("DESCRIPTION", description);
        netflixValues.put("SEASONS", seasons);
        netflixValues.put("IMAGE_RESOURCE_ID", resourceId);
        db.insert("NETFLIX", null, netflixValues);
    }

    private static void insertHbo(SQLiteDatabase db, String name, String description, String seasons, int resourceId) {
        ContentValues hboValues = new ContentValues();
        hboValues.put("NAME", name);
        hboValues.put("DESCRIPTION", description);
        hboValues.put("SEASONS", seasons);
        hboValues.put("IMAGE_RESOURCE_ID", resourceId);
        db.insert("HBO", null, hboValues);
    }

    private static void insertAmazon(SQLiteDatabase db, String name, String description, String seasons, int resourceId) {
        ContentValues amazonValues = new ContentValues();
        amazonValues.put("NAME", name);
        amazonValues.put("DESCRIPTION", description);
        amazonValues.put("SEASONS", seasons);
        amazonValues.put("IMAGE_RESOURCE_ID", resourceId);
        db.insert("AMAZON", null, amazonValues);
    }

    private void updateMyDatabase(SQLiteDatabase db, int oldVersion, int newVersion) {

        if (oldVersion < 1) {
            db.execSQL("CREATE TABLE NETFLIX (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "NAME TEXT, "
                    + "DESCRIPTION TEXT, "
                    + "SEASONS TEXT, "
                    + "IMAGE_RESOURCE_ID INTEGER);");
            insertNetflix(db, "Stranger Things",
                    "Podczas powrotu do domu znika dwunastoletni Will Byers. Zaginięcie chłopca jest początkiem dziwnych i niebezpiecznych wydarzeń trapiących prowincjonalne miasteczko.",
                    " 3", R.drawable.strangerthings);
            insertNetflix(db, "La Casa De Papel",
                    "Ośmioro zamaskowanych przestępców napada na hiszpańską mennicę narodową. Ich przedstawicielem jest tajemniczy Profesor, który prowadzi negocjacje z policją.",
                    " 4", R.drawable.lacasa);
            insertNetflix(db, "House of Cards",
                    "Francis Underwood jest bezwzględnym politykiem próbującym się zemścić na prezydencie, który pominął go przy obsadzeniu stanowiska sekretarza stanu.",
                    " 6", R.drawable.houseofcards);
            insertNetflix(db, "Narcos",
                    "Dwaj agenci zostają wysłani do Kolumbii, aby zakończyć działalność handlarza narkotyków.",
                    " 3", R.drawable.narcos);
            insertNetflix(db, "Dark",
                    "Zaginięcie dzieci ujawnia podwójne życie i nadszarpnięte relacje członków czterech rodzin, łącząc się z wydarzeniami sprzed trzydziestu lat.",
                    " 3", R.drawable.dark);
            insertNetflix(db, "The Crown",
                    "Po śmierci króla Jerzego VI nową władczynią Wielkiej Brytanii zostaje jego córka Elżbieta II. Kobieta obejmuje tron w momencie, kiedy imperium chyli się ku upadkowi.",
                    " 4", R.drawable.thecrown);
        }

        if (oldVersion < 3) {
            db.execSQL("CREATE TABLE HBO (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "NAME TEXT, "
                    + "DESCRIPTION TEXT, "
                    + "SEASONS TEXT, "
                    + "IMAGE_RESOURCE_ID INTEGER);");
            insertHbo(db, "Chernobyl",
                    "Po wybuchu elektrowni jądrowej w Czarnobylu ratownicy poświęcają zdrowie i życie, by ratować Europę przed skutkami katastrofy.",
                    " 1", R.drawable.chernobyl);
            insertHbo(db, "Game of Thrones",
                    "Adaptacja sagi George'a R.R. Martina. W królestwie Westeros walka o władzę, spiski oraz zbrodnie są na porządku dziennym.",
                    " 8", R.drawable.got);
            insertHbo(db, "The Sopranos",
                    "Tony Soprano, mąż i ojciec dwójki dzieci, a zarazem ważny członek mafii z New Jersey, cierpi na tajemnicze ataki paniki. Kiedy sytuacja zaczyna go przerastać, postanawia rozpocząć terapię u psychiatry.",
                    " 6", R.drawable.sopranos);
            insertHbo(db, "Big Little Lies",
                    "Idealne życie trzech matek przybiera nieoczekiwany obrót, gdy w miasteczku dochodzi do zbrodni.",
                    " 2", R.drawable.bigll);
            insertHbo(db, "Westworld",
                    "Naukowiec tworzy futurystyczny park rozrywki, który zamieszkany jest przez posiadające sztuczną inteligencję tzw. \"hosty\".",
                    " 3", R.drawable.westworld);
            insertHbo(db, "Wataha",
                    "Kapitan Wiktor Rebrow próbuje rozwikłać zagadkę zamachu bombowego, w którym zginęli jego przyjaciele ze Straży Granicznej w Bieszczadach.",
                    " 3", R.drawable.wataha);

            db.execSQL("CREATE TABLE AMAZON (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "NAME TEXT, "
                    + "DESCRIPTION TEXT, "
                    + "SEASONS TEXT, "
                    + "IMAGE_RESOURCE_ID INTEGER);");
            insertAmazon(db, "Fleabag",
                    "Młoda kobieta próbuje na nowo ułożyć sobie życie w Londynie po niedawno przeżytej tragedii.",
                    " 2",
                    R.drawable.fleabag);
            insertAmazon(db, "The Marvelous Mrs. Maisel",
                    "Lata 60., USA - w świecie opanowanym przez mężczyzn zdradzana żona postanawia rozpocząć karierę jako komik sceniczny.",
                    " 3", R.drawable.maisel);
            insertAmazon(db, "The Boys",
                    "Grupa samozwańczych obrońców sprawiedliwości przeciwstawia się superbohaterom, którzy nadużywają swoich mocy.",
                    " 1", R.drawable.boys);
            insertAmazon(db, "Undone",
                    "Po wypadku samochodowym Alma odkrywa, że potrafi wpływać na bieg czasu. Rozwija nowe umiejętności, aby dotrzeć do prawdy o śmierci swego ojca.",
                    " 1", R.drawable.undone);
            insertAmazon(db, "The Man in the High Castle",
                    "Alternatywne spojrzenie na historię Ameryki Północnej: jakie mogłoby być życie po II wojnie światowej, gdyby III Rzesza i Cesarstwo Japonii wygrały wojnę.",
                    " 4", R.drawable.man);
            insertAmazon(db, "Carnival Row",
                    "W mrocznym mieście seryjny morderca poluje na nadnaturalne istoty. Prowadzący śledztwo detektyw nieoczekiwanie staje się głównym podejrzanym.",
                    " 1", R.drawable.carnival);

            db.execSQL("ALTER TABLE NETFLIX ADD COLUMN WATCHED NUMERIC;");
            db.execSQL("ALTER TABLE HBO ADD COLUMN WATCHED NUMERIC;");
            db.execSQL("ALTER TABLE AMAZON ADD COLUMN WATCHED NUMERIC;");
        }
    }
}