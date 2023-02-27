package StringsFirstAssignments;

public class Part3 {

    public boolean twoOccurrences (String stringa, String stringb) {
        /*
        twoOccurrences(“by”, “A story by Abby Long”
        true
        twoOccurrences(“a”, “banana”)
        true
        twoOccurrences(“atg”, “ctgtatgta”)
        false
         */
        /*
         Use String built in method called regionMatches
         */
        int occurCount = 0;
        for(int i=0; i<=stringb.length(); i++) {
            if (stringa.regionMatches(0, stringb, i, 1)){
                occurCount = occurCount + 1;
            }

        }
        if(occurCount > 2){
            return true;
        } else {
            return false;
        }

    }

    public String lastPart(String stringa, String stringb) {
        /*lastPart(“an”, “banana”)
         */
        int index = 0;
        String remainPart = "";
        for (int i = 0; i <= stringb.length(); i++) {
//            System.out.println("Print value of i: " + i);
            if (stringa.regionMatches(0, stringb, i, 1)){
                index =i;
                break;
            }
        }
        if (index != 0){
            remainPart = stringb.substring(index+stringa.length());
            return remainPart;
        } else {
            return stringb;
        }

    }
    public static void main(String[] args) {


//        String x = "hel!";
//        String y = "hello";
//        x.regaionMatches({x index}, {y string}, {y index}, {length of string that needs matching})
//        System.out.println(x.regionMatches(0, y,0,3));
        Part3 p3 = new Part3();
//        System.out.println(p3.twoOccurrences("a", "banann"));
//        System.out.println(p3.twoOccurrences("atg", "ctgtatgtatgatg"));
//        System.out.println(p3.twoOccurrences("by", "A story by Abby Long"));
//        System.out.println(p3.lastPart("ana", "banana"));
//        System.out.println(p3.lastPart("an", "banana"));
        System.out.println(p3.lastPart("zoo", "forest"));

    }

}
