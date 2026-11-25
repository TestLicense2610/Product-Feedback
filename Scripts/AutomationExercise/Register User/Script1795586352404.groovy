import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

def element = { String xpath -> new TestObject().addProperty('xpath', ConditionType.EQUALS, xpath) }
def counterFile = java.nio.file.Paths.get(System.getProperty('user.dir'), 'automationexercise_email_counter.txt')
def lastNumber = java.nio.file.Files.exists(counterFile) ?
        new String(java.nio.file.Files.readAllBytes(counterFile), java.nio.charset.StandardCharsets.UTF_8).trim().toInteger() : 1
def emailNumber = lastNumber + 1
email = "automationexercise${emailNumber}@example.com"
java.nio.file.Files.write(
        counterFile,
        emailNumber.toString().getBytes(java.nio.charset.StandardCharsets.UTF_8)
)

try {
    WebUI.openBrowser('')
    WebUI.navigateToUrl('https://www.automationexercise.com/')
    WebUI.click(element('//a[@href="/login"]'))
    WebUI.setText(element('//input[@data-qa="signup-name"]'), name)
    WebUI.setText(element('//input[@data-qa="signup-email"]'), email)
    WebUI.click(element('//button[@data-qa="signup-button"]'))
    WebUI.verifyElementPresent(element('//h2[contains(normalize-space(), "Enter Account Information")]'), 10)
    WebUI.click(element('//input[@id="id_gender1"]'))
    WebUI.setText(element('//input[@data-qa="password"]'), password)
    WebUI.selectOptionByValue(element('//select[@id="days"]'), '1', false)
    WebUI.selectOptionByValue(element('//select[@id="months"]'), '1', false)
    WebUI.selectOptionByValue(element('//select[@id="years"]'), '1990', false)
    WebUI.setText(element('//input[@data-qa="first_name"]'), 'Test')
    WebUI.setText(element('//input[@data-qa="last_name"]'), 'User')
    WebUI.setText(element('//input[@data-qa="address"]'), '1 Test Street')
    WebUI.selectOptionByLabel(element('//select[@id="country"]'), 'United States', false)
    WebUI.setText(element('//input[@data-qa="state"]'), 'California')
    WebUI.setText(element('//input[@data-qa="city"]'), 'Los Angeles')
    WebUI.setText(element('//input[@data-qa="zipcode"]'), '90001')
    WebUI.setText(element('//input[@data-qa="mobile_number"]'), '5551234567')
    WebUI.click(element('//button[@data-qa="create-account"]'))
    WebUI.verifyElementPresent(element('//h2[@data-qa="account-created"]'), 10)
    WebUI.click(element('//a[@data-qa="continue-button"]'))
} finally {
    WebUI.closeBrowser()
}