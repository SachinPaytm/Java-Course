package test;

import com.semanticsquare.thrillio.constants.MovieGenre;
import com.semanticsquare.thrillio.entities.Movie;
import com.semanticsquare.thrillio.manager.BookmarkManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {

    @Test
    void isKidFriendlyEligible() {
        //test 1  HORROR
        Movie movie = BookmarkManager.getInstance().createMovie(3000,"Citizen Kane","",1941,new String[]{"Orson Welles,Joseph Cotten"},new String[]{"Orson Welles"}, MovieGenre.HORROR,8.5);
        boolean isKidFriendlyEligible = movie.isKidFriendlyEligible();
        assertFalse(isKidFriendlyEligible,"CLASSIC movie");

        //test 2 THRILLER
        movie = BookmarkManager.getInstance().createMovie(3000,"Citizen Kane","",1941,new String[]{"Orson Welles,Joseph Cotten"},new String[]{"Orson Welles"}, MovieGenre.THRILLERS,8.5);
        isKidFriendlyEligible = movie.isKidFriendlyEligible();
        assertFalse(isKidFriendlyEligible,"THRILLER movie");
    }
}