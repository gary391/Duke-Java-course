package week3;

import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class WhichCountriesExport {
    public void listExporters(CSVParser parser, String exportOfInterest){
        // For each row in the CSV file
        for(CSVRecord record: parser) {
            // Look at the export column
            String export = record.get("Exports");
            // Check if it contains exportOfInterest

            if(export.contains(exportOfInterest)){
                // If so, write down the name of country from that row
                String country = record.get("Country");
                System.out.println(country);
            }

        }
    }
    public void whoExportsCoffee(){
        FileResource fr = new FileResource();
        CSVParser Parser = fr.getCSVParser();
        listExporters(Parser, "coffee");
    }


    public String countryInfo (CSVParser parser, String country){
        // Germany: motor vehicles, machinery, chemicals: $1,547,000,000,000
        String info = null;
        for(CSVRecord record: parser) {

            // Look at the country column
            String data = record.get("Country");
//            System.out.println("country: " + country);
            if(data.contains(country)){
                return (data + ": " + record.get("Exports") + ": " + record.get("Value (dollars)"));
            }
        }
        return "NOT FOUND";
    }

    public void tester(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
//        parser = fr.getCSVParser();
//        System.out.println(countryInfo(parser, "Nauru"));
//        listExportersTwoProducts(parser,"fish", "nuts" );
//        System.out.println(numberOfExporters(parser, "sugar"));
        bigExporters(parser, "$999,999,999,999");

    }

    public void listExportersTwoProducts (CSVParser parser, String exportItem1, String exportItem2){

        for(CSVRecord record: parser) {
            // Look at the export column
            String export = record.get("Exports");
            // Check if it contains exportOfInterest

            if(export.contains(exportItem1) & export.contains(exportItem2)) {
                // If so, write down the name of country from that row
                String country = record.get("Country");
//                System.out.println(country);
                System.out.println(country);
            }

        }


    }

    public int numberOfExporters(CSVParser parser, String exportItem){
        int count = 0;
        for(CSVRecord record: parser) {
            // Look at the export column
            String export = record.get("Exports");
            // Check if it contains exportOfInterest
            if(export.contains(exportItem)){
                // If so, write down the name of country from that row
                String country = record.get("Country");
                count = count + 1;
            }
        }
    return count;
    }

    public void bigExporters(CSVParser parser, String marketCap){
        for(CSVRecord record: parser) {
            // Look at the export column
            String export = record.get("Value (dollars)");
            if (export.length() > marketCap.length()) {
                String country = record.get("Country");
                System.out.print(country);
                System.out.println(" " + export);
            }
        }

    }

    public static void main(String[] args) {
        WhichCountriesExport wce = new WhichCountriesExport();
//        wce.whoExportsCoffee();
        wce.tester();

    }

}
