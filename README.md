#########################################################################
NAPOMENA: Za razvoj testova je korišćen Selenium 3 WebDriver alat
	  Testovi su pisani korišćenjem Junit frameworka i POM pattern-a
	  Korišćeno razvojno okruženje NetBeans IDE 8.2
	  Programski jezik: Java
#########################################################################

Za pokretanje test skripti potrebno je raspakovati rar folder HTEC_Dejan_Ilic.rar.

Otvoriti razvojno okruženje NetBeans IDE 8.2 i uvesti projekat.

Pre puštanja testova potrebno je pripremiti i dodatne biblioteke.

Biblioteke možete skinuti sa web adrese [ http://docs.seleniumhq.org/download/  ]  (Language Java).

Desni klik na projekat >> Propeties >> Libraries >> Compile kartica >> (izbrišete trenutne biblioteke koje se tu nalaze)
>> Add JAR/Folder i selektujete sve biblioteke koje ste prethodno skinuli na vašem računaru.

Potrebno je dodatno skinuti biblioteku log4j i na isti način uvesti u projekat.
Nju možete skinuti sa adrese [http://www.java2s.com/Code/Jar/l/Downloadlog4jjar.htm].

Takođe je neophodno skinuti chromedriver.exe i uvesti i taj fajl u root projekta.
Web adresa je [http://chromedriver.storage.googleapis.com/index.html?path=2.30/].
Skidate verziju u zavisnosti od operativnog sistema koji koristite.

Testove pokrećete iz foldera TestPackages koji se nalazi u okviru projekta.
Primer: Za pokretanje testa NewTopic.java koji je smešten u paketu new_topic, 
	neophodno je kliknuti desnim tasterom miša na NewTopic.java i izavrati opciju Run File ili Test File.
	Za pokretanje testova u Debug modu umesto Run File birate Debug Test File.