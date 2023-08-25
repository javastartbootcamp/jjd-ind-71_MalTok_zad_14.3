class Country {
    private final String code;
    private final String name;
    private final int people;

    public Country(String code, String name, int people) {
        this.code = code;
        this.name = name;
        this.people = people;
    }

    @Override
    public String toString() {
        return name + " (" + code + ") ma " + people + " ludności.";
    }
}
