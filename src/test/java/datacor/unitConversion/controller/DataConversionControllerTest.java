package datacor.unitConversion.controller;

import static datacor.unitConversion.dto.enums.UnitOfMeasurement.KILOGRAM;
import static datacor.unitConversion.dto.enums.UnitOfMeasurement.POUND;
import static org.mockito.Mockito.times;

import datacor.unitConversion.dto.ConversionInputDTO;
import datacor.unitConversion.service.DataConversionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DataConversionControllerTest {

  @Mock
  DataConversionService dataConversionService;

  @Test
  public void testController_HappyPath() {
    //Arrange
    ConversionInputDTO incomingPayload = new ConversionInputDTO(3.0, KILOGRAM, POUND);
    DataConversionController dataConversionController = new DataConversionController(
        dataConversionService);

    //Call
    dataConversionController.convertData(incomingPayload);

    //Verify
    Mockito.verify(dataConversionService, times(1)).convertItem(incomingPayload);
  }
}
