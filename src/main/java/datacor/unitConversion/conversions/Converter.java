package datacor.unitConversion.conversions;

import static datacor.unitConversion.dto.enums.UnitOfMeasurement.CENTIMETER;
import static datacor.unitConversion.dto.enums.UnitOfMeasurement.FOOT;
import static datacor.unitConversion.dto.enums.UnitOfMeasurement.GALLON;
import static datacor.unitConversion.dto.enums.UnitOfMeasurement.INCH;
import static datacor.unitConversion.dto.enums.UnitOfMeasurement.KILOGRAM;
import static datacor.unitConversion.dto.enums.UnitOfMeasurement.LITER;
import static datacor.unitConversion.dto.enums.UnitOfMeasurement.POUND;
import static datacor.unitConversion.dto.enums.UnitOfMeasurement.YARD;

import datacor.unitConversion.dto.ConverterDTO;
import datacor.unitConversion.dto.ConversionInputDTO;
import datacor.unitConversion.exception.InvalidConversionException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class Converter {

  private final HashMap<ConverterDTO, Double> conversionMap = createConversionMap();

  public Double convertMeasurement(ConversionInputDTO conversionInputDTO) {

    try {
      return conversionInputDTO.getQuantity() * conversionMap.get(
          new ConverterDTO(conversionInputDTO.getSourceUOM(), conversionInputDTO.getDesiredUOM()));

    } catch (Exception e) {
      throw new InvalidConversionException(
          "Invalid Conversion: SourceUOM and DesiredUOM must be compatible. Source UOM: "
              + conversionInputDTO.getSourceUOM() + " cannot be converted to Desired UOM : "
              + conversionInputDTO.getDesiredUOM());
    }
  }

  private static HashMap<ConverterDTO, Double> createConversionMap() {
    HashMap<ConverterDTO, Double> conversionMap = new HashMap<>();

    conversionMap.put(new ConverterDTO(CENTIMETER, INCH), 1/2.54);
    conversionMap.put(new ConverterDTO(CENTIMETER, FOOT), 1/30.48);
    conversionMap.put(new ConverterDTO(CENTIMETER, YARD), 1/91.44);

    conversionMap.put(new ConverterDTO(INCH, CENTIMETER), 2.54);
    conversionMap.put(new ConverterDTO(INCH, FOOT), 1/12.0);
    conversionMap.put(new ConverterDTO(INCH, YARD), 1/36.0);

    conversionMap.put(new ConverterDTO(FOOT, CENTIMETER), 30.48);
    conversionMap.put(new ConverterDTO(FOOT, INCH), 12.0);
    conversionMap.put(new ConverterDTO(FOOT, YARD), 1/3.0);

    conversionMap.put(new ConverterDTO(YARD, CENTIMETER), 91.44);
    conversionMap.put(new ConverterDTO(YARD, INCH), 36.0);
    conversionMap.put(new ConverterDTO(YARD, FOOT), 3.0);

    conversionMap.put(new ConverterDTO(POUND, LITER), 1/2.2);
    conversionMap.put(new ConverterDTO(POUND, KILOGRAM), 1/2.2);
    conversionMap.put(new ConverterDTO(POUND, GALLON), 1/8.0);

    conversionMap.put(new ConverterDTO(LITER, POUND), 2.2);
    conversionMap.put(new ConverterDTO(LITER, KILOGRAM), 1.0);
    conversionMap.put(new ConverterDTO(LITER, GALLON), 1/3.8);

    conversionMap.put(new ConverterDTO(GALLON, LITER), 3.8);
    conversionMap.put(new ConverterDTO(GALLON, POUND), 8.0);
    conversionMap.put(new ConverterDTO(GALLON, KILOGRAM), 3.8);

    conversionMap.put(new ConverterDTO(KILOGRAM, LITER), 1.0);
    conversionMap.put(new ConverterDTO(KILOGRAM, POUND), 2.2);
    conversionMap.put(new ConverterDTO(KILOGRAM, GALLON), 1/3.8);

    return conversionMap;
  }

  public Map<ConverterDTO, Double> getConversionMap() {
    return conversionMap;
  }



  /* MAIN METHOD FOR SIMPLE RUN INSTEAD OF HITTING WEB SERVICE */
  public static void main(String[] args) {
    Converter converter = new Converter();

    System.out.println(converter.convertMeasurement(new ConversionInputDTO(72.0, INCH, FOOT)));
  }
}
