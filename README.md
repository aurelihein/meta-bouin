meta-bouin Yocto Layer
=====================

## Introduction ##

This is a meta that take advantage of the WPEwebkit under various platform

## Build Instructions ##

Building the firmware for rpi is pretty easy.

1. First of all create the yocto repository :

`mkdir zeus-rpi3-wpe`

`cd zeus-rpi3-wpe`

2. Download the needed metas thanks to repo :

`repo init -u https://github.com/aurelihein/meta-bouin.git -m manifest-zeus.xml -b zeus`

or

the latest tested one : 

`repo init -u https://github.com/aurelihein/meta-bouin.git -m manifest-last-tested-zeus.xml -b zeus`

`repo sync --force-sync`

3. Configure with the needed machine and config 

    * fdo mode :

    `source setup-environment build_rpi3_64-mesa-fdo raspberrypi3-64-mesa bouin rpi rpi3_64-fdo --update-config`

    * rdk mode (TODO) :

    `source setup-environment build_rpi3_64-mesa-rdk raspberrypi3-64-mesa bouin rpi rpi3_64-rdk --update-config`

4. Run the build

`bitbake demo-browser-image`

## Installing the wic image ##

From the build directory :

1.Rpi3 : `export SDCARD_IMAGE=tmp/deploy/images/raspberrypi3-64-mesa/demo-browser-image-raspberrypi3-64-mesa.wic`

2.Sdcard path : export it : `export SDCARD_SLOT=/dev/foo` and check with `lsblk ${SDCARD_SLOT}`

where `/dev/foo` might be `/dev/sde`, or whatever is appropriate for your system).

3.`sudo dd if=${SDCARD_IMAGE} of=${SDCARD_SLOT} bs=4M conv=notrunc,noerror status=progress ; sync`

The image will be burned to SD, erasing anything that might have already been there. Use a micro-SD card that's 4GB or larger.

## Installing the wic.gz image ##

From the build directory :

1.Rpi3 : `export GZ_SDCARD_IMAGE=tmp/deploy/images/raspberrypi3-64-mesa/demo-browser-image-raspberrypi3-64-mesa.wic.gz`

2.Sdcard path : export it : `export SDCARD_SLOT=/dev/foo` and check with `lsblk ${SDCARD_SLOT}`

where `/dev/foo` might be `/dev/sde`, or whatever is appropriate for your system).

3.`gzip -cd ${GZ_SDCARD_IMAGE} | sudo dd of=${SDCARD_SLOT} bs=4M conv=notrunc,noerror status=progress ; sync`

The image will be burned to SD, erasing anything that might have already been there. Use a micro-SD card that's 4GB or larger.

## Current branch and repo needed : ##

git clone -b zeus https://github.com/aurelihein/meta-bouin sources/meta-bouin
git clone -b zeus git://github.com/OSSystems/meta-gstreamer1.0.git sources/meta-gstreamer1.0
git clone -b zeus git://git.openembedded.org/meta-openembedded sources/meta-openembedded
git clone -b zeus git://git.yoctoproject.org/meta-raspberrypi sources/meta-raspberrypi
git clone -b master git://github.com/Igalia/meta-webkit sources/meta-webkit
git clone -b zeus https://git.yoctoproject.org/git/poky sources/poky

## Known Issues ##

For some reason wpewebkit try to use ${HOME}/.ccache folder, to avoid any problem you can do the following command before the command `source ...` :

`export HOME=/tmp/hometmp`
