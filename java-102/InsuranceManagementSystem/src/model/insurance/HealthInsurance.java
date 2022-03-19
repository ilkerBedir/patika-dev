package model.insurance;

import java.time.LocalDate;

public class HealthInsurance extends Insurance {
  public HealthInsurance(String name, int cost, LocalDate startDate, LocalDate finishDate) {
    super(name, cost, startDate, finishDate);
  }

  @Override
  public int calculate() {
    return cost * 120;
  }
}
