package StringsFirstAssignments;

import edu.duke.URLResource;

//        String x = "hel!";
//        String y = "hello";
//        x.regaionMatches({x index}, {y string}, {y index}, {length of string that needs matching})
//        System.out.println(x.regionMatches(0, y,0,3));
public class Part4 {

    // Method to read the url using URLResource
    public String URL = "https://www.dukelearntoprogram.com//course2/data/manylinks.html";
    public String YOUTUBE = "youtube.com";
    public void urlReader () {
        // read the url using URLResource
        URLResource ur = new URLResource(URL);
        // reading word by word
        for(String word: ur.words()){
//            System.out.println(word);
            // Find "youtube.com" in the list of words
            // 1. Check if the word has youtube in it.
            // 2. Find the first and last occurrence of "" to get the youtube url.
            String newWord = word.toLowerCase();
            if (newWord.regionMatches(17, YOUTUBE, 0, YOUTUBE.length())){
//                System.out.println(word);
//                System.out.println(.indexOf("\"")); // First occurrence
//                System.out.println(newWord.lastIndexOf("\"")); // Last occurrence
                System.out.println(word.substring(word.indexOf("\"")+1, word.lastIndexOf("\"")));
            }
        }
    }

    public static void main(String[] args) {
        Part4 p4 = new Part4();
        p4.urlReader();
    }
}
