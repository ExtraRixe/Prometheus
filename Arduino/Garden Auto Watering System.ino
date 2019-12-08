#include <virtuabotixRTC.h> //Library used
#include <SimpleDHT.h>

//Debug *Change Value to True for debug mode
bool DEBUG = false;

// Global Values
bool watering = false;
bool wateredToday = false;
String today;

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
int relay = 3;

//Photoresistor
int photores = 1;
int PRvalue;

//----------------------INITIALIZATION-----------------------//
void setup() {
    Serial.begin(9600);
    RTC.updateTime();
    today = (String)(RTC.dayofmonth)+"/"+(String)(RTC.month)+"/"+(String)(RTC.year);

    pinMode(relay, OUTPUT);

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
                        Serial.println(getTimeDate());
                        Serial.println();
                        
                        Serial.println("**RELAY/VALVE**");
                        digitalWrite(relay,HIGH);
                        Serial.println("VALVE STATUS: OPEN");
                        delay(3000);
                        digitalWrite(relay,LOW);
                        Serial.println("VALVE STATUS: CLOSE");
                        
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

String getTimeDate(){
  return (String)(RTC.dayofmonth)+"/"+(String)(RTC.month)+"/"+(String)(RTC.year)+" "+(String)(RTC.hours)+":"+(String)(RTC.minutes)+":"+(String)(RTC.seconds);  
}

//----------------------LOOP-----------------------//

void loop() {
  RTC.updateTime();
  String runningDate = (String)(RTC.dayofmonth)+"/"+(String)(RTC.month)+"/"+(String)(RTC.year);  
  PRvalue = analogRead(photores);
  if(today!=runningDate){
    today = runningDate;
    wateredToday = false;
  }
  if(wateredToday == false && RTC.hours > 6 && /*RTC.hours < 16* &&*/ getSoilMoisture() < 70 ){
    digitalWrite(relay,HIGH);
    watering = true;
    delay(5000);
  }
  else if(watering == true && getSoilMoisture() > 70){
    digitalWrite(relay,LOW);
    watering = false;
    wateredToday = true;
  }
  
}
