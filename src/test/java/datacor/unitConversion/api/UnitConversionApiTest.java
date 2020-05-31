package datacor.unitConversion.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import datacor.unitConversion.dto.ConversionInputDTO;
import datacor.unitConversion.dto.enums.UnitOfMeasurement;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@ActiveProfiles("apitests")
@SpringBootTest
public class UnitConversionApiTest {

  @Autowired
  WebApplicationContext webApplicationContext;

  private MockMvc mockMvc;

  private ObjectMapper objectMapper = new ObjectMapper();

  @Before
  public void setup() {
    mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
  }

  @Test
  public void testUnitConversionEndpoint_HappyPath() throws Exception {
    // Arrange
    ConversionInputDTO conversionInputDTO = new ConversionInputDTO(24.0, UnitOfMeasurement.INCH,
        UnitOfMeasurement.FOOT);

    // Call and Verify
    mockMvc.perform(post("/convertData").contentType(MediaType.APPLICATION_JSON_VALUE)
        .content(objectMapper.writeValueAsString(conversionInputDTO))).andExpect(status().isOk())
        .andExpect(content().json(objectMapper.writeValueAsString(2.0)));
  }

  @Test
  public void testUnitConversionEndpoint_InvalidConversion() throws Exception {
    // Arrange
    ConversionInputDTO conversionInputDTO = new ConversionInputDTO(24.0, UnitOfMeasurement.INCH,
        UnitOfMeasurement.GALLON);


    // Call and Verify
    mockMvc.perform(post("/convertData").contentType(MediaType.APPLICATION_JSON_VALUE)
        .content(objectMapper.writeValueAsString(conversionInputDTO)))
        .andExpect(status().isBadRequest())
        .andExpect(content().string(
            "Invalid Conversion: SourceUOM and DesiredUOM must be compatible. Source UOM: INCH cannot be converted to Desired UOM : GALLON"));
  }
}
