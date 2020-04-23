DESCRIPTION = "This program used for copy primary framebuffer to secondary \
framebuffer (eg. FBTFT)"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=725f991a1cc322aa7a0cd3a2016621c4"

COMPATIBLE_MACHINE = "raspberrypi"

SRCBRANCH = "master"
SRCREV = "af8d32246c23cb23e4030e6588668a14341f5ddc"

SRC_URI = "\
    git://github.com/tasanakorn/rpi-fbcp.git;protocol=git;branch=${SRCBRANCH} \
    file://0001-Use-system-lib-directory.patch \
"
S = "${WORKDIR}/git"

inherit cmake

DEPENDS += "userland virtual/libgles2 virtual/egl"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 fbcp ${D}${bindir}
}