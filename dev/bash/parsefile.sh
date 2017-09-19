#! /bin/bash

file="./data.txt"

while IFS= read line
do
    # display $line or do somthing with $line
    echo "read a line:"
    echo "$line"

    IFS=' ', read -a myarray <<< "$line"

    echo ${myarray[0]}
    echo ${myarray[1]}
    echo ${myarray[2]} 

done <"$file"
