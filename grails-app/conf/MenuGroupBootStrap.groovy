import agricloud.Menu
import agricloud.MenuGroup
import agricloud.UserGroup


class MenuGroupBootStrap {
    def init = { servletContext ->
		new UserGroup(userGroupId: 'admin', description: '管理者群組').save(failOnError: true)
		
		Menu.list().each { menu->
			new MenuGroup(menu: menu, userGroup: UserGroup.findByUserGroupId('admin')).save(failOnError: true)
		}
				
    }

    def destroy = {
    }
}