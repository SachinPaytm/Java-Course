package test;

import com.semanticsquare.thrillio.entities.Bookmark;
import com.semanticsquare.thrillio.manager.BookmarkManager;

import static org.junit.jupiter.api.Assertions.*;

class WebLinkTest {

    @org.junit.jupiter.api.Test
    void isKidFriendlyEligible() {
        //Test 1: porn in url
        Bookmark weblink = BookmarkManager.getInstance().createWebLink(2000,"Taming Tiger Part 2","http://www.javaworld.com/article/2072759/core-java/taming-porn--part-2.html","http://www.javaworld.com");
        boolean isKidFriendlyEligible = weblink.isKidFriendlyEligible();
        assertFalse(isKidFriendlyEligible, "For porn in url : False");

        //test 2: porn in title
        weblink = BookmarkManager.getInstance().createWebLink(2000,"Taming porn Part 2","http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html","http://www.javaworld.com");
        isKidFriendlyEligible = weblink.isKidFriendlyEligible();
        assertFalse(isKidFriendlyEligible, "For porn in title : False");

        //test 3: adult in host
        weblink = BookmarkManager.getInstance().createWebLink(2000,"Taming Tiger Part 2","http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html","http://www.adult.com");
        isKidFriendlyEligible = weblink.isKidFriendlyEligible();
        assertFalse(isKidFriendlyEligible, "For adult in host : False");

        //test 4: adult in url not in host
        weblink = BookmarkManager.getInstance().createWebLink(2000,"Taming Tiger Part 2","http://www.javaworld.com/article/2072759/core-java/taming-adult--part-2.html","http://www.javaworld.com");
        isKidFriendlyEligible = weblink.isKidFriendlyEligible();
        assertTrue(isKidFriendlyEligible, "For adult in url not in host : true");

        //test 5:adult in title
        weblink = BookmarkManager.getInstance().createWebLink(2000,"Taming adult Part 2","http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html","http://www.javaworld.com");
        isKidFriendlyEligible = weblink.isKidFriendlyEligible();
        assertTrue(isKidFriendlyEligible, "For adult  in title : true");

        //test 6 18+ in title
        weblink = BookmarkManager.getInstance().createWebLink(2000,"Taming 18+ Part 2","http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html","http://www.javaworld.com");
        isKidFriendlyEligible = weblink.isKidFriendlyEligible();
        assertFalse(isKidFriendlyEligible, "For 18+  in title : false");

        //test 7 18+ in url
        weblink = BookmarkManager.getInstance().createWebLink(2000,"Taming 18+ Part 2","http://www.javaworld.com/article/2072759/core-java/18+-tiger--part-2.html","http://www.javaworld.com");
        isKidFriendlyEligible = weblink.isKidFriendlyEligible();
        assertFalse(isKidFriendlyEligible, "For 18+  in url : false");

        //test 8 18+ in host
        weblink = BookmarkManager.getInstance().createWebLink(2000,"Taming 18+ Part 2","http://www.javaworld.com/article/2072759/core-java/18+-tiger--part-2.html","http://www.javaworld18+.com");
        isKidFriendlyEligible = weblink.isKidFriendlyEligible();
        assertFalse(isKidFriendlyEligible, "For 18+  in host : false");

    }
}