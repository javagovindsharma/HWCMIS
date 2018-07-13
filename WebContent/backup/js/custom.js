// JavaScript Document


$( ".datepicker" ).datepicker({
			inline: true
});
$(document).ready(function(){
		
	$(".fancybox").fancybox({
		openEffect  : 'none',
		closeEffect : 'none',
		iframe : {
			preload: false
		}
	});
	
	
	
	$(".various").fancybox({
		maxWidth	: 400,
		maxHeight	: 300,
		fitToView	: false,
		width		: '70%',
		height		: '70%',
		autoSize	: false,
		closeClick	: false,
		openEffect	: 'none',
		closeEffect	: 'none',
		helpers   : { 
          overlay : {closeClick: false} // prevents closing when clicking OUTSIDE fancybox 
         }
	});
	
	
	
	$('.fancybox-media').fancybox({
		openEffect  : 'none',
		closeEffect : 'none',
		helpers : {
			media : {}
		}
	});
	
	/************************************************/
	$(window).scroll(function(){
				
									  
				if($(this).scrollTop()>170){
				$('.total').addClass('fixed');				
				}
				
			else if($(this).scrollTop()>160){
				$("[aria-expanded=true]").not(".list-group-submenu").addClass('fixed2');				
				}
			
			else{
				$('.total').removeClass('fixed');
				$("[aria-expanded=true]").removeClass('fixed2');
								
				}	
								  
	 });	
	
});


/************************************************/













