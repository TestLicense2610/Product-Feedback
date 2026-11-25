import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase

def element = { String xpath ->
    new TestObject().addProperty('xpath', ConditionType.EQUALS, xpath)
}


  WebUI.openBrowser('')
  
  WebUI.navigateToUrl('https://www.automationexercise.com/')
  
  WebUI.click(element('//a[@href="/login"]'))
  
  WebUI.setText(element('//input[@data-qa="login-email"]'), email)
  
  WebUI.setText(element('//input[@data-qa="login-password"]'), password)
  
  WebUI.click(element('//button[@data-qa="login-button"]'))
  
  WebUI.verifyElementPresent(element('//a[contains(normalize-space(),"Logged in as")]'), 10)
 
//WebUI.callTestCase(findTestCase('Test Cases/AutomationExercise/Login User with correct email and password'),null,FailureHandling.STOP_ON_FAILURE)

WebUI.click(element('//a[@href="/logout"]'))

WebUI.verifyElementPresent(element('//h2[contains(normalize-space(), "Login to your account")]'), 10)

WebUI.closeBrowser()

