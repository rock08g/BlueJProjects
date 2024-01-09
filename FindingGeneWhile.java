import edu.duke.*;

public class FindingGeneWhile {

    public String findGene(String dna, int where){
        int startIndex = dna.indexOf("ATG", where);
        if (startIndex == -1) {
            return "";
        }
        int taaIndex = findStopCodon(dna, startIndex, "TAA");
        int tagIndex = findGenericTag(dna, startIndex, "TAG");
        int tgaIndex = findGenericTag(dna, startIndex, "TGA");
        int minIndex = Math.min(taaIndex, Math.min(tagIndex, tgaIndex));
        if (minIndex == -1 || (tgaIndex != -1 && tgaIndex < taaIndex)) {
            minIndex = tgaIndex;
        }
        else {
            minIndex = taaIndex;
        }

        if (minIndex == -1 || (tagIndex != -1 && tagIndex < minIndex)) {
            minIndex = tagIndex;
        }

        if (minIndex == =1) {
            return "";
        }

        return dna.substring(startIndex, minIndex + 3);
    }

public void printAllGenes(String dna) {
    int startIndex = 0;
    while (true) {
        String currentGene = findGene(dna,startIndex);
        if (currentGene.isEmpty()) {
            break;
        }
        System.out.println(currentGene);
        startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
    }
}

public int findStopCodon (String dnaStr, int startIndex, String stopCodon){
    int index = dnaStr.indexOf(stopCodon, startIndex + 3);
    while (index!= -1){
        if((index - startIndex) % 3 == 0){
            return index;
            }
        else {
            index = dnaStr.indexOf(stopCodon, index + 1);
        }
    }
    return dnaStr.length();
}

public void testFindStopCodon () {
    String dna = "xxxyyyzzzTAAxxxyyyzzzTAAxx";
    int dex = findStopCodon(dna, 0, "TAA");
    if (dex != 9) {
        System.out.println("error on line 9");
    }
    dex = findStopCodon(dna, 9, "TAA");
    if (dex!= 21) {
        System.out.println("error on line 21");
    }
    dex = findStopCodon(dna, 1, "TAA");
    if (dex!= 26) {
        System.out.println("error on line 26");
    }
    dex = findStopCodon(dna, 0, "TAG");
    if (dex= 26) {
        System.out.println("error on line 26 TAG");
    }
    System.out.println("Tests are finished");
}

 public void testSimpleGene () {
        String startCodon = "ATG";
        String stopCodon = "TAA";
        String dna1 = "AATGCGTAATTAATCG";
        String gene1 = findGene(dna1,startCodon,stopCodon);
        System.out.println("The DNA string is " + dna2);
        System.out.println("The Gene string is " + gene2);
        String dna3 = "CGATGGTTGATAAGCCTAAGCTAAA";
        String gene3 = findGene(dna3,startCodon,stopCodon);
        System.out.println("The DNA string is " + dna3);
        System.out.println("The Gene string is " + gene3);
    }
}