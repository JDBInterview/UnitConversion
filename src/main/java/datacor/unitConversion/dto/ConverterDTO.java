package datacor.unitConversion.dto;

import datacor.unitConversion.dto.enums.UnitOfMeasurement;
import java.util.Objects;

public class ConverterDTO {
  private UnitOfMeasurement sourceUOM;
  private UnitOfMeasurement desiredUOM;

  public ConverterDTO(UnitOfMeasurement sourceUOM,
      UnitOfMeasurement desiredUOM) {
    this.sourceUOM = sourceUOM;
    this.desiredUOM = desiredUOM;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConverterDTO that = (ConverterDTO) o;
    return sourceUOM == that.sourceUOM &&
        desiredUOM == that.desiredUOM;
  }

  @Override
  public int hashCode() {
    return Objects.hash(sourceUOM, desiredUOM);
  }
}
