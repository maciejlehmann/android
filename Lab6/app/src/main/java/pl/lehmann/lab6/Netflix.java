package pl.lehmann.lab6;

public class Netflix {
    private String name;
    private String description;
    private String seasons;
    private int imageResourceId;

    public static final Netflix[] series = {
            new Netflix("Stranger Things",
                    "Podczas powrotu do domu znika dwunastoletni Will Byers. Zaginięcie chłopca jest początkiem dziwnych i niebezpiecznych wydarzeń trapiących prowincjonalne miasteczko.",
                    " 3",
                    R.drawable.strangerthings),
            new Netflix("La Casa De Papel",
                    "Ośmioro zamaskowanych przestępców napada na hiszpańską mennicę narodową. Ich przedstawicielem jest tajemniczy Profesor, który prowadzi negocjacje z policją.",
                    " 4",
                    R.drawable.lacasa),
            new Netflix("House of Cards",
                    "Francis Underwood jest bezwzględnym politykiem próbującym się zemścić na prezydencie, który pominął go przy obsadzeniu stanowiska sekretarza stanu.",
                    " 6",
                    R.drawable.houseofcards),
            new Netflix("Narcos",
                    "Dwaj agenci zostają wysłani do Kolumbii, aby zakończyć działalność handlarza narkotyków.",
                    " 3",
                    R.drawable.narcos),
            new Netflix("Dark",
                    "Zaginięcie dzieci ujawnia podwójne życie i nadszarpnięte relacje członków czterech rodzin, łącząc się z wydarzeniami sprzed trzydziestu lat.",
                    " 2",
                    R.drawable.dark),
            new Netflix("The Crown",
                    "Po śmierci króla Jerzego VI nową władczynią Wielkiej Brytanii zostaje jego córka Elżbieta II. Kobieta obejmuje tron w momencie, kiedy imperium chyli się ku upadkowi.",
                    " 3",
                    R.drawable.thecrown)
    };

    private Netflix(String name, String description, String seasons, int imageResourceId) {
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
