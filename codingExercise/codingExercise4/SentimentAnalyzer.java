package codingExercise.codingExercise4;

import java.util.Arrays;

public class SentimentAnalyzer {
    // Tip: labeled continue can be used when iterating featureSet + convert review to lower-case
    public static int[] detectProsAndCons(String review, String[][] featureSet, String[] posOpinionWords,
                                          String[] negOpinionWords) {
        int[] featureOpinions = new int[featureSet.length]; // output
        review = review.toLowerCase();
//        System.out.println(review);
        // your code ~ you will be invoking getOpinionOnFeature
        for(int i = 0;i<featureSet.length;i++){
            int opinion = 0;
            for(String feature:featureSet[i]){
                int data = getOpinionOnFeature(review,feature,posOpinionWords,negOpinionWords);
                if(data==1){
                    opinion = data;
                    break;
                }
                else if(data==-1){
                    opinion = -1;
                }
//                System.out.println(data);
            }

//            System.out.println(featureSet[i].toString());
            featureOpinions[i] = opinion;
        }

        return featureOpinions;
    }

    // First invoke checkForWasPhrasePattern and
    // if it cannot find an opinion only then invoke checkForOpinionFirstPattern
    private static int getOpinionOnFeature(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {

        // your code
        int checkForWasPhrasePattern = checkForWasPhrasePattern(review,feature,posOpinionWords,negOpinionWords);
        int checkForOpinionFirstPattern = checkForOpinionFirstPattern(review,feature,posOpinionWords,negOpinionWords);
        if(checkForWasPhrasePattern==1 || checkForOpinionFirstPattern==1) return 1;
        if(checkForWasPhrasePattern==-1 || checkForOpinionFirstPattern==-1) return -1;
        return 0;

    }

    // Tip: Look at String API doc. Methods like indexOf, length, substring(beginIndex), startsWith can come into play
    // Return 1 if positive opinion found, -1 for negative opinion, 0 for no opinion
    // You can first look for positive opinion. If not found, only then you can look for negative opinion
    private static int checkForWasPhrasePattern(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {
        int opinion = 0;
        String pattern = feature + " was ";

        // your code
        for(String posOpinionWord:posOpinionWords){
            String finalPattern = (pattern + posOpinionWord).toLowerCase();
            if(review.indexOf(finalPattern)>=0){
                return 1;
            }
        }
        for(String negOpinionWord:negOpinionWords){
            String finalPattern = (pattern + negOpinionWord).toLowerCase();
            if(review.indexOf(finalPattern)>=0){
                return -1;
            }
        }

        return opinion;
    }

    // You can first look for positive opinion. If not found, only then you can look for negative opinion
    private static int checkForOpinionFirstPattern(String review, String feature, String[] posOpinionWords,
                                                   String[] negOpinionWords) {
        // Extract sentences as feature might appear multiple times.
        // split() takes a regular expression and "." is a special character
        // for regular expression. So, escape it to make it work!!
        String[] sentences = review.split("\\.");
        int opinion = 0;
        String pattern = " "+feature;
        // your code for processing each sentence. You can return if opinion is found in a sentence (no need to process subsequent ones)
        for(String posOpinionWord:posOpinionWords){
            String finalPattern = (posOpinionWord+pattern).toLowerCase();
//            System.out.println(finalPattern);
            if(review.indexOf(finalPattern)>=0){
                return 1;
            }
        }
        for(String negOpinionWord:negOpinionWords){
            String finalPattern = (negOpinionWord+pattern).toLowerCase();
            if(review.indexOf(finalPattern)>=0){
                return -1;
            }
        }
        return opinion;
    }

    public static void main(String[] args) {
        String review = "Haven't been here in years! Fantastic service and the food was delicious! Definetly will be a frequent flyer! Francisco was very attentive";

        //String review = "Sorry OG, but you just lost some loyal customers. Horrible service, no smile or greeting just attitude. The breadsticks were stale and burnt, appetizer was cold and the food came out before the salad.";

        String[][] featureSet = {
                { "ambiance", "ambience", "atmosphere", "decor" },
                { "dessert", "ice cream", "desert" },
                { "food" },
                { "soup" },
                { "service", "management", "waiter", "waitress", "bartender", "staff", "server" } };
        String[] posOpinionWords = { "good", "fantastic", "friendly", "great", "excellent", "amazing", "awesome",
                "delicious" };
        String[] negOpinionWords = { "slow", "bad", "horrible", "awful", "unprofessional", "poor" };

        int[] featureOpinions = detectProsAndCons(review, featureSet, posOpinionWords, negOpinionWords);
        System.out.println("Opinions on Features: " + Arrays.toString(featureOpinions));
    }
}