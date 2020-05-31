package datacor.unitConversion.service;

import static datacor.unitConversion.dto.enums.UnitOfMeasurement.GALLON;
import static datacor.unitConversion.dto.enums.UnitOfMeasurement.LITER;

import datacor.unitConversion.conversions.Converter;
import datacor.unitConversion.dto.ConversionInputDTO;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DataConversionServiceTest {

  @Test
  public void testService_HappyPath() {
    //Arrange
    Converter converter = new Converter();
    DataConversionService dataConversionService = new DataConversionService(converter);

    //Call
    double actualConvertedValue = dataConversionService.convertItem(new ConversionInputDTO(2.0, GALLON, LITER));

    //Verify
    Assertions.assertThat(actualConvertedValue).isEqualTo(7.6);
  }
}
