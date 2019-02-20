#Image that embed starting point for crypto

# Base this image on rpi-basic-image
include recipes-core/images/rpi-basic-image.bb

#Not taken into effect here !
##if rpi native:
#PREFERRED_PROVIDER_virtual/wpebackend = "wpebackend-rdk"
#PACKAGECONFIG_pn-wpebackend-rdk = "rpi"
##else
#PREFERRED_PROVIDER_virtual/wpebackend = "wpebackend-fdo"
##endif

MACHINE_FEATURES += " userland "

IMAGE_FEATURES += " package-management "
IMAGE_FEATURES += " ssh-server-dropbear hwcodecs "

IMAGE_INSTALL += "\
    htop \
    iotop \
    tree \
    wpewebkit cog \
    kbd keymaps \
    "

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
