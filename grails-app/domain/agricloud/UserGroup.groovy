package agricloud

class UserGroup {
	
	String userGroupId
	String description
	
    static constraints = {
		description nullable:true
		//TODO 確認：有打也出現 Property [userGroupId] of class [class agricloud.UserGroup] cannot be null??
		//userGroupId nullable:true
    }
}
