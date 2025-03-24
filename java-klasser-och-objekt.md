# Java - Klasser och Objekt

## Vad är en klass?

En klass i Java är en **mall** eller **blueprint** som definierar egenskaper och beteenden för en viss typ av objekt. Klasser är grundläggande byggstenar i objektorienterad programmering (OOP).


**Liknelse med relationsdatabaser:**
- En klass motsvarar en **tabell** i en relationsdatabas
- Klassens attribut motsvarar **kolumner** i tabellen

## Vad är ett objekt?

Ett objekt är en **instans** av en klass. När en klass instansieras skapas ett objekt med sitt eget tillstånd (värden på attribut) men som följer strukturen och beteendet som definierats i klassen.

**Synonymer för objekt:**
- Instans

**Liknelse med relationsdatabaser:**
- Ett objekt motsvarar en **rad** i en tabell
- Objektets attributvärden motsvarar **cellvärden** i raden

## Klassers grundläggande byggstenar

### Attribut (fält/fields, variabler)

Attribut representerar **data** eller **tillstånd** som tillhör klassen. De deklareras i klassen.

```java
public class Person {
    // Attribut (fält)
    String namn;
    int ålder;
    String adress;
}
```

### Konstruktor

En konstruktor är en speciell metod som anropas när ett objekt skapas (instansieras). Konstruktorer:
- Har samma namn som klassen
- Har ingen returtyp (inte ens void)
- Anropas med nyckelordet `new`

Om du inte skapar någon konstruktor, får klassen automatiskt en standardkonstruktor utan parametrar som Java skapar åt dig.

```java
public class Person {
    String namn;
    int ålder;
    
    // Standardkonstruktor (utan parametrar)
    public Person() {
        this.namn = "Okänd";
        this.ålder = 0;
    }
    
    // Konstruktor med parametrar
    public Person(String namn, int ålder) {
        this.namn = namn;
        this.ålder = ålder;
    }
}
```

#### Flera konstruktorer i samma klass

Du kan ha flera konstruktorer i samma klass, så länge de har olika parameterlistor. Detta kallas för **konstruktoröverlagring**.

```java
public class Bil {
    String märke;
    String modell;
    int årsmodell;
    String färg;
    
    // Konstruktor 1 - endast märke och modell
    public Bil(String märke, String modell) {
        this.märke = märke;
        this.modell = modell;
        this.årsmodell = 2023;  // Standardvärde
        this.färg = "Vit";      // Standardvärde
    }
    
    // Konstruktor 2 - alla attribut
    public Bil(String märke, String modell, int årsmodell, String färg) {
        this.märke = märke;
        this.modell = modell;
        this.årsmodell = årsmodell;
        this.färg = färg;
    }
    
    // Konstruktor 3 - anropar en annan konstruktor med 'this'
    public Bil(String märke, String modell, int årsmodell) {
        this(märke, modell, årsmodell, "Vit");  // Anropar konstruktor 2
    }
}
```

#### Kreativa sätt att använda konstruktorer

**Exempel 1: Validering i konstruktorn**
```java
public class Cirkel {
    double radie;
    
    public Cirkel(double radie) {
        if (radie <= 0) {
            throw new IllegalArgumentException("Radien måste vara större än noll!");
        }
        this.radie = radie;
    }
}
```

**Exempel 2: Generera unika ID i konstruktorn**
```java
public class Produkt {
    String namn;
    double pris;
    String produktID;
    
    public Produkt(String namn, double pris) {
        this.namn = namn;
        this.pris = pris;
        // Generera ett unikt ID baserat på tiden
        this.produktID = "PROD-" + System.currentTimeMillis();
    }
}
```

**Exempel 3: Loggning vid objektskapande**
```java
public class LoggadAnvändare {
    String användarnamn;
    
    public LoggadAnvändare(String användarnamn) {
        this.användarnamn = användarnamn;
        System.out.println("Ny användare skapad: " + användarnamn + " kl " + java.time.LocalTime.now());
    }
}
```

### Getters och Setters (åtkomstmetoder)

Dessa metoder ger kontrollerad åtkomst till attribut:
- **Getters** hämtar värdet på ett attribut
- **Setters** ändrar värdet på ett attribut, ofta med validering

