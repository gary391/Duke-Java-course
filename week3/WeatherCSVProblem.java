package week3;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;

public class WeatherCSVProblem {
    // CSVRecord hottestHourInFile
    public CSVRecord hottestHourInFile(CSVParser parser) {
        // Start with largestSoFar as nothing
        // We need to return this value
        CSVRecord largestSoFar = null;
        // For each row (currentRow) in the CSV file
        for(CSVRecord currentRow: parser){
            // If largestSoFar is nothing
//            if (largestSoFar == null){
//                largestSoFar = currentRow; // Here we are assigning the currentRow to largestSoFar to the currentRow
//                // Otherwise
//            } else {
//
//                double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
//                double largestTemp = Double.parseDouble(largestSoFar.get("TemperatureF"));
//                // Check if the curretRow's Temperature > largestSoFar
//                if (currentTemp > largestTemp) {
//                    largestSoFar = currentRow;
//                }
//            }
            largestSoFar = getLargestOfTwo(currentRow, largestSoFar);
        }
        return largestSoFar;
    }
    // Test method
    public void testHottestInDay (){
        // FileResource
        FileResource fr = new FileResource("/Users/gauyada/WorkDocs/03_KNOWLEDGE/42_DUKE_JAVA/src/nc_weather/2015/weather-2015-01-02.csv");
        CSVRecord largest = hottestHourInFile(fr.getCSVParser());
        System.out.println("Hottest Temperature was " + largest.get("TemperatureF") + " at " + largest.get("TimeEST"));
    }

    public CSVRecord getLargestOfTwo (CSVRecord currentRow, CSVRecord largestSoFar) {

        if (largestSoFar == null){
            largestSoFar = currentRow; // Here we are assigning the currentRow to largestSoFar to the currentRow
            // Otherwise
        } else {

            double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
            double largestTemp = Double.parseDouble(largestSoFar.get("TemperatureF"));
            // Check if the curretRow's Temperature > largestSoFar
            if (currentTemp > largestTemp) {
                largestSoFar = currentRow;
            }
        }
        return largestSoFar;

    }

    public void testHottestInManyDays(){
        CSVRecord largest =  hottestInManyDays();
        System.out.println("hottest temperature was " + largest.get("TemperatureF") + " at " + largest.get("TimeEDT"));
    }
    // Hottest in many dates
    public CSVRecord hottestInManyDays() {
        CSVRecord largestSoFar = null;
        // Allow to select any number of files to compare at the same time.
        DirectoryResource dr = new DirectoryResource();
        // Iterate over files
        for (File f : dr.selectedFiles()) {
            // New file resource using the file from the directory each file at a time
            FileResource fr = new FileResource(f);

            // use method to get largest in file
            CSVRecord currentRow = hottestHourInFile(fr.getCSVParser());
            // The largestSoFar is the answer
            largestSoFar = getLargestOfTwo(currentRow, largestSoFar);

        }
        return largestSoFar;
    }

    public static void main(String[] args) {
        WeatherCSVProblem wsp = new WeatherCSVProblem();
//        wsp.testHottestInDay();
        wsp.testHottestInManyDays();

    }
}
