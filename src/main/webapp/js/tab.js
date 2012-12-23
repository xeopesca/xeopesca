function cm_tabs(options)
{
	if(	(options.tab && options.tab != '') && (options.container && options.container != '') )
	{
		var tabs		= document.getElementById(options.tab).children;
		var containers	= document.getElementById(options.container).children;
		
		for(var i=0; i< tabs.length; i++)
		{
			tabs[i].i = i;
			containers[i].style.display = 'none';
			
			tabs[i].onclick = function() 
			{
				for(var e=0; e < containers.length; e++)
				{
					tabs[e].className = ''
					containers[e].style.display = 'none';
				}
				tabs[this.i].className = 'active';
				containers[this.i].style.display = 'block';	
			}	
		}
		
		if(options.active && options.active <= tabs.length && options.active != '')
		{
			tabs[(options.active-1)].className = 'active';
			containers[(options.active-1)].style.display = 'block';
		} else {
			tabs[0].className = 'active';
			containers[0].style.display = 'block';	
		}
	} 
	return false;
}