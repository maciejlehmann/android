package pl.lehmann.lab6;

public class Amazon {
    private String name;
    private String description;
    private String seasons;
    private int imageResourceId;

    public static final Amazon[] series = {
            new Amazon("Fleabag",
                    "Młoda kobieta próbuje na nowo ułożyć sobie życie w Londynie po niedawno przeżytej tragedii.",
                    " 2",
                    R.drawable.fleabag),
            new Amazon("The Marvelous Mrs. Maisel",
                    "Lata 60., USA - w świecie opanowanym przez mężczyzn zdradzana żona postanawia rozpocząć karierę jako komik sceniczny.",
                    " 3",
                    R.drawable.maisel),
            new Amazon("The Boys",
                    "Grupa samozwańczych obrońców sprawiedliwości przeciwstawia się superbohaterom, którzy nadużywają swoich mocy.",
                    " 1",
                    R.drawable.boys),
            new Amazon("Undone",
                    "Po wypadku samochodowym Alma odkrywa, że potrafi wpływać na bieg czasu. Rozwija nowe umiejętności, aby dotrzeć do prawdy o śmierci swego ojca.",
                    " 1",
                    R.drawable.undone),
            new Amazon("The Man in the High Castle",
                    "Alternatywne spojrzenie na historię Ameryki Północnej: jakie mogłoby być życie po II wojnie światowej, gdyby III Rzesza i Cesarstwo Japonii wygrały wojnę.",
                    " 4",
                    R.drawable.man),
            new Amazon("Carnival Row",
                    "W mrocznym mieście seryjny morderca poluje na nadnaturalne istoty. Prowadzący śledztwo detektyw nieoczekiwanie staje się głównym podejrzanym.",
                    " 1",
                    R.drawable.carnival)
    };

    private Amazon(String name, String description, String seasons, int imageResourceId) {
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