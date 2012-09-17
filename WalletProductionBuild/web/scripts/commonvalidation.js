/*
   Single Validation script for validation entry
   WEB Version

   v1.00 -  24/04/2008
   O2
*/

var ErrorMessages = new Array()
var num_messages = 0;
function addmsg(message) {
  ErrorMessages[num_messages] = message;
  return num_messages++;
}
var ErrFirstNameBlank              = addmsg("Your First Name cannot be blank.\nPlease try again.");
var ErrFirstNameInvalidChars       = addmsg("Your First Name may only be formed of letters, numbers, -, '.', ',', or spaces.\nPlease try again.");
var ErrFirstNameInvalidLength      = addmsg("Your First Name must be between 2 and 20 characters long.\nPlease try again.");
var ErrFirstNameBeginsDot          = addmsg("Your First Name cannot begin with a dot.\n Please try again.");
var ErrLastNameBlank               = addmsg("Your Last Name cannot be blank.\nPlease try again.");
var ErrLastNameInvalidChars        = addmsg("Your Last Name may only be formed of letters, numbers, -, '.', ',', or spaces.\nPlease try again.");
var ErrLastNameInvalidLength       = addmsg("Your Last Name must be between 2 and 20 characters long.\nPlease try again.");
var ErrLastNameBeginsDot           = addmsg("Your Last Name cannot begin with a dot.\n Please try again.");

//----------------------------------------------------------------------
// Function:    numbersonly
// Parameters:  Key: 
// Description: Only allows numbers to be entered
// Return Value: true if numbered entered
//               false otherwise
//----------------------------------------------------------------------

function numbersonly(myfield, e) {
	var key;
	var keychar;

	if (window.event) {
	   key = window.event.keyCode;
	} else if (e) {
	   key = e.which;
	} else {
	   return true;
	}
	keychar = String.fromCharCode(key);

	// control keys
	if ((key==null) || (key==0) || (key==8) || (key==9) || (key==13) || (key==27) ) {
	   return true;
	} else if ((("0123456789").indexOf(keychar) > -1)) {
	// numbers
	   return true;
	} else {
	   return false;
	}
}

//----------------------------------------------------------------------
//Function:     validLength
//Parameters:   inStr1:  string to be validated
//              min,max:  minimum and maximum lengths allowed.
//Description:  Validate length against min and max.
//Return value: true if valid
//              false otherwise
//------------------------------------------------------------------------
function validLength( inStr1, min, max ){
  var inStr = new String( inStr1);
  if ( inStr.length < min || inStr.length > max) {
    return false;
  }
  return true;
}

//----------------------------------------------------------------------
//Function:     stringContainsChar
//Parameters:   inStr:  string
//              inChrs: characters to be looked for inside inStr
//              only:   false or true
//Description:  only = true means restrict inStr to characters in inChrs.
//              If only = true,  check to see if any char within inStr is NOT in inChrs.
//              If only = false, check to see if any char within inChrs IS in inStr.
//Return value: If only = true, return false if found a char in inStr that is NOT in inChrs, else
//              inStr contains characters only in inChrs, therefore return true
//              If only = false, return true if found a char in inStr that IS in inChrs, else return false.
//------------------------------------------------------------------------
function stringContainsChars( inStr, inChrs, only  ){
  var str  = new String( inStr );
  var chrs = new String( inChrs );

  for ( i=0; i < str.length; i++ ){
    var c = str.charAt( i );
    if ( only ){ // have we found something not in inChrs
      if ( chrs.indexOf( c ) == -1 ){
        return false;
      }
    }else if ( chrs.indexOf( c ) != -1 ){
      return true;
    }
  }
  if ( only ){
    return true;
  }else{
    return false;
  }
}
//----------------------------------------------------------------------
//Function:     stringContainsString
//Parameters:   inStr:  string
//              inCompStr: string to be looked for inside inStr
//              only:   false or true
//Description:  Determines if inStr contains inCompStr

