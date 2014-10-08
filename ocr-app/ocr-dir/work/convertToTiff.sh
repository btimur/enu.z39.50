#!/bin/sh

gs -q -dNOPAUSE -r600 -sDEVICE=tiffg4  -sOutputFile=$1  $2  -sCompression=none -c quit
