import agricloud.Menu


class MenuBootStrap {
    def init = { servletContext ->

		
		new Menu(functionId: "USM001", description: "使用者資料維護" ).save(failOnError: true)
        new Menu(functionId: "MNM001", description: "群組權限維護").save(failOnError: true)

    }

    def destroy = {
    }
}