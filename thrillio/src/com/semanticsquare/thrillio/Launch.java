package com.semanticsquare.thrillio;

import com.semanticsquare.thrillio.bgjobs.WebPageDownloaderTask;
import com.semanticsquare.thrillio.entities.Bookmark;
import com.semanticsquare.thrillio.entities.User;
import com.semanticsquare.thrillio.manager.BookmarkManager;
import com.semanticsquare.thrillio.manager.UserManager;

import java.util.List;

public class Launch {

    private static List<User> users;
    private static List<List<Bookmark>> bookmarks;

    private static void loadData(){
        System.out.println("\n1. Loading Data.... ");
        DataStore.loadData();
        users = UserManager.getInstance().getUsers();
        bookmarks = BookmarkManager.getInstance().getBookmarks();
        System.out.println("\nPrinting Data.... ");
        printUsersData();
        printBookmarksData();
    }

    private static void printUsersData() {
        for(User user:users) {
            System.out.println(user);
        }
    }


    private static void printBookmarksData() {
        for(List<Bookmark> bookmarkList :bookmarks){
            for (Bookmark bookmark:bookmarkList){
                System.out.println(bookmark);
            }
        }
    }

    private static void startBookmarking(){
        System.out.println("\n2. Browsing... ");
        for (User user:users){
            View.browse(user,bookmarks);
        }

        /* System.out.println("\n2. Bookmarking... ");
        for (User user:users){
            //View.Bookmark(user,bookmarks);
        }*/
    }

    public static void main(String[] args) {
        loadData();
        startBookmarking();
//        runDownloaderJob();
    }

    private static void runDownloaderJob(){
        WebPageDownloaderTask webPageDownloaderTask = new WebPageDownloaderTask(true);
        (new Thread(webPageDownloaderTask)).start();
    }
}