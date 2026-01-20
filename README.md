MTTPP - Framework za automatsko testiranje programske podrške
Ivan Žgela

Ovaj projekt je razvijen kao okvir za automatizaciju frontend testiranja web aplikacije. Za potrebe testiranja korištena je platforma **SauceDemo**, a framework je izgrađen prema najvišim standardima automatizacije.

Korišteni alati i tehnologije
- **Programski jezik:** Java 25 (OpenJDK)
- **Build alat:** Maven
- **Testni framework:** TestNG (verzija 7.8.0)
- **Automatizacija:** Selenium WebDriver (verzija 4.27.0)
- **Upravljanje driverima:** WebDriverManager (verzija 5.6.3)

## Implementirane napredne tehnike (Bonus bodovi)
Kako bi se osigurala visoka kvaliteta koda i stabilnost testova, ugrađene su sljedeće tehnike:
1. **Page Object Model (POM)**: Lokatori i akcije su odvojeni od same testne logike (paketi `pages` i `tests`), što omogućuje lakše održavanje koda.
2. **WebDriverManager**: Automatsko upravljanje binarnim datotekama drivera, bez potrebe za ručnim skidanjem `chromedriver.exe`.
3. **JavascriptExecutor**: Korišten za robusno izvršavanje klikova na gumbima koji su kritični za checkout proces, čime se izbjegavaju problemi s verzijama preglednika.
4. **Explicit & Implicit Waits**: Implementirano sinkronizirano čekanje elemenata (`WebDriverWait` i `ExpectedConditions`) za stabilnost frameworka.
5. **OOP Nasljeđivanje**: Svi testovi nasljeđuju `BaseTest` klasu, čime je postignut čist setup i teardown proces.
6. **.gitignore**: Projekt je očišćen od suvišnih datoteka (target, .idea) pomoću .gitignore datoteke.

## Struktura projekta
- `src/main/java/pages`: Klase s lokatorima (LoginPage, InventoryPage).
- `src/test/java/base`: Konfiguracija drivera (BaseTest).
- `src/test/java/tests`: Implementacija 5 testnih scenarija.

## Popis testnih slučajeva
1. `testSuccessfulLogin` - Provjera prijave s ispravnim podacima.
2. `testFailedLogin` - Provjera validacije i error poruke za neispravnu lozinku.
3. `testAddToCart` - Provjera dodavanja artikla u košaricu i ažuriranja badge-a.
4. `testRemoveFromCart` - Provjera uklanjanja artikla i nestanka badge-a.
5. `testCheckout` - Kompletan proces kupnje (Ivan) od košarice do "Thank you for your order" stranice.

## Kako pokrenuti projekt
1. Klonirajte projekt: `git clone <URL_TVOG_REPOZITORIJA>`
2. Otvorite projekt u IntelliJ IDEA (kao Maven projekt).
3. Pokrenite testove putem TestNG runnera ili naredbom `mvn test`.
