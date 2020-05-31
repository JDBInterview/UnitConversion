package datacor.unitConversion.dto;

import datacor.unitConversion.dto.enums.UnitOfMeasurement;

public class ConversionInputDTO {
  private Double quantity;
  private UnitOfMeasurement sourceUOM;
  private UnitOfMeasurement desiredUOM;

  public ConversionInputDTO(Double quantity, UnitOfMeasurement sourceUOM,
      UnitOfMeasurement desiredUOM) {
    this.quantity = quantity;
    this.sourceUOM = sourceUOM;
    this.desiredUOM = desiredUOM;
  }

  public Double getQuantity() {
    return quantity;
  }

  public void setQuantity(Double quantity) {
    this.quantity = quantity;
  }

  public UnitOfMeasurement getSourceUOM() {
    return sourceUOM;
  }

  public void setSourceUOM(UnitOfMeasurement sourceUOM) {
    this.sourceUOM = sourceUOM;
  }

  public UnitOfMeasurement getDesiredUOM() {
    return desiredUOM;
  }

  public void setDesiredUOM(UnitOfMeasurement desiredUOM) {
    this.desiredUOM = desiredUOM;
  }
}
