SUMMARY = "A demo image for WPE browser support"
inherit core-image

COMPATIBLE_MACHINE = "^rpi$"

IMAGE_FEATURES += "hwcodecs"

IMAGE_LINGUAS = " "
#IMAGE_LINGUAS = " en-us en-gb "

LICENSE = "CLOSED"

IMAGE_INSTALL += "\
    kernel-modules \
    htop iotop tree \
    kbd keymaps xkeyboard-config \
    networkmanager \
    psplash \
    "

IMAGE_INSTALL += "\
    waylandeglinfo \
    wpewebkit cog \
    "

IMAGE_INSTALL += "\
    html5videotest \
    "

export IMAGE_BASENAME = "rpi-browser-image"
