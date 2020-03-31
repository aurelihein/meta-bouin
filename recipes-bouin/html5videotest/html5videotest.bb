SUMMARY = "HTML5 video test"
DESCRIPTION = "This a test for HTML5 video"
LICENSE = "CLOSED"

RDEPENDS_${PN} += "apache2"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI = "file://page.html"
SRC_URI += "file://10_24fps_5M_nb-fastdecode.mp4"
SRC_URI += "file://html5launcher.sh"

S="${WORKDIR}"

do_patch[noexec] = "1"
do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install () {
    rm -rf ${D}
    install -d ${D}/usr/share/apache2/htdocs
    install -m 644 ${WORKDIR}/*.html ${D}/usr/share/apache2/htdocs/
    install -m 644 ${WORKDIR}/*.mp4 ${D}/usr/share/apache2/htdocs/
    install -d ${D}/usr/bin
    install -m 755 ${WORKDIR}/*.sh ${D}/usr/bin/
}

FILES_${PN} = "/usr/share/apache2/htdocs/"
FILES_${PN} += "/usr/bin/"
