#!/bin/sh

# Parameters
# 1 - 'source file path' to recognize (pdf-file)
# 2 - 'base name' of files (without sufix and extentions. In samlpe: 'files', 'SDADSASD' or others
#     As a result will be created files with name: <base-name>-<index>.tiff

PROCESS_COUNT=$((16-1))
DOC_PAGE_COUNT=$(gs -q -dNODISPLAY -c "($1) (r) file runpdfbegin pdfpagecount = quit")

if [ "$DOC_PAGE_COUNT" -lt "$PROCESS_COUNT" ]; then
	PROCESS_COUNT=$DOC_PAGE_COUNT
fi

echo '$PROCESS_COUNT='$PROCESS_COUNT
echo '$DOC_PAGE_COUNT='$DOC_PAGE_COUNT

PAGE_PER_PART=$((DOC_PAGE_COUNT / PROCESS_COUNT))
echo '$PAGE_PER_PART='$PAGE_PER_PART

RESIDUE=$(($DOC_PAGE_COUNT % $PROCESS_COUNT))
echo '$RESIDUE='$RESIDUE

PART_COUNT=$PROCESS_COUNT
if [ "$RESIDUE" -ne "0" ]; then
	PART_COUNT=$(($PART_COUNT + 1))
fi
echo '$PART_COUNT='$PART_COUNT

for i in $(seq 1 $PART_COUNT);
do
	FIRST_PAGE=$(( $PAGE_PER_PART * (i - 1) + 1 ))
	LAST_PAGE=$(( $PAGE_PER_PART * i ))
	if [ "$i" -eq "$PART_COUNT" ]; then
		LAST_PAGE=$DOC_PAGE_COUNT
	fi
	echo '['$FIRST_PAGE']-['$LAST_PAGE']'
    inputNo=$(printf "%04d" $i);
	gs -q -dNOPAUSE -r600 -sDEVICE=tiffg4 -dBATCH -sCompression=none -sOutputFile=$2-$inputNo.tiff -dFirstPage=$FIRST_PAGE -dLastPage=$LAST_PAGE $1
done
