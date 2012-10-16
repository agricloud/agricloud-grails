import agricloud.Menu
import agricloud.User


class UserBootStrap {
    def init = { servletContext ->
        // Check whether the test data already exists.
		
		new User(account: "", password: "" ).save(failOnError: true)
		new User(account: "admin", password: "admin" ).save(failOnError: true)

    }

    def destroy = {
    }
}