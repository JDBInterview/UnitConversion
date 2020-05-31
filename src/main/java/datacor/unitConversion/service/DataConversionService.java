package datacor.unitConversion.service;

import datacor.unitConversion.conversions.Converter;
import datacor.unitConversion.dto.ConversionInputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataConversionService {
  private Converter converter;

  @Autowired
  public DataConversionService(Converter converter) {
    this.converter = converter;
  }

  public Double convertItem(ConversionInputDTO conversionInputDTO){
    return converter.convertMeasurement(conversionInputDTO);
  }

}
