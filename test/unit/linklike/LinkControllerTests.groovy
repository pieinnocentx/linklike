package linklike



import grails.test.mixin.*
import org.junit.*
import grails.test.mixin.domain.DomainClassUnitTestMixin

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(LinkController)
@TestMixin(DomainClassUnitTestMixin)
@Mock([Link])
class LinkControllerTests {

    void testVoteWithOneLinkInList() {
    	def link1 = new Link(title:'a',url: 'b')
    	link1.save()

    	params.title = 'a'
       	controller.voteUp()

       	assertEquals 1,link1.voteCount
    }

	void testVoteWithMoreThanOneLinkInList() {
    	mockDomain(Link,
    		[ [title:'link1',url:'www.a.com'],
    		[title:'link2',url:'www.b.com'],
    		[title:'link3',url:'www.c.com'] ])
    	def model = controller.index()

    	params.title = 'link2'
       	controller.voteUp()

       	assertEquals 1, Link.get(2).voteCount
    }    

}