//Return value: true - inStr contains inCompStr
//              false - inCompStr not within inStr
//------------------------------------------------------------------------
function stringContainsString( inStr, inCompStr){
  var str  = new String( inStr );
  var comps = new String( inCompStr );
  if (str.indexOf(comps)>-1){
    return true;
  }else{
    return false;
  }
}
//----------------------------------------------------------------------
//Function:     stringStartsOrEnds
//Parameters:   inStr:  string
//              inCompStr: characters to be tested at start and end
//Description:
//              Tests if inStr starts or ends with inCompStr
//Return value: true - inStr starts or ends with inCompStr
//              false - inStr neither starts nor ends with inCompStre
//------------------------------------------------------------------------
function stringStartsOrEnds(inStr, inCompStr){
  var str  = new String( inStr );
  if (str.indexOf(inCompStr)==0 || str.charAt(str.length - 1)==inCompStr){
    return true;
  }else{
    return false;
  }
}
//----------------------------------------------------------------------
//Function:     isBlank
//Parameter:    inStr:  string
//Description:  Check if scalar is blank, or white space
//Return value: true if NOT blank or white space,
//              false otherwise
//-----------------------------------------------------------------------
function isBlank( inStr ){
  if ( inStr == "") return true;
  invChars = "\t\n ";
  return stringContainsChars( inStr, invChars, true);
}

//----------------------------------------------------------------------
// Function:    paramvalidation
// Parameters:  document: 
// Description: Ensure that a value has been entered
// Return Value: true if not empty string
//               false otherwise
//
//NOTE: This function is not complete but is a placehold to be developed 
//----------------------------------------------------------------------
function paramvalidation(form) {
  if ( form.name == "remindPasswordForm") {
	if ((form.remindMsisdn.value) != ('') || (form.remindUserName.value) != (''))  { return false; }
    else { return true; }
  } else if ( form.name == "newPasswordForm") {
	if ((form.newPassword.value) != ('') || (form.re_enterPassword.value) != (''))  { return false; }
    else { return true; }
  } else if ( form.name == "newSecurityDetailsForm") {
	if ((form.securityQuestion.value) != ('  -- Please select --') || (form.securityAnswer.value) != (''))  { return false; }
    else { return true; }
  } else if ( form.name == "smsVerifyForm") {
	if ((form.verificationCode.value) != (''))  { return false; }
    else { return true; }
  }
}

//Validates names fields before UserName suggestion popup
function UserNamesSuggestionCheck() {
	
	
    with (document.enterUserDetailsForm) {
    	
        forename.value=Trim(forename.value);
        lastName.value=Trim(lastName.value);
        
        if ( !validateFirstName( forename.value, forename )        ||
             !validateLastName( lastName.value, lastName )
           ) {
            return false;
        } else {
            return true;
        }
    }
}


//------------------------------------------------------------------------
// String Utilities
//------------------------------------------------------------------------


/*
        PURPOSE: Remove leading blanks from our string.
        IN: str - the string we want to LTrim
*/
function LTrim(str) {
  var whitespace = new String(" \t\n\r");
  //var s = new String(str);
  var s=(" "+str);

  if (whitespace.indexOf(s.charAt(0)) != -1){
    // We have a string with leading blank(s)...

    var j=0, i = s.length;

    // Iterate from the far left of string until we
    // don't have any more whitespace...
    while (j < i && whitespace.indexOf(s.charAt(j)) != -1) {
      j++;
    }

    // Get the substring from the first non-whitespace
    // character to the end of the string...
    s = s.substring(j, i);
  }

  return s;
}


/*
        PURPOSE: Remove trailing blanks from our string.
        IN: str - the string we want to RTrim

*/
function RTrim(str) {
  // We don't want to trip JUST spaces, but also tabs,
  // line feeds, etc.  Add anything else you want to
  // "trim" here in Whitespace
  var whitespace = new String(" \t\n\r");

  //        var s = new String(str);

  var s=(str+" ");

  if (whitespace.indexOf(s.charAt(s.length-1)) != -1){
    // We have a string with trailing blank(s)...

    var i = s.length - 1;       // Get length of string

    // Iterate from the far right of string until we
    // don't have any more whitespace...
    while (i >= 0 && whitespace.indexOf(s.charAt(i)) != -1) {
      i--;
    }

    // Get the substring from the front of the string to
    // where the last non-whitespace character is...
   s = s.substring(0, i+1);
  }

  return s;
}


