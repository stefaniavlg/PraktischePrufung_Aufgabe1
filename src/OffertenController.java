import java.io.FileNotFoundException;
import java.io.IOException;

public class OffertenController {

    OffertenRepo offertenRepo = new OffertenRepo();

    public void read() throws FileNotFoundException {
        offertenRepo.read();
    }
    public void writeSorted() throws IOException {
        offertenRepo.writeSorted();
    }
}
