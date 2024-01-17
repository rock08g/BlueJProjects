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

    
    public String findGene (String dna) {
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

    public void printAllGenes (String dna) {
        while (true) {
            String gene = findGene(dna);
            if (gene.length() == 0) {
                break;
            }
            System.out.println(gene);
            dna = dna.substring(gene.length());
        }
    }

    public void testFindGene() {
        String dna1 = "ATGAAATAGTAA";
        String result1 = findGene(dna1);
        System.out.println("DNA: " + dna1);
        System.out.println("Gene: " + result1);
        System.out.println();

        String dna2 = "ATGAAATAGTAG";
        String result2 = findGene(dna2);
        System.out.println("DNA: " + dna2);
        System.out.println("Gene: " + result2);
        System.out.println();

        String dna3 = "ATGAAATAGTGAA";
        String result3 = findGene(dna3);
        System.out.println("DNA: " + dna3);
        System.out.println("Gene: " + result3);
        System.out.println();

        String dna4 = "ATGAAATAGT";
        String result4 = findGene(dna4);
        System.out.println("DNA: " + dna4);
        System.out.println("Gene: " + result4);
        System.out.println();

        String dna5 = "ATGAAATAGTAG";
        String result5 = findGene(dna5);
        System.out.println("DNA: " + dna5);
        System.out.println("Gene: " + result5);
        System.out.println();
    }

    public void testFindStopCodon () {
        String dna1 = "ATGAAATAGTAA";
        int result1 = findStopCodon(dna1, 0, "TAA");
        System.out.println("DNA: " + dna1);
        System.out.println("Stop Codon: TAA");
        System.out.println("Result: " + result1);
        System.out.println();

        String dna2 = "ATGAAATAGTAG";
        int result2 = findStopCodon(dna2, 0, "TAG");
        System.out.println("DNA: " + dna2);
        System.out.println("Stop Codon: TAG");
        System.out.println();
          
        String dna3 = "TGA";
        int result3 = findStopCodon(dna3, 0, "TGA");
        System.out.println("DNA: " + dna3);
        System.out.println("Stop Codon: TGA");
        System.out.println("Result: " + result3);
        System.out.println();

        String dna4 = "ATGAAATAGT";
        int result4 = findStopCodon(dna4, 0, "TAA");
        System.out.println("DNA: " + dna4);
        System.out.println("Stop Codon: TAA");
        System.out.println();
        
        String dna5 = "TAA";
        int result5 = findStopCodon(dna5, 0, "TAA");
        System.out.println("DNA: " + dna5);
        System.out.println("Stop Codon: TAA");
        System.out.println("Result: " + result5);
        System.out.println();
    }
}

public class Part2 {
    public int howMany(String stringa, String stringb) {
        int count = 0;
        int index = stringb.indexOf(stringa);
        while (index!= -1) {
            count++;
            index = stringb.indexOf(stringa, index + stringa.length());
        }
        return count;
    }

    public void testHowMany() {
        String stringa1 = "GAA";
        String stringb1 = "ATGAACGAATTGAATC";
        int result1 = howMany(stringa1, stringb1);
        System.out.println("Stringa: " + stringa1);
        System.out.println("Stringb: " + stringb1);
        System.out.println("Result: " + result1);
        System.out.println();
        String stringa2 = "AA";
        String stringb2 = "ATAAAA";
        int result2 = howMany(stringa2, stringb2);
        System.out.println("Stringa: " + stringa2);
        System.out.println("Stringb: " + stringb2);
        System.out.println("Result: " + result2);
        System.out.println();
    }
}

public class Part3 {

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

    
    public String findGene (String dna) {
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

    public void printAllGenes (String dna) {
        while (true) {
            String gene = findGene(dna);
            if (gene.length() == 0) {
                break;
            }
            System.out.println(gene);
            dna = dna.substring(gene.length());
        }
    }
    public int countGenes(String dna) {
        int startCodon = dna.indexOf("ATG", 0);
        if (startCodon == -1) {
            return "";
        }
        int count = 0;
        int taaCodon = findStopCodon(dna, startCodon, "TAA");
        int tagCodon = findStopCodon(dna, startCodon, "TAG");
        int tgaCodon = findStopCodon(dna, startCodon, "TGA");
        int minIndex = Math.min(taaCodon, Math.min(tagCodon, tgaCodon));
        while (minIndex != -1) {
           count++;
           startCodon = dna.indexOf("ATG", minIndex);
           taaCodon = findStopCodon(dna, startCodon, "TAA");
           tagCodon = findStopCodon(dna, startCodon, "TAG");
           tgaCodon = findStopCodon(dna, startCodon, "TGA");
           minIndex = Math.min(taaCodon, Math.min(tagCodon, tgaCodon));
        }
        return count;
    }

    public void testCountGenes() {
        int result = countGenes("ATGTAAGATGCCCTAGT");
        System.out.println("There were " + result + " genes in the DNA.");
    }
}

Public class TestSummary {
    public int findGene (String dna) {
        int startCodon = dna.indexOf("ATG", 0);
        if (startCodon == -1) {
            return "";
        }
        int minIndex = Math.min(findStopCodon(dna, startCodon, "TAA";


    }

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
}