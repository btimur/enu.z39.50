#!/bin/sh

export TESSDATA_PREFIX=/usr/local/share/tessdata

echo $TESSDATA_PREFIX

ls *.tiff | parallel sudo /usr/local/bin/tesseract -l kaz+rus+eng {} {.}.res pdf
 
