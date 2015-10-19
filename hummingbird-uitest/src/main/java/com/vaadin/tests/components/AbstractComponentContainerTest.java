package com.vaadin.tests.components;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;

import com.vaadin.ui.AbstractComponentContainer;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.InlineDateField;
import com.vaadin.ui.NativeButton;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.RichTextArea;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalSplitPanel;

public abstract class AbstractComponentContainerTest<T extends AbstractComponentContainer>
        extends AbstractComponentTest<T> {

    private String CATEGORY_COMPONENT_CONTAINER_FEATURES = "Component container features";
    private Command<T, ComponentSize> addButtonCommand = new Command<T, ComponentSize>() {

        @Override
        public void execute(T c, ComponentSize size, Object data) {
            Button b = new Button("A button");
            c.addComponent(b);
            size.apply(b);
        }
    };

    private Command<T, ComponentSize> addNativeButtonCommand = new Command<T, ComponentSize>() {

        @Override
        public void execute(T c, ComponentSize size, Object data) {
            NativeButton b = new NativeButton("Native button");
            c.addComponent(b);
            size.apply(b);
        }
    };

    private Command<T, ComponentSize> addTextAreaCommand = new Command<T, ComponentSize>() {
        @Override
        public void execute(T c, ComponentSize size, Object data) {
            TextArea ta = new TextArea();
            c.addComponent(ta);
            size.apply(ta);
        }
    };

    private Command<T, ComponentSize> addRichTextAreaCommand = new Command<T, ComponentSize>() {
        @Override
        public void execute(T c, ComponentSize size, Object data) {
            RichTextArea ta = new RichTextArea();
            c.addComponent(ta);
            size.apply(ta);
        }
    };

    private Command<T, ComponentSize> addTextFieldCommand = new Command<T, ComponentSize>() {
        @Override
        public void execute(T c, ComponentSize size, Object data) {
            TextField tf = new TextField();
            c.addComponent(tf);
            size.apply(tf);
        }
    };

    private Command<T, ComponentSize> addInlineDateFieldCommand = new Command<T, ComponentSize>() {
        @Override
        public void execute(T c, ComponentSize size, Object data) {
            InlineDateField tf = new InlineDateField();
            c.addComponent(tf);
            size.apply(tf);
        }
    };
    private Command<T, ComponentSize> addPopupDateFieldCommand = new Command<T, ComponentSize>() {
        @Override
        public void execute(T c, ComponentSize size, Object data) {
            PopupDateField tf = new PopupDateField();
            c.addComponent(tf);
            size.apply(tf);
        }
    };

    private Command<T, ComponentSize> addVerticalSplitPanelCommand = new Command<T, ComponentSize>() {
        @Override
        public void execute(T c, ComponentSize size, Object data) {
            VerticalSplitPanel vsp = new VerticalSplitPanel();
            c.addComponent(vsp);
            size.apply(vsp);
        }
    };

    private Command<T, ComponentSize> addHorizontalSplitPanelCommand = new Command<T, ComponentSize>() {
        @Override
        public void execute(T c, ComponentSize size, Object data) {
            HorizontalSplitPanel vsp = new HorizontalSplitPanel();
            c.addComponent(vsp);
            size.apply(vsp);
        }
    };

    private Command<T, ComponentSize> addTabSheetCommand = new Command<T, ComponentSize>() {
        @Override
        public void execute(T c, ComponentSize size, Object data) {
            TabSheet ts = createTabSheet();
            c.addComponent(ts);
            size.apply(ts);
        }
    };

    private Command<T, Object> removeAllComponentsCommand = new Command<T, Object>() {
        @Override
        public void execute(T c, Object value, Object data) {
            c.removeAllComponents();
        }
    };
    private Command<T, Integer> removeComponentByIndexCommand = new Command<T, Integer>() {

        @Override
        public void execute(T c, Integer value, Object data) {
            Component child = getComponentAtIndex(c, value);
            c.removeComponent(child);

        }
    };

    private Command<T, Integer> setComponentHeight = new Command<T, Integer>() {

        @Override
        public void execute(T c, Integer value, Object data) {
            Component child = getComponentAtIndex(c, value);
            child.setHeight((String) data);

        }
    };

    private Command<T, Integer> setComponentWidth = new Command<T, Integer>() {

        @Override
        public void execute(T c, Integer value, Object data) {
            Component child = getComponentAtIndex(c, value);
            child.setWidth((String) data);

        }
    };

    protected static class ComponentSize {
        private String width, height;

        public ComponentSize(String width, String height) {
            this.width = width;
            this.height = height;
        }

        public void apply(Component target) {
            target.setWidth(width);
            target.setHeight(height);
        }

        public String getWidth() {
            return width;
        }

        public String getHeight() {
            return height;
        }

        @Override
        public String toString() {
            String s = "";
            s += width == null ? "auto" : width;
            s += " x ";
            s += height == null ? "auto" : height;
            return s;
        }
    }

    @Override
    protected void createActions() {
        super.createActions();

        createAddComponentActions(CATEGORY_COMPONENT_CONTAINER_FEATURES);
        createRemoveComponentActions(CATEGORY_COMPONENT_CONTAINER_FEATURES);
        createChangeComponentSizeActions(CATEGORY_COMPONENT_CONTAINER_FEATURES);
    }

    protected Component getComponentAtIndex(T container, int value) {
        Iterator<Component> iter = container.iterator();
        for (int i = 0; i < value; i++) {
            iter.next();
        }

        return iter.next();
    }

    protected TabSheet createTabSheet() {
        TabSheet ts = new TabSheet();
        NativeButton b = new NativeButton("Full sized");
        b.setSizeFull();
        ts.addTab(b, "Size full NativeButton", ICON_16_USER_PNG_UNCACHEABLE);
        ts.addTab(new Button("A button"), "Button", null);
        return ts;
    }

    private void createRemoveComponentActions(String category) {
        String subCategory = "Remove component";
        String byIndexCategory = "By index";

        createCategory(subCategory, category);
        createCategory(byIndexCategory, subCategory);
        createClickAction("Remove all components", subCategory,
                removeAllComponentsCommand, null);
        for (int i = 0; i < 20; i++) {
            createClickAction("Remove component " + i, byIndexCategory,
                    removeComponentByIndexCommand, Integer.valueOf(i));
        }

    }

    private void createAddComponentActions(String category) {
        String subCategory = "Add component";
        createCategory(subCategory, category);

        LinkedHashMap<String, Command<T, ComponentSize>> addCommands = new LinkedHashMap<String, AbstractComponentTestCase.Command<T, ComponentSize>>();
        addCommands.put("Button", addButtonCommand);
        addCommands.put("NativeButton", addNativeButtonCommand);
        addCommands.put("TextField", addTextFieldCommand);
        addCommands.put("TextArea", addTextAreaCommand);
        addCommands.put("RichTextArea", addRichTextAreaCommand);
        addCommands.put("TabSheet", addTabSheetCommand);
        addCommands.put("InlineDateField", addInlineDateFieldCommand);
        addCommands.put("PopupDateField", addPopupDateFieldCommand);
        addCommands.put("VerticalSplitPanel", addVerticalSplitPanelCommand);
        addCommands.put("HorizontalSplitPanel", addHorizontalSplitPanelCommand);

        HashSet<String> noVerticalSize = new HashSet<String>();
        noVerticalSize.add("TextField");
        noVerticalSize.add("Button");

        // addCommands.put("AbsoluteLayout", addAbsoluteLayoutCommand);
        // addCommands.put("HorizontalLayout", addHorizontalLayoutCommand);
        // addCommands.put("VerticalLayout", addVerticalLayoutCommand);

        ComponentSize[] sizes = new ComponentSize[] {
                new ComponentSize(null, null), new ComponentSize("200px", null),
                new ComponentSize("100%", null),
                new ComponentSize(null, "200px"),
                new ComponentSize(null, "100%"),
                new ComponentSize("300px", "300px"),
                new ComponentSize("100%", "100%"),

        };

        for (String componentCategory : addCommands.keySet()) {
            createCategory(componentCategory, subCategory);

            for (ComponentSize size : sizes) {
                if (size.getHeight() != null
                        && noVerticalSize.contains(componentCategory)) {
                    continue;
                }
                createClickAction(size.toString(), componentCategory,
                        addCommands.get(componentCategory), size);
            }
        }

    }

    private void createChangeComponentSizeActions(String category) {
        String widthCategory = "Change component width";
        createCategory(widthCategory, category);
        String heightCategory = "Change component height";
        createCategory(heightCategory, category);

        String[] options = new String[] { "100px", "200px", "50%", "100%" };
        for (int i = 0; i < 20; i++) {
            String componentWidthCategory = "Component " + i + " width";
            String componentHeightCategory = "Component " + i + " height";
            createCategory(componentWidthCategory, widthCategory);
            createCategory(componentHeightCategory, heightCategory);

            createClickAction("auto", componentHeightCategory,
                    setComponentHeight, Integer.valueOf(i), null);
            createClickAction("auto", componentWidthCategory, setComponentWidth,
                    Integer.valueOf(i), null);
            for (String option : options) {
                createClickAction(option, componentHeightCategory,
                        setComponentHeight, Integer.valueOf(i), option);
                createClickAction(option, componentWidthCategory,
                        setComponentWidth, Integer.valueOf(i), option);
            }

        }

    }

}