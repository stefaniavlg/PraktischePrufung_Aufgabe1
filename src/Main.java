import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        OffertenController offertenController = new OffertenController();
        try {
            offertenController.read();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            offertenController.writeSorted();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            offertenController.writeStatistik();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
