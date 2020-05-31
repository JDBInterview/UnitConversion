package datacor.unitConversion.controller;

import datacor.unitConversion.dto.ConversionInputDTO;
import datacor.unitConversion.service.DataConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/convertData")
public class DataConversionController {

  DataConversionService dataConversionService;

  @Autowired
  public DataConversionController(DataConversionService dataConversionService) {
    this.dataConversionService = dataConversionService;
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> convertData(@RequestBody ConversionInputDTO conversionInputDTO){

    Double outputMeasurement = dataConversionService.convertItem(conversionInputDTO);

    return ResponseEntity.status(200)
        .contentType(MediaType.APPLICATION_JSON).body(outputMeasurement);
  }
}

