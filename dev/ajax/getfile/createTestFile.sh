#!/bin/bash

if [ -z "$1" ]; then
  echo "Usage: createTestFile.sh <file> <count>"
  exit 1
else
  file=$1
fi

if [ -z "$2" ]; then
  echo "Usage: createTestFile.sh <file> <count>"
  exit 1
else 
  count=$2
fi

echo -n "" > $file

for i in `seq 1 $count`;
do
  echo "line" $i >> $file
done 
