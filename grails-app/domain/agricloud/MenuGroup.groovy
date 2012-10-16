package agricloud

class MenuGroup {

	UserGroup userGroup
	Menu menu
	
    static constraints = {
		//TODO 確認：有打也出現 Property [userGroupId] of class [class agricloud.UserGroup] cannot be null??
		userGroup nullable:true
    }
}
