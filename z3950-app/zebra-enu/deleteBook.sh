#!/bin/sh


zebraidx adelete data/$1

zebraidx commit

mv  data/$1 deleted/$1
