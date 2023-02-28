package com.semanticsquare.thrillio.dao;

import com.semanticsquare.thrillio.DataStore;
import com.semanticsquare.thrillio.entities.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookmarkDao {
    public List<List<Bookmark>> getBookmarks(){
        return DataStore.getBookmarks();
    }

    public void saveUserBookmark(UserBookmark userBookmark) {
//        DataStore.add(userBookmark);
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jid_thrillio?useSSL=false", "root", "sachin@paytm");
             Statement statement = conn.createStatement();) {
            if(userBookmark.getBookmark() instanceof WebLink){
                saveUserWeblink(userBookmark,statement);
            }
            else if(userBookmark.getBookmark() instanceof Book){
                saveUserBook(userBookmark,statement);
            }
            else if(userBookmark.getBookmark() instanceof Movie){
                saveUserMovie(userBookmark,statement);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void saveUserWeblink(UserBookmark userBookmark, Statement statement) throws SQLException {
        String query = "insert into User_WebLink(user_id,weblink_id) values ("
                + userBookmark.getUser().getId()+","+userBookmark.getBookmark().getId()+");";
        statement.executeUpdate(query);
    }
    private void saveUserBook(UserBookmark userBookmark, Statement statement) throws SQLException {
        String query = "insert into User_Book(user_id,book_id) values ("
                + userBookmark.getUser().getId()+","+userBookmark.getBookmark().getId()+");";
        statement.executeUpdate(query);
    }
    private void saveUserMovie(UserBookmark userBookmark, Statement statement) throws SQLException {
        String query = "insert into User_Movie(user_id,movie_id) values ("
                + userBookmark.getUser().getId()+","+userBookmark.getBookmark().getId()+");";
        statement.executeUpdate(query);
    }

    public List<WebLink> getAllWeblinks(){
        List<List<Bookmark>> bookmarks = DataStore.getBookmarks();
        List<Bookmark> allWebLinks = bookmarks.get(0);
        List<WebLink> webLinks = new ArrayList<>();
        for (Bookmark weblink:allWebLinks) {
            webLinks.add((WebLink)weblink);
        }
        return webLinks;
    }
    public List<WebLink> getWebLinks(WebLink.DownloadStatus downloadStatus){
        List<WebLink> allWeblinks = getAllWeblinks();
        List<WebLink> webLinks = new ArrayList<>();
        for (WebLink webLink:allWeblinks){
            if(webLink.getDownloadStatus().equals(downloadStatus)){
                webLinks.add(webLink);
            }
        }
        return webLinks;
    }

    public void updateKidFriendlyStatus(Bookmark bookmark) {
        int kidFriendlyStatus = bookmark.getKidFriendlyStatus().ordinal();
        long userId = bookmark.getKidFriendlyMarkedBy().getId();
        String tableToUpdate = "WebLink";
        if (bookmark instanceof Book) tableToUpdate = "Book";
        else if(bookmark instanceof Movie) tableToUpdate = "Movie";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jid_thrillio?useSSL=false", "root", "sachin@paytm");
             Statement statement = conn.createStatement();) {
            String query = "update "+tableToUpdate + " set kid_friendly_status= "+kidFriendlyStatus+", kid_friendly_marked_by= " + userId + " where id= "+bookmark.getId()+ ";";
            System.out.println("query updateKidFriendlyStatus" +query);
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void sharedByInfo(Bookmark bookmark) {
        long userId = bookmark.getSharedBy().getId();
        String tableToUpdate = "WebLink";
        if (bookmark instanceof Book) tableToUpdate = "Book";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jid_thrillio?useSSL=false", "root", "sachin@paytm");
             Statement statement = conn.createStatement();) {
            String query = "update "+tableToUpdate + " set shared_by= " + userId + " where id= "+bookmark.getId()+ ";";
            System.out.println("query sharedByInfo " +query);
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}