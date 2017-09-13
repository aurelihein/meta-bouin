DESCRIPTION = "Bitcoin Miner"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

RDEPENDS_${PN} += "libcurl"
DEPENDS += "curl"

SRCREV ?= "${AUTOREV}"
#mgjaggers repo handle opencl that take advantage of using GPU devices for computing
#SRC_URI += "git://github.com/mgjaggers/cpuminer;branch=master"
SRC_URI += "git://github.com/pooler/cpuminer;branch=master"
SRC_URI += "file://0001-solve-AC_MSG_ERROR-and-libcurl-dependencies.patch"

SRC_URI[md5sum] = "3e44ce271424987c9c9ae845aece93f3"
SRC_URI[sha256sum] = "5da86a9e11478c9d9345d8bf2f06836c085b98cb5b8b29704f4ae67e227a97dc"

inherit autotools pkgconfig 

S = "${WORKDIR}/git"
B = "${WORKDIR}/git"

EXTRA_OEMAKE="CFLAGS='-O3 -mfpu=neon '"

