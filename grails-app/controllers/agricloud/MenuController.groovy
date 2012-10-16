package agricloud

class MenuController {
    static scaffold = true

    def tree = {
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
}