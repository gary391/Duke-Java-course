package StringsSecondAssignments;

public class Part1 {
    public int findStopCodon (String dnaStr, int startIndex, String stopCodon) {
        // This is the currIndex
        //    1  2  3  4  5  6  7  8
        //'ATGAAATTTGGGATAAGGGCCCTTTTTAAA'
        int currIndex = dnaStr.indexOf(stopCodon, startIndex+3);

        while(currIndex != -1 ){
            int diff = currIndex - startIndex;
            if(diff %3 ==0){
                return  currIndex;
            } else
                currIndex = dnaStr.indexOf(stopCodon, currIndex+1);
        }
    return dnaStr.length();
    }
    public void testFindStopCodon(){
        String dna = "zzzxxxyyyyTAAzzzxxxyyyyTAAxx";
        int dex = findStopCodon(dna, 0, "TAA");
        System.out.println(dex);
    }

    public String findGene (String dna, int where){
        int startIndex = dna.indexOf("ATG", where);
        if(startIndex == -1){
            return "";
        }
        // Find the first occurance of stopcodon taa
        int taaIndex = findStopCodon(dna, startIndex, "TAA");
        int tgaIndex = findStopCodon(dna, startIndex, "TGA");
        int tagIndex = findStopCodon(dna, startIndex, "TAG");

        int temp = Math.min(taaIndex, tgaIndex);
        int minIndex = Math.min(temp, tagIndex);
        System.out.println("Length of dna: " + dna.length());
        if(minIndex != dna.length()) { // Unable to find the minIndex
            return dna.substring(startIndex, minIndex+3);

        } else {
            return "";
        }
    }

    public void testFindGene(){
        String dna = "ATGCCCGGGAAATAACCC";
        String dna1 = "ATGCCCGGGAAATAACCCATGCCCGGGAAATAACCCATGCCCGGGAAATAACCCATGCCCGGGAAATAACCCATGCCCGGGAAATAACCC";
        String gene = findGene(dna, 0);
        printAllGene(dna1);
        if(!gene.equals("ATGCCCGGGAAATAA")) {
            System.out.println("error");
        }
        System.out.println("test finished!");
    }

    public void printAllGene(String dna){
        int startIndex = 0 ;
         while( true ){
             String gene =  findGene(dna, startIndex);
             if(gene.isEmpty()){
                break;
             }
             System.out.println("Gene is: "+ gene);
             startIndex = dna.indexOf(gene, startIndex) + gene.length();
         }

    }

    public static void main(String[] args) {
        Part1 p1 = new Part1();
//        p1.testFindStopCodon();
        p1.testFindGene();

    }
}
