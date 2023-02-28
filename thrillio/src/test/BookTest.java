package test;

import com.semanticsquare.thrillio.constants.BookGenre;
import com.semanticsquare.thrillio.entities.Book;
import com.semanticsquare.thrillio.manager.BookmarkManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void isKidFriendlyEligible() {
        //test 1 PHILOSOPHY
        Book book  = BookmarkManager.getInstance().createBook(4000,"Walden",1854,"Wilder Publications",new String[]{"Henry David Thoreau"}, BookGenre.PHILOSOPHY,4.3);
        boolean isKidFriendlyEligible = book.isKidFriendlyEligible();
        assertFalse(isKidFriendlyEligible,"Book has PHILOSOPHY genre");

        //test 2: SELF_HELP
        book  = BookmarkManager.getInstance().createBook(4000,"Walden",1854,"Wilder Publications",new String[]{"Henry David Thoreau"}, BookGenre.SELF_HELP,4.3);
        isKidFriendlyEligible = book.isKidFriendlyEligible();
        assertFalse(isKidFriendlyEligible,"Book has SELF_HELP genre");

    }
}