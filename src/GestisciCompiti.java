import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Stream;

public class GestisciCompiti {

    /**
     * Ritorna la descrizione dei compiti ordinati per data di creazione
     *
     * @param compiti
     * @return Stream di stringe con descrizione dei compiti ordinati per data di creazione
     */
    public static Stream<String> getDescrizioneOrdinataPerCreazione(ArrayList<Compito> compiti) {
        return compiti.stream()
                .filter(compito -> compito.getTipo().equals(Tipo.STUDIO))
                .sorted()
                .map(Compito::getDescrizione);
    }

    /**
     * Trova le materie di cui sono stati assegnati compiti
     *
     * @param compiti
     * @return Stream di materie di cui sono stati assegnati compiti
     */
    public static Stream<Materia> getMaterieConCompiti(ArrayList<Compito> compiti) {
        return compiti.stream()
                .map(Compito::getMateria)
                .distinct();
    }

    /**
     * Ritorna i primi {@<code>n</code>} compiti di tipo {@<code>LETTURA</code>}
     *
     * @param compiti
     * @param n
     * @return Stream di compiti di tipo Lettura
     */
    public static Stream<Compito> getCompitiDiLettura(ArrayList<Compito> compiti, int n) {
        return compiti.stream()
                .filter(compito -> compito.getTipo().equals(Tipo.LETTURA))
                .sorted()
                .limit(n);
    }

    /**
     * Ritorna i compiti in scadenza nella prossima settimana
     *
     * @param compiti
     * @return Stream di compiti in scadenza entro la prossima settimana
     */
    public static Stream<Compito> getCompitiInScadenza(ArrayList<Compito> compiti) {
        int daysToDomenica = 7 - LocalDate.now().getDayOfWeek().getValue();
        return compiti.stream()
                .filter(compito -> compito.getDataDiScadenza().isBefore(LocalDate.now().plusDays(daysToDomenica)));
    }

    /**
     * Ritorna la quantità di compiti che non sono ancora stati svolti
     * .<
     *
     * @param compiti
     * @return {@code int} quantità di compiti da svolgere
     */
    public static int quantitaDiCompitiDaFare(ArrayList<Compito> compiti) {
        return (int) compiti.stream()
                .filter(compito -> !compito.isCompletato())
                .count();
    }
}
