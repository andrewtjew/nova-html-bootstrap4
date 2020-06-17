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

import org.nova.html.bootstrap4.Button;
import org.nova.html.bootstrap4.ModalCloseButton;
import org.nova.html.bootstrap4.classes.StyleColor;
import org.nova.html.tags.h5;

public class ConfirmDialog extends ModalDocument 
{ 
    public ConfirmDialog(boolean center,String title,String message,String cancelButtonText,String confirmButtonText,String confirmButtonSCript)
    {
        super(center);
        header().bg(StyleColor.primary).text(StyleColor.light).addInner(new h5().addInner((title)));
        body().addInner(message);
        footer().addInner(new Button().color(StyleColor.success).addInner(confirmButtonText).onclick(confirmButtonSCript));
        footer().addInner(new ModalCloseButton(cancelButtonText));
    }
    public ConfirmDialog(boolean center,String title,String message,String confirmButtonSCript)
    {
        this(center,title,message,"Cancel","OK",confirmButtonSCript);
    }
}
