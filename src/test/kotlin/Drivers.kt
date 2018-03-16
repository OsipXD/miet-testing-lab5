import com.automation.remarks.kirk.Browser
import com.automation.remarks.kirk.core.configuration
import com.automation.remarks.kirk.ext.autoClose
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.opera.OperaDriver

object Drivers {

    init {
        System.setProperty("webdriver.chrome.driver", "D:\\Developing\\Selenium\\Drivers\\chromedriver.exe")
        System.setProperty("webdriver.opera.driver", "D:\\Developing\\Selenium\\Drivers\\operadriver.exe")
    }

    operator fun get(type: Type): WebDriver {
        return when (type) {
            Type.CHROME -> ChromeDriver()
            Type.OPERA -> OperaDriver() as WebDriver
        }.apply {
            autoClose(true)
        }
    }

    enum class Type {
        CHROME, OPERA
    }
}

fun drive(
        type: Drivers.Type = Drivers.Type.CHROME,
        block: Browser.() -> Unit = {}
): Browser {
    return Browser(Drivers[type]).apply {
        config = configuration
        block()
    }
}
