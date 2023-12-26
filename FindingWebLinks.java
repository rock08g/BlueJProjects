import edu.duke.*;

public class FindingWebLinks {
    public void findingWebLinks () {
        URLResource ur = new URLResource("https://www.dukelearntoprogram.com//course2/data/manylinks.html");
        String yt = "youtube.com";
        String quote = "\"";
        for (String word : ur.words()) {
            String tempURL = word.toLowerCase();
            int startIndex = tempURL.indexOf(yt);
            if (startIndex != -1) {
                int quoteStartIndex = tempURL.indexOf(quote);
                int quoteEndIndex = tempURL.indexOf(quote, startIndex + 1);
                String ytURL = word.substring(quoteStartIndex + 1, quoteEndIndex);
                System.out.println(ytURL);
            }
            
        }
    }
}
