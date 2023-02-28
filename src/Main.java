import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Compito> diario = new ArrayList<>();
        Compito studiaRivoluzione = new Compito("Studiare la rivoluzione francese",
                LocalDate.of(2023, 1, 10),
                LocalDate.of(2023, 2, 25),
                Tipo.STUDIO,
                Materia.STORIA);
        diario.add(new Compito("Studiare la rivoluzione francese",
                LocalDate.of(2023, 1, 10),
                LocalDate.of(2023, 2, 25),
                Tipo.STUDIO,
                Materia.STORIA));
        diario.add(new Compito("Creare codice per gestione dei compiti",
                LocalDate.of(2023, 2, 20),
                LocalDate.of(2023, 2, 28),
                Tipo.PROGRAMMAZIONE,
                Materia.STORIA));
        diario.add(new Compito("Leggere il capitolo sui verbi irregilari",
                LocalDate.of(2023, 2, 5),
                LocalDate.of(2023, 4, 1),
                Tipo.LETTURA,
                Materia.INGLESE));
        diario.add(new Compito("Leggere il capitolo sui verbi irregilari",
                LocalDate.of(2023, 3, 5),
                LocalDate.of(2023, 5, 5),
                Tipo.LETTURA,
                Materia.MATEMATICA));
        GestisciCompiti.getDescrizioneOrdinataPerCreazione(diario).forEach(System.out::println);
        GestisciCompiti.getMaterieConCompiti(diario).forEach(System.out::println);
        GestisciCompiti.getCompitiDiLettura(diario, 1).forEach(System.out::println);
        System.out.println("Compiti in scadenza: ");
        GestisciCompiti.getCompitiInScadenza(diario).forEach(System.out::println);
        diario.get(0).setCompletato(true);
        System.out.println(GestisciCompiti.quantitaDiCompitiDaFare(diario));
    }
}