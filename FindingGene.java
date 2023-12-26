public class FindingGene {
    
    public String findSimpleGene (String dna, String startCodon, String stopCodon) {
        String result = "";
        if (dna.equals(dna.toUpperCase())) {
            startCodon = startCodon.toUpperCase();
            stopCodon = stopCodon.toUpperCase();
        }
        else {
            dna = dna.toLowerCase();
            startCodon = startCodon.toLowerCase();
            stopCodon = stopCodon.toLowerCase();
        }
        int startIndex = dna.indexOf(startCodon);
        int stopIndex = dna.indexOf(stopCodon, startIndex + 3);
        if (startIndex == -1 || stopIndex == -1) {
            return "";
        }
        result = dna.substring(startIndex, stopIndex +3);
        if (result.length() % 3 != 0) {
            return "";
        }
        return result;
    }
    
    public void testSimpleGene () {
        String startCodon = "ATG";
        String stopCodon = "TAA";
        String dna1 = "AATGCGTAATATGGT";
        String gene1 = findSimpleGene(dna1,startCodon,stopCodon);
        System.out.println("The DNA string is " + dna1);
        System.out.println("The Gene string is " + gene1);
        String dna2 = "AATGCTAGGGTAATATGGT";
        String gene2 = findSimpleGene(dna2,startCodon,stopCodon);
        System.out.println("The DNA string is " + dna2);
        System.out.println("The Gene string is " + gene2);
        String dna3 = "ATCCTATGCTTCGGCTGCTCTAATATGGT";
        String gene3 = findSimpleGene(dna3,startCodon,stopCodon);
        System.out.println("The DNA string is " + dna3);
        System.out.println("The Gene string is " + gene3);
        String dna4 = "ATGTAA";
        String gene4 = findSimpleGene(dna4,startCodon,stopCodon);
        System.out.println("The DNA string is " + dna4);
        System.out.println("The Gene string is " + gene4);
        String dna5 = "ATGTTTTTAA";
        String gene5 = findSimpleGene(dna5,startCodon,stopCodon);
        System.out.println("The DNA string is " + dna5);
        System.out.println("The Gene string is " + gene5);
    }

    public boolean twoOccurrences (String stringa, String stringb) {
        int count = 0;
        int startIndex = stringb.indexOf(stringa);
        while (startIndex > -1) {
            count ++;
            startIndex = stringb.indexOf(stringa, startIndex + stringa.length());
        }
        if (count > 1){
            return true;
        }
        return false;
    }
    
    public String lastPart (String stringa, String stringb) {
        int index = stringb.indexOf(stringa);
        if (index > -1) {
            return stringb.substring(index + stringa.length());
        }
        return stringb;
    }
    
    public void testing () {
        String stringa1 = "by";
        String stringb1 = "A story by Abby Long";
        String stringa2 = "a";
        String stringb2 = "banana";
        String stringa3 = "atg";
        String stringb3 = "ctgtatgta";
        boolean test1 = twoOccurrences(stringa1, stringb1);
        boolean test2 = twoOccurrences(stringa2, stringb2);
        boolean test3 = twoOccurrences(stringa3, stringb3);
        System.out.println(stringa1);
        System.out.println(stringb1);
        System.out.println("The results of checking for two instances of stringa in stringb are: " + test1);
        System.out.println(stringa2);
        System.out.println(stringb2);
        System.out.println("The results of checking for two instances of stringa in stringb are: " + test2);
        System.out.println(stringa3);
        System.out.println(stringb3);
        System.out.println("The results of checking for two instances of stringa in stringb are: " + test3);
    }

}
