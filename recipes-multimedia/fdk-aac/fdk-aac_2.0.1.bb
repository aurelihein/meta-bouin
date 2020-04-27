SUMMARY = "fdk-aac package provides the Fraunhofer FDK AAC library"
LICENSE = "FDK_AAC_Codec_Library_for_Android"
LIC_FILES_CHKSUM = "file://${LAYER_LICENSES}/FDK_AAC_Codec_Library_for_Android;md5=82cc3a3051fa83300844515aa0944374"

SRC_URI = "https://downloads.sourceforge.net/opencore-amr/fdk-aac-2.0.1.tar.gz"

SRC_URI[md5sum] = "e8b0b38e837df455b8a1ba75417ff0ad"
SRC_URI[sha256sum] = "840133aa9412153894af03b27b03dde1188772442c316a4ce2a24ed70093f271"


inherit autotools pkgconfig