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

    public CSVRecord coldestHourInFile(CSVParser parser){
        CSVRecord smallestSoFar = null;
        for(CSVRecord currentRow: parser){
            // If largestSoFar is nothing
            if (smallestSoFar == null){
                smallestSoFar = currentRow; // Here we are assigning the currentRow to largestSoFar to the currentRow
                // Otherwise
            } else {
                double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                double smallestTemp = Double.parseDouble(smallestSoFar.get("TemperatureF"));
                // Check if the curretRow's Temperature < smallestSoFar
                if (currentTemp != -9999 && currentTemp < smallestTemp) {
                    smallestSoFar = currentRow;

                }
            }
        }
        return smallestSoFar;
    }

    public String fileWithColdestTemperature(){
        CSVRecord smallestSoFar = null;
        // Allow to select any number of files to compare at the same time.
        DirectoryResource dr = new DirectoryResource();
        // Iterate over files
        String fileName = null;
        for (File f : dr.selectedFiles()) {
            // New file resource using the file from the directory each file at a time
            FileResource fr = new FileResource(f);
            // use method to get smallest in file
            CSVRecord currentRow = coldestHourInFile(fr.getCSVParser());
            // The smallestSoFar is the answer
            if (smallestSoFar == null){
                smallestSoFar = currentRow; // Here we are assigning the currentRow to largestSoFar to the currentRow
                // Otherwise
            } else {
                double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                double smallestTemp = Double.parseDouble(smallestSoFar.get("TemperatureF"));
                // Check if the curretRow's Temperature < smallestSoFar
                if (currentTemp < smallestTemp) {
                    smallestSoFar = currentRow;
                    fileName = f.getName();
                }
            }
        }

        return fileName;

    }

    public void testFileWithColdestTemperature(){
        String smallestFile =  fileWithColdestTemperature();
        System.out.println("Coldest day was in file " + smallestFile);
        FileResource fr = new FileResource("/Users/gauyada/WorkDocs/03_KNOWLEDGE/42_DUKE_JAVA/src/nc_weather/2014/" + smallestFile);
        CSVRecord coldestHour =  coldestHourInFile(fr.getCSVParser());
        System.out.println("Coldest temperature on that day was " + coldestHour.get("TemperatureF"));
        System.out.println("All the Temperatures on the coldest day were: ");
        for(CSVRecord currentRow: fr.getCSVParser()){
//            System.out.println(currentRow);
            System.out.println(currentRow.get("DateUTC") + ": " + currentRow.get("TemperatureF"));
        }



    }


    public void testColdestHourInFile(){
        FileResource fr = new FileResource("/Users/gauyada/WorkDocs/03_KNOWLEDGE/42_DUKE_JAVA/src/nc_weather/2014/weather-2014-05-01.csv");
        CSVRecord coldestHour =  coldestHourInFile(fr.getCSVParser());
        System.out.println("Coldest temperature was " + coldestHour.get("TemperatureF") + " at " + coldestHour.get("TimeEDT"));
    }

    public CSVRecord humidistHourInFile(CSVParser parser){
        CSVRecord smallestSoFar = null;
        for(CSVRecord currentRow: parser){
            // If largestSoFar is nothing
            if (smallestSoFar == null){
                smallestSoFar = currentRow; // Here we are assigning the currentRow to largestSoFar to the currentRow
                // Otherwise
            } else {
                try{
                    double currentTemp = Double.parseDouble(currentRow.get("Humidity"));
                    double smallestTemp = Double.parseDouble(smallestSoFar.get("Humidity"));
                    if (currentTemp < smallestTemp) {
                        smallestSoFar = currentRow;
                    }
                } catch (NumberFormatException ex){
                    System.out.println("Exception"+ ex);
                }

                // Check if the curretRow's Temperature < smallestSoFar


                }
            }
        return smallestSoFar;
    }

    public CSVRecord lowestHumidityInManyFiles(){
        CSVRecord smallestSoFar = null;
        // Allow to select any number of files to compare at the same time.
        DirectoryResource dr = new DirectoryResource();
        // Iterate over files
//        String fileName = null;
        for (File f : dr.selectedFiles()) {
            // New file resource using the file from the directory each file at a time
            FileResource fr = new FileResource(f);
            // use method to get smallest in file
            CSVRecord currentRow = humidistHourInFile(fr.getCSVParser());
            // The smallestSoFar is the answer
            if (smallestSoFar == null){
                smallestSoFar = currentRow; // Here we are assigning the currentRow to largestSoFar to the currentRow
                // Otherwise
            } else {
                double currentTemp = Double.parseDouble(currentRow.get("Humidity"));
                double smallestTemp = Double.parseDouble(smallestSoFar.get("Humidity"));
                // Check if the curretRow's Temperature < smallestSoFar
                if (currentTemp < smallestTemp) {
                    smallestSoFar = currentRow;
//                    fileName = f.getName();
                }
            }
        }

        return smallestSoFar;

    }

    public void testLowestHumidityInManyFiles(){
        CSVRecord lowest =  lowestHumidityInManyFiles();
        System.out.println("Lowest Humidity was " + lowest.get("Humidity") + " at " + lowest.get("DateUTC"));
    }

    public double averageTemperatureInFile(CSVParser parser){
        double avgTemp = 0;
        int count = 0;
        for(CSVRecord currentRow: parser){
            double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
            avgTemp = avgTemp + currentTemp;
            count = count + 1;
                }
        return avgTemp/count;
        }



    public void testAverageTemperatureInFile() {
        FileResource fr = new FileResource("/Users/gauyada/WorkDocs/03_KNOWLEDGE/42_DUKE_JAVA/src/nc_weather/2014/weather-2014-06-01.csv");
        double averageTemp = averageTemperatureInFile(fr.getCSVParser());
        System.out.println("Average temperature in file is " + averageTemp);
    }

//    public double averageTemperatureWithHighHumidityInFile(CSVParser parser, int humidValue){
    public double averageTemperatureWithHighHumidityInFile(CSVParser parser, int humidValue) {
        double avgTemp = 0;
        int count = 0;
        for (CSVRecord currentRow : parser) {
            if (Integer.parseInt(currentRow.get("Humidity")) > humidValue) {
                double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                avgTemp = avgTemp + currentTemp;
                count = count + 1;
            }
        }
        if(count > 0 ){
            System.out.println("value: " + avgTemp / count);
            return avgTemp / count;
        } else {
            return 0d;
        }

    }
    public void testAverageTemperatureWithHighHumidityInFile(){
        FileResource fr = new FileResource("/Users/gauyada/WorkDocs/03_KNOWLEDGE/42_DUKE_JAVA/src/nc_weather/2014/weather-2014-03-30.csv");
        double averageTemp = averageTemperatureWithHighHumidityInFile(fr.getCSVParser(), 80);
//        double averageTemp = averageTemperatureWithHighHumidityInFile(fr.getCSVParser());
        if(averageTemp != 0d){
            System.out.println("Average temperature when high Humidity is " + averageTemp);
        } else{
            System.out.println("No temperatures with that humidity");
        }

    }
    public static void main(String[] args) {
        WeatherCSVProblem wsp = new WeatherCSVProblem();
//        wsp.testHottestInDay();
//        wsp.testHottestInManyDays();
//        wsp.testColdestHourInFile();
//        wsp.testFileWithColdestTemperature();
//        wsp.testLowestHumidityInManyFiles();
//        wsp.testAverageTemperatureInFile();
        wsp.testAverageTemperatureWithHighHumidityInFile();


    }
}
