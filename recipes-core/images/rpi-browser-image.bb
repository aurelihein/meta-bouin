#Image that embed starting point for crypto

include recipes-core/images/core-image-base.bb


COMPATIBLE_MACHINE = "^rpi$"

SPLASH = "psplash-raspberrypi"

IMAGE_FEATURES += "ssh-server-dropbear splash"

#Not taken into effect here !
##if rpi native:
#PREFERRED_PROVIDER_virtual/wpebackend = "wpebackend-rdk"
#PACKAGECONFIG_pn-wpebackend-rdk = "rpi libinput"
##else
#PREFERRED_PROVIDER_virtual/wpebackend = "wpebackend-fdo"
##endif

MACHINE_FEATURES += " userland "

IMAGE_FEATURES += " package-management "
IMAGE_FEATURES += " ssh-server-dropbear hwcodecs "

IMAGE_INSTALL += "\
    kernel-modules \
    htop \
    iotop \
    tree \
    libinput \
    wpewebkit cog \
    kbd keymaps xkeyboard-config \
    libx11 libx11-locale \
    gstreamer1.0-omx \
    "
#For test purpose add the following IMAGE_INSTALL_append
#BUT you admit to add commercial as falloiwing into conf/local.conf
#LICENSE_FLAGS_WHITELIST += "commercial"
IMAGE_INSTALL_append = " packagegroup-rpi-test"

#you can test with :
#omxplayer -p hdmi /usr/share/movies/big_buck_bunny_1080p_surround.avi
#or
#gst-launch-1.0 -v filesrc location=10_24fps_5M_nb-fastdecode.mp4 ! queue ! omxh264dec ! glimagesink

#You can test WPE browser :
#export WPE_BCMRPI_TOUCH=1
#export WPE_BCMRPI_CURSOR=1
#cog https://www.google.fr

export IMAGE_BASENAME = "rpi-browser-image"
