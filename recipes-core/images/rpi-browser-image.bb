SUMMARY = "A demo image for WPE browser support"
inherit core-image

include recipes-core/images/core-image-weston.bb

COMPATIBLE_MACHINE = "^rpi$"

IMAGE_FEATURES += "hwcodecs"

CORE_IMAGE_BASE_INSTALL += "\
    weston weston-init weston-examples \
    packagegroup-rpi-test-aurelien \
    "

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
    gstreamer1.0-plugins-base \
    gstreamer1.0-plugins-good \
    gstreamer1.0-plugins-bad \
    gstreamer1.0-plugins-ugly \
    "

IMAGE_INSTALL += "\
    waylandeglinfo \
    wpewebkit cog \
    "

IMAGE_INSTALL += "\
    html5videotest \
    "

export IMAGE_BASENAME = "rpi-browser-image"
