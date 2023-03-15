package StringsSecondAssignments;

import edu.duke.StorageResource;

public class Part3 {
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
    public StorageResource getAllGene(String dna){
        // Create an empty StorageResource, call it geneList
        StorageResource geneList = new StorageResource();
        int startIndex = 0 ;
        while( true ){
            String gene =  findGene(dna, startIndex);
            if(gene.isEmpty()){
                break;
            }
            // Add that gene to geneList
            geneList.add(gene);
            startIndex = dna.indexOf(gene, startIndex) + gene.length();
        }
        return geneList;
    }

    //countGenes
    public int countGenes(String dna){
        int geneOccurence = 0;
        int startIndex = 0 ;
        while( true ) {
            String gene = findGene(dna, startIndex);
            if (gene.isEmpty()) {
                break;
            }
            geneOccurence = geneOccurence + 1;
            startIndex = dna.indexOf(gene, startIndex) + gene.length();
        }
        return geneOccurence;
    }

    //testCountGenes
    public void testCountGene(){
        System.out.println("Number of genes: " + countGenes("ATGTAAGATGCCCTAGTATGTAAGATGCCCTAGTATGTAAGATGCCCTAGT"));
        System.out.println("Number of genes: " + countGenes("ATGTAAGATGCCCTAGT"));
    }

    public void testOn(String dna){
        System.out.println("Testing getAllGenes on ");
        StorageResource genes = getAllGene(dna);
        for(String g: genes.data() ){
            System.out.println(g);
        }
    }

    public static void main(String[] args) {
        Part3 p3 = new Part3();
        p3.testCountGene();
    }
}
