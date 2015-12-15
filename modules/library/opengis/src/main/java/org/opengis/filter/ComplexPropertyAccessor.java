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
package org.opengis.filter;

import org.opengis.feature.Property;

/**
 * Used for filters to get object properties based on an xpath expression.
 * 
 * @author Alvaro Huarte
 */
public interface ComplexPropertyAccessor {
    
    /**
     * Returns a single property of the complex object which matches the specified name.
     *
     * @param name The name of the property to return.
     *
     * @return The property matching the specified name, or <code>null</code>.
     */
    Property getProperty(String name);
}
