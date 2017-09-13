#! /bin/sh
# daemon start-up script for motioneye that create output dir if needed
# 
#
OUTPUT_DIR=/media/motioneye
[ ! -e $OUTPUT_DIR ] && mkdir -p $OUTPUT_DIR
exit 0
