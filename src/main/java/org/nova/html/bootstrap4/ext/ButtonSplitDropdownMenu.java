package org.nova.html.bootstrap4.ext;

import org.nova.html.bootstrap4.Button;
import org.nova.html.bootstrap4.ButtonDropdown;
import org.nova.html.bootstrap4.ButtonGroup;
import org.nova.html.bootstrap4.DropdownMenu;
import org.nova.html.bootstrap4.ToggleDropdownButton;
import org.nova.html.bootstrap4.classes.StyleColor;

public class ButtonSplitDropdownMenu extends ButtonGroup
{
    final private Button button;
    final private ToggleDropdownButton toggler;
    final private DropdownMenu menu;
    
    public ButtonSplitDropdownMenu()
    {
        addClass("dropdown");
        this.button=returnAddInner(new Button());
        this.toggler=returnAddInner(new ToggleDropdownButton());
        this.menu=returnAddInner(new DropdownMenu(this.toggler()));
    }
    
    public ButtonSplitDropdownMenu buttonToggles()
    {
        this.button().onclick(this.menu.js_dropdown_toggle());
        button.data("toggle","dropdown");
//        this.menu.reference_parent(this.button);
        return this;
    }

    public Button button()
    {
        return button;
    }

    public ToggleDropdownButton toggler()
    {
        return toggler;
    }

    public DropdownMenu menu()
    {
        return menu;
    }
    
    public ButtonSplitDropdownMenu color(StyleColor color)
    {
        this.button().color(color);
        this.toggler().color(color);
        return this;
    }
    
    
    
}
