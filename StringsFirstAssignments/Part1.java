package StringsFirstAssignments;

public class Part1 {

    // findSimpleGene
    public String findSimpleGene(String dna) {

        // Start codon
        final int startIndex = dna.indexOf("ATG");
        if (startIndex == -1) {
            return "";
        }
        //Stop Codon
        final int stopIndex = dna.indexOf("TAA", startIndex + 3);
        if (stopIndex == -1) {
            return "";
        }
        final int lengthOfString = (stopIndex + 3) - startIndex;
        if ((lengthOfString % 3) == 0) {
            return dna.substring(startIndex, stopIndex);
        } else {
            return "No Gene Present";
        }
        }

    public void testSimpleGene(){

        // case1: DNA with no "ATG"
        String gene1 = "ATCATCTAA";
        System.out.println("Checking gene1: " + findSimpleGene(gene1));
        // case2: DNA with no "TAA"
        String gene2 = "ATGTTAATGTTGG";
        System.out.println("Checking gene2: " + findSimpleGene(gene2));
        // case3: DNA with no "ATG" and "TAA"
        String gene3 = "TTTTTGGGGGGTTTTAAA";
        System.out.println("Checking gene3: " + findSimpleGene(gene3));
        // case4: DNA with ATG, TAA and the substring between them is a multiple of 3 (a gene)
        String gene4 = "ATGTTTGGGAAATAA";
        System.out.println("Checking gene4: " + findSimpleGene(gene4));
        // case5: DNA with ATG, TAA and the substring between them is not a multiple of 3
        String gene5 = "ATGTTTGGAAATAA";
        System.out.println("Checking gene5: " + findSimpleGene(gene5));
    }

    public static void main(String[] args) {
        Part1 p1 = new Part1();
        p1.testSimpleGene();
    }

    }