$(document).ready(function(){// wait until the DOM is ready
  $(function(){// encapsulate our variables into their own scope

    // traverse all inputs with an alt attribute
//    $("input[placeholder]").each(function(){
    $("input[alt]").each(function(){
      if( 'placeholder' in this )
      {
      var $ip = $(this),// the input itself (in a jQuery object)
//          tx = $ip.attr('placeholder');// placeholder text
          tx = $ip.attr('alt');// placeholder text

      // create a label and a span within it
      var $lb = $('<label></label>'),
          $sp = $('<span class="placeholder">'+tx+'</span>').appendTo($lb);

      // the label surrounds the input
      $lb.insertBefore($ip).append($ip);

      // try getting the input's size
      var w = $ip.width(),
          h = $ip.height();

      // if it fails, it's likely because the input is not visible
      if (!w || !h) {

        // clone the input and make it have size/shape without showing it
        var $clone = $ip.clone().appendTo('body').css({
          position : 'absolute',
          visibility : 'hidden',
          display : 'block'
        });

        // fetch the correct size (hopefully)
        w = $clone.width();
        h = $clone.height();

        $clone.remove();
      }

      // copy the position, size, and font into the
      // placeholder text's span
      $sp.css({
        position : 'absolute',
        display : 'block',
        width : w+'px',
        height : h+'px',
        lineHeight : $ip.css('line-height'),
        paddingLeft : $ip.css('padding-left'),
        paddingTop : '11px',
        fontSize : $ip.css('font-size'),
        fontWeight : $ip.css('font-weight'),
        overflow : 'hidden',
        cursor : 'text'
      });

      // in MSIE 7 the text is vertically misaligned
      if ($.browser.msie && parseInt($.browser.version) <= 7)
        $sp.css({marginTop:'2px'});

      // if the input is hidden or shown, so should the placeholder be
      $ip.bind('hide', function(){ $sp.hide(); });
      // when showing, ensure the text is the right size
      $ip.bind('show', function(){
        $sp.show().css({
          width:$ip.width()+'px',
          height:$ip.height()+'px'
        });
      });

      // if the input is starting out hidden, hide the placeholder
      if (!$ip.is(':visible'))
        $sp.hide();


      // if the input already has a value, hide the placeholder
      if ( ($(this).val() != '') )
        $sp.hide();


      // when input gets focus, hide the placeholder and
      // when we leave the input, if it has no user entry
      // show the placeholder
      $ip.focus(function(){ $sp.hide(); });
      $ip.blur(function(){ if ($(this).val() == '') $sp.show(); });

      // if the placeholder is focused, send focus to the input
      $sp.focus(function(){ $ip.focus(); });
      }
    });

    // override jQuery.hide() to trigger the 'hide' event
    var hide = $.fn.hide;
    $.fn.hide = function() {
      $(this).trigger('hide');
      return hide.apply(this, arguments);
    };

    // override jQuery.show() to trigger the 'show' event
    var show = $.fn.show;
    $.fn.show = function() {
      $(this).trigger('show');

      return show.apply(this, arguments);
    };
  });
});