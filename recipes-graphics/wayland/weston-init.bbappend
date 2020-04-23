FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://weston.default"
SRC_URI += "file://weston@.service"
SRC_URI += "file://weston.ini"
SRC_URI += "file://profile-wayland.sh"

do_install_append () {
    install -d ${D}/${sysconfdir}/default
    install -m 0644 ${WORKDIR}/weston.default ${D}/${sysconfdir}/default/weston
    install -d ${D}/etc/profile.d
    install -m 755 ${WORKDIR}/profile-wayland.sh ${D}/etc/profile.d/
}

FILES_${PN} += "/etc/profile.d/"