```java
public class Person {
    String namn;
    int ålder;
    
    // Konstruktor
    public Person(String namn, int ålder) {
        this.namn = namn;
        this.ålder = ålder;
    }
    
    // Getter för namn
    public String getNamn() {
        return this.namn;
    }
    
    // Setter för namn
    public void setNamn(String namn) {
        this.namn = namn;
    }
    
    // Getter för ålder
    public int getÅlder() {
        return this.ålder;
    }
    
    // Setter för ålder med validering
    public void setÅlder(int ålder) {
        if (ålder >= 0 && ålder <= 120) {
            this.ålder = ålder;
        } else {
            System.out.println("Ogiltig ålder angiven!");
        }
    }
}
```

#### Kreativa sätt att använda getters och setters

**Exempel 1: Formaterad data i getter**
```java
public class Anställd {
    String förnamn;
    String efternamn;
    
    // Getter som kombinerar förnamn och efternamn
    public String getFulltNamn() {
        return förnamn + " " + efternamn;
    }
    
    // Getter som returnerar initialer
    public String getInitialer() {
        return förnamn.charAt(0) + "." + efternamn.charAt(0) + ".";
    }
}
```

**Exempel 2: Konvertering i setter**
```java
public class Användare {
    String användarnamn;
    
    // Setter som konverterar till gemener
    public void setAnvändarnamn(String användarnamn) {
        this.användarnamn = användarnamn.toLowerCase();
    }
}
```

**Exempel 3: Beräknat värde i getter**
```java
public class Rektangel {
    double bredd;
    double höjd;
    
    // Getter för area - beräknas när den efterfrågas
    public double getArea() {
        return bredd * höjd;
    }
    
    // Getter för omkrets - beräknas när den efterfrågas
    public double getOmkrets() {
        return 2 * (bredd + höjd);
    }
}
```

### toString-metod

`toString`-metoden returnerar en strängrepresentation av objektet. Den ärvs från `Object`-klassen och överskrivs ofta för att ge mer meningsfull information.

```java
public class Person {
    String namn;
    int ålder;
    
    @Override
    public String toString() {
        return "Person [namn=" + namn + ", ålder=" + ålder + "]";
    }
}
```

### Instansmetoder (icke-statiska metoder)

Dessa metoder definierar objektets beteende och kan använda och förändra objektets tillstånd.

```java
public class Person {
    String namn;
    int ålder;
    
    public void presentera() {
        System.out.println("Hej, jag heter " + namn + " och är " + ålder + " år gammal.");
    }
    
    public void fyllaÅr() {
        this.ålder++;
        System.out.println(namn + " fyller " + ålder + " år idag!");
    }
}
```

### Kort om statiska medlemmar

Statiska medlemmar (markerade med nyckelordet `static`) tillhör klassen istället för enskilda objekt. Ett vanligt exempel är en räknare som håller koll på hur många objekt som skapats:

```java
public class Person {
    String namn;
    int ålder;
    
    // Statiskt attribut som är gemensamt för hela klassen
    static int antalPersoner = 0;
    
    public Person(String namn, int ålder) {
        this.namn = namn;
        this.ålder = ålder;
        antalPersoner++; // Öka räknaren varje gång en person skapas
    }
}
```

## Vanliga exempel på klasser i Java

### Exempel 1: En entitetsklass - Student

```java
public class Student {
    String förnamn;
    String efternamn;
    String studentID;
    int ålder;
    
    // Konstruktor
    public Student(String förnamn, String efternamn, String studentID, int ålder) {
        this.förnamn = förnamn;
        this.efternamn = efternamn;
        this.studentID = studentID;
        this.ålder = ålder;
    }
    
    // Getter för att få hela namnet
    public String getFulltNamn() {
        return förnamn + " " + efternamn;
    }
    
    // Metod för att kontrollera om studenten är myndig
    public boolean ärMyndig() {
        return ålder >= 18;
    }
    
    // toString-metod för trevlig utskrift
    @Override
    public String toString() {
        return "Student: " + getFulltNamn() + " (ID: " + studentID + ")";
    }
}
```

### Exempel 2: En klass för beräkningar - Miniräknare

