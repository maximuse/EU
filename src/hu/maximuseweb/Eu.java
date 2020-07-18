package hu.maximuseweb;

class Eu {
    private String orszag;
    private String datum;

    Eu(String orszag, String datum) {
        this.orszag = orszag;
        this.datum = datum;
    }

    String getOrszag() {
        return orszag;
    }

    void setOrszag(String orszag) {
        this.orszag = orszag;
    }

    String getDatum() {
        return datum;
    }

    void setDatum(String datum) {
        this.datum = datum;
    }

    @Override
    public String toString() {
        return "Eu{" +
                "orszag='" + orszag + "', " +
                "datum=" + datum + "}\n";
    }
}