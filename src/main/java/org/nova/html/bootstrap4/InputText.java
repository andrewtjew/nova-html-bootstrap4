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

import org.nova.html.elements.InputType;
import org.nova.html.enums.autocomplete;

public class InputText extends InputComponent<InputText>
{
    public InputText()
    {
        super(InputType.text);
    }
    public InputText autocomplete(autocomplete autocomplete) //text, search, url, tel, email, password, datepickers, range, and color.
    {
        attr("autocomplete",autocomplete);
        return this;
    }
    public InputText autocomplete(boolean autocomplete)
    {
        if (autocomplete)
        {
            attr("autocomplete");
        }
        return this;
    }
    
    public InputText dirname(String value) //text
    {
        return attr("dirname",value);
    }
    public InputText maxlength(long number) //text
    {
        return attr("maxlength",number);
    }
    public InputText pattern(String regex) 
    {
        return attr("pattern",regex);
    }
    public InputText placeholder(String text) //text, search, url, tel, email, and password.
    {
        return attr("placeholder",text);
    }
    public InputText list(String id)
    {
        return attr("list",id);
    }
    
    public InputText size(int number) //text, search, tel, url, email, and password.
    {
        return attr("size",number);
    }
    public InputText required()  //text, search, url, tel, email, password, date pickers, number, checkbox, radio, and file.
    {
        return attr("required");
    }
    public InputText value(String text) //button, reset, submit, text, password, hidden, checkbox, radio, image
    {
        return attr("value",text);
    }

}

