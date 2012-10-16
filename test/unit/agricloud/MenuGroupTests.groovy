package agricloud



import grails.test.mixin.*
import org.junit.*
import agricloud.Menu
import agricloud.UserGroup

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(MenuGroup)
@Mock([Menu, UserGroup])
class MenuGroupTests {

    void testSomething() {
       assert MenuGroup.list().size() == 0
    }
	
	void testGroupsMenuCreate() {
		def menu = new Menu(functionId: 'M1')
		assertNotNull menu.save()
		
		
		
		def userGroup=new UserGroup(UserGroupId:'G1')
		assertNotNull userGroup.save()
		
		MenuGroup menuGroup=new MenuGroup(userGroup:userGroup,menu:menu)
		
		assertNotNull menuGroup.save()
		
		def menuGroupRow = MenuGroup.findAllByUserGroup(userGroup)
		
		assertNotNull menuGroupRow
		
		println menuGroupRow

	 }
}
