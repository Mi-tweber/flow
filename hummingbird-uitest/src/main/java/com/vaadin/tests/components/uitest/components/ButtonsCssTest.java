package com.vaadin.tests.components.uitest.components;

import com.vaadin.server.ExternalResource;
import com.vaadin.server.ThemeResource;
import com.vaadin.tests.components.uitest.TestSampler;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Link;
import com.vaadin.ui.themes.ValoTheme;

public class ButtonsCssTest extends GridLayout {

    private TestSampler parent;
    private int debugIdCounter = 0;

    public ButtonsCssTest(TestSampler parent) {
        this.parent = parent;
        setSpacing(true);
        setWidth("100%");
        setColumns(6);

        Button b = new Button("Default button");
        b.setId("button" + debugIdCounter++);
        addComponent(b);

        b = new Button("Button with icon");
        b.setIcon(new ThemeResource(parent.ICON_URL));
        b.setId("button" + debugIdCounter++);
        addComponent(b);

        b = new Button("Button with tooltip");
        b.setId("button" + debugIdCounter++);
        addComponent(b);

        b = new Button("Link button");
        b.setStyleName(ValoTheme.BUTTON_LINK);
        b.setId("button" + debugIdCounter++);
        addComponent(b);

        b = new Button("Disabled on click button");
        b.setDisableOnClick(true);
        b.setId("button" + debugIdCounter++);
        addComponent(b);

        CheckBox cb = new CheckBox("Checkbox");
        cb.setId("button" + debugIdCounter++);
        addComponent(cb);

        cb = new CheckBox("Checkbox with icon");
        cb.setIcon(new ThemeResource(parent.ICON_URL));
        cb.setId("button" + debugIdCounter++);
        addComponent(cb);

        Link l = new Link("A link", new ExternalResource(""));
        l.setId("button" + debugIdCounter++);
        addComponent(l);

        createButtonWith("Primary", ValoTheme.BUTTON_PRIMARY, null);
        createButtonWith("Tiny", ValoTheme.BUTTON_TINY, null);
        createButtonWith("Small", ValoTheme.BUTTON_SMALL, null);
        createButtonWith("Large", ValoTheme.BUTTON_LARGE, null);
        createButtonWith("Huge", ValoTheme.BUTTON_HUGE, null);
        createButtonWith("Borderless", ValoTheme.BUTTON_BORDERLESS, null);
        createButtonWith("Icon only", ValoTheme.BUTTON_ICON_ONLY,
                parent.ICON_URL);

    }

    private void createButtonWith(String caption, String primaryStyleName,
            String iconUrl) {
        Button b = new Button();
        b.setId("button" + debugIdCounter++);

        if (caption != null) {
            b.setCaption(caption);
        }

        if (primaryStyleName != null) {
            b.addStyleName(primaryStyleName);
        }

        if (iconUrl != null) {
            b.setIcon(new ThemeResource(iconUrl));
        }

        addComponent(b);

    }

    @Override
    public void addComponent(Component component) {
        parent.registerComponent(component);
        super.addComponent(component);
    }

}