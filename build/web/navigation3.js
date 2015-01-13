window.addEvent('domready', function()
{

	// *************** SCROLLING NAVIGATION
	
	var scroll = new Fx.Scroll(window, {duration: 1000, wait: false, transition: Fx.Transitions.quadInOut});
	
	$$('.gotohome').addEvent('click', function(event){ event = new Event(event).stop(); scroll.toElement('start'); });
	$$('.gotoabout').addEvent('click', function(event){ event = new Event(event).stop(); scroll.toElement('about'); });
	$$('.gotowork').addEvent('click', function(event){ event = new Event(event).stop(); scroll.toElement('work'); });
	$$('.gotocontact').addEvent('click', function(event){ event = new Event(event).stop(); scroll.toElement('contact'); });
	$$('.gotoprint').addEvent('click', function(event){ event = new Event(event).stop(); scroll.toElement('print'); });
	$$('.gotoskills').addEvent('click', function(event){ event = new Event(event).stop(); scroll.toElement('skills'); });
	$$('.gototechnical').addEvent('click', function(event){ event = new Event(event).stop(); scroll.toElement('technical'); });
	
	// *************** SHOW CASE
	
	// *************** PRINT DESIGN
	
	var mySlide1 = new Fx.Slide('showcase-psrfall', {duration: 400, wait: false, transition: Fx.Transitions.quadInOut});
	var mySlide2 = new Fx.Slide('showcase-psrspring', {duration: 500, wait: false, transition: Fx.Transitions.quadInOut});
	var mySlide7 = new Fx.Slide('showcase-ipi', {duration: 600, wait: false, transition: Fx.Transitions.quadInOut});
	var mySlide9 = new Fx.Slide('showcase-poidware', {duration: 550, wait: false, transition: Fx.Transitions.quadInOut});
	   
	//initially hide everything
	mySlide1.hide();
	mySlide2.hide();
	mySlide7.hide();
	//mySlide9.hide();
	
	$('phirhofall').addEvent('click', function(e){
		e = new Event(e);
		mySlide1.toggle();
		mySlide2.slideOut();
		mySlide7.slideOut();
		mySlide9.slideOut();
		e.stop();
	});
	
	$('phirhospring').addEvent('click', function(e){
		e = new Event(e);
		mySlide1.slideOut();
		mySlide2.toggle();
		mySlide7.slideOut();
		mySlide9.slideOut();
		e.stop();
	});
	
	$('ipi2009').addEvent('click', function(e){
		e = new Event(e);
		mySlide1.slideOut();
		mySlide2.slideOut();
		mySlide7.toggle();
		mySlide9.slideOut();
		e.stop();
	});
	
	$('poidware').addEvent('click', function(e){
		e = new Event(e);
		mySlide1.slideOut();
		mySlide2.slideOut();
		mySlide7.slideOut();
		mySlide9.toggle();
		e.stop();
	});
	
	// *************** WEBSITE DESIGN
	
	var mySlide3 = new Fx.Slide('showcase1', {duration: 400, wait: false, transition: Fx.Transitions.quadInOut});
	var mySlide4 = new Fx.Slide('showcase2', {duration: 500, wait: false, transition: Fx.Transitions.quadInOut});
	var mySlide5 = new Fx.Slide('showcase3', {duration: 450, wait: false, transition: Fx.Transitions.quadInOut});
	var mySlide6 = new Fx.Slide('showcase4', {duration: 550, wait: false, transition: Fx.Transitions.quadInOut});
	var mySlide8 = new Fx.Slide('showcase5', {duration: 550, wait: false, transition: Fx.Transitions.quadInOut});
	 var mySlide9 = new Fx.Slide('showcase6', {duration: 550, wait: false, transition: Fx.Transitions.quadInOut});  
	//initially hide everything
	//mySlide3.hide();
	mySlide4.hide();
	mySlide5.hide();
	mySlide6.hide();
	mySlide8.hide();
	mySlide9.hide();
	$('portfolio-item-1').addEvent('click', function(e){
		e = new Event(e);
		mySlide3.slideIn();
		mySlide4.slideOut();
		mySlide5.slideOut();
		mySlide6.slideOut();
		mySlide8.slideOut();
		e.stop();
	});
	
	$('portfolio-item-2').addEvent('click', function(e){
		e = new Event(e);
		mySlide3.slideOut();
		mySlide4.slideIn();
		mySlide5.slideOut();
		mySlide6.slideOut();
		mySlide8.slideOut();
		e.stop();
	});
	
	$('portfolio-item-3').addEvent('click', function(e){
		e = new Event(e);
		mySlide3.slideOut();
		mySlide4.slideOut();
		mySlide5.slideIn();
		mySlide6.slideOut();
		mySlide8.slideOut();
		e.stop();
	});
	
	$('portfolio-item-4').addEvent('click', function(e){
		e = new Event(e);
		mySlide3.slideOut();
		mySlide4.slideOut();
		mySlide5.slideOut();
		mySlide6.slideIn();
		mySlide8.slideOut();
		e.stop();
	});
	
	$('portfolio-item-5').addEvent('click', function(e){
		e = new Event(e);
		mySlide3.slideOut();
		mySlide4.slideOut();
		mySlide5.slideOut();
		mySlide6.slideOut();
		mySlide8.slideIn();
		e.stop();
	});
	
	$('portfolio-item-6').addEvent('click', function(e){
		e = new Event(e);
		mySlide3.slideOut();
		mySlide4.slideOut();
		mySlide5.slideOut();
		mySlide6.slideOut();
		mySlide9.slideIn();
		e.stop();
	});
	
	$$('.close-print').each(function(el){
		el.addEvent('click', function(event) {
			event = new Event(event).stop();
			mySlide1.slideOut();
			mySlide2.slideOut();
			mySlide7.slideOut();
			mySlide1.slideOut();
		});
	});
	
	$$('.close-web').each(function(el){
		el.addEvent('click', function(event) {
			event = new Event(event).stop();
			mySlide3.slideOut();
			mySlide4.slideOut();
			mySlide5.slideOut();
			mySlide6.slideOut();
			mySlide8.slideOut();
		});
	});
	
}); 	
