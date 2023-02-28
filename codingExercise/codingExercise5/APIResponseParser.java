package codingExercise.codingExercise5;
public class APIResponseParser {

    /**
     * Parses the input text and returns a Book instance containing
     * the parsed data.
     * @param response text to be parsed
     * @return Book instance containing parsed data
     */
    public static Book parse(String response) {

//        String startRule = "<work>";
//        String endRule = "</work>";
//        response = parse(response,startRule,endRule);
        System.out.println(response);
        Book book = new Book();

        //Title

//        startRule = "<best_book>";
//        endRule = "</best_book>";
//        String bestBook = parse(response, startRule, endRule);
        String startRule = "<title>";
        String endRule = "</title>";
        String title = parse(response,startRule,endRule);
        book.setTitle(title);



//        //author name
//        startRule = "<author>";
//        endRule = "</author>";
//        String author = parse(bestBook,startRule,endRule);

        startRule = "<name>";
        endRule = "</name>";
        String name = parse(response,startRule,endRule);
        book.setAuthor(name);


        startRule = "<image_url>";
        endRule = "</image_url> ";
        String image_url= parse(response,startRule,endRule);
        book.setImageUrl(image_url);


        startRule = "<original_publication_year type=\"integer\">";
        endRule = "</original_publication_year>";
        int original_publication_year = Integer.parseInt(parse(response,startRule,endRule).replaceAll(",",""));;
        book.setPublicationYear(original_publication_year);



        startRule = "<ratings_count type=\"integer\">";
        endRule = "</ratings_count>";
        int ratings_count = Integer.parseInt(parse(response,startRule,endRule).replaceAll(",",""));
        book.setRatingsCount(ratings_count);



        startRule = "<average_rating>";
        endRule = "</average_rating>";
        double average_rating = Double.parseDouble(parse(response,startRule,endRule));
        book.setAverageRating(average_rating);


        // Your code
        return book;
    }

    /*
    public static String parseName(String response,String startRule,String endRule){
        //s = "<work> <title> abc </title>";
        int startIdx = response.indexOf(startRule)+startRule.length();
//        startIdx = response.indexOf(">",startIdx)+1;
        int endIdx = response.indexOf(endRule);
        if(endIdx<startIdx) return "";
        String res = response.substring(startIdx,endIdx);
//        System.out.println(res);
        return res;

    }
*/
    // write overloaded parse method with the 3 parameters response, startRule, endRule
    public static String parse(String response,String startRule,String endRule){
        //s = "<work> <title> abc </title>";
        int startIdx = response.indexOf(startRule)+startRule.length();
        int endIdx = response.indexOf(endRule);
        if(endIdx<startIdx) return "";
        String res = response.substring(startIdx,endIdx);
        System.out.println(res);
        return res;

    }
    public static void main(String[] args) {
        String response = "<work>" +
                "<id type=\"integer\">2361393</id>" +
                "<books_count type=\"integer\">813</books_count>" +
                "<ratings_count type=\"integer\">1,16,315</ratings_count>" +
                "<text_reviews_count type=\"integer\">3439</text_reviews_count>" +
                "<original_publication_year type=\"integer\">1854</original_publication_year>" +
                "<original_publication_month type=\"integer\" nil=\"true\"/>" +
                "<original_publication_day type=\"integer\" nil=\"true\"/>" +
                "<average_rating>3.79</average_rating>" +
                "<best_book type=\"Book\">" +
                "<id type=\"integer\">16902</id>" +
                "<title>Walden</title>" +
                "<author>" +
                "<id type=\"integer\">10264</id>" +
                "<name>Henry David Thoreau</name>" +
                "</author>" +
                "<image_url>" +
                "http://images.gr-assets.com/books/1465675526m/16902.jpg" +
                "</image_url>" +
                "<small_image_url>" +
                "http://images.gr-assets.com/books/1465675526s/16902.jpg" +
                "</small_image_url>" +
                "</best_book>" +
                "</work>";

        APIResponseParser.parse(response);
    }
}