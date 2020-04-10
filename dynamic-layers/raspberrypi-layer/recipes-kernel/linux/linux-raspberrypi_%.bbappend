DISABLE_RPI_BOOT_LOGO ?= "1"
DISABLE_CONSOLE_LOG_AT_BOOT ?= "1"

# Disable rpi logo on boot
CMDLINE_append += ' ${@oe.utils.conditional("DISABLE_CONSOLE_LOG_AT_BOOT", "1", "quiet", "", d)}'
