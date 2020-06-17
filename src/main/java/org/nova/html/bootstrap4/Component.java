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

import org.nova.html.bootstrap4.classes.DeviceClass;
import org.nova.html.bootstrap4.classes.Float_;
import org.nova.html.elements.GlobalEventTagElement;

public abstract class Component<ELEMENT extends Component<ELEMENT>> extends GlobalEventTagElement<ELEMENT> 
{
    final private String componentClass;
//    private DeviceClass deviceClass;

    public Component(String tag,String componentClass)
    {
        this(tag,componentClass,false);
    }
    
    public Component(String tag,String componentClass,boolean noEndTag)
    {
        super(tag,noEndTag);
        this.componentClass=componentClass;
        addClass(componentClass);
    }
    
    protected String getComponentClass()
    {
        return this.componentClass;
    }
    /*
    protected DeviceClass getDeviceClass()
    {
        return this.deviceClass;
    }
    */
    
    public ELEMENT addClass(Object class_,Object...fragments)
    {
        if (fragments!=null)
        {
            if (class_!=null)
            {
                StringBuilder sb=new StringBuilder(class_.toString());
                for (Object fragment:fragments)
                {
                    if (fragment!=null)
                    {
                        sb.append('-').append(fragment);
                    }
                }
                addClass(sb.toString());
            }
        }
        return (ELEMENT)this;
    }

    public ELEMENT addClass(ClassBuilder classBuilder)
    {
        addClass(classBuilder.toString());
        return (ELEMENT)this;
    }
    
    public ELEMENT deviceClass(DeviceClass deviceClass)
    {
        return addClass(this.getComponentClass(),deviceClass);
    }

}
