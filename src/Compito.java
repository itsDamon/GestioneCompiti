import java.time.LocalDate;

public class Compito implements Comparable<Compito>{
    private String descrizione;
    private LocalDate dataDiCreazione;
    private LocalDate dataDiScadenza;
    private boolean isCompletato;
    private Tipo tipo;
    private Materia materia;

    public Compito(String descrizione, LocalDate dataDiCreazione, LocalDate dataDiScadenza, Tipo tipo, Materia materia) {
        this.descrizione = descrizione;
        this.dataDiCreazione = dataDiCreazione;
        this.dataDiScadenza = dataDiScadenza;
        this.isCompletato = false;
        this.tipo = tipo;
        this.materia = materia;
    }

    public LocalDate getDataDiCreazione() {
        return dataDiCreazione;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public boolean isCompletato() {
        return isCompletato;
    }

    public void setCompletato(boolean completato) {
        isCompletato = completato;
    }

    public Materia getMateria() {
        return materia;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public LocalDate getDataDiScadenza() {
        return dataDiScadenza;
    }

    @Override
    public String toString() {
        return "Compito{" +
                "descrizione='" + descrizione + '\'' +
                ", dataDiCreazione=" + dataDiCreazione +
                ", dataDiScadenza=" + dataDiScadenza +
                ", isCompletato=" + isCompletato +
                ", tipologia=" + tipo +
                '}';
    }

    @Override
    public int compareTo(Compito o) {
        return dataDiCreazione.compareTo(o.getDataDiCreazione());
    }
}
