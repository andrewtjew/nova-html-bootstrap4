/*******************************************************************************
 * Copyright (C) 2017-2019 Kat Fung Tjew
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 ******************************************************************************/
package org.nova.html.bootstrap4;

import org.nova.html.bootstrap4.classes.StyleColor;
import org.nova.html.elements.Element;
import org.nova.html.tags.td;

public class TableRow extends StyleComponent<TableRow>
{
    public TableRow()
    {
        super("tr","table");
    }
    
    public TableRow add(Object...objects)
    {
        if (objects==null)
        {
            addInner(new td());
        }
        else
        {
            for (Object object:objects)
            {
                if (object==null)
                {
                    addInner(new td());
                }
                else if (object instanceof td)
                {
                    addInner(object);
                }
                else if (object instanceof Element)
                {
                    addInner(new td().addInner((Element)object));
                }
                else
                {
                    addInner(new td().addInner(object.toString()));
                }
            }
        }
        return this;
        
    }
    
    public TableRow table_color(StyleColor value)
    {
        addClass("table",value);
        return this;
    }
}
