//----------------------------------------------------------------------
//Function:     insertPlaceHoldersForInputFields
//Description:  iterates through the form, and for each <input> field 
//              inserts place-holder text where place-holder text = alt text
//              
//Parameters:   
//Return value: 
//--------------------------------------------------------------------





function insertPlaceHoldersForInputFields()
{
    var inputFields = document.getElementsByTagName( 'input' );    
	
	for ( i = 0; i < inputFields.length; i++ )
    {
		var inputField = inputFields[ i ];
		
        if ( inputField != null  )
        {
        	// if the inputField can have a placeholder attribute, set the placeholder's 
        	// value to alt attributes value
        	if ( ( 'placeholder' in inputField ) && ( inputField.alt != "" ) )
            {
        		inputField.placeholder = inputField.alt;

            }
        }
    	
    }
}



function fixRadio() {
    var labels = document.getElementsByTagName('label'),
        target_id,
        el;
    for (var i = 0; labels[i]; i++) {
        if (labels[i].getAttribute('for')) {
            labels[i].onclick = labelClick;
        }
    }
};

function labelClick() {
    el = document.getElementById(this.getAttribute('for'));
    if (['radio', 'checkbox'].indexOf(el.getAttribute('type')) != -1) {
        el.setAttribute('selected', !el.getAttribute('selected'));
    } else {
        el.focus();
    }
};


function resetDateOfBirth()
{
    el = document.getElementById("birthDay");
    if (el && el.value=="DD")
    {
        el.value="";
    }

    el = document.getElementById("birthYear");

    if (el && el.value=="YYYY")
    {
        el.value="";
    }

}