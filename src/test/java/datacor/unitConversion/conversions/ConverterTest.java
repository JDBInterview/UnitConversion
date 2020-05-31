package datacor.unitConversion.conversions;

import static datacor.unitConversion.dto.enums.UnitOfMeasurement.CENTIMETER;
import static datacor.unitConversion.dto.enums.UnitOfMeasurement.POUND;

import com.google.common.collect.Lists;
import datacor.unitConversion.dto.ConversionInputDTO;
import datacor.unitConversion.exception.InvalidConversionException;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ConverterTest {

  @Test
  public void testConvertMeasurement_HappyPath() {

    //Arrange
    Converter converter = new Converter();
    List<ConversionInputDTO> conversionInputDTOS = new ArrayList<>();
    List<Double> actualConvertedMeasurements = new ArrayList<>();

    converter.getConversionMap().forEach((conversionDTO, conversionFactor) -> conversionInputDTOS
        .add(new ConversionInputDTO(2.0, conversionDTO.getSourceUOM(),
            conversionDTO.getDesiredUOM())));

    //Call
    conversionInputDTOS.forEach(conversionInputDTO -> actualConvertedMeasurements
        .add(converter.convertMeasurement(conversionInputDTO)));

    //Verify
    Assertions.assertThat(actualConvertedMeasurements).hasSameSizeAs(getExpectedConvertedMeasurements());
    Assertions.assertThat(actualConvertedMeasurements).containsAll(getExpectedConvertedMeasurements());
  }

  @Test(expected = InvalidConversionException.class)
  public void testConvertMeasurement_InvalidConversion() {

    //Arrange
    Converter converter = new Converter();

    //Call
    converter.convertMeasurement(new ConversionInputDTO(30.0, POUND, CENTIMETER));
  }

  private List<Double> getExpectedConvertedMeasurements() {
    return Lists.newArrayList(6.0, 0.16666666666666666, 2.0, 0.021872265966754158, 4.4,
        0.5263157894736842, 0.05555555555555555, 0.06561679790026247, 24.0, 7.6, 72.0,
        0.5263157894736842, 2.0, 60.96, 182.88, 0.6666666666666666, 7.6, 4.4, 0.7874015748031495,
        16.0, 5.08, 0.25, 0.9090909090909091, 182.88);
  }


}
