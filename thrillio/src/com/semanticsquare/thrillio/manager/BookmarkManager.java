package com.semanticsquare.thrillio.manager;

import com.semanticsquare.thrillio.constants.BookGenre;
import com.semanticsquare.thrillio.constants.KidFriendlyStatus;
import com.semanticsquare.thrillio.constants.MovieGenre;
import com.semanticsquare.thrillio.dao.BookmarkDao;
import com.semanticsquare.thrillio.entities.*;
import com.semanticsquare.thrillio.util.HttpConnect;
import com.semanticsquare.thrillio.util.IOUtil;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;

public class BookmarkManager {
    private static BookmarkManager instance = new BookmarkManager();
    private static BookmarkDao dao = new BookmarkDao();
    private BookmarkManager(){}

    public static BookmarkManager getInstance() {
        return instance;
    }



    public Movie createMovie(long id, String title, String profileUrl, int releaseYear, String[] cast, String[] directors, MovieGenre genre, double imdbRating){
        Movie movie = new Movie();
        movie.setId(id);
        movie.setTitle(title);
        movie.setProfileUrl(profileUrl);
        movie.setReleaseYear(releaseYear);
        movie.setImdbRating(imdbRating);
        movie.setDirectors(directors);
        movie.setCast(cast);
        movie.setGenre(genre);
        return movie;
    }
    public Book createBook(long id, String title, int publicationYear, String publisher, String[] authors, BookGenre genre, double amazonRating){
        Book book = new Book();
        book.setId(id);
        book.setTitle(title);
        book.setPublisher(publisher);
//        book.setProfileUrl(profileUrl);
        book.setPublicationYear(publicationYear);
        book.setAmazonRating(amazonRating);
        book.setAuthors(authors);
        book.setGenre(genre);
        return book;
    }

    public WebLink createWebLink(long id, String title, String url, String host){
        WebLink webLink  = new WebLink();
        webLink.setId(id);
        webLink.setTitle(title);
        webLink.setUrl(url);
        webLink.setHost(host);
        return webLink;
    }

    public List<List<Bookmark>> getBookmarks(){
        return dao.getBookmarks();
    }
    public static void saveUserBookmark(User user, Bookmark bookmark) {
        UserBookmark userBookmark = new UserBookmark();
        userBookmark.setUser(user);
        userBookmark.setBookmark(bookmark);
        /*
        if (bookmark instanceof WebLink) {
            try {
                String url = ((WebLink)bookmark).getUrl();
                if (!url.endsWith(".pdf")) {
                    String webpage = HttpConnect.download(((WebLink)bookmark).getUrl());
                    if (webpage != null) {
                        IOUtil.write(webpage, bookmark.getId());
                    }
                }
            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (URISyntaxException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

         */
        dao.saveUserBookmark(userBookmark);
    }
    public void setKidFriendlyStatus(User user, KidFriendlyStatus kidFriendlyStatus, Bookmark bookmark) {
        bookmark.setKidFriendlyStatus(kidFriendlyStatus);
        bookmark.setKidFriendlyMarkedBy(user);
        dao.updateKidFriendlyStatus(bookmark);
        System.out.println("KidFriendlyStatus: " + kidFriendlyStatus + " Marked By: "+user.getEmail()+"," + bookmark);
    }

    public void share(User user, Bookmark bookmark) {
        bookmark.setSharedBy(user);
        System.out.println("Data to be shared: ");
        if(bookmark instanceof Book){
            System.out.println(((Book)bookmark).getItemData());
        }
        else if(bookmark instanceof WebLink){
            System.out.println(((WebLink)bookmark).getItemData());
        }
        dao.sharedByInfo(bookmark);
    }
}