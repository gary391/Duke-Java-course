package week4;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import org.apache.commons.csv.CSVRecord;

import java.io.File;

public class BabyBirths {
    /*
    Write a description of class BabyBirths here

     */
    public void printNames() {
        // Which file to open
        FileResource fr = new FileResource();
        // Iterate over the records
        for (CSVRecord rec : fr.getCSVParser(false)) {

            // print out the name if the number born are under a certain value.
            int numBorn = Integer.parseInt(rec.get(2));
            if(numBorn >= 100) {
                System.out.println("Name " + rec.get(0) +
                        " Gender " + rec.get(1) +
                        " Number Born " + rec.get(2));
            }
        }
    }

    public void totalBirths(FileResource fr) {
        int totalBirths = 0;
        for (CSVRecord rec : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(rec.get(2));
            totalBirths = totalBirths + numBorn;
        }
        System.out.println("Total births: " + totalBirths);
        totalMaleBorn (fr);
        totalGirlBorn (fr);
    }
    public void totalMaleBorn (FileResource fr) {
        int totalMaleBorn = 0;
        for (CSVRecord rec : fr.getCSVParser(false)) {
            if(rec.get(1).equals("M")){
                int numBorn = Integer.parseInt(rec.get(2));
                totalMaleBorn = totalMaleBorn + numBorn;
            }

        }
        System.out.println("Total Male births: " + totalMaleBorn);
    }
    public void totalGirlBorn (FileResource fr) {
        int totalGirlBorn = 0;
        for (CSVRecord rec : fr.getCSVParser(false)) {
            if(rec.get(1).equals("F")){
                int numBorn = Integer.parseInt(rec.get(2));
                totalGirlBorn = totalGirlBorn + numBorn;
            }

        }
        System.out.println("Total Girl births: " + totalGirlBorn);
    }
    public void testTotalBirths(){
        FileResource fr = new FileResource("/Users/gauyada/WorkDocs/03_KNOWLEDGE/42_DUKE_JAVA/src/week4/babyNames/data/example-small.csv");
        totalBirths(fr);

    }

    public void getBoyRank(FileResource fr){
        int rankIs;

        for (CSVRecord rec : fr.getCSVParser(false)) {
            if(rec.get(1).equals("M")){


            }
        }
    }
    public void testGetBoyRank() {
        FileResource fr = new FileResource("/Users/gauyada/WorkDocs/03_KNOWLEDGE/42_DUKE_JAVA/src/week4/babyNames/data/example-small.csv");
        getBoyRank(fr);
    }

    public int getRank(int year, String name, String gender){
        int rankIs = 0;
        int foundIt = 0;
        String file = "yob" + year + ".csv";
        FileResource fr = new FileResource( "/Users/gauyada/WorkDocs/03_KNOWLEDGE/42_DUKE_JAVA/src/week4/babyNames/data/" + file);
        for (CSVRecord rec : fr.getCSVParser(false)) {
            if(rec.get(1).equals(gender)){
                rankIs = rankIs + 1;
                if(rec.get(0).equals(name)) {
                    foundIt = 1;
                    break;
                }
            }
        }
        if(foundIt == 1) {
            return rankIs;
        } else {
            return -1;
        }
    }

    public String getName(int year, int rank, String gender){
        int rankIs = 0;
        int foundIt = 0;
        String nameFound = null;
        String file = "yob" + year + ".csv";
        FileResource fr = new FileResource( "/Users/gauyada/WorkDocs/03_KNOWLEDGE/42_DUKE_JAVA/src/week4/babyNames/data/" + file);
        for (CSVRecord rec : fr.getCSVParser(false)) {

            if(rec.get(1).equals(gender)){
                rankIs = rankIs + 1;
                if(rankIs == rank) {
                    nameFound = rec.get(0);
                    foundIt = 1;
                    break;
                }

            }
        }
        if(foundIt == 1) {
            return nameFound;
        } else {
            return "NO NAME";
        }
    }

    public void whatIsNameInYear (String name,int year, int newYear, String gender ){
        int nameRank = getRank(year,name, gender);
        String newName = getName(newYear, nameRank, gender);
        System.out.println("%s born in %d would be %s if she was born in %d ".formatted(name, year, newName, newYear));

    }

    public int yearOfHighestRank (String name, String gender){
        int highestRank= 0;
        int highestRankYear = 0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            String yearValue = f.getName();
            int year = Integer.parseInt(yearValue.substring(3,7));
            int tempRank = getRank(year, name,gender);
            if(highestRank == 0  ||  tempRank < highestRank){
                highestRank = tempRank;
                highestRankYear = year;
            }

        }

    return highestRankYear;
    }

    public double getAverage (String name, String gender) {
        double tempSum = 0;
        int count = 0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            String yearValue = f.getName();
            int year = Integer.parseInt(yearValue.substring(3, 7));
            int tempRank = getRank(year, name, gender);
            tempSum = tempSum + tempRank;
            count = count + 1;
        }
        return tempSum / count;
    }
    public int getTotalBirthsRankedHigher (int year, String name, String gender){
        int rankIs = 0;
        int foundIt = 0;
        int birthCount = 0;
        int tempRank =  getRank(year, name, gender);
        System.out.println("tempRank: " + tempRank);
        String file = "yob" + year + ".csv";
        FileResource fr = new FileResource( "/Users/gauyada/WorkDocs/03_KNOWLEDGE/42_DUKE_JAVA/src/week4/babyNames/data/" + file);
        for (CSVRecord rec : fr.getCSVParser(false)) {
            if(rec.get(1).equals(gender)){
                rankIs = rankIs + 1;
                System.out.println(rec.get(0));
                if(rankIs <= tempRank) {
                    foundIt = 1;

                    break;
                }
            }
        }
        if(foundIt == 1) {
            return rankIs;
        } else {
            return -1;
        }
    }

        public static void main (String[]args){
            BabyBirths bb = new BabyBirths();
//        bb.printNames();
//        bb.testTotalBirths();
//        bb.testGetBoyRank();
//        System.out.println(bb.getRank(2012, "Gaurav", "M"));
//        System.out.println(bb.getRank(2012, "Mason", "M"));
//        System.out.println(bb.getName(1973, 1, "M"));
//        bb.whatIsNameInYear("Isabella", 2012, 2014, "F" );
//            System.out.println(bb.yearOfHighestRank("Mason", "M"));
//            System.out.println(bb.getAverage("Jacob", "M"));
            System.out.println(bb.getTotalBirthsRankedHigher(2012, "Ethan", "M"));
        }
    }
