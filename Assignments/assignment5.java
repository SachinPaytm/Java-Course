package Assignments;

import java.util.Arrays;

public class assignment5 {
    public static void main(String[] args) {
        String[] grades = {"one"," two"," three"," four"};

        StringBuilder concat = Arrays.stream(grades)
                .reduce(new StringBuilder(),
                        (sb, s) -> sb.append(s),
                        (sb1, sb2) -> sb1.append(sb2));

        StringBuilder concat2 = Arrays.stream(grades)
                .map(StringBuilder::new)
                .reduce(new StringBuilder(),
                        (sb1, sb2) -> sb1.append(sb2));


        System.out.println(concat);
        System.out.println(concat2);


//        StringBuilder concat3 = new StringBuilder(Arrays.stream(grades)
//                .reduce(String.valueOf((new StringBuilder())),
//                        (sb1, s) -> String.valueOf((new StringBuilder().append(sb1).append(s)))));
//        System.out.println(concat3);


//        StringBuilder concat4 = Arrays.stream(grades)
//                .collect(StringBuilder::new,
//                        StringBuilder::append,
//                        StringBuilder::append);
//
//        System.out.println(concat4);



    }
}
