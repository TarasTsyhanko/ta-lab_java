package consolemenu;

public enum Months {
    JANUARY("Happy NEW YEAR, and I wish you good luck"),
    FEBRUARY("Only 29 days for learn Java, I am sad about that"),
    MARCH("the most colder month in a year"),
    APRIL("oh no, this year will not be new season Game of Thrones"),
    MAY("the age of vegetarians is begin"),
    JUNE("Please, more strawberry"),
    JULY("I want to go to sea, but I have to work"),
    AUGUST("31 hot days "),
    SEPTEMBER("best time for mountains"),
    OCTOBER("somebody grow up "),
    NOVEMBER("could you buy me a tangerines"),
    DECEMBER("let it snow, let it snow, let it snow");
    private String info;


    Months(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
}

