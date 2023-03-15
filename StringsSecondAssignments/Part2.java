package StringsSecondAssignments;

public class Part2 {
    public int howMany(String stringa, String stringb) {
        //“GAA”, “ATGAACGAATTGAATC”) returns 3
        //(“AA”, “ATAAAA”) returns 2
        int totalOccurence = 0;
        int startIndex = 0;

        while(true) {
            int currIndex = stringb.indexOf(stringa,startIndex);
//            System.out.println(currIndex);
            if(currIndex ==-1){ // If stringa is not in stringb
                break;
            }
            totalOccurence = totalOccurence + 1;
            startIndex = currIndex+stringa.length(); // Moving the startIndex
        }
        return totalOccurence;
    }

    // testHowMany
    public void testHowMany (){
        System.out.println("Number of appearences: " + howMany("AA", "ATAAAAAATAAA"));
        System.out.println("Number of appearences: " + howMany("GG", "ATAAAAGGTAAA"));
        System.out.println("Number of appearences: " + howMany("TA", "ATTAATATTTAA"));
    }
    public static void main(String[] args) {
        Part2 p2 = new Part2();
        p2.testHowMany();
    }
}
