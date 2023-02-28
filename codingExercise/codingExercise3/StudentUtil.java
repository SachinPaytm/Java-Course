package codingExercise.codingExercise3;
public class StudentUtil {

    public static double[] calculateGPA(int[] studentIdList, char[][] studentsGrades) {
        // your code
        double[] studentGPA = new double[studentIdList.length];
        for(int i = 0;i<studentIdList.length;i++){
            double total = 0;
            int length = 0;
            for (char studentsGrade:studentsGrades[i]) {
                //System.out.print(studentsGrade);
                switch (studentsGrade){
                    case 'A': total+=4;break;
                    case 'B': total+=3;break;
                    case 'C': total+=2;break;
                    default: break;
                }
                length++;
            }
            studentGPA[i] = total/length;
            //System.out.println(studentGPA[i]);
        }
        return studentGPA;
    }

    public static int[] getStudentsByGPA(double lower, double higher, int[] studentIdList, char[][] studentsGrades) {
        // perform parameter validation. Return null if passed parameters are not valid
        if(lower>higher || lower<0 || higher<0) return  null;
        // invoke calculateGPA
        double[] studentGPA = calculateGPA(studentIdList,studentsGrades);
        // construct the result array and return it. You would need an extra for loop to compute the size of the resulting array
        //System.out.println(studentGPA);
        int len = 0;
        for(int i = 0;i<studentIdList.length;i++){
            if(studentGPA[i]>=lower && studentGPA[i]<=higher){
                len++;
            }
        }
        int[] studentId = new int[len];
        int index = 0;
        for(int i =0;i<studentIdList.length;i++){
            if(studentGPA[i]>=lower && studentGPA[i]<=higher){
                studentId[index++] = studentIdList[i];
            }
        }
        return studentId;
    }

}