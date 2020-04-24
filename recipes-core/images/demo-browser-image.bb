SUMMARY = "A demo image for WPE browser support"

require recipes-core/images/bouin-image-base.bb

EXTRA_IMAGE_FEATURES="debug-tweaks"
IMAGE_FEATURES += "hwcodecs"

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
