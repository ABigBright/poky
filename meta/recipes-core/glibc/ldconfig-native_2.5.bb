DESCRIPTION = "A standalone native ldconfig build"

LICENSE = "GPLv2"

SRC_URI = "file://ldconfig-native-2.5.tar.bz2 \
           file://ldconfig.patch;patch=1 \
           file://32and64bit.patch;patch=1"

PR = "r1"

inherit native

S = "${WORKDIR}/${PN}-${PV}"

do_compile () {
	$CC ldconfig.c -std=gnu99 chroot_canon.c xmalloc.c xstrdup.c cache.c readlib.c  -I. dl-cache.c -o ldconfig
}

do_install () {
	install -d ${D}/${bindir}/
	install ldconfig ${D}/${bindir}/
}
