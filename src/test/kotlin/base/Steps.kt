package base

import com.automation.remarks.kirk.KElement
import cucumber.api.java8.En
import drive

abstract class Steps(url: String) : En {

    protected val browser = drive {
        open(url)
    }

    protected lateinit var focused: KElement

    protected fun KElement.sendData(data: String) {
        enterData(data)
        pressEnter()
    }

    protected fun KElement.enterData(data: String) {
        click()
        focused = this
        sendKeys(data)
    }
}