package agricloud

class UserController {
    static scaffold = true

    def login = {
    	log.info "account=${params.account}"
    	log.info "password=${params.password}"

    	//def user = User.findByAccount(params.account)

    	def users = User.withCriteria {
    		eq ('account', params.account)
    		eq ('password', params.password)
    	}

        render (contentType: 'text/json') {
            [
                success: users.size()==1,
                session: new Date().toString().encodeAsMD5()
            ]
        }
    }

}
