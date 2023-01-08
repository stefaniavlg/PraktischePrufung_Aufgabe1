import model.Offerten;
import model.Ort;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class OffertenRepo {

    private List<Offerten> offertenList = new ArrayList<>();

    /**
     * READ
     * @throws FileNotFoundException
     */
    public void read() throws FileNotFoundException {
        File inputFile = new File("src/files/offerten.txt");
        Scanner reader = new Scanner(inputFile);

        while (reader.hasNextLine()){

//1&Art Of Fire GmBh&38000&7.7&Eichenstrasse 15&Thurgau

            String line = reader.nextLine();
            var lineSplited= line.split("&");

            int id= Integer.parseInt(lineSplited[0]);
            String unternehmensname = lineSplited[1];
            int preis= Integer.parseInt(lineSplited[2]);
            float mehrwertsteuer= Float.parseFloat(lineSplited[3]);
            String adresse = lineSplited[4];
            Ort ort= Ort.valueOf(lineSplited[5]);

            offertenList.add((new Offerten(id,unternehmensname,preis,mehrwertsteuer,adresse,ort)));

        }
    }

    /**
     * sort offerten + speichern
     *
     * @throws IOException
     */
    public void writeSorted() throws IOException{

        //b) offerten nach preis(inkl. mehrwersteure) fallender reihenfolge
        //in datei offertensortiert.txt speichern

        FileWriter fileWriterPreis = new FileWriter("src/files/offertensortiert.txt");
        PrintWriter printWriterPreis = new PrintWriter(fileWriterPreis);

        List<Offerten> offertenPreis = offertenList; //.stream().filter(offerten -> offerten.getPreis().collect(Collectors.toList());
        List<Offerten> offertenMWst = offertenList;

        //Comparator<Offerten> comparator = Comparator.comparing(offerten -> offerten.getPreis());
        //comparator = comparator.thenComparing(Comparator.comparing(offerten -> offerten.getMehrwertsteuer()));

        //offertenPreis.sort(Comparator.comparing(offertenPreise -> offertenPreise.getPreis(), Collections.reverseOrder()));
        offertenPreis.sort(Comparator.comparing(offertenMWste->offertenMWste.getMehrwertsteuer(),Collections.reverseOrder()));

//comparator.reversed();
        offertenPreis.forEach(offerten -> printWriterPreis.write(offerten.toString() + "\n"));
       // offertenPreis.forEach(offerten -> printWriterPreis.write(offerten.toString() + "\n"));
        printWriterPreis.close();

        //eine Statistik mit einem Top der Orte nach Einkommen erstellt.
        // Diese Statistik wird in eine
        //andere Textdatei mit dem Namen statistik.txt gespeichert.




    }

    /**
     * Statistik TOP Orte nach Einkommen
     *
     * St. Gallen: 65000
     * Zürich: 55000
     * Thurgau: 38000
     *
     */
    public void writeStatistik() throws IOException{


        FileWriter fileWriterStatistik = new FileWriter("src/files/statistik.txt");
        PrintWriter printWriterStatistik = new PrintWriter(fileWriterStatistik);

        List<Offerten> offertenOrt = offertenList;

        //Ort[] orte = Ort.values();


        //Arrays.stream(orte).filter(o->o.toString().equals("Thurgau"))
                      //      .forEach(offerten -> printWriterStatistik.write(offerten.toString() + "\n"));

        //List<Offerten> offertenLis= offertenList.stream().distinct().collect(Collectors.toList());

        offertenOrt.sort(Comparator.comparing(offertenOrte->offertenOrte.getPreis(),Collections.reverseOrder()));

        offertenList.forEach(offerten -> printWriterStatistik.write(offerten.getOrt() + ":" + offerten.getPreis()+ "\n"));

        printWriterStatistik.close();
}}
