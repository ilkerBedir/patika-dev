package model.insurance;

import java.time.LocalDate;

public class CarInsurance extends Insurance {
  public CarInsurance(String name, int cost, LocalDate startDate, LocalDate finishDate) {
    super(name, cost, startDate, finishDate);
  }

  @Override
  public int calculate() {
    return cost * 150;
  }
}
