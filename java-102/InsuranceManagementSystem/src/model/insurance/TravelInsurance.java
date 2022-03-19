package model.insurance;

import java.time.LocalDate;

public class TravelInsurance extends Insurance {
  public TravelInsurance(String name, int cost, LocalDate startDate, LocalDate finishDate) {
    super(name, cost, startDate, finishDate);
  }

  @Override
  public int calculate() {
    return (finishDate.getYear() - startDate.getYear()) * cost;
  }
}
