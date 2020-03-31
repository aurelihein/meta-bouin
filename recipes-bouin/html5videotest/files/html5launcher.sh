#!/bin/sh
#Aurelien BOUIN
#27/03/2020
#purpose launch cog to auto start player

export WPE_BCMRPI_TOUCH=1
export WPE_BCMRPI_CURSOR=1
export WPE_DISPLAY_FPS=1
cog http://localhost/page.html
#cog https://www.google.fr