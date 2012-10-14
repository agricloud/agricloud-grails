package agricloud

class Menu {
	String functionId
	String description
	//String groupId
	Menu parent

    static constraints = {
    	parent nullable: true
    }
}
