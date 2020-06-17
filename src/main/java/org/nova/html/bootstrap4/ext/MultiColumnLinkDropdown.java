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
import org.nova.html.bootstrap4.ButtonComponent;
import org.nova.html.bootstrap4.Container;
import org.nova.html.bootstrap4.Item;
import org.nova.html.bootstrap4.classes.Justify;
import org.nova.html.bootstrap4.classes.StyleColor;
import org.nova.html.elements.Composer;
import org.nova.html.elements.Element;
import org.nova.html.tags.a;
import org.nova.html.tags.div;

public class MultiColumnLinkDropdown extends ButtonComponent<MultiColumnLinkDropdown>
{
    final private Item menu;
    final private Item container;
    private boolean split;
    private boolean usehref;
    private boolean menuRight;
    private Item current;
    
    public MultiColumnLinkDropdown(String label)
    {
        this(label,null);
    }
    public MultiColumnLinkDropdown(String label,String href)
    {
        super("a");
        this.usehref=href!=null;
        attr("href",href);
        addInner(label);
        this.menu=new Item();
        this.container=new Item().d_flex();
        this.menu.addInner(container);
        addColumn();
    }

    public MultiColumnLinkDropdown addColumn()
    {
        this.current=this.container.returnAddInner(new Item()).mx(1);
        return this;
    }
    
    
    public Item menu()
    {
        return this.menu;
    }
    
    public MultiColumnLinkDropdown addToMenu(String label,String href)
    {
        this.current.addInner((new a().addClass("dropdown-item").href(href).addInner(label)));
        return this;
    }
    public MultiColumnLinkDropdown addToMenu(Element element)
    {
        this.current.addInner(element);
        return this;
    }

    public MultiColumnLinkDropdown addDivider()
    {
        this.current.addInner(new div().addClass("dropdown-divider"));
        return this;
    }
    public MultiColumnLinkDropdown menuRight(boolean value)
    {
        this.menuRight=value;
        return this;
    }
    
    public MultiColumnLinkDropdown split()
    {
        this.split=true;
        return this;
    }
    
    @Override
    public void compose(Composer composer) throws Throwable
    {
        this.menu.addClass("dropdown-menu");
        if (this.menuRight)
        {
            this.menu.addClass("dropdown-menu-right");
        }
        
        if (this.split)
        {
            div group=new div().addClass("btn-group");
            group.addInner(new Element()
            {
                @Override
                public void compose(Composer composer) throws Throwable
                {
                    if (usehref==false)
                    {
                        attr("data-toggle","dropdown");
                    }
                    composeThis(composer);
                    Button splitter=new Button().attr("data-toggle","dropdown").attr("aria-haspopup",true).attr("aria-expanded",false);
                    splitter.addClass(class_());
                    splitter.addClass("dropdown-toggle");
                    splitter.addClass("dropdown-toggle-split");
                    splitter.compose(composer);
                    menu.compose(composer);
                }
            });
            group.compose(composer);
        }
        else
        {
            attr("data-toggle","dropdown");
            addClass("dropdown-toggle");
            super.compose(composer);
            this.menu.compose(composer);
        }
        
    }

}
