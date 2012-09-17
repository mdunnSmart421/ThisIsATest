<%@page import="java.util.List"%>
<%@page import="com.o2.finance.etc.RequestParameterConstants"%>


<% List results = (List) request.getAttribute(RequestParameterConstants.USERNAME_SUGGESTIONS); %>

<div>
  <strong>The following usernames are available:</strong>
</div>

<br/>

<% for (int i=0; i<results.size(); i++) { %>

  <% String nextResult = (String) results.get(i); %>
  
  <div class="esLabelClass">
    <div class="formContainer floatLeft w77">
      <label for="usernameSuggestion<%= i %>" title="<%= nextResult %>">
        <input id="usernameSuggestion<%= i %>" type="radio" name="usernameSuggestion" value="<%= nextResult %>" title="Username Suggestion" onclick="setUsernameSuggestion('<%= nextResult %>');"/>
        <%= nextResult %>
      </label>
    </div>
  </div>
  
  <div class="clear" style="width: 1px; height: 1px;"></div>
  
<% } %>