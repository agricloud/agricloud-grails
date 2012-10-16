package agricloud



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Menu)
class MenuTests {

    void testSomething() {
       assert Menu.list().size() == 0
    }

    void testAddItemToMenu() {
    	def row = new Menu(
    		functionId: 'A01',
    		description: 'User Register'
    	)

    	def result = row.save()

    	println result

    	assertNotNull result
    }

    void testAddItemsToMenuGroup() {
    	def row0 = new Menu(functionId: 'G01', description: 'Group 1')
    	def row1 = new Menu(functionId: 'ITEM01', description: 'Menu Item 1')
    	def row2 = new Menu(functionId: 'ITEM02', description: 'Menu Item 2')

//    	row1.parent = row0
//    	row2.parent = row0

		assertNotNull row0.save()
		assertNotNull row1.save()
		assertNotNull row2.save()

		row0 = Menu.findByFunctionId('G01')

		assertNotNull row0
		println row0
//		def rows = Menu.findAllByParent(row0)
//		assert rows.size() == 2
    }


}
