package agricloud

import grails.converters.JSON

class MenuGroupController {
    static scaffold = true
	
	
	
	
	def gridStore = {
		def list = []
		
				// Groovier Style ;-)
		MenuGroup.list().each { menuGroup->
			list << [
				menuId: menuGroup.menu.functionId,
				menuDes:menuGroup.menu.description,
				userGroupId: menuGroup.userGroup.userGroupId,
				userGroupDes: menuGroup.userGroup.description
			]
		}
		
		render (contentType: 'text/json') {
            [
				items: list,
				totalCount: list.size()
			]
		}

	}	
}
