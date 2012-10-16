import agricloud.*

/**
 * User Boot Strap
 * 佈署階段自動載入使用者資料
 */
class UserBootStrap {
    def init = { servletContext ->
        // Check whether the test data already exists.
		
		new User(account: "", password: "" ).save(failOnError: true)
		new User(account: "admin", password: "admin" ).save(failOnError: true)
    }

    def destroy = {
    }
}