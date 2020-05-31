package datacor.unitConversion.dto.enums;

public enum UnitOfMeasurement {
  GALLON("G"),
  LITER("L"),
  INCH("IN"),
  CENTIMETER("CM"),
  FOOT("FT"),
  YARD("YD"),
  KILOGRAM("KG"),
  POUND("LB");

  private String shortHand;

  private UnitOfMeasurement(String shortHand) {
    this.shortHand = shortHand;
  }

  public String getShortHand() {
    return shortHand;
  }
}
