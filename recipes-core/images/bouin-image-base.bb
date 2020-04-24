SUMMARY = "Bouin - Base Image"

inherit core-image

LICENSE = "BOUIN-Proprietary"
LIC_FILES_CHKSUM = "file://${LAYER_LICENSES}/BOUIN-Proprietary;md5=f9b4c55261d4b2bbe10220540f0bbb21"

COPY_LIC_MANIFEST = "1"
COPY_LIC_DIRS = "1"

IMAGE_LINGUAS = " "
#IMAGE_LINGUAS = " en-us en-gb "

#In case of BB_RMWORK /etc/build is not persistent
python buildinfo_append() {
    import shutil

    shutil.copyfile(d.expand('${IMAGE_ROOTFS}${IMAGE_BUILDINFO_FILE}'), d.expand('${DEPLOY_DIR_IMAGE}/last_build_info.txt'))
}