```java
public class Miniräknare {
    // Konstruktor behövs inte eftersom vi använder standardkonstruktorn
    
    // Metoder för grundläggande beräkningar
    public double addera(double tal1, double tal2) {
        return tal1 + tal2;
    }
    
    public double subtrahera(double tal1, double tal2) {
        return tal1 - tal2;
    }
    
    public double multiplicera(double tal1, double tal2) {
        return tal1 * tal2;
    }
    
    public double dividera(double täljare, double nämnare) {
        if (nämnare == 0) {
            System.out.println("Varning: Division med noll!");
            return 0;
        }
        return täljare / nämnare;
    }
    
    // Metod för att beräkna potens
    public double upphöjtTill(double bas, int exponent) {
        double resultat = 1;
        for (int i = 0; i < exponent; i++) {
            resultat *= bas;
        }
        return resultat;
    }
}
```

### Exempel 3: En verktygsklass - TextBehandlare

```java
public class TextBehandlare {
    String text;
    
    // Konstruktor som tar emot en text
    public TextBehandlare(String text) {
        this.text = text;
    }
    
    // Konstruktor som skapar ett tomt objekt
    public TextBehandlare() {
        this.text = "";
    }
    
    // Metod för att sätta ny text
    public void setText(String text) {
        this.text = text;
    }
    
    // Metod för att lägga till text i slutet
    public void läggTillText(String tillägg) {
        this.text += tillägg;
    }
    
    // Metod för att räkna antal ord
    public int räknaOrd() {
        if (text.trim().isEmpty()) {
            return 0;
        }
        return text.trim().split("\\s+").length;
    }
    
    // Metod för att räkna antal tecken (inklusive mellanslag)
    public int räknaTecken() {
        return text.length();
    }
    
    // Metod för att konvertera texten till versaler
    public String tillVersaler() {
        return text.toUpperCase();
    }
    
    // Metod för att konvertera texten till gemener
    public String tillGemener() {
        return text.toLowerCase();
    }
}
```

## Klasser som inte passar i databas-liknelsen

### Arbetarklass

En klass som utför uppgifter men inte nödvändigtvis representerar data.

```java
public class EmailUtskickare {
    String avsändarAdress;
    
    public EmailUtskickare(String avsändarAdress) {
        this.avsändarAdress = avsändarAdress;
    }
    
    public void skickaEmail(String mottagare, String ämne, String meddelande) {
        // Kod för att skicka e-post skulle finnas här
        System.out.println("Skickar e-post från " + avsändarAdress + " till " + mottagare);
        System.out.println("Ämne: " + ämne);
        System.out.println("Meddelande: " + meddelande);
    }
}
```

### Kontrollerklass

En klass som styr flödet i en applikation.

```java
public class SpelarKontroller {
    public void startaSpel() {
        System.out.println("Spelet startar...");
        // Kod för att starta spelet
    }
    
    public void pausaSpel() {
        System.out.println("Spelet pausat");
        // Kod för att pausa spelet
    }
    
    public void avslutaSpel() {
        System.out.println("Spelet avslutas");
        // Kod för att avsluta spelet
    }
}
```
## Komposition - Att bygga klasser av andra klasser

Komposition är ett centralt begrepp inom objektorienterad programmering. Det handlar om att en klass kan innehålla objekt av andra klasser som attribut. Detta skapar en "har-en"-relation mellan klasserna.

### Vad är komposition?

- **Komposition** innebär att en klass innehåller objekt av andra klasser som en del av sitt tillstånd
- Detta skapar en "har-en"-relation (till skillnad från arv som skapar en "är-en"-relation)
- Komposition gör det möjligt att bygga komplexa objekt genom att kombinera enklare objekt

### Exempel på komposition

```java
// En enkel klass
public class Motor {
    private int hästkrafter;
    
    public Motor(int hästkrafter) {
        this.hästkrafter = hästkrafter;
    }
    
    public void starta() {
        System.out.println("Motorn startar: " + hästkrafter + " hästkrafter brummar!");
    }
}

// En klass som använder komposition
public class Bil {
    private String märke;
    private Motor motor;  // Bil "har-en" Motor
    
    public Bil(String märke, int motoreffekt) {
        this.märke = märke;
        this.motor = new Motor(motoreffekt);  // Skapar ett motor-objekt
    }
    
    public void starta() {
        System.out.println(märke + " startar:");
        motor.starta();  // Anropar metodern på det komposita objektet
    }
}
```

