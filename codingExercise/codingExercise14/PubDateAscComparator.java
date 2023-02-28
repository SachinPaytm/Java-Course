package codingExercise.codingExercise14;

import java.util.Comparator;

public class PubDateAscComparator implements Comparator{

    @Override
    public int compare(Object first,Object second) {
        int firstYear = ((Book)first).getYear();
        int secondYear = ((Book)second).getYear();
        if(firstYear>secondYear){
            return 1;
        }
        else if(firstYear<secondYear){
            return  -1;
        }
        return ((Book)first).getTitle().compareTo(((Book)second).getTitle());
    }
}