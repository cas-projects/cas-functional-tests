import pages.AdminPage
import pages.LoginPage
import pages.LoginPageWithService
import pages.LogoutPage

class LoginSpecWithService extends CommonGebSpec {
	def setup() {
		super
		to LoginPageWithService
	}

    def "Correct credentials, with service, logout test"() {
		given:
        at LoginPageWithService

        when: "submit correct credentials"
		loginAs(properties.username, properties.password)

		// Verify csrfToken presence
		String cookieValue = verifyCookie(properties."cookie.name")
		
        then: "you should be redirected to foo with a valid service ticket"
        at AdminPage

		// Visit /logout
		to LogoutPage
		browser.go("/$contextRoot/logout")
		
		// Verify that CAS overwrote the TGT cookie
		def newCookie = driver.manage().getCookieNamed(properties."cookie.name")
		assert newCookie != cookieValue
		
		// Visit /login?service=foo
		to LoginPageWithService
		
		then: "see form asking for credentials"
		at LoginPage
    }
}
