package agricloud

class Menu {
	String functionId
	String description
	String folderId

    static constraints = {
		folderId nullable: true
		description nullable: true
    }
}
