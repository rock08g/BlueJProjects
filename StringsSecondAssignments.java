import edu.duke.*;

public class Part1 {
    public int findStopCodon(String dna, int startIndex, String stopCodon) {
        int index = dna.indexOf(stopCodon, startIndex + 3);
        while (index != -1) {

            if ((index - startIndex) % 3 == 0) {
                return index;
            }
            else {
                index = dna.indexOf(stopCodon, startIndex + 1);
            }
        }
        return dna.length();
    }

    
    }public String findGene (String dna) {
        int startCodon = dna.indexOf("ATG", 0);
        if (startCodon == -1) {
            return "";
        }
        int taaCodon = findStopCodon(dna, startCodon, "TAA");
        int tagCodon = findStopCodon(dna, startCodon, "TAG");
        int tgaCodon = findStopCodon(dna, startCodon, "TGA");
        int minIndex = Math.min(taaCodon, Math.min(tagCodon, tgaCodon));
        if (minIndex == -1) {
            return "";
        }
        return dna.substring(startCodon, minIndex + 3);
    }

    public void testFindStopCodon () {
        String dna1 = "ATGAAATAGTAA";
        String result1 = findStopCodon(dna1, 0, "TAA");
        System.out.println("DNA: " + dna1);
        System.out.println("Stop Codon: TAA");
        System.out.println("Result: " + result1);
        System.out.println();

        String dna2 = "ATGAAATAGTAG";
        String result2 = findStopCodon(dna2, 0, "TAG");
        System.out.println("DNA: " + dna2);
        System.out.println("Stop Codon: TAG");
        System.out.println("Result: " + result2);
        System.out.println();

        String dna3 = "ATGAAATAGTGAA";
        String result3 = findStopCodon(dna3, 0, "TGA");
        System.out.println("DNA: " + dna3);
        System.out.println("Stop Codon: TGA");
        System.out.println("Result: " + result3);
        System.out.println();

        String dna4 = "ATGAAATAGT";
        String result4 = findStopCodon(dna4, 0, "TAA");
        System.out.println("DNA: " + dna4);
        System.out.println("Stop Codon: TAA");
        System.out.println("Result: " + result4);
        System.out.println();

        String dna5 = "ATGAAATAGTAG";
        String result5 = findStopCodon(dna5, 0, "TAA");
        System.out.println("DNA: " + dna5);
        System.out.println("Stop Codon: TAA");
        System.out.println("Result: " + result5);
        System.out.println();

    }

}