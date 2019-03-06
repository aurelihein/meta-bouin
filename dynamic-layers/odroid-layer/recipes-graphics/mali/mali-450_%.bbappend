do_install () {
	# Create MALI manifest
	install -m 755 -d ${D}${libdir} ${D}${libdir}/pkgconfig ${D}${includedir}
	cp -av --no-preserve=ownership ${S}/lib/pkgconfig/* ${D}${libdir}/pkgconfig
	cp -av --no-preserve=ownership ${S}/include/EGL ${D}${includedir}
	cp -av --no-preserve=ownership ${S}/include/GLES ${D}${includedir}
	cp -av --no-preserve=ownership ${S}/include/GLES2 ${D}${includedir}
	cp -av --no-preserve=ownership ${S}/include/KHR ${D}${includedir}
	if [ "${USE_X11}" = "yes" ]; then
		cp -av --no-preserve=ownership ${S}/lib/arm64/r7p0/m450-X/*.so ${D}${libdir}
		cp -av --no-preserve=ownership ${S}/include/EGL_platform/platform_x11/* ${D}${includedir}/EGL
	fi
	if [ "${USE_WL}" = "yes" ]; then
		bbnote "Could use wayland/drm or wayland/fbdev"
		cp -av --no-preserve=ownership ${S}/lib/arm64/r7p0/m450/wayland/drm/*.so ${D}${libdir}
		cp -av --no-preserve=ownership ${S}/include/EGL_platform/platform_wayland/* ${D}${includedir}/EGL
		cp -av --no-preserve=ownership ${S}/lib/libwayland*.so* ${D}${libdir}
	fi
	if [ "${USE_DFB}" = "yes" ]; then
		cp -av --no-preserve=ownership ${S}/lib/arm64/r7p0/m450/fbdev/*.so ${D}${libdir}
		cp -av --no-preserve=ownership ${S}/include/EGL_platform/platform_fbdev/* ${D}${includedir}/EGL
	fi
	cp -av --no-preserve=ownership ${S}/lib/libE*.so* ${D}${libdir}
	cp -av --no-preserve=ownership ${S}/lib/libG*.so* ${D}${libdir}
	cp -av --no-preserve=ownership ${S}/lib/libgbm.so* ${D}${libdir}
	patchelf --set-soname libMali.so ${D}${libdir}/libMali.so
	ln -sf libMali.so ${D}/${libdir}/libOpenCL.so
	# Specific gbm move
	mv ${D}${libdir}/pkgconfig/gbm/* ${D}${libdir}/pkgconfig/
	rm -r ${D}${libdir}/pkgconfig/gbm
	mv ${D}${includedir}/EGL/gbm/* ${D}${includedir}
	rm -r ${D}${includedir}/EGL/gbm
}
