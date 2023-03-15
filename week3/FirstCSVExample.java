package week3;

import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class FirstCSVExample {

    public void readFood(){
        // File resource object - As there are no resources it will pop up a dialogue
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser(); //  File resource object to get the getCSVParser
        for(CSVRecord record : parser){
            System.out.print(record.get("Name") + " ");  // This the header of the csv.
            System.out.print(record.get("Favorite Color") + " ");
            System.out.print(record.get("Favorite Number") + " ");
            System.out.println(record.get("Favorite Food"));
        }
    }

    public static void main(String[] args) {
        FirstCSVExample fcsv = new FirstCSVExample();
        fcsv.readFood();
    }
}
