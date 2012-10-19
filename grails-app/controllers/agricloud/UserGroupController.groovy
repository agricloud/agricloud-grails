package agricloud

import grails.converters.JSON

class UserGroupController {
	static scaffold = true

	def listAll = {
		render (contentType: 'text/json') {
			[
						items: UserGroup.list(),
						totalCount: UserGroup.count()
						]
		}
	}
	def create = {
		def item=new UserGroup(userGroupId: request.JSON.userGroupId, description: request.JSON.description)
		
		item.save()
		render (contentType: 'text/json') {
			[
				success: item.hasErrors()==false
			]
		}
	}
	def update = {
		def item=UserGroup.findById(params.id)

		if (!item) {
			render (contentType: 'text/json') {
				[
					success: false
				]
			}
		}else {
		
			item.userGroupId = request.JSON.userGroupId
			item.description = request.JSON.description	
			item.save()
			render (contentType: 'text/json') {
				[
					success: item.hasErrors()==false
				]
			}
		}
	}
	
	def delete={
		def item=UserGroup.findById(params.id)

		if (!item) {
			render (contentType: 'text/json') {
				[
					success: false
				]
			}
		}else {
			item.delete();
			
			render (contentType: 'text/json') {
				[
					success: item.hasErrors()==false
				]
			}
		}
	}
//	def rest = {
//		switch(request.method){
//			case "POST"://save
//				break
//			case "GET":
//				break
//			case "PUT"://update
//				break
//			case "DELETE":
//				break
//		}
//	}

}
