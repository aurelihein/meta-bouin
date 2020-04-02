rpi-bouin Yocto Layer
=====================

## Introduction ##

This layer is intended to provide information about raspberry pi
development firmware.

There is several interesting branches :
*master : support web browser, kiosk mode support hardware acceleration
->WPE : https://www.igalia.com/wpe/  -  https://webkit.org/wpe/

*crypto : if you want to try out minning crypto money : https://github.com/aurelihein/meta-bouin/tree/crypto/
->cpuminer
->bitmark
->verge
*video : if you want to try out video : https://github.com/aurelihein/meta-bouin/tree/video/
->motion
->motioneye
*webkit-wpe : if you want to try wpe webkit : https://webkit.org/wpe/
*initialenv : which is the starting point of a new branch

## Build Instructions ##

Building the firmware for rpi is pretty easy.

First of all download two needed meta :

1.`git clone `

Configure and run the build

1.`export TEMPLATECONF="$(pwd)/sources/meta-bouin/confs/conf-rpi" && export MACHINE="raspberrypi3" && export DISTRO="bouin" && . ./sources/poky/oe-init-build-env build`

3.`bitbake rpi-browser-image`

## Installing the wic image ##

From the build directory :

1.Rpi3 : `export SDCARD_IMAGE=build/tmp/deploy/images/raspberrypi3/rpi-browser-image-raspberrypi3.wic`

2.Sdcard place : export it : `export SDCARD_SLOT=/dev/foo` and check with `lsblk ${SDCARD_SLOT}`

where `/dev/foo` might be `/dev/sde`, or whatever is appropriate for your system).

3.`sudo dd if=${SDCARD_IMAGE} of=${SDCARD_SLOT} bs=4M conv=notrunc,noerror status=progress ; sync`

The image will be burned to SD, erasing anything that might have already been there. Use a micro-SD card that's 4GB or larger.

## Installing the wic.gz image ##

From the build directory :

1.Rpi3 : `export GZ_SDCARD_IMAGE=build/tmp/deploy/images/raspberrypi3/rpi-browser-image-raspberrypi3.wic.gz`

2.Sdcard place : export it : `export SDCARD_SLOT=/dev/foo` and check with `lsblk ${SDCARD_SLOT}`

where `/dev/foo` might be `/dev/sde`, or whatever is appropriate for your system).

3.`gzip -cd ${GZ_SDCARD_IMAGE} | sudo dd of=${SDCARD_SLOT} bs=4M conv=notrunc,noerror status=progress ; sync`

The image will be burned to SD, erasing anything that might have already been there. Use a micro-SD card that's 4GB or larger.

## Current State ##

git clone -b sumo https://github.com/aurelihein/meta-bouin sources/meta-bouin
git clone -b sumo git://github.com/OSSystems/meta-gstreamer1.0.git sources/meta-gstreamer1.0
git clone -b sumo git://git.openembedded.org/meta-openembedded sources/meta-openembedded
git clone -b sumo git://git.yoctoproject.org/meta-raspberrypi sources/meta-raspberrypi
git clone -b sumo git://github.com/Igalia/meta-webkit sources/meta-webkit
git clone -b sumo https://git.yoctoproject.org/git/poky sources/poky