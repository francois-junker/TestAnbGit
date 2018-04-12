/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.anbrimex.bibus.builder;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Francois
 */
public class ObjectBuilder {
    
    private ObjectBuilder() {
    }
    
    public static <T> T buildObject(Class<T> objectClass, Map<String, String[]> values) {
        try {
            T instance = objectClass.getConstructor().newInstance();
            
            for (Map.Entry<String, String[]> entry : values.entrySet()) {
                Field field = objectClass.getDeclaredField(entry.getKey());
                field.setAccessible(true);
                Object valueConverted = convertValue(field.getType(), entry.getValue()[0]);
                field.set(instance, valueConverted);
            }
            
            return instance;
        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchFieldException ex) {
            Logger.getLogger(ObjectBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    private static Object convertValue(Class targetType, String orignalValue) {
        if (targetType.equals(Integer.class) || targetType.equals(int.class)) {
            return Integer.parseInt(orignalValue);
        } else if (targetType.equals(String.class)) {
            return orignalValue;
        }
        return null;
    }
}