I exemplet ovan:
- `Bil` har en kompositionsrelation till `Motor` (en bil har en motor)
- `Bil`-klassen hanterar ett `Motor`-objekt som en del av sitt tillstånd
- När en `Bil` skapas, skapas också en `Motor` för den bilen
- `Bil`-klassen kan delegera vissa uppgifter till sin `Motor` (t.ex. att starta)

### Fördelar med komposition

1. **Återanvändning**: Du kan återanvända befintliga klasser för att bygga nya, mer komplexa klasser
2. **Modularitet**: Kod blir mer modulär och lättare att underhålla
3. **Ansvarsfördelning**: Varje klass kan fokusera på sin specifika uppgift

### Komposition med arrayer

Komposition kan också innebära att en klass innehåller flera objekt av samma typ, ofta lagrade i en array eller annan datastruktur.

```java
public class Bibliotek {
    private String namn;
    private Bok[] böcker;  // En array av Bok-objekt
    private int antalBöcker;
    
    public Bibliotek(String namn) {
        this.namn = namn;
        this.böcker = new Bok[100];  // Biblioteket kan innehålla upp till 100 böcker
        this.antalBöcker = 0;
    }
    
    public void läggTillBok(Bok bok) {
        if (antalBöcker < böcker.length) {
            böcker[antalBöcker] = bok;
            antalBöcker++;
        }
    }
}
```

I detta exempel har vi en `Bibliotek`-klass som innehåller en samling av `Bok`-objekt. Detta är exakt vad du kommer att implementera i övningarna!# Java - Klasser och Objekt

## Biblioteksövningar - Steg för steg

Nu ska vi bygga ett enkelt bibliotekssystem med klasser som du kan testa i main-metoden. Vi delar upp detta i flera övningar som bygger på varandra.

Använd endast engelska namn på attribut och metoder.

### Övning 1: Skapa Bok-klassen

Skapa en klass `Bok` med följande attribut:
- titel (String)
- författare (String)
- antalSidor (int)
- isbn (String)
- utlånad (boolean) - standardvärde false

Implementera:
- En konstruktor som tar titel, författare, antalSidor och isbn
- En konstruktor som bara tar titel och författare (sätt antalSidor till 100 och generera ett slumpmässigt ISBN)
- En metod `lånUt()` som ändrar utlånad till true
- En metod `lämnaTillbaka()` som ändrar utlånad till false
- En metod `ärTillgänglig()` som returnerar true om boken inte är utlånad
- En metod `ärLång()` som returnerar true om boken har fler än 400 sidor
- En toString-metod som visar all information om boken

### Övning 2: Skapa Bibliotek-klassen

Skapa en klass `Bibliotek` med följande attribut:
- namn (String)
- böcker - en ArrayList som kan lagra böcker (Komposition)
- antalBöcker (int) - håller reda på hur många böcker som finns i arrayen

Implementera:
- En konstruktor som tar bibliotekets namn och initierar arrayen
- En metod `läggTillBok(Bok bok)` som lägger till en bok i arrayen
- En metod `lånaBok(String titel)` som markerar en bok som utlånad om den finns och är tillgänglig
- En metod `återlämnabok(String titel)` som markerar en bok som återlämnad
- En metod `sökEfterBok(String titel)` som returnerar en bok om den hittas (annars null)
- En metod `skrivUtAllaBöcker()` som skriver ut information om alla böcker
- En metod `skrivUtTillgängligaBöcker()` som skriver ut information om alla tillgängliga böcker
- En statisk variabel `antalBibliotek` som räknar hur många bibliotek som skapats
- En getter `getAntalBibliotek()` som returnerar hur många bibliotek som skapats

### Övning 3: Skapa BibliotekProgram med main-metod

Skapa en klass `BibliotekProgram` med en main-metod som demonstrerar hela systemet. I main-metoden ska du:

1. Skapa ett bibliotek
2. Skapa några böcker med båda konstruktorerna 
3. Lägg till böckerna i biblioteket
4. Skriv ut alla böcker för att kontrollera
5. Låna ut några böcker
6. Skriv ut tillgängliga böcker
7. Återlämna en bok
8. Skriv ut tillgängliga böcker igen
9. Sök efter en specifik bok och kontrollera om den är lång
10. Skapa ett till bibliotek för att testa den statiska räknaren


