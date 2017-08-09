/*
 * Copyright 2000-2017 Vaadin Ltd.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.vaadin.generated.vaadin.grid;

import com.vaadin.ui.Component;
import com.vaadin.ui.ComponentSupplier;
import com.vaadin.ui.HasStyle;
import javax.annotation.Generated;
import com.vaadin.annotations.Tag;
import com.vaadin.annotations.HtmlImport;
import elemental.json.JsonObject;

@Generated({
		"Generator: com.vaadin.generator.ComponentGenerator#0.1.17-SNAPSHOT",
		"WebComponent: vaadin-grid-table-body#UNKNOWN", "Flow#0.1.17-SNAPSHOT"})
@Tag("vaadin-grid-table-body")
@HtmlImport("frontend://bower_components/vaadin-grid/vaadin-grid-table-header-footer.html")
public class GeneratedVaadinGridTableBody<R extends GeneratedVaadinGridTableBody<R>>
		extends
			Component implements ComponentSupplier<R>, HasStyle {

	/**
	 * This property is not synchronized automatically from the client side, so
	 * the returned value may not be the same as in client side.
	 */
	public boolean isFocused() {
		return getElement().getProperty("focused", false);
	}

	/**
	 * @param focused
	 *            the boolean value to set
	 * @return this instance, for method chaining
	 */
	public R setFocused(boolean focused) {
		getElement().setProperty("focused", focused);
		return get();
	}

	public void focusLeft() {
		getElement().callFunction("focusLeft");
	}

	public void focusDown() {
		getElement().callFunction("focusDown");
	}

	public void focusPageDown() {
		getElement().callFunction("focusPageDown");
	}

	public void focusPageUp() {
		getElement().callFunction("focusPageUp");
	}

	public void focusRight() {
		getElement().callFunction("focusRight");
	}

	public void focusUp() {
		getElement().callFunction("focusUp");
	}

	public void focusHome() {
		getElement().callFunction("focusHome");
	}

	public void focusEnd() {
		getElement().callFunction("focusEnd");
	}

	/**
	 * @param e
	 *            Missing documentation!
	 */
	protected void focusFirst(JsonObject e) {
		getElement().callFunction("focusFirst", e);
	}

	public void focusLast() {
		getElement().callFunction("focusLast");
	}
}