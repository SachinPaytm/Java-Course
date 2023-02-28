package codingExercise.codingExercise10;

import java.lang.reflect.Method;

public class SimpleUnitTester {

    public int execute(Class clazz) throws Exception {
        int failedCount = 0;
        final String TEST = "test";
        // your code
        //System.out.println(clazz.getName());
        //Object instance = clazz.newInstance();        depricated

        Object instance = null;
        try {
            instance = clazz.getDeclaredConstructor().newInstance();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        for(Method method:clazz.getDeclaredMethods()){
            String methodName = method.getName();
            System.out.println("Method name: " + methodName);
            if(methodName.length()>=4 && methodName.substring(0,TEST.length()).equals(TEST)
                    && method.getReturnType()==boolean.class){
                Object result = method.invoke(instance);
                System.out.println("result : "+ result.equals(false));
                if(result.equals(false)) {
                    failedCount++;
                }
            }
            else{
            }
        }
        System.out.println(failedCount);
        return failedCount;
    }

}