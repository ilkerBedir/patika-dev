import comparator.SortByPageNumber;
import model.Book;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.TreeSet;

public class Main {
  public static void main(String[] args) {
    Book book1 = new Book("Kürk Mantolu Madonna", 160, "Sabahattin Ali", LocalDate.parse("2019-09-14"));
    Book book2 = new Book("İnce Memed 1", 436, "Yaşar Kemal", LocalDate.parse("2021-12-27"));
    Book book3 = new Book("Beyaz Gemi", 180, "Cengiz Aytmatov", LocalDate.parse("2020-02-02"));
    Book book4 = new Book("Fareler ve İnsanlar", 111, "John SteinBeck", LocalDate.parse("2020-05-21"));
    Book book5 = new Book("Anayurt Oteli", 128, "Yusuf Atılgan", LocalDate.parse("2019-04-25"));
    TreeSet<Book> bookSet1 = new TreeSet<>();
    TreeSet<Book> bookSet2 = new TreeSet<>(new SortByPageNumber());
    bookSet1.add(book1);
    bookSet1.add(book2);
    bookSet1.add(book3);
    bookSet1.add(book4);
    bookSet1.add(book5);
    System.out.println("-------- 1. Set---------");
    Iterator<Book> iterator = bookSet1.iterator();
    while (iterator.hasNext()) {
      Book book = iterator.next();
      System.out.println(book.toString());
      bookSet2.add(book);
    }

    System.out.println("-------- 2. Set---------");
    Iterator<Book> itr = bookSet2.iterator();
    while (itr.hasNext()) {
      System.out.println(itr.next().toString());
    }
  }
}
