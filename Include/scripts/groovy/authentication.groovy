import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.testng.Assert
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class authentication {

	@Given("I access to automation exercise system")
	def access_to_system() {
		WebUI.openBrowser(GlobalVariable.BASE_URL)
		WebUI.maximizeWindow()
	}

	@When("The {string} page should be displayed")
	def verify_page_displayed(String pageName) {
		switch(pageName.toUpperCase()) {
			case 'HOME':
				WebUI.waitForElementVisible(findTestObject('Object Repository/000_Common/div_GetById',['param':'slider-carousel']), GlobalVariable.MIN_TIME_FOR_WAIT)
				WebUI.verifyElementVisible(findTestObject('Object Repository/000_Common/div_GetById',['param':'slider-carousel']))
				break

			case 'SIGNUP / LOGIN':
				WebUI.waitForElementVisible(findTestObject('Object Repository/000_Common/h2_GeneralText',['param':'New User Signup!']), GlobalVariable.MIN_TIME_FOR_WAIT)
				WebUI.verifyElementVisible(findTestObject('Object Repository/000_Common/h2_GeneralText',['param':'New User Signup!']))
				break

			default:
				throw new IllegalStateException ("Page name is invalid!")
		}
	}

	@Then("The {string} menu's option should be focused")
	def verify_menu_option_focused(String menuOption) {
		WebUI.waitForElementVisible(findTestObject('Object Repository/000_Common/a_GeneralText',['param':menuOption]), GlobalVariable.MIN_TIME_FOR_WAIT)
		String attributeText = WebUI.getAttribute(findTestObject('Object Repository/000_Common/a_GeneralText',['param':menuOption]), 'style')
		Assert.assertTrue(attributeText.contains('orange'), "Menu's option is NOT focused")
	}

	@When("I click {string} menu's option")
	def click_menu_option(String menuOption) {
		WebUI.waitForElementVisible(findTestObject('Object Repository/000_Common/a_GeneralText',['param':menuOption]), GlobalVariable.MIN_TIME_FOR_WAIT)
		WebUI.click(findTestObject('Object Repository/000_Common/a_GeneralText',['param':menuOption]))
	}
}