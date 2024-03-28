package com.jnj.pageobjects;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.jnj.base.BaseClass;

public class WhereToBuyPage extends BaseClass{
	
	Actions actions;

	/**
	 * Constructor
	 */
	public WhereToBuyPage() {
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
	}


}
