package linklike

class LinkController {

    def index() { 
        def links = Link.findAll()
        [ links: links ]
    }

    def create() {
        def link = new Link(title: params.title, url: params.url)
        link.save()
        redirect(action: "index")
    }

    def voteUp(String title) {
    	def links = Link.findAll()
    	for(link in links)
    		if(link.title == title)
    			link.voteCount += 1
    }

}
