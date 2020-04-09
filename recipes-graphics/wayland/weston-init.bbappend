FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://weston.default"
SRC_URI += "file://weston@.service"
SRC_URI += "file://weston.ini"

do_install_append () {
    install -d ${D}/${sysconfdir}/default/
    install -m 644 ${WORKDIR}/weston.default ${D}/${sysconfdir}/default/weston
}