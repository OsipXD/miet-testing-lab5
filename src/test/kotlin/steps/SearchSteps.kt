package steps

import com.automation.remarks.kirk.conditions.text
import com.automation.remarks.kirk.ext.s
import base.Steps
import java.util.*
import kotlin.test.assertTrue

class SearchSteps : Steps("http://rpginventory.endlesscode.ru/en/") {

    private val searchBox by lazy { browser.element("#qsearch__in") }
    private val searchResults by lazy { browser.element(".search_results") }

    init {
        Given("^opened registration form$") {
            browser.element(".login_link_desktop").click()
        }

        When("^typed random text to search box$") {
            searchBox.sendData(UUID.randomUUID().toString())
        }

        When("^typed \"([^\"]*)\" to search box") { text: String ->
            searchBox.sendData(text)
        }

        Then("^should show no results$") {
            browser.element("div.nothing")
                    .shouldHave(text("Nothing was found."))
        }

        Then("^\"([^\"]*)\" should be first in search results$") { title: String ->
            searchResults.firstChild().s("a")
                    .shouldHave(text(title))
        }

        Then("^\"([^\"]*)\" should be in search results$") { title: String ->
            assertTrue {
                searchResults.children("dt a").any { it.text == title }
            }
        }
    }
}
