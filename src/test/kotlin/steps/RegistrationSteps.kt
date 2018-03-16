//package steps
//
//import base.Steps
//import com.automation.remarks.kirk.conditions.size
//import com.automation.remarks.kirk.ext.s
//import org.openqa.selenium.Keys
//import kotlin.test.assertTrue
//
//class RegistrationSteps : Steps("https://passport.yandex.ru/registration-new") {
//
//    private val firstNameField by lazy { browser.s("input#firstname") }
//    private val lastNameField by lazy { browser.s("input#lastname") }
//    private val loginField by lazy { browser.s("input#login") }
//    private val passField by lazy { browser.s("input#password") }
//    private val passConfirmField by lazy { browser.s("input#password_confirm") }
//    private val phoneField by lazy { browser.s("input#phone") }
//
//    init {
//        When("^typed ([^\"]*): ([^\"]*)$") { type: String, text: String ->
//            when (type) {
//                "first name" -> firstNameField.enterData(text)
//                "last name" -> lastNameField.enterData(text)
//                "login" -> loginField.enterData(text)
//                "password" -> passField.enterData(text)
//                "password confirmation" -> passConfirmField.enterData(text)
//                "phone" -> phoneField.enterData(text)
//            }
//        }
//
//        When("^pressed tab$") {
//            focused.sendKeys(Keys.TAB)
//        }
//
//        Then("^all fields should be valid$") {
//            browser.s("form.registration__form").children("div.field__valid") shouldHave size(5)
//        }
//
//        //language=RegExp
//        Then("^should have (\\d+) invalid fields$") { n: Int ->
//            browser.s("form.registration__form").children("div.field__valid") shouldHave size(5 - n)
//        }
//    }
//}