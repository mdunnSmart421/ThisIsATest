<%@page import="java.util.List" %>
<%@page import="com.o2.finance.etc.RequestParameterConstants" %>


<% List results = (List) request.getAttribute( RequestParameterConstants.USERNAME_SUGGESTIONS ); %>

<div>
    <strong>The following usernames are available:</strong>
</div>

<div class="gender">

<% for (int i = 0; i < results.size(); i++)
{ %>


<% String nextResult = (String) results.get( i ); %>

<label for="usernameSuggestion<%= i %>" title="<%= nextResult %>">
    <input class="radio" id="usernameSuggestion<%= i %>" type="radio" name="usernameSuggestion" value="<%= nextResult %>"
           title="Username Suggestion" onclick="setUsernameSuggestion('<%= nextResult %>');"/>
    <%= nextResult %>
</label>

<% } %>
    </div>