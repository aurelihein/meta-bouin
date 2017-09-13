DESCRIPTION = "A web frontend for the motion daemon, which is a software motion detector http://motion.sf.net"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4fe869ee987a340198fb0d54c55c47f1"

INHERIT_INIT_ADD =  "${@base_contains('DISTRO_FEATURES', 'systemd','systemd', 'update-rc.d', d)}"

DEPENDS += "python zlib jpeg"

MOTIONEYE_BRANCH ??= "master"
MOTIONEYE_SRC_URI ??= "git://github.com/ccrisan/motioneye"
SRCREV ?= "${AUTOREV}"
SRC_URI = "${MOTIONEYE_SRC_URI};branch=${MOTIONEYE_BRANCH}"
SRC_URI += "file://motioneye.conf"
SRC_URI += "file://motioneye.service"
SRC_URI += "file://motioneye.sh"

SRC_URI[md5sum] = "07bf90bcbf6337bc027c0b686b9b3a68"
SRC_URI[sha256sum] = "4ceb2d276904f71f5eb84455759f82fbba36025687d661c255f9e270c51e73c9"

inherit setuptools ${INHERIT_INIT_ADD}

SYSTEMD_SERVICE_${PN} = "motioneye.service"

S = "${WORKDIR}/git"
B = "${WORKDIR}/git"

do_install_append() {
	#Avoid package requires /bin/bash, but no providers found in RDEPENDS_
	sed -i -e "s/\/bin\/bash/\/bin\/sh/" ${D}/usr/lib/python2.7/site-packages/motioneye/scripts/relayevent.sh
	install -d ${D}/etc/motion/
	install -d ${D}/var/lib/motioneye
	install -m 0644 ${WORKDIR}/motioneye.conf ${D}/etc/motion/
	install -d ${D}/var/lib/motioneye
	install -d ${D}${systemd_unitdir}/system
	install -m 0644 ${WORKDIR}/motioneye.service ${D}${systemd_unitdir}/system/
	install -d ${D}/etc/init.d/
	install -m 0755 ${WORKDIR}/motioneye.sh ${D}/etc/init.d
	
}
# pip install motioneye --upgrade to install python-pillow

FILES_${PN} += "/lib/systemd/ /etc/init.d/"


