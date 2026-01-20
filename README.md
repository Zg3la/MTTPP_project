MTTPP - Framework za automatsko testiranje programske podrške
Ivan Žgela

Ovaj projekt je razvijen kao okvir za automatizaciju frontend testiranja web aplikacije. Za potrebe testiranja korištena je platforma **SauceDemo**, a framework je izgrađen prema najvišim standardima automatizacije.

Korišteni alati i tehnologije
- **Programski jezik:** Java 25 (OpenJDK)
- **Build alat:** Maven
- **Testni framework:** TestNG (verzija 7.8.0)
- **Automatizacija:** Selenium WebDriver (verzija 4.27.0)
- **Upravljanje driverima:** WebDriverManager (verzija 5.6.3)

## Struktura projekta
- `src/main/java/pages`: Klase s lokatorima (LoginPage, InventoryPage).
- `src/test/java/base`: Konfiguracija drivera (BaseTest).
- `src/test/java/tests`: Implementacija 5 testova.

## Popis testnih slučajeva
1. `testSuccessfulLogin` - Provjera prijave s ispravnim podacima.
2. `testFailedLogin` - Provjera validacije i poruke za neispravnu lozinku.
3. `testAddToCart` - Provjera dodavanja proizvoda u košaricu i ažuriranja badge-a.
4. `testRemoveFromCart` - Provjera uklanjanja artikla i nestanka badgeaa.
5. `testCheckout` - Kompletan proces kupnje (Ivan) od košarice do "Thank you for your order" stranice.

## Pokretanje testova
1. Desni klik na datoteku src/test/java/tests/SauceDemoTests.java
2. Run 'SauceDemoTests'
3. Rezultati testova su vidljivi u "Run" windowu
