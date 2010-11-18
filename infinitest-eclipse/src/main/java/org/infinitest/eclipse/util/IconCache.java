/*
 * This file is part of Infinitest.
 *
 * Copyright (C) 2010
 * "Ben Rady" <benrady@gmail.com>,
 * "Rod Coffin" <rfciii@gmail.com>,
 * "Ryan Breidenbach" <ryan.breidenbach@gmail.com>, et al.
 *
 * Infinitest is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Infinitest is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Infinitest.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.infinitest.eclipse.util;

import static com.google.common.collect.Maps.*;

import java.io.InputStream;
import java.util.Map;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.infinitest.util.Icon;

public class IconCache
{
    private static Map<Icon, Image> smallImages = newHashMap();
    private static Map<Icon, Image> largeImages = newHashMap();

    public static synchronized Image getSmallImage(Icon imageType)
    {
        if (!smallImages.containsKey(imageType))
        {
            smallImages.put(imageType, createImage(imageType.getSmallFormatStream()));
        }
        return smallImages.get(imageType);
    }

    public static synchronized Image getLargeImage(Icon imageName)
    {
        if (!largeImages.containsKey(imageName))
        {
            largeImages.put(imageName, createImage(imageName.getLargeFormatStream()));
        }
        return largeImages.get(imageName);
    }

    private static Image createImage(InputStream iconStream)
    {
        if (iconStream != null)
        {
            return new Image(Display.getCurrent(), iconStream);
        }
        return null;
    }
}