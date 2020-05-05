package pl.lehmann.Lab4;

public class Hbo {
    private String name;
    private String description;
    private String seasons;
    private int imageResourceId;

    public static final Hbo[] series = {
            new Hbo("Chernobyl",
                    "Po wybuchu elektrowni jądrowej w Czarnobylu ratownicy poświęcają zdrowie i życie, by ratować Europę przed skutkami katastrofy.",
                    " 1",
                    R.drawable.chernobyl),
            new Hbo("Game of Thrones",
                    "Adaptacja sagi George'a R.R. Martina. W królestwie Westeros walka o władzę, spiski oraz zbrodnie są na porządku dziennym.",
                    " 8",
                    R.drawable.got),
            new Hbo("The Sopranos",
                    "Tony Soprano, mąż i ojciec dwójki dzieci, a zarazem ważny członek mafii z New Jersey, cierpi na tajemnicze ataki paniki. Kiedy sytuacja zaczyna go przerastać, postanawia rozpocząć terapię u psychiatry.",
                    " 6",
                    R.drawable.sopranos),
            new Hbo("Big Little Lies",
                    "Idealne życie trzech matek przybiera nieoczekiwany obrót, gdy w miasteczku dochodzi do zbrodni.",
                    " 2",
                    R.drawable.bigll),
            new Hbo("Westworld",
                    "Naukowiec tworzy futurystyczny park rozrywki, który zamieszkany jest przez posiadające sztuczną inteligencję tzw. \"hosty\".",
                    " 3",
                    R.drawable.westworld),
            new Hbo("Wataha",
                    "Kapitan Wiktor Rebrow próbuje rozwikłać zagadkę zamachu bombowego, w którym zginęli jego przyjaciele ze Straży Granicznej w Bieszczadach.",
                    " 3",
                    R.drawable.wataha)
    };

    private Hbo(String name, String description, String seasons, int imageResourceId) {
        this.name = name;
        this.description = description;
        this.seasons = seasons;
        this.imageResourceId = imageResourceId;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String getSeasons() {
        return seasons;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String toString() {
        return this.name;
    }
}