export WAYLAND_DISPLAY="wayland-0"
export XDG_RUNTIME_DIR="/run/user/0"
if [ ! -d ${XDG_RUNTIME_DIR} ]; then
    if [ -e /tmp/weston_export.sh ]; then
        source /tmp/weston_export.sh
    else
        echo "Warning /tmp/weston_export.sh does not exist" >&2
    fi
fi
export COG_PLATFORM_FDO_VIEW_FULLSCREEN=1
