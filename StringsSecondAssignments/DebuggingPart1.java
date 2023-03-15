package StringsSecondAssignments;

public class DebuggingPart1 {
    public void findAbc(String input) {
        int index = input.indexOf("abc");
        while (true) {
//            if(index == -1 ) {
            System.out.println("input length: " + input.length());
            System.out.println("input.length() - 3:  " + (input.length() - 3));
            if (index == -1 || index >= input.length() - 3) {
                System.out.println("index after updating " + index);
                break;
            }

            String found = input.substring(index+1, index+4);
            System.out.println("Found is: " + found);
            index = input.indexOf("abc", index+3);
            System.out.println("Index is: " + index);

        }
    }
    public void test() {
//        findAbc("abcd");
//        findAbc("abcdabc");
//        findAbc("eusabce");
//        findAbc("abcbbbabcdddabc");
//        findAbc("yabcyabc");
//        findAbc("abcabcabcabca");
        findAbc("abcdkfjsksioehgjfhsdjfhksdfhuwabcabcajfieowj");
    }

    public static void main(String[] args) {
        DebuggingPart1 dbp1 = new DebuggingPart1();
        dbp1.test();
    }
}
