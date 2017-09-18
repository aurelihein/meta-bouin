DESCRIPTION = "VERGE cryptocurrency"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

RDEPENDS_${PN} += "libcurl"
DEPENDS += "db boost openssl"

SRCREV ?= "${AUTOREV}"
SRC_URI += "git://github.com/vergecurrency/raspi;branch=master"
#SRC_URI += "git://github.com/vergecurrency/VERGE;branch=master"

SRC_URI[md5sum] = "3e44ce271424987c9c9ae845aece93f3"
SRC_URI[sha256sum] = "5da86a9e11478c9d9345d8bf2f06836c085b98cb5b8b29704f4ae67e227a97dc"

inherit autotools pkgconfig 

S = "${WORKDIR}/git"
B = "${WORKDIR}/git"

#EXTRA_OEMAKE="CFLAGS='-O3 -mfpu=neon '"
EXTRA_OECONF += "--with-incompatible-bdb --with-boost-libdir=${STAGING_LIBDIR} --disable-sse2 --disable-tests"
