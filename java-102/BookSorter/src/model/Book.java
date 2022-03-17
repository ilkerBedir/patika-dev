package model;

import java.time.LocalDate;


public class Book implements Comparable<Book>{
  private String name;
  private int pageCount;
  private String authorName;
  private LocalDate publishDate;

  public Book(String name, int pageCount, String authorName, LocalDate publishDate) {
    this.name = name;
    this.pageCount = pageCount;
    this.authorName = authorName;
    this.publishDate = publishDate;
  }

  public int getPageCount() {
    return pageCount;
  }

  public String getName() {
    return name;
  }

  @Override
  public int compareTo(Book book) {
    return name.compareTo(book.getName());
  }

  @Override
  public String toString() {
    return "Book{" +
      "name='" + name + '\'' +
      ", pageCount=" + pageCount +
      ", authorName='" + authorName + '\'' +
      ", publishDate=" + publishDate +
      '}';
  }
}
