#!/bin/bash

find . -name "*.java" > source.txt
javac --release=7 @source.txt