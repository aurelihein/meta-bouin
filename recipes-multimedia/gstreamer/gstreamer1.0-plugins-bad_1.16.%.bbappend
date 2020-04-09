DEPENDS += "fdk-aac"
EXTRA_OECONF_remove = "--disable-fdk_aac"
EXTRA_OECONF += "--enable-fdk_aac"

DEPENDS += "wpebackend-fdo wpewebkit"
EXTRA_OECONF_remove = "--disable-wpe"
EXTRA_OECONF += "--enable-wpe"