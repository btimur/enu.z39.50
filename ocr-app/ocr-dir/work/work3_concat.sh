#!/bin/sh

# concat pdf in single document
# $1 - result pdf file name
pdftk ./images/*.res.pdf cat output $1