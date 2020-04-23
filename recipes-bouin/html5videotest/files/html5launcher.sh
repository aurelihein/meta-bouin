#!/bin/sh
#Aurelien BOUIN
#27/03/2020
#purpose launch cog to auto start player

if [ "$1" = "rdk" ] ; then
    #you can test with :
    #omxplayer -p -o hdmi /usr/share/movies/big_buck_bunny_1080p_surround.avi
    #or
    #gst-launch-1.0 -v filesrc location=10_24fps_5M_nb-fastdecode.mp4 ! queue ! omxh264dec ! glimagesink
    export WPE_BCMRPI_TOUCH=1
    export WPE_BCMRPI_CURSOR=1
    #export WPE_DISPLAY_FPS=1
    cog http://localhost/page.html
    #cog https://www.google.fr
else
    #export WPE_DISPLAY_FPS=1
    export WAYLAND_DISPLAY="wayland-0"
    export XDG_RUNTIME_DIR="/run/user/0"
    if [ ! -d ${XDG_RUNTIME_DIR} ]; then
        if [ -e /tmp/weston_export.sh ]; then
            source /tmp/weston_export.sh
        else
            echo "Warning /tmp/weston_export.sh does not exist" >&2
        fi
    fi
    export COG_PLATFORM_FDO_VIEW_FULLSCREEN=1
    cog --platform=fdo http://localhost/page.html
fi
