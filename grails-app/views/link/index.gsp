<h1>Link Like</h1>

<g:form name="linkCreateForm" url="[action:'create']">
  Title: <g:textField name="title"/><br/>
  URL: <g:textField name="url"/><br/>
  <input type="submit" value="Add new link"/>
</g:form>

<hr>


<ul>
  <% if(links.size() == 0) { %>
    <li>No links</li>
  <% } else { %>
    <% for(link in links) { %>
      <li>
        <g:form name="linkCreateForm" url="[action:'voteUp']">
        <a href= <%= link.url %>><%= link.title %></a>
        <%= link.voteCount %>
        
        <input type="hidden" name="title" value= <%= link.title %> >
        <input type="submit" value="vote up!"/>
        </g:form>
      </li>
    <% } %> 
  <% } %>
</ul>

