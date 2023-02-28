package com.semanticsquare.nestedclasses;

import java.io.StringWriter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.basic.IntConverter;
import com.thoughtworks.xstream.converters.basic.StringConverter;
import com.thoughtworks.xstream.converters.collections.CollectionConverter;
import com.thoughtworks.xstream.converters.reflection.ReflectionConverter;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.StaxDriver;


public class DataTranslator {

    public static String getBookAsXml(int id, String title, double rating, int fbLikesCount, int tweetCount) {

        class Book {
            private int id;
            private String title;
            private double rating;
            private int fbLikesCount;
            private int tweetCount;

            public Book (int id, String title, double rating, int fbLikesCount, int tweetCount) {
                this.id = id;
                this.title = title;
                this.rating = rating;
                this.fbLikesCount = fbLikesCount;
                this.tweetCount = tweetCount;
            }


            @Override
            public String toString() {
                return "Book{" +
                        "id=" + id +
                        ", title='" + title + '\'' +
                        ", rating=" + rating +
                        ", fbLikesCount=" + fbLikesCount +
                        ", tweetCount=" + tweetCount +
                        '}';
            }
        }

        Book book = new Book(id, title, rating, fbLikesCount, tweetCount);

/*        XStream xstream = new XStream(new StaxDriver()) {
            @Override
            protected void setupConverters() {
            }
        };
        xstream.registerConverter(new ReflectionConverter(xstream.getMapper(), xstream.getReflectionProvider()), XStream.PRIORITY_VERY_LOW);
        xstream.registerConverter(new IntConverter(), XStream.PRIORITY_NORMAL);
        xstream.registerConverter(new StringConverter(), XStream.PRIORITY_NORMAL);
        xstream.registerConverter(new CollectionConverter(xstream.getMapper()), XStream.PRIORITY_NORMAL);


 */

//
//        XStream xstream = new XStream(new DomDriver());
//        xstream.alias("book", Book.class);
//        StringWriter writer = new StringWriter();
//        xstream.marshal(book,  new PrettyPrintWriter(writer));

//        return writer.toString();
//        return xstream.toXML(book);

        return book.toString();
    }

    public static void main(String[] args) {
        System.out.println(DataTranslator.getBookAsXml(
                2002, "Interface vs Abstract Class", 3.0, 5, 6));
    }
}
