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
package org.nova.html.bootstrap4.ext;

import org.nova.html.bootstrap4.CustomControl;
import org.nova.html.bootstrap4.CustomLabel;
import org.nova.html.bootstrap4.CustomRadio;
import org.nova.html.bootstrap4.StyleComponent;

public class CustomRadioControl extends StyleComponent<CustomRadioControl>
{
    private CustomRadio customRadio;
    private CustomLabel customLabel;

    public CustomRadioControl(String label,String name,Object value)
    {
        super("div", "custom-control");
        addClass("custom-radio");
        this.customRadio = returnAddInner(new CustomRadio()).name(name).value(value);
        this.customRadio.id();
        this.customLabel=returnAddInner(new CustomLabel()).for_(customRadio);
        if (label!=null)
        {
            this.customLabel.addInner(label);
        }
        else
        {
            this.customLabel.addInner("&#x200B;");
        }
    }
    public CustomRadioControl(String name,Object value,CustomLabel label)
    {
        super("div", "custom-control");
        addClass("custom-radio");
        this.customRadio = returnAddInner(new CustomRadio()).name(name).value(value);
        this.customRadio.id();
        this.customLabel=label;
        this.customLabel.for_(customRadio);
    }
    
    public CustomRadio customRadio()
    {
        return this.customRadio;
    }
}
