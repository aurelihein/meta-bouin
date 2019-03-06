include recipes-core/images/core-image-base.bb


#COMPATIBLE_MACHINE = "^rpi$"

#Not taken into effect here !
##if rpi native:
#PREFERRED_PROVIDER_virtual/wpebackend = "wpebackend-rdk"
#PACKAGECONFIG_pn-wpebackend-rdk = "rpi libinput"
##else
#PREFERRED_PROVIDER_virtual/wpebackend = "wpebackend-fdo"
##endif

#MACHINE_FEATURES += " userland "

REQUIRED_DISTRO_FEATURES = "wayland"

IMAGE_FEATURES += " ssh-server-dropbear splash "
IMAGE_FEATURES += " package-management "
IMAGE_FEATURES += " ssh-server-dropbear hwcodecs "

#CORE_IMAGE_BASE_INSTALL += "weston weston-init weston-examples gtk+3-demo clutter-1.0-examples"
CORE_IMAGE_BASE_INSTALL += "weston weston-init weston-examples gtk+3-demo"

IMAGE_INSTALL += "${CORE_IMAGE_BASE_INSTALL}"

IMAGE_INSTALL += "\
    kernel-modules \
    htop \
    iotop \
    tree \
    libinput \
    wpewebkit cog \
    kbd keymaps xkeyboard-config \
    mali-450 mesa-gl \
    networkmanager \
    weston \
    "

#   libx11 libx11-locale

 
#You can test WPE browser :
#export WPE_BCMRPI_TOUCH=1
#export WPE_BCMRPI_CURSOR=1
#export WPE_DISPLAY_FPS=1
#export COG_PLATFORM_FDO_VIEW_FULLSCREEN=1
#cog -P fdo https://www.google.fr
#cog https://www.google.fr

export IMAGE_BASENAME = "odroid-browser-image"
