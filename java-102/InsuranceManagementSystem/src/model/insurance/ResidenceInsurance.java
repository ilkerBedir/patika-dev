package model.insurance;

import java.time.LocalDate;

public class ResidenceInsurance extends Insurance {


  public ResidenceInsurance(String name, int cost, LocalDate startDate, LocalDate finishDate) {
    super(name, cost, startDate, finishDate);
  }

  @Override
  public int calculate() {
    return (((finishDate.getYear() - startDate.getYear()) * 12) + (finishDate.getMonth().getValue() - startDate.getMonth().getValue())) * cost;
  }
}
