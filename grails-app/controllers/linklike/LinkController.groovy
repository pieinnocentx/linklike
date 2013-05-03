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

    def voteUp() {
    	def links = Link.findAll()
    	for(link in links)
    		if(link.title == params.title)
    			link.voteCount += 1
        redirect(action: "index")
    }

}
