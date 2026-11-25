import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

def element = { String xpath -> new TestObject().addProperty('xpath', ConditionType.EQUALS, xpath) }

WebUI.openBrowser('')
WebUI.navigateToUrl('https://www.automationexercise.com/')
WebUI.click(element('//a[@href="/login"]'))
WebUI.setText(element('//input[@data-qa="login-email"]'), email)
WebUI.setText(element('//input[@data-qa="login-password"]'), password)
WebUI.click(element('//button[@data-qa="login-button"]'))
WebUI.verifyElementPresent(element('//a[contains(normalize-space(), "Logged in as")]'), 10)
WebUI.closeBrowser()