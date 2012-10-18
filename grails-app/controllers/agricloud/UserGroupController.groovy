package agricloud

class UserGroupController {
    static scaffold = true
	
	def gridStore = {
		render (contentType: 'text/json') {
			[
				items: UserGroup.list(),
				totalCount: UserGroup.count()
			]
		}
	}
}
