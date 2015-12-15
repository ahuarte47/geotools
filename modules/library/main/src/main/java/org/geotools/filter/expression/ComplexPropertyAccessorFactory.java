/*
 *    GeoTools - The Open Source Java GIS Toolkit
 *    http://geotools.org
 * 
 *    (C) 2015, Open Source Geospatial Foundation (OSGeo)
 *
 *    This library is free software; you can redistribute it and/or
 *    modify it under the terms of the GNU Lesser General Public
 *    License as published by the Free Software Foundation;
 *    version 2.1 of the License.
 *
 *    This library is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *    Lesser General Public License for more details.
 */
package org.geotools.filter.expression;

import org.geotools.factory.Hints;
import org.opengis.feature.Property;
import org.opengis.filter.ComplexPropertyAccessor;

/**
 * This class will access a Property from a {@link org.opengis.filter.ComplexPropertyAccessor}
 * with the name equal to xpath.
 * 
 * @author Alvaro Huarte
 *
 * @source $URL$
 */
public class ComplexPropertyAccessorFactory implements PropertyAccessorFactory {
    
    static PropertyAccessor PROPERTYA = new ComplexPropertyAccessorImpl();
    
    public PropertyAccessor createPropertyAccessor(Class<?> type, String xpath, 
           Class<?> target, Hints hints) {
        return PROPERTYA;
    }
    
    /**
     * Grab a value from a Property with matching name.
     */
    static class ComplexPropertyAccessorImpl implements PropertyAccessor {
        
        /**
         * Gets the Property of the specified name.
         */
        private static Property findProperty(Object object, String xpath) {
            if (object instanceof ComplexPropertyAccessor) {
                ComplexPropertyAccessor propertyAccessor = (ComplexPropertyAccessor)object;
                return propertyAccessor.getProperty(xpath);
            }
            return null;
        }
        
        public boolean canHandle(Object object, String xpath, Class target) {
            Property property = findProperty(object, xpath);
            return property != null;
        }
        
        public Object get(Object object, String xpath, Class target) 
               throws IllegalArgumentException {
            Property property = findProperty(object, xpath);
            return property != null ? property.getValue() : null;
        }
        
        public void set(Object object, String xpath, Object value, Class target) 
               throws IllegalArgumentException {
            Property property = findProperty(object, xpath);
            if (property != null) property.setValue(value);
        }
    }
}
