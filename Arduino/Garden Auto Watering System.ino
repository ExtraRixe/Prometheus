#include <virtuabotixRTC.h> //Library used
#include <SimpleDHT.h>

//Debug *Change Value to True for debug mode
bool DEBUG = true;

// Global Values
bool watering = false;
bool wateredToday = false;

//Soil Moisture Sensor
int moistureSensor = 0; 
int SMvalue;  
int limit = 300; 

//DHT11 Humidity Sensor
int humiditySensor = 2;
SimpleDHT11 dht11(humiditySensor);

//Real-Time Clock
virtuabotixRTC RTC(6, 7, 8);

//Relay
int relay = 4;

//Photoresistor
int photores = 1;
int PRvalue;

//----------------------INITIALIZATION-----------------------//
void setup() {
    Serial.begin(9600);
    pinMode(4, OUTPUT);

                        if (DEBUG == true){
                        Serial.println("-=DEBUG BEGIN=-");
                        Serial.println("**DHT**");
                        Serial.println(getHumidity());
                        Serial.println();
                    
                        Serial.println("**SOIL MOISTURE**");
                        Serial.print(getSoilMoisture());
                        Serial.print("%");
                        Serial.println("\n");
                    
                        Serial.println("**PHOTORESISTOR**");
                        Serial.print(getPhotoresistor());
                        Serial.print("%");
                        Serial.println("\n");
                    
                        Serial.println("**RTC**");
                        RTC.updateTime();
                        Serial.println(getTime());
                        
                        Serial.println("...\n...\n...");
                        Serial.println("-=DEBUG END=-");
                        delay(1500);
                      }
}
//----------------------METHODS-----------------------//
String getHumidity(){
    byte temperature = 0;
    byte humidity = 0;
    int err = SimpleDHTErrSuccess;
    if ((err = dht11.read(&temperature, &humidity, NULL)) != SimpleDHTErrSuccess) {
      return "Read DHT11 failed";
    }else{
      return ((String)(int)temperature) + " *C  | " + ((String)(int)humidity) + " H";
  }   

}

int getSoilMoisture(){
  SMvalue = analogRead(moistureSensor); 
  int SMmap = map(SMvalue,0,1024,100,0);
  return SMmap;
}
int getPhotoresistor(){
  PRvalue = analogRead(photores); 
  int PRmap = map(PRvalue,0,1024,0,100);
  return PRmap;
}
String getTime(){
return (String)(RTC.dayofmonth)+"/"+(String)(RTC.month)+"/"+(String)(RTC.year)+" "+(String)(RTC.hours)+":"+(String)(RTC.minutes)+":"+(String)(RTC.seconds);
}

//----------------------LOOP-----------------------//

void loop() {
  RTC.updateTime();
  PRvalue = analogRead(photores);
  
  



}

