import agricloud.Menu


class MenuBootStrap {
    def init = { servletContext ->
		new Menu(functionId: 'US.USM001', description: '使用者資料維護').save(failOnError: true)
        new Menu(functionId: 'MN.MNM001', description: '功能群組維護').save(failOnError: true)
		new Menu(functionId: 'US.USM002', description: '使用者群組維護').save(failOnError: true)
		
    }

    def destroy = {
    }
}