DESCRIPTION = "Motion, a software motion detector http://motion.sf.net"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://copyright;md5=877e86a07f388074ed4c7c5852c2700e"

RDEPENDS_${PN} += "libjpeg-turbo ffmpeg"
DEPENDS += "ffmpeg  libjpeg-turbo"
MOTION_BRANCH ??= "master"
MOTION_SRC_URI ??= "git://github.com/Ranoc/motion"
SRCREV ?= "${AUTOREV}"
SRC_URI = "${MOTION_SRC_URI};branch=${MOTION_BRANCH}"
SRC_URI += "file://motion.conf"
SRC_URI += "file://thread-1.conf"

SRC_URI[md5sum] = "07bf90bcbf6337bc027c0b686b9b3a68"
SRC_URI[sha256sum] = "4ceb2d276904f71f5eb84455759f82fbba36025687d661c255f9e270c51e73c9"

inherit autotools pkgconfig 

S = "${WORKDIR}/git"
B = "${WORKDIR}/git"

do_install_append() {
	#Avoid package requires /bin/bash, but no providers found in RDEPENDS_
	sed -i -e "s/\/bin\/bash/\/bin\/sh/" ${D}/usr/share/motion/examples/motion.init-Debian
	sed -i -e "s/\/bin\/bash/\/bin\/sh/" ${D}/usr/share/motion/examples/motion.init-Fedora
	install -d ${D}/etc/motion/
	install -m 0644 ${WORKDIR}/*.conf ${D}/etc/motion/
}


EXTRA_OECONF="--without-sdl --without-sqlite3"
