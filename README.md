RUNNING APP

Run Via IntelliJ

  1. navigate to project folder
  2. mvn clean install -U -DskipTests
  3. right click DataConversionApplication click Run DataConversionApplication

Run Via Command Line 

  1. navigate to project folder
  2. mvn clean install -U -DskipTests
  3. mvn spring-boot:run
  4. Hit Through Post Man


Hit Endpoint Via PostMan: 

  1. POST Request
  2. url: http://localhost:8080/convertData
  3. Sample Payload: 
      {
          "quantity":24,
          "sourceUOM":"INCH",
          "desiredUOM": "FOOT"
      }
      
      
Viable Source And Desired Unit Of Measurements

  CENTIMETER
  INCH
  FOOT
  YARD
  
  POUND
  LITER
  GALLON
  KILOGRAM