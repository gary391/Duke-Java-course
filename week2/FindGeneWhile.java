package week2;

public class FindGeneWhile {

    public String findGene(String dna) {
        /*
         1. I found the first occurrence of "ATG"  `startIndex`
         2. Find the `TAA` starting from (`startIndex +3`), call this result `currIndex`
         3. As long as currIndex is not equal to -1
                4. check if (`currIndex - startIndex`) is a multiple of 3
                5. if so, the text between startIndex and currIndex + 3 is your answer
                6. if not, update currIndex to the index of the next "TAA", starting (`currIndex + 1`)
                7. Your answer is the empty string
          */
        // I found the first occurrence of "ATG" `startIndex`
        int startIndex = dna.indexOf("ATG");
        // Find the `TAA` starting from (`startIndex + 3`), call this result `currIndex`
        int currIndex = dna.indexOf("TAA", startIndex+3); // This value will be -1 when we are not able to find TAA in the gene.
        // As long as currIndex is not equal to -1 this implies that We are not able to find the TAA in the string.
        while (currIndex != -1) {
            if ((currIndex - startIndex) % 3 == 0) {
                return dna.substring(startIndex, currIndex+3);
            } else {
                currIndex = dna.indexOf("TAA", currIndex+1);
            }
        }
        return "";
    }

    public static void main(String[] args) {
        FindGeneWhile fdGene = new FindGeneWhile();
        System.out.println("Find the gene in this sequence: ");
        System.out.println(fdGene.findGene("ATGAACTGCTAAATT"));
    }
}
