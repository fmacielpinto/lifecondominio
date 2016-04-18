package br.com.lifecondominio.util;

import java.math.BigDecimal;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter("bigDecimalConverter")
public class BigDecimalConverter
  implements Converter
{
  public Object getAsObject(FacesContext context, UIComponent component, String value)
  {
    if ((context == null) || (component == null)) {
      throw new NullPointerException();
    }
    if (value == null) {
      return null;
    }
    value = value.trim();
    if (value.length() < 1) {
      return null;
    }
    try
    {
      return new BigDecimal(value.replace(',', '.'));
    }
    catch (Exception e)
    {
      throw new ConverterException(e);
    }
  }
  
  public String getAsString(FacesContext context, UIComponent component, Object value)
  {
    if ((context == null) || (component == null)) {
      throw new NullPointerException();
    }
    if (value == null) {
      return "";
    }
    if ((value instanceof String)) {
      return (String)value;
    }
    try
    {
      return value.toString().replace('.', ',');
    }
    catch (Exception e)
    {
      throw new ConverterException(e);
    }
  }
}
