/*
 *  Justian Tremblay | 040968930
 *  JsonColorDeserializer.java
 *  Purose: Converts a json color object to a java color object
 *  note: This class does not currently work and is here for future assignments.  
 */
package service;

import java.awt.Color;
import javax.json.bind.serializer.JsonbDeserializer;
import javax.json.stream.JsonParser.Event;

/**
 *
 * @author tjust
 */
public class JsonColorDeserializer implements JsonbDeserializer<Color> {
    @Override
    public Color deserialize(javax.json.stream.JsonParser parser, javax.json.bind.serializer.DeserializationContext ctx, java.lang.reflect.Type rtType) {
        String keyname = "";  
        int value = 0; 
        int red = 0; 
        int green = 0; 
        int blue = 0;
        while (parser.hasNext()) {
            Event event = parser.next();
            switch (event) {
                case KEY_NAME: {
                    keyname = parser.getString();
                    break;
                }
                case VALUE_NUMBER: {
                    value = parser.getInt();
                    if (keyname.equals("red")) red = value;
                    else if (keyname.equals("green"))
                        green = value;
                    else if (keyname.equals("blue"))
                        blue = value; 
                    break;
                }
            }
        }   
        return new Color(red,green,blue);
    } 
}