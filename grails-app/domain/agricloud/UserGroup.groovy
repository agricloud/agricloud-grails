package agricloud

class UserGroup {
	
	String userGroupId
	String description
	
    static constraints = {
		description nullable:true
    }
}
