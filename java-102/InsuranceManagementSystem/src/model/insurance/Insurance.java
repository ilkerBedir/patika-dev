package model.insurance;

import java.time.LocalDate;

public abstract class Insurance {
  protected String name;
  protected int cost;
  protected LocalDate startDate;
  protected LocalDate finishDate;

  public Insurance(String name, int cost, LocalDate startDate, LocalDate finishDate) {
    this.name = name;
    this.cost = cost;
    this.startDate = startDate;
    this.finishDate = finishDate;
  }

  public abstract int calculate();
}
