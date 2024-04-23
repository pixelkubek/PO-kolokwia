#!/bin/bash

DIR="$PWD"
echo $DIR
fileName="$DIR/notatki/kod.md"
echo "# Rozwiązania PO" > $fileName || exit 1

tasks="2023 2021 2020 2019 2018"
echo $tasks

echo "Scanning directories"
for task in $tasks
do
    taskDir="$DIR/$task"
    taskName=$(basename $task)
    echo "## Zadanie: $taskName" >> $fileName || exit 1
    solutions=$(find $taskDir -type d)
    echo $solutions
    for solutionDir in $solutions
    do
        if [[ $solutionDir == $taskDir ]]; then
            continue
        fi

        dirname=$(basename $solutionDir)
        echo "### Rozwiązanie: $dirname" >> $fileName || exit 1
        echo "\`\`\`java" >> "$fileName" || exit 1
        files=$(find $solutionDir/ -name "*.java")
        for file in $files
        do
            cat "${file}" >> "$fileName" || exit 1
            echo "" >> "$fileName" || exit 1
        done
        echo "\`\`\`" >> "$fileName" || exit 1
    done
done

echo "Running make..."
make kod.pdf