/*
  PURPOSE: Remove trailing and leading blanks from our string.
  IN: str - the string we want to Trim

  RETVAL: A Trimmed string!
 */
function Trim(str) {
  return(RTrim(LTrim(str))).substring(0);
}


/*
  PURPOSE: Add withChars to the left of a string to make it a given size
  IN: str - the string we want to Trim
      toSize - required length at completion
      withChar - single character with which to pad

  RETVAL: A Left-padded string!
 */
function LPad(str,toSize, withChar){
  pstr=new String(str);
  while (pstr.length < toSize){
    pstr=withChar+""+pstr;
  }
  return pstr;
}

/*
PURPOSE: Add withChars to the right of a string to make it a given size
IN: str - the string we want to Trim
    toSize - required length at completion
    withChar - single character with which to pad

RETVAL: A Right-padded string!
 */
function RPad(str,toSize, withChar) {
  pstr=new String(str);
  while (pstr.length < toSize){
    pstr+=(""+withChar);
  }
  return pstr;
}

//----------------------------------------------------------------------
//Function:     validateFirstName
//Description:  Validates first name
//              Entered first name should not be blank, should not contain
//              certain characters, or begin with a dot, and should be between
//              2 and 30 characters.
//Parameters:   inStr:  Entered first Name
//Return value: true if valid
//              false otherwise
//-----------------------------------------------------------------------
function validateFirstName( inStr, elem ){
  if ( isBlank( inStr ) ){
    alert( ErrorMessages[ErrFirstNameBlank] );
    if ( elem) {
      elem.focus();
    }
    return false;
  }

  validChars = "0123456789abcdefghijklmnopqrstuvwyxzABCDEFGHIJKLMNOPQRSTUVWXYZ.,- ";

  if ( !stringContainsChars( inStr, validChars, true)){
    alert( ErrorMessages[ErrFirstNameInvalidChars]);
    if ( elem){
      elem.focus();
    }
    return false;
  }

  if ( inStr.charAt( 0 ) == "." ){
    alert( ErrorMessages[ ErrFirstNameBeginsDot]);
    if ( elem) {
      elem.focus();
    }
    return false;
  }

  if ( !validLength( inStr, 2, 20 ) ){
    alert( ErrorMessages[ ErrFirstNameInvalidLength]);
    if ( elem) {
      elem.focus();
    }
    return false;
  }

  return true;
}

//----------------------------------------------------------------------
//Function:     validateLastName
//Description:  Validates last name
//              Entered last name should not be blank, should not contain
//              certain characters, or begin with a dot, and should be between
//              2 and 30 characters.
//Parameters:   inStr:  Entered Last Name
//Return value: true if valid
//              false otherwise
//-----------------------------------------------------------------------
function validateLastName( inStr, elem ){

  var str = new String( inStr );

  if ( isBlank( inStr ) ){
    alert( ErrorMessages[ErrLastNameBlank] );
    if ( elem) elem.focus();
      return false;
    }

    validChars = "0123456789abcdefghijklmnopqrstuvwyxzABCDEFGHIJKLMNOPQRSTUVWXYZ.,- ";

    if ( !stringContainsChars( inStr, validChars, true) ){
      alert( ErrorMessages[ ErrLastNameInvalidChars]);
      if ( elem) elem.focus();
        return false;
      }

   if ( str.charAt( 0 ) == "." ){
    alert( ErrorMessages[ ErrLastNameBeginsDot]);
      if ( elem) elem.focus();
        return false;
      }

    if ( !validLength( inStr, 2, 20 ) ){
      alert( ErrorMessages[ ErrLastNameInvalidLength]);
      if ( elem) {
        elem.focus();
      }
        return false;
    }
  return true;
}
