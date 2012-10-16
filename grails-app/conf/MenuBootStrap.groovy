import agricloud.Menu


class MenuBootStrap {
    def init = { servletContext ->
		new Menu(functionId: 'US.USM001', description: '使用者資料維護').save(failOnError: true)
        new Menu(functionId: 'MN.MNM001', description: '群組權限維護').save(failOnError: true)
    }

    def destroy = {
    }
}