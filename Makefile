notatka.pdf:
	pandoc --from=gfm --to=pdf -V geometry:"left=1cm, top=1cm, right=1cm, bottom=2cm" ./notatki/notatka.md -o $@

clean:
	rm notatka.pdf