package StringsFirstAssignments;

public class Part2 {
    public String findSimpleGene(String dna, String startCodon, String stopCodon) {
        String newdna = dna.toLowerCase();
        String gene = "";
        // Start codon
        final int startIndex = newdna.indexOf(startCodon.toLowerCase());
        if (startIndex == -1) {
            return "";
        }
        //Stop Codon
        final int stopIndex = newdna.indexOf(stopCodon.toLowerCase(), startIndex + 3);
        if (stopIndex == -1) {
            return "";
        }
        final int lengthOfString = (stopIndex + 3) - startIndex;

        if ((lengthOfString % 3) == 0) {
//            return dna.substring(startIndex, stopIndex);
            gene =  newdna.substring(startIndex, stopIndex);
        } else {
            gene = "No Gene Present";
        }

    if (dna == dna.toUpperCase()){
        return gene.toUpperCase();
    } else {
        return gene.toLowerCase();
    }

    }



    public void testSimpleGene(){

        // case1: DNA with no "ATG"
        String gene1 = "ATCATCTAA";

        System.out.println("Checking gene1: " + findSimpleGene(gene1, "ATG", "TAA"));
        // case2: DNA with no "TAA"
        String gene2 = "ATGTTAATGTTGG";
        System.out.println("Checking gene2: " + findSimpleGene(gene2, "ATG", "TAA"));
        // case3: DNA with no "ATG" and "TAA"
        String gene3 = "TTTTTGGGGGGTTTTAAA";
        System.out.println("Checking gene3: " + findSimpleGene(gene3, "ATG", "TAA"));
        // case4: DNA with ATG, TAA and the substring between them is a multiple of 3 (a gene)
        String gene4 = "ATGTTTGGGAAATAA";
//        String gene4 = "atgtttgggaaataa";
        System.out.println("Checking gene4: " + findSimpleGene(gene4, "ATG", "TAA"));
        // case5: DNA with ATG, TAA and the substring between them is not a multiple of 3
        String gene5 = "ATGTTTGGAAATAA";
        System.out.println("Checking gene5: " + findSimpleGene(gene5, "ATG", "TAA"));
    }

    public static void main(String[] args) {
        Part2 p2 = new Part2();
        p2.testSimpleGene();

    }

}
