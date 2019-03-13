FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SPLASH_IMAGES = " file://captina-3_640x544.png;outsuffix=default"
SPLASH_IMAGES_append = " file://captina-1_1920x1080.png;outsuffix=captina1"
SPLASH_IMAGES_append = " file://captina-2_1280x1088.png;outsuffix=captina2"
ALTERNATIVE_PRIORITY_psplash-raspberrypi[psplash] = "10"

SRC_URI_append = " ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', '\
                   file://psplash-quit.service \
                   file://psplash-start.service \
                   file://psplash-final.service \
                   ', '', d)}"

inherit systemd

SYSTEMD_SERVICE_${PN} = "${@bb.utils.contains('DISTRO_FEATURES','systemd','psplash-start.service psplash-quit.service psplash-final.service','',d)}"
SYSTEMD_AUTO_ENABLE ?= "enable"

do_install_append() {
        if ${@bb.utils.contains('DISTRO_FEATURES','systemd','true','false',d)}; then
                install -d ${D}${systemd_unitdir}/system/
                install -m 0644 ${WORKDIR}/*.service ${D}${systemd_unitdir}/system
        fi
}
