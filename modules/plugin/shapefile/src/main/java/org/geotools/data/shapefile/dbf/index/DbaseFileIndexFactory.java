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
package org.geotools.data.shapefile.dbf.index;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.TimeZone;

/**
 * Factory class of Dbase index file managers (To speedup alphanumeric filters in a DBF-file).
 * 
 * @author Alvaro Huarte
 */
public interface DbaseFileIndexFactory {
    
    /**
     * Returns a supported index manager of the specified Dbase file.
     * @throws IOException
     */
    DbaseFileIndex getIndexManager(URL urlDbaseFile, Charset charset, TimeZone timeZone) throws IOException;
}
