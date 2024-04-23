#!/usr/bin/env bash
# modified from:
# https://superuser.com/questions/601198/how-can-i-automatically-convert-all-source-code-files-in-a-folder-recursively

tex_file=$(mktemp) ## Random temp file name

cat<<EOF >$tex_file   ## Print the tex file header
\documentclass{article}

\usepackage{polski}
\usepackage[utf8]{inputenc}
\usepackage[a4paper, margin=1.5cm]{geometry}
\usepackage{multicol}

\usepackage{listings}
% Polish Char Fix
\lstset{               
  literate={ą}{{\k a}}1
           {Ą}{{\k A}}1
           {ż}{{\. z}}1
           {Ż}{{\. Z}}1
           {ź}{{\' z}}1
           {Ź}{{\' Z}}1
           {ć}{{\' c}}1
           {Ć}{{\' C}}1
           {ę}{{\k e}}1
           {Ę}{{\k E}}1
           {ó}{{\' o}}1
           {Ó}{{\' O}}1
           {ń}{{\' n}}1
           {Ń}{{\' N}}1
           {ś}{{\' s}}1
           {Ś}{{\' S}}1
           {ł}{{\l}}1
           {Ł}{{\L}}1
}

\lstdefinestyle{customasm}{
  language=Java,   
  breaklines=true, 
  linewidth=8.5cm,
  basicstyle=\tiny\ttfamily,
}        

\begin{document}

EOF

for baseFolder in $(find . -type d -regex '^./[0-9]*'); do
    for codeFolder in $baseFolder/*; do
        echo "\section{$codeFolder}" >> $tex_file
        echo "\begin{multicols}{2}" >> $tex_file

        find $codeFolder -type f -name "*.java" | 
        sed 's/^\..//' |                 ## Change ./foo/bar.src to foo/bar.src

        while read  i; do                ## Loop through each file
            name=${i//_/\\_}             ## escape underscores
            echo "\lstinputlisting[style=customasm]{\detokenize{$i}}" >>$tex_file
        done &&
        echo "\end{multicols}" >> $tex_file

    done
done

echo "\end{document}" >> $tex_file &&
pdflatex -jobname=kod -output-directory . $tex_file && 
pdflatex -jobname=kod -output-directory . $tex_file