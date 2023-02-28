package com.semanticsquare.thrillio;

import com.semanticsquare.thrillio.constants.KidFriendlyStatus;
import com.semanticsquare.thrillio.constants.UserType;
import com.semanticsquare.thrillio.controller.BookmarkController;
import com.semanticsquare.thrillio.entities.Bookmark;
import com.semanticsquare.thrillio.entities.User;
import com.semanticsquare.thrillio.partner.Shareable;

import java.util.List;

public class View {
    public static void browse(User user, List<List<Bookmark>> bookmarks) {
        System.out.println("\n"+user.getEmail()+" is browsing...");
        int bookmarkCount = 0;
        for(List<Bookmark> bookmarksList : bookmarks){
            for(Bookmark bookmark:bookmarksList){
                boolean isBookmarked = getBookmarkDecision(bookmark);
                if (isBookmarked) {
                    BookmarkController.getInstance().saveUserBookmark(user, bookmark);
                    System.out.println("New item bookmarked "+bookmark);
                    bookmarkCount++;
                }

                if(user.getUserType().equals(UserType.EDITOR) || user.getUserType().equals(UserType.CHIEF_EDITOR)){
                    //marking kid friendly
                    if(bookmark.isKidFriendlyEligible() && bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.UNKNOWN)){
                        KidFriendlyStatus kidFriendlyStatus = getKidFriendlyStatusDecision(bookmark);
                        if(kidFriendlyStatus.equals(KidFriendlyStatus.UNKNOWN)==false) {
                            BookmarkController.getInstance().setKidFriendlyStatus(user,kidFriendlyStatus,bookmark);
                        }
                    }
                    //sharing
                    if(bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.APPROVED)
                            && bookmark instanceof Shareable){
                        boolean isShared = getShareDecision();
                        if(isShared){
                            BookmarkController.getInstance().share(user,bookmark);
                        }
                    }
                }

            }
        }

    }

    //Get user input for these methods
    private static boolean getShareDecision() {
        return  Math.random()>0.5?true:false;
    }

    private static KidFriendlyStatus getKidFriendlyStatusDecision(Bookmark bookmark) {
        double prob = Math.random();
        return prob<0.4?KidFriendlyStatus.APPROVED:(prob>=0.4 && prob<0.8)?KidFriendlyStatus.REJECTED:KidFriendlyStatus.UNKNOWN;
    }

    private static boolean getBookmarkDecision(Bookmark bookmark) {
        return Math.random()>0.5?true:false;
    }

    /*public static void Bookmark(User user, Bookmark[][] bookmarks) {
        System.out.println("\n"+user.getEmail()+" is bookmarking");
        for(int i = 0;i<DataStore.USER_BOOKMARK_LIMIT;i++){
            int typeOffset = (int)(Math.random()*DataStore.BOOKMARK_TYPES_COUNT);
            int bookmarkOffset = (int)(Math.random()*DataStore.BOOKMARK_COUNT_PER_TYPE);
            Bookmark Bookmark = bookmarks[typeOffset][bookmarkOffset];
            BookmarkController.getInstance().saveUserBookmark(user,bookmark);
            System.out.println(bookmark);
        }
    }*/
}
