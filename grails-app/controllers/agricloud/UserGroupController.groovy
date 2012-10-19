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
		if (item.validate()) {
			item.save();
			response.status = 201
			render item as JSON
		} else {
			sendValidationFailedResponse(item, 403)
		}
	}
	def update = {
		def item=UserGroup.findById(params.id)
		if (!item) {
			SendNotFoundResponse()
		}
		item.userGroupId = request.JSON.userGroupId
		item.description = request.JSON.description


		if (item.validate()) {
			item.save();
			response.status = 201
			render ""
		} else {
			sendValidationFailedResponse(item, 403)
		}
	}
	
	def delete={
		def item=UserGroup.findById(params.id)

		if (!item) {
			SendNotFoundResponse()
		}
		item.delete();
		response.status = 204
		render ""
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
