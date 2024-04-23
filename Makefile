notatka.pdf:
	pandoc --from=gfm --to=pdf -V geometry:"left=1cm, top=1cm, right=1cm, bottom=2cm" ./notatki/notatka.md -o $@
kod.md:
	./combine_java.sh ./
kod.pdf: kod.md
	pandoc --from=gfm --to=pdf -V documentclass=extarticle -V wrap=auto -V geometry="left=1cm, top=1cm, right=1cm, bottom=2cm" ./notatki/kod.md -o $@

clean:
	rm -rf notatka.pdf
	rm -rf kod.pdf
	rm -rf ./notatki/kod.md