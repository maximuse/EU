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

    String getDatum() {
        return datum;
    }

    @Override
    public String toString() {
        return "Eu{" +
                "orszag='" + orszag + "', " +
                "datum=" + datum + "}\n";
    }
}