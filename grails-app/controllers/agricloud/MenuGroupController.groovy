package agricloud

import grails.converters.JSON

class MenuGroupController {
    static scaffold = true
	
	
	
	
	def listAll = {
		def list = []
		MenuGroup.list().each { menuGroup->
			list << [
				id:menuGroup.id,
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
	
	def create = {
		log.info request.JSON
		def menu=Menu.findByFunctionId(request.JSON.menuId)
		def userGroup=UserGroup.findByUserGroupId(request.JSON.userGroupId)

		log.info menu
		log.info userGroup
		
		def item=new MenuGroup()
		item.menu=menu;
		item.userGroup=userGroup;
		

		item.save();
		response.status = 201
		render item as JSON

	}
	def update = {
		def menu=Menu.findByFunctionId(request.JSON.menuId)
		def userGroup=UserGroup.findByUserGroupId(request.JSON.userGroupId)
		def item=MenuGroup.findById(request.JSON.id)
		if (!item) {
			SendNotFoundResponse()
		}
		
		item.menu=menu;
		item.userGroup=userGroup;


		if (item.validate()) {
			item.save();
			response.status = 201
			render ""
		} else {
			sendValidationFailedResponse(item, 403)
		}
	}
	
	def delete={
		

		def item=MenuGroup.findById(params.id)

		if (!item) {
			SendNotFoundResponse()
		}
		item.delete();
		response.status = 204
		render ""
	}
	private def sendValidationFailedResponse(item, status) {
		response.status = status
		render contentType: "application/xml", {
			item {
				item?.errors?.fieldErrors?.each {err ->
					field(err.field)
					message(g.message(error: err))
				}
			}
		}
	}
	private def SendNotFoundResponse() {
		response.status = 404
		render contentType: "application/xml", {
			errors {
				message("Customer not found with id: " + params.id)
			}
		}
	}
}
