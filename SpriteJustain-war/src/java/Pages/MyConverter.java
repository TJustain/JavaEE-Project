/*
 *  Justian Tremblay | 040968930
 *  Myconverter.java
 *  Purose: The goal of this class is to convert java objects to text and text to java objects.
 *  This class also verifys if the user input is valid.
 */
package Pages;

import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
/**
 *
 * @author tjust
 */
@FacesConverter(forClass=Color.class)
public class MyConverter implements Converter {
    
    /**
     * This method takes a object and converts it to a String.
     * 
     * @param context
     * @param component
     * @param value the object to be converted
     * @return text version of the object
     */
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(context == null){
            throw new NullPointerException("context");
        }
        if(component == null){
           throw new NullPointerException("component"); 
        }
        Color color = (Color) value;
        String temp = String.format("%x",color.getRGB());
        String returnString = "#" + temp.substring(2, 8);
        
        return returnString;
           
        /**
         * My original solution for rgb:
         * 
         *  String string = String.valueOf(value);
         *  String returnString = string.substring(14, string.length());
         *  return returnString;
         */ 
    }

    /**
     * This method takes a String and converts it to an object.
     * 
     * @param context
     * @param component
     * @param value the String to be converted
     * @return text version of the object
     */
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Color color = new Color(0);
        if(context == null){
            throw new NullPointerException("context");
        }
        if(component == null){
           throw new NullPointerException("component"); 
        }   
        value = value.toLowerCase();
                //regex pattern to verify the input String 
                Pattern colorPattern = Pattern.compile("#([0-9a-f]{3}|[0-9a-f]{6}|[0-9a-f]{8})");
                Matcher match = colorPattern.matcher(value);
                Boolean valid = match.matches();
                
                if(valid){
                    color = Color.decode(value);
                }else{
                    FacesMessage msg = new FacesMessage(value + " is not valid please use the fololwing format #RRGGBB");
                    throw new ConverterException(msg);
                }
                
                return color;
    }
}
