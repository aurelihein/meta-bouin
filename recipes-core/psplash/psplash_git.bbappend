FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SPLASH_IMAGES_append = " file://bouin_640x544.png;outsuffix=bouin"
ALTERNATIVE_PRIORITY_psplash-bouin[psplash] = "500"

SRC_URI_append = " ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', '\
                   file://psplash-quit.service \
                   file://psplash-start.service \
                   file://psplash-final.service \
                   ', '', d)}"

inherit systemd
SYSTEMD_SERVICE_${PN} = "${@bb.utils.contains('DISTRO_FEATURES','systemd','psplash-start.service psplash-quit.service psplash-final.service','',d)}"

do_install_append() {
        if ${@bb.utils.contains('DISTRO_FEATURES','systemd','true','false',d)}; then
                install -d ${D}${systemd_unitdir}/system/
                install -m 0644 ${WORKDIR}/*.service ${D}${systemd_unitdir}/system
        fi
}
