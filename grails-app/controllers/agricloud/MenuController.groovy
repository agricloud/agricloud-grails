package agricloud

class MenuController {
    static scaffold = true

    def tree = {

    	//def user = User.findByAccount(params.account)

    	def menus = Menu.list()

        def list=[];

        for ( i in menus ) {
            def map=[text:i.functionId,leaf:true,iconCls:'text',id:i.functionId]
            list.add(map)
        }


        render (contentType: 'text/json') {
            ["children": list]
        }

    }
}