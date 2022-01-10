import model.Offerten;
import model.Ort;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class OffertenRepo {

    private List<Offerten> offertenList = new ArrayList<>();

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

    public void writeSorted() throws IOException{

        //b) offerten nach preis(inkl. mehrwersteure) fallender reihenfolge
        //in datei offertensortiert.txt speichern
        FileWriter fileWriterPreis = new FileWriter("src/files/offertensortiert.txt");
        PrintWriter printWriterPreis = new PrintWriter(fileWriterPreis);
        List<Offerten> offertenPreis = offertenList; //.stream().filter(offerten -> offerten.getPreis().collect(Collectors.toList());
        offertenPreis.sort(Comparator.comparing(offertenPreise -> offertenPreise.getPreis(), Collections.reverseOrder()));
        offertenPreis.forEach(offerten -> printWriterPreis.write(offerten.toString() + "\n"));
        printWriterPreis.close();

        //


    }
}
