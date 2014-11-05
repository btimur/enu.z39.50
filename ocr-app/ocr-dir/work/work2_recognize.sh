#!/bin/sh

# recognize images
ls ./images | parallel /usr/local/bin/tesseract -c tessedit_pdf_compression=1 -l kaz+rus+eng ./images/{} ./images/{.}.res pdf