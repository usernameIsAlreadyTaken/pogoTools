set chPath=d:\p4\junzhou-PSHAENGDESK002-hauntedhog\
set episodesPath=%chPath%hauntedhog-server\src\main\webapp\episodes\icons\
set productsPath=%chPath%hauntedhog-server\src\main\webapp\products\
set scenesPath=%chPath%hauntedhog-server\src\main\webapp\scenes\icons\

d:
cd %episodesPath%
p4 add %2.png
cd %productsPath%
p4 add HauntedHog_episode_%1.png
p4 add HauntedHog_episode_%1_preview.png
p4 add OFB-GENI_%3.png
p4 add OFB-GENI_%4.png
p4 add OFB-GENI_%5.png
p4 add OFB-GENI_%6.png
cd %scenesPath%
p4 add %7.png
p4 add %8.png
p4 add %9.png