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

    void testVote() {
    	def link1 = new Link(title:'a',url: 'b')
    	link1.save()

       	controller.voteUp()

       	assertEquals 1,link1.voteCount
    }
}
