SUMMARY = "A demo image for WPE browser support"
inherit core-image

LICENSE = "BOUIN-Proprietary"
LIC_FILES_CHKSUM = "file://${LAYER_LICENSES}/BOUIN-Proprietary;md5=3cfa1f23f08d4958b1b6041eddb2580d"

EXTRA_IMAGE_FEATURES="debug-tweaks"
IMAGE_FEATURES += "hwcodecs"

IMAGE_LINGUAS = " "
#IMAGE_LINGUAS = " en-us en-gb "

IMAGE_INSTALL += "\
    kernel-modules \
    htop iotop tree \
    kbd keymaps xkeyboard-config \
    networkmanager rfkill \
    psplash \
    systemd-bash-completion nano \
    bash-completion bash-completion-extra \
    usbutils \
    "

IMAGE_INSTALL += "\
    waylandeglinfo \
    wpewebkit cog \
    "

IMAGE_INSTALL += "\
    html5videotest \
    "

export IMAGE_BASENAME = "demo-browser-image"
