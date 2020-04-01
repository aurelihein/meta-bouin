SUMMARY = "A demo image."
include recipes-core/images/core-image-weston.bb

IMAGE_INSTALL = "packagegroup-core-boot ${CORE_IMAGE_EXTRA_INSTALL}"

IMAGE_LINGUAS = " "
#IMAGE_LINGUAS = " en-us en-gb "

LICENSE = "MIT"

inherit core-image distro_features_check

#Seems to not work :
SPLASH = "psplash-captina"

IMAGE_ROOTFS_SIZE ?= "8192"
IMAGE_ROOTFS_EXTRA_SPACE_append = "${@bb.utils.contains("DISTRO_FEATURES", "systemd", " + 4096", "" ,d)}"

COMPATIBLE_MACHINE = "^rpi$"

IMAGE_FEATURES += "ssh-server-dropbear"

#MACHINE_FEATURES += " userland "

IMAGE_FEATURES += " package-management "
IMAGE_FEATURES += " ssh-server-dropbear hwcodecs "

IMAGE_INSTALL_RPI += "\
    gstreamer1.0-omx "

IMAGE_INSTALL += "\
    kernel-modules \
    htop \
    iotop \
    tree \
    libinput \
    wpewebkit cog \
    kbd keymaps xkeyboard-config \
    ${IMAGE_INSTALL_RPI} \
    networkmanager \
    psplash \
    html5videotest \
    "

IMAGE_INSTALL += "${CORE_IMAGE_BASE_INSTALL}"

#For test purpose add the following IMAGE_INSTALL_append
#BUT you admit to add commercial as falloiwing into conf/local.conf
#LICENSE_FLAGS_WHITELIST += "commercial"
IMAGE_INSTALL_append = " packagegroup-rpi-test-aurelien"

#you can test with :
#omxplayer -p -o hdmi /usr/share/movies/big_buck_bunny_1080p_surround.avi
#or
#gst-launch-1.0 -v filesrc location=10_24fps_5M_nb-fastdecode.mp4 ! queue ! omxh264dec ! glimagesink

#You can test WPE browser :
#export WPE_BCMRPI_TOUCH=1
#export WPE_BCMRPI_CURSOR=1
#export WPE_DISPLAY_FPS=1
#cog https://www.google.fr

export IMAGE_BASENAME = "rpi-browser-weston-image"