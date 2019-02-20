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
    "
#For test purpose add the following IMAGE_INSTALL_append
#BUT you admit to add commercial as falloiwing into conf/local.conf
#LICENSE_FLAGS_WHITELIST += "commercial"
IMAGE_INSTALL_append = " packagegroup-rpi-test"
#you can test with :
#omxplayer -p -p hdmi /usr/share/movies/big_buck_bunny_1080p_surround.avi

#sumo now use dnf
#OWN_REPO_URL ?= "http://aurelihein.ddns.net:8765/yocto/crypto/rpm/"
#
#add_custom_smart_config() {
#    smart --data-dir=${IMAGE_ROOTFS}/var/lib/smart channel --yes --add all type=rpm-md baseurl=${OWN_REPO_URL}/all
#   smart --data-dir=${IMAGE_ROOTFS}/var/lib/smart channel --yes --add cortexa7hf_neon_vfpv4 type=rpm-md baseurl=${OWN_REPO_URL}/cortexa7hf_neon_vfpv4
#   smart --data-dir=${IMAGE_ROOTFS}/var/lib/smart channel --yes --add raspberrypi3 type=rpm-md baseurl=${OWN_REPO_URL}/raspberrypi3
#}
#ROOTFS_POSTPROCESS_COMMAND =+ "add_custom_smart_config ;"

export IMAGE_BASENAME = "rpi-browser-image"
