#!/bin/sh

# extract images from pdf file
# $1 - pdf file name
# $2 - index (number) of file

pdfimages -j $1 ./images/$2