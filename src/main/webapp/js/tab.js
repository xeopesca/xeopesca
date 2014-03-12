/* --------------------------------------------------------------------
 This file is part of xeoPesca

Copyright (C) 2013 - Pablo Belay Fernández 
This program is free software: you can redistribute it
and/or modify it under the terms of the GNU General
Public License as published by the Free Software
Foundation, either version 3 of the License, or (at your
option) any later version.
This program is distributed in the hope that it will be
useful, but WITHOUT ANY WARRANTY; without even the
implied warranty of MERCHANTABILITY or FITNESS FOR A
PARTICULAR PURPOSE. See the GNU General Public License
for more details.
You should have received a copy of the GNU General Public
License along with this program. If not, see
http://www.gnu.org/licenses/gpl-3.0-standalone.html
--------------------------------------------------------------------*/

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