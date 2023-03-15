package week2;

public class AllCodons {


        public int findStopCodon(String dnaStr, int startIndex, String stopCodon){

       // ##### Split the method into two method, as there can be three stop codon `TAA`,`TGA`,`TAG`
       // ##### Find stop codon method

        // 3. Find the `stopCodon` starting from (`startIndex +3`), call this result `currIndex`
            int currIndex = dnaStr.indexOf(stopCodon,startIndex +3 );
//        4. As long as `currIndex` is not equal to  -1
                while(currIndex != -1) {
                    int diff = currIndex - startIndex;
                    if(diff % 3 == 0){
                        return currIndex;
                    } else {
                        currIndex = dnaStr.indexOf(stopCodon, currIndex+1);

                    }
                }
//                return dnaStr.length();
                return -1;

//            5. check if (`currIndex - startIndex`) is a multiple of 3
//                6. if so, currIndex is your answer.
//                7. if not, update currIndex to the index of the next `stopCodon`, starting (`currIndex + 1`)
//        8. Your answer is the string.length() imples that it is largest of all the three value. If minIndex is the lengthOf dna that means that no codon was found
//        ---
//        3. findStopCodon(dnaStr, startIndex, "TAA") and call the result taaIndex
//        4. findStopCodon(dnaStr, startIndex, "TAG") and call the result tagIndex
//        5. findStopCodon(dnaStr. startIndex, "TGA") and call the result tgaIndex
//        6. Take the smallest of taaIndex, tagIndex, tgaIndex: Call in minIndex
//        7. Your answer is the text from startIndex to minIndex+3


    }
    public String findGene(String dna, int where) {
        // find the first occurrence of "ATG", startIndex
        int startIndex = dna.indexOf("ATG", where);
        if (startIndex == -1) {
            return "";
        }
        int taaIndex = findStopCodon(dna, startIndex, "TAA");
        int tgaIndex = findStopCodon(dna, startIndex, "TGA");
        int tagIndex = findStopCodon(dna, startIndex, "TAG");
//        int temp = Math.min(taaIndex, tgaIndex);
//        int minIndex = Math.min(temp, tagIndex);
        int minIndex = 0;
        if (taaIndex == -1 || (tgaIndex != -1 && tgaIndex < taaIndex)) {
            minIndex = tgaIndex;
        } else {
            minIndex = taaIndex;
        }

        if (minIndex == -1 || (tagIndex != -1 && tagIndex < minIndex)) {
            minIndex = tagIndex;
            if (minIndex == -1) {
                return "";
            }
//        if (minIndex == dna.length()){
//            return "";
//        } else {
        }
        return dna.substring(startIndex, minIndex + 3);
    }

    // Method that will print out all the genes in a sequence

    public void printAllGenes(String dna) {
            // Set StartIndex to 0
        int startIndex = 0;
        // Repeat the following steps
        while (true) {
            // find the next gene after startIndex
            String gene = findGene(dna, startIndex);
            // If no gene was found, leave this loop
            if(gene.isEmpty()){
                break;
            }
            // print that gene out
            System.out.println(gene);

            // set startIndex to just past the end of the gene
            startIndex = dna.indexOf(gene, startIndex) + gene.length();
        }




    }
    public void testFindGene() {
        /*
        1. I found the first occurrence of "ATG"  `startIndex`
        2. If `startIndex` is -1, then your answer is the empty string.
        */
//        String dna = "zzzxxxyyyyTAAzzzxxxyyyyTAAxx";
//        int dex = findStopCodon(dna, 0, "TAA");
//        System.out.println(dex);
        String dna = "ATGCCCGGGAAATAACCC";
        String gene = findGene(dna, 0);
        if(!gene.equals("ATGCCCGGGAAATAA")) {
            System.out.println("error");
        }
        System.out.println("test finished!");
    }

    public static void main(String[] args) {
        AllCodons alc = new AllCodons();
        alc.testFindGene();
    }
}
