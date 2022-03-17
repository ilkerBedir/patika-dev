package comparator;

import model.Book;

import java.util.Comparator;

public class SortByPageNumber implements Comparator<Book> {
  @Override
  public int compare(Book book1, Book book2) {
    return book1.getPageCount()-book2.getPageCount();
  }
}
