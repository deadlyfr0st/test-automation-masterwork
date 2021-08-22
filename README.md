# Web alkalmazás felület tesztelési vizsgaremek
Közösségi Wiki oldal tesztelése.

Az alkalmazás az alábbi link-re kattintva érhető el:
[Community Wiki](http://test-automation-wiki2.greenfox.academy)

</br>
</br>

*Leírás olvasása más nyelveken: [Magyar](README.md), [Angol](README.en.md).*

---
## Manuális tesztesetek
A manuális tesztesetek leírása megtekinthető az alábbi linken:\
[Teszt dokumentáció](https://docs.google.com/spreadsheets/d/1qGWCf2IpK-5bKLUf3cfcBtrDLPi3BzlE4_qjTqdzZg0/edit?usp=sharing)

---
## Információ a projektről
A projekt JAVA nyelven készült JDK8-al, IntelliJ IDEA fejlesztői környezetben, Gradle projekt struktúra és Selenium WebDriver használatával.
A tesztek futtatása JUnit5 és AssertJ segítségével történik.

Az elkészült tesztek jelenleg Google Chrome-ban futnak, viszont kompatibilisek az alábbi böngészőkkel:
- Google Chrome
- Mozilla Firefox
- Microsoft Edge

A használni kívánt böngészőt a "src/test/resources/test.properties" fájl-ban módosíthatjuk.\
Írjuk át a `chrome` kulcsszót `firefox`-ra.\
Amennyiben nem "firefox" vagy "chrome" szerepel a fájlban, akkor az alapértelmezett böngésző a Microsoft Edge lesz.

#### Tesztelt funkciók:
- Regisztráció
- Bejelentkezés/Kijelentkezés
- Adat listázás
- Navigálás több oldalas adatlisták között
- Új wiki oldalak létrehozása
- Létrehozott wiki oldalak módosítása
- Adat mentése fájl-ba

---
## Automata tesztek futtatása
- Klónozd le a repository-t a számítógépedre
- Nyisd meg a klónozott gradle projektet Intellij IDEA-val
- Kattints az IntelliJ ablak alján látható "Terminal" fülre
- Írd be a következőt: `gradlew clean test`
- Nyomj "Enter"-t

## Teszt report készítése és elérése az előzőleg futtatott tesztek után
- Kattints az IntelliJ ablak alján látható "Terminal" fülre
- Írd be a következőt: `gradlew allureServe`
- Nyomj "Enter"-t

Ez a parancs elkészíti a reportot és megnyitja az alapértelmezett böngésződben.

---
### Kiegészítő információ a tesztek futtatásához és teszt report készítéséhez

Amennyiben a fentebb leírt parancsok nem működnek, próbáld meg a parancsok elé írni a következőt: `./`\
pl., `./gradlew clean test`
