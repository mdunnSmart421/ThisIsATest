/*** Username Finder ***/
/*
Object used to send off username search requests to a server
*/
function usernameFinder(theFormObj,displayDivId) {
	this.theFormObj = theFormObj;
	this.divId = displayDivId;
	this.deployURL = 'usernameSuggestions.do'; 
		
	this.forenameSource = theFormObj.elements['forename']; // *** replace *** with the relevant field name
	this.lastnameSource  = theFormObj.elements['lastName']; // *** replace *** with the relevant field name
	this.errorMessage    = 'A problem occured, we cannot offer username suggestions at the moment.';
	
	/**
	 * Makes the AJAX call to retrieve a list of username suggestions.
	 */
	this.getNames = function() {
		this.clearDisplay();
		this.displayMessage('One moment....');
		url = (this.deployURL + '?foreName=' + this.forenameSource.value + '&lastName=' + this.lastnameSource.value);
		this.makeAjaxRequest(url);
	};

	/**
	 * Clear any previous contents displayed in the AJAX display area.
	 */
	this.clearDisplay = function() {
		displayDiv = document.getElementById(displayDivId);
		displayDiv.innerHTML = '';
	};

	/**
	 * Display a message in the display area.
	 */
	this.displayMessage = function(txt) {
		displayDiv = document.getElementById(displayDivId);
		displayDiv.innerHTML = '<p class=\"w50 bold cellBorderBottom\">' + txt + '</p>'
			+ '<div class="eShim"><div class="shim">&nbsp;</div></div>'
	};

	/**
	 * Make the AJAX call.
	 */
	this.makeAjaxRequest = function(url) {
     var httpRequest;
     
     if (window.XMLHttpRequest) { // Mozilla, Safari, ...
         httpRequest = new XMLHttpRequest();
         if (httpRequest.overrideMimeType) {
             httpRequest.overrideMimeType('text/xml');
         }
     } else if (window.ActiveXObject) { // IE
         try {
             httpRequest = new ActiveXObject("Msxml2.XMLHTTP");
         } catch (e) {
             try {
                 httpRequest = new ActiveXObject("Microsoft.XMLHTTP");
             } 
             catch (e) {}
         }
     }

     if (!httpRequest) {
         alert(this.errorMessage);
         return false;
     }
     httpRequest.onreadystatechange = function() { usernameResults(httpRequest); };
     httpRequest.open('GET', url, true);
     httpRequest.send(null);
	};

	/**
	 * Display the AJAX results in the display area.
	 */
	usernameResults = function(httpRequest) {
		if (httpRequest.readyState == 4) {
			if (httpRequest.status == 200) {
				displayDiv = document.getElementById(displayDivId);
				displayDiv.innerHTML = httpRequest.responseText;
			} else {
				alert(this.errorMessage);
			}
		}
	};

};

function setUsernameSuggestion(suggestion) {
	textBox = document.getElementById('username');
	textBox.value = suggestion;
}