#Image that embed starting point for crypto

# Base this image on rpi-basic-image
include recipes-core/images/rpi-basic-image.bb

IMAGE_FEATURES += "package-management"

IMAGE_INSTALL += "\
    htop \
    iotop \
    tree \
    cpuminer \
    verge \
    "

#pyro now use dnf
#OWN_REPO_URL ?= "http://aurelihein.ddns.net:8765/yocto/crypto/rpm/"
#
#add_custom_smart_config() {
#    smart --data-dir=${IMAGE_ROOTFS}/var/lib/smart channel --yes --add all type=rpm-md baseurl=${OWN_REPO_URL}/all
#   smart --data-dir=${IMAGE_ROOTFS}/var/lib/smart channel --yes --add cortexa7hf_neon_vfpv4 type=rpm-md baseurl=${OWN_REPO_URL}/cortexa7hf_neon_vfpv4
#   smart --data-dir=${IMAGE_ROOTFS}/var/lib/smart channel --yes --add raspberrypi3 type=rpm-md baseurl=${OWN_REPO_URL}/raspberrypi3
#}
#ROOTFS_POSTPROCESS_COMMAND =+ "add_custom_smart_config ;"

export IMAGE_BASENAME = "rpi-crypto-image"

