SUMMARY = "A demo image for WPE browser support"
inherit core-image

COMPATIBLE_MACHINE = "^rpi$"

IMAGE_FEATURES += "hwcodecs"

CORE_IMAGE_BASE_INSTALL += "\
    packagegroup-core-boot \
    packagegroup-rpi-test-aurelien \
    "

IMAGE_INSTALL += "${CORE_IMAGE_EXTRA_INSTALL}"

MACHINE_FEATURES += "userland "

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
    gstreamer1.0-plugins-base-alsa \
    gstreamer1.0-omx \
    "

IMAGE_INSTALL += "\
    libinput \
    wpebackend-rdk wpewebkit cog \
    "

IMAGE_INSTALL += "\
    html5videotest \
    "

IMAGE_INSTALL += "\
    fbcp \
    fontconfig \
    fontconfig-utils \
    ttf-bitstream-vera \
    tzdata tzdata-misc tzdata-europe tzdata-posix tzdata-right tzdata-africa \
    tzdata-americas tzdata-antarctica tzdata-arctic tzdata-asia \
    tzdata-atlantic tzdata-australia tzdata-europe tzdata-pacific \
    "


export IMAGE_BASENAME = "rpi-browser-image"
