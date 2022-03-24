/*
 *  Justian Tremblay | 040968930
 *  JsonColorSerializer.java
 *  Purose: Converts a java color object to a json color object to be displayed properly in a GET request
 */
package service;

import java.awt.Color;
import javax.json.bind.serializer.JsonbSerializer;
import javax.json.bind.serializer.SerializationContext;
import javax.json.stream.JsonGenerator;

/**
 *
 * @author tjust
 */
public class JsonColorSerializer implements JsonbSerializer<Color>  {
    @Override
    public void serialize(Color c, JsonGenerator jg, SerializationContext ctx) {
        jg.writeStartObject();
        jg.write("red", c.getRed());
        jg.write("green", c.getGreen());
        jg.write("blue", c.getBlue());
        jg.writeEnd();
    }
}