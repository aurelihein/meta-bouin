FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://cog-fdo"

do_install_append () {
    install -d ${D}/${bindir}/
    install -m 755 ${WORKDIR}/cog-fdo ${D}/${bindir}/cog-fdo
}
