package agricloud

import grails.converters.JSON

class MenuController {
    static scaffold = true

    def treeStore = {
    	//def user = User.findByAccount(params.account)

        def list = []

        // Groovier Style ;-)
        Menu.list().each { menu->
            list << [
                id: menu.functionId,
                text: menu.description,
                leaf: true,
                iconCls: 'text'
            ]
        }

        render (contentType: 'text/json') {
            [children: list]
        }
    }
	
	def gridStore = {
		render (contentType: 'text/json') {
            [
				items: Menu.list(),
				totalCount: Menu.count()
			]
        }
	}
	

}