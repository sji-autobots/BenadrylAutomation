package com.jnj.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jnj.base.BaseClass;

public class AllergiesPage extends BaseClass {
	Actions actions;

	/**
	 * Constructor
	 */
	public AllergiesPage() {
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
	}

	/**
	 * Locators
	 */
	@FindBy(xpath = "(//*[@id='header-search-btn']/span)[1]")
	WebElement searchBtn;

}
