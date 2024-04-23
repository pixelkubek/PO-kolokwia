.PHONY: clean kod2.pdf

notatka.pdf:
	pandoc --from=gfm --to=pdf -V geometry:"left=1cm, top=1cm, right=1cm, bottom=2cm" ./notatki/notatka.md -o $@

kod.md:
	./combine_java.sh ./

kod1.pdf: kod.md
	pandoc --from=gfm --to=pdf -V documentclass=extarticle -V wrap=auto -V geometry="left=1cm, top=1cm, right=1cm, bottom=2cm" ./notatki/kod.md -o $@

kod2.pdf:
	bash src2pdf.sh

clean:
	rm -rf notatka.pdf kod.*
	rm -rf ./notatki/kod.md
