#!/bin/sh

export TESSDATA_PREFIX=/usr/local/share/tessdata

echo $TESSDATA_PREFIX

sudo ls *.tiff | parallel /usr/local/bin/tesseract -l rus+eng {} {.}.res pdf
 
