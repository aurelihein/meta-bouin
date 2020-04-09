#!/bin/sh
#Aurelien BOUIN
#27/03/2020
#purpose launch cog to auto start player

if [ "$1" = "rdk" ] ; then
    export WPE_BCMRPI_TOUCH=1
    export WPE_BCMRPI_CURSOR=1
    #export WPE_DISPLAY_FPS=1
    cog http://localhost/page.html
    #cog https://www.google.fr
else
    #export WPE_DISPLAY_FPS=1
    export WAYLAND_DISPLAY="wayland-0"
    export XDG_RUNTIME_DIR="/run/user/0"
    if [ -e /tmp/weston_export.sh ]; then
        source /tmp/weston_export.sh
    else
        echo "Warning /tmp/weston_export.sh does not exist"
    fi
    export COG_PLATFORM_FDO_VIEW_FULLSCREEN=1
    echo "First open a weston terminal on the board, write down the values of this variables and then export the same values to this variables from the ssh terminal"
    cog --platform=fdo http://localhost/page.html
fi
