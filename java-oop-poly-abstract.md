# Objektorienterad Programmering i Java - En introduktion

## Vad är Objektorienterad Programmering och varför använder vi det?

Objektorienterad programmering (OOP) är en programmeringsparadigm som bygger på konceptet "objekt". Ett objekt innehåller både data (attribut) och funktionalitet (metoder) som arbetar med dessa data. Det är ett sätt att organisera kod som gör den mer:

- **Strukturerad**: Kod organiseras i logiska enheter (klasser och objekt)
- **Underhållbar**: Ändringar i en del påverkar inte nödvändigtvis andra delar
- **Återanvändbar**: Samma kod kan användas på flera ställen utan att dupliceras
- **Skalbar**: Programmet kan växa utan att bli ohanterligt komplext

### Verkliga exempel och liknelser

I verkliga livet grupperar vi naturligt saker efter deras egenskaper och beteenden. En bil har attribut (färg, märke, modell) och beteenden (acceleration, bromsning). I OOP representerar vi dessa som:

```java
class Bil {
    // Attribut (data)
    String färg;
    String märke;
    String modell;
    
    // Metoder (beteenden)
    void accelerera() {
        System.out.println("Bilen accelererar");
    }
    
    void bromsa() {
        System.out.println("Bilen bromsar");
    }
}
```

### Fördelar med OOP

1. **Modularitet**: Programmet delas upp i självständiga moduler
2. **Kodåteranvändning**: Genom arv och sammansättning kan kod användas på flera ställen
3. **Enklare felsökning**: Problem kan isoleras till specifika klasser eller objekt
4. **Säkrare data**: Genom inkapsling kan vi kontrollera tillgången till känslig data
5. **Speglar verkligheten**: OOP-modeller speglar ofta verkliga objekt och relationer

## De fyra grundpelarna i OOP

Java och andra objektorienterade språk bygger på fyra grundläggande principer:

1. **Encapsulation** (Inkapsling)
2. **Inheritance** (Arv)
3. **Polymorphism** (Polymorfism)
4. **Abstraction** (Abstraktion)

Låt oss utforska var och en av dessa för att förstå hur de hjälper oss att bygga robusta program.

## Encapsulation (Inkapsling) - Skydda och kontrollera data

Encapsulation handlar om att skydda data och begränsa direkt åtkomst till ett objekts interna tillstånd. Vi gör detta genom att:
- Göra attribut privata
- Erbjuda publika metoder för att komma åt och ändra data på ett kontrollerat sätt

### Hur gör vi det?

Vi använder **access modifiers** (åtkomstmodifierare) för att kontrollera vem som har tillgång till våra variabler och metoder:

```java
public class Konto {
    // Privata attribut - direkt åtkomst begränsad
    private double saldo;
    private String kontonummer;
    
    // Publika metoder - kontrollerad åtkomst
    public double getSaldo() {
        return saldo;
    }
    
    public void insättning(double belopp) {
        if (belopp <= 0) {
            System.out.println("Beloppet måste vara positivt");
            return;
        }
        this.saldo += belopp;
    }
    
    public boolean uttag(double belopp) {
        if (belopp <= 0) {
            System.out.println("Beloppet måste vara positivt");
            return false;
        }
        
        if (belopp > saldo) {
            System.out.println("Otillräckligt saldo");
            return false;
        }
        
        this.saldo -= belopp;
        return true;
    }
}
```

### Vad får vi ut av det?

1. **Dataskydd**: Vi förhindrar att attribut ändras på ogiltiga sätt
2. **Validering**: Vi kan kontrollera att all data uppfyller regler innan den accepteras
3. **Flexibilitet**: Vi kan ändra den interna implementationen utan att påverka kod som använder klassen
4. **Läsbarhet**: Kod blir enklare att förstå när åtkomst är tydligt definierad

## Inheritance (Arv) - Bygg på befintlig funktionalitet

Inheritance låter oss skapa nya klasser baserade på befintliga klasser. Den nya klassen (subklassen) ärver attribut och metoder från den befintliga klassen (superklassen).

### Hur gör vi det?

Vi använder nyckelordet `extends` för att skapa en subklass:

```java
// Superclass
public class Fordon {
    protected String registreringsnummer;
    protected String märke;
    
    public void start() {
        System.out.println("Fordonet startar");
    }
    
    public void stopp() {
        System.out.println("Fordonet stannar");
    }
}

// Subclass
public class Bil extends Fordon {
    private int antalDörrar;
    
    public void kör() {
        System.out.println("Bilen kör framåt");
    }
}
```

### Vad får vi ut av det?

1. **Kodåteranvändning**: Vi behöver inte upprepa kod som redan finns i superklassen
2. **Hierarkisk organisation**: Vi kan organisera klasser i logiska hierarkier
3. **Specialisering**: Vi kan skapa mer specialiserade versioner av generella koncept
4. **Enklare underhåll**: Ändringar i superklassen påverkar automatiskt alla subklasser

När vi skapar en `Bil`-instans har den alla funktioner från både `Bil` och `Fordon`:

```java
Bil minBil = new Bil();
minBil.märke = "Volvo";  // Ärvt attribut från Fordon
minBil.start();          // Ärvd metod från Fordon
minBil.kör();            // Metod definierad i Bil
```

## Polymorphism (Polymorfism) - Många former, ett gränssnitt

Polymorfism låter oss arbeta med objekt av olika klasser genom ett gemensamt gränssnitt. Det finns två typer av polymorfism:

1. **Compile-time polymorphism**: Method overloading (samma metodnamn, olika parametrar)
2. **Run-time polymorphism**: Method overriding (omdefiniera ärvda metoder)

### Hur gör vi det?

#### Method Overriding (körtidspolymorfism)

```java
public class Fordon {
    public void ljud() {
        System.out.println("Fordon låter");
    }
}

public class Bil extends Fordon {
    @Override
    public void ljud() {
        System.out.println("Bilen tutar");
    }
}

public class Motorcykel extends Fordon {
    @Override
    public void ljud() {
        System.out.println("Motorcykeln brummar");
    }
}
```

#### Superklassreferenser

En av de kraftfullaste aspekterna av polymorfism är att en superklassreferens kan referera till ett subklassobjekt:

```java
Fordon fordon1 = new Bil();
Fordon fordon2 = new Motorcykel();

fordon1.ljud();  // Utskrift: "Bilen tutar"
fordon2.ljud();  // Utskrift: "Motorcykeln brummar"
```

Här är både `fordon1` och `fordon2` deklarerade som typen `Fordon`, men de refererar till objekt av olika typer. När vi anropar `ljud()`, används versionen från den faktiska objekttypen, inte från referenstypen.

### Vad får vi ut av det?

1. **Flexibilitet**: Kod kan hantera olika typer av objekt utan att veta deras exakta typ
2. **Utbyggbarhet**: Vi kan lägga till nya typer utan att ändra existerande kod
3. **Generalisering**: Vi kan skriva kod som fungerar med vilken subklass som helst

#### Exempel på Polymorfism med arrayreferenser

Java är starkt typat, vilket betyder att varje variabel måste ha en specifik typ. Men med polymorfism kan vi ha en array som innehåller olika typer av relaterade objekt:

```java
// Array av Fordon som kan innehålla olika subklasser
Fordon[] fordon = new Fordon[3];
fordon[0] = new Bil();
fordon[1] = new Motorcykel();
fordon[2] = new Fordon();

// Vi kan iterera och anropa samma metod på alla
for (Fordon f : fordon) {
    f.ljud();  // Anropar rätt version för varje objekt
}
```

Utskrift:
```
Bilen tutar
Motorcykeln brummar
Fordon låter
```

#### Praktiskt exempel: Formberäkningar

```java
public class GeometriskForm {
    public double area() {
        return 0.0;
    }
}

public class Cirkel extends GeometriskForm {
    private double radie;
    
    public Cirkel(double radie) {
        this.radie = radie;
    }
    
    @Override
    public double area() {
        return Math.PI * radie * radie;
    }
}

public class Rektangel extends GeometriskForm {
    private double bredd;
    private double höjd;
    
    public Rektangel(double bredd, double höjd) {
        this.bredd = bredd;
        this.höjd = höjd;
    }
    
    @Override
    public double area() {
        return bredd * höjd;
    }
}

// Användning
public class Main {
    public static void main(String[] args) {
        GeometriskForm[] former = new GeometriskForm[2];
        former[0] = new Cirkel(5.0);
        former[1] = new Rektangel(4.0, 6.0);
        
        for (GeometriskForm form : former) {
            System.out.println("Arean är: " + form.area());
        }
    }
}
```

## Abstraction (Abstraktion) - Fokusera på det väsentliga

Abstraction handlar om att fokusera på vad något gör snarare än hur det gör det. Vi visar bara de nödvändiga funktionerna och döljer komplexiteten.

### Hur gör vi det?

Vi använder abstract klasser och metoder:

```java
// 1. Vi lägger till ordet "abstract" före klassen
public abstract class Djur {
    protected String namn;
    
    // Vanlig konkret metod som alla djur kan använda
    public void sov() {
        System.out.println(namn + " sover");
    }
    
    // 2. Vi deklarerar en metod som abstract 
    // (utan implementation, bara signaturen)
    public abstract void låt();
}
```

När vi markerar en klass som `abstract`:
1. Vi kan inte skapa instanser av den direkt (`new Djur()` skulle ge kompileringsfel)
2. Vi kan deklarera abstrakta metoder (metoder utan implementation)
3. Subklasser måste implementera alla abstrakta metoder (eller också vara abstrakta)

### Implementera en Abstrakt Klass

```java
public class Hund extends Djur {
    public Hund(String namn) {
        this.namn = namn;
    }
    
    // Vi måste implementera den abstrakta metoden
    @Override
    public void låt() {
        System.out.println(namn + " skäller");
    }
}

public class Katt extends Djur {
    public Katt(String namn) {
        this.namn = namn;
    }
    
    @Override
    public void låt() {
        System.out.println(namn + " jamar");
    }
}
```

### Vad får vi ut av det?

1. **Konceptuell klarhet**: Vi definierar tydligt vad en klass måste göra
2. **Förhindrar felaktig användning**: Vi kan inte skapa instanser av ofullständiga koncept
3. **Garanterad funktionalitet**: Alla subklasser måste implementera abstract metoder
4. **Gemensamt API**: Vi kan definiera ett gemensamt gränssnitt för relaterade klasser

#### Användning:

```java
// Djur djur = new Djur();  // Kompileringsfel: Cannot instantiate abstract class
Djur hund = new Hund("Rex");  // OK - referens kan vara abstract typ
Djur katt = new Katt("Whiskers");  // OK

hund.sov();  // Rex sover
hund.låt();  // Rex skäller

katt.sov();  // Whiskers sover
katt.låt();  // Whiskers jamar
```

## Interfaces - Definiera beteenden

Interfaces är en annan form av abstraktion. De definierar ett kontrakt för vad en klass kan göra, utan att specificera hur.

### Hur gör vi det?

Istället för `class` använder vi nyckelordet `interface`:

```java
public interface Simbar {
    // Alla metoder i ett interface är implicit abstract
    void simma();
    
    // Sedan Java 8 kan vi ha "default"-metoder med implementation
    default void flyt() {
        System.out.println("Flyter på vattnet");
    }
}
```

En klass implementerar ett interface med nyckelordet `implements`:

```java
public class Fisk implements Simbar {
    @Override
    public void simma() {
        System.out.println("Fisken simmar genom att röra sin stjärtfena");
    }
}

public class Anka extends Fågel implements Simbar {
    @Override
    public void simma() {
        System.out.println("Ankan simmar på vattenytan");
    }
}
```

### Skillnad mellan Abstract Klass och Interface

| Abstract Klass | Interface |
|----------------|-----------|
| Kan ha både abstrakta och konkreta metoder | Traditionellt bara abstrakta metoder (sedan Java 8 även default och static) |
| Kan ha instance variables | Bara konstanter (public static final) |
| En klass kan bara ärva från en abstract klass | En klass kan implementera flera interfaces |
| Kan ha konstruktorer | Kan inte ha konstruktorer |

### Vad får vi ut av det?

1. **Multipla beteenden**: En klass kan implementera flera interfaces
2. **Löst kopplad kod**: Koder är inte beroende av specifika implementationer
3. **Tydliga kontrakt**: Definierar tydligt vad en klass måste göra
4. **Flexibilitet**: Vi kan lägga till ny funktionalitet utan att ändra existerande klasshierarkier

#### Praktiskt exempel med interface:

```java
// Ett interface för betalningssätt
public interface Betalningsmetod {
    boolean processaBetalning(double belopp);
    String getBetalningsInfo();
}

// Olika implementationer
public class Kreditkort implements Betalningsmetod {
    private String kortnummer;
    
    public Kreditkort(String kortnummer) {
        this.kortnummer = kortnummer;
    }
    
    @Override
    public boolean processaBetalning(double belopp) {
        System.out.println("Betalar " + belopp + " kr med kreditkort");
        return true;
    }
    
    @Override
    public String getBetalningsInfo() {
        return "Kreditkort som slutar på " + kortnummer.substring(kortnummer.length() - 4);
    }
}

public class Swish implements Betalningsmetod {
    private String telefonnummer;
    
    public Swish(String telefonnummer) {
        this.telefonnummer = telefonnummer;
    }
    
    @Override
    public boolean processaBetalning(double belopp) {
        System.out.println("Betalar " + belopp + " kr med Swish");
        return true;
    }
    
    @Override
    public String getBetalningsInfo() {
        return "Swish till nummer " + telefonnummer;
    }
}

// Användning
public class Butik {
    public void genomförKöp(double belopp, Betalningsmetod betalning) {
        System.out.println("Bearbetar köp på " + belopp + " kr");
        System.out.println("Betalningssätt: " + betalning.getBetalningsInfo());
        
        if (betalning.processaBetalning(belopp)) {
            System.out.println("Köp genomfört!");
        } else {
            System.out.println("Betalning misslyckades!");
        }
    }
}
```

Vi kan nu använda olika betalningsmetoder utan att ändra `Butik`-klassen:

```java
Butik butik = new Butik();
butik.genomförKöp(500.0, new Kreditkort("1234-5678-9012-3456"));
butik.genomförKöp(350.0, new Swish("070-1234567"));
```

## Kombinera OOP-principerna

Ett robust Java-program använder alla dessa principer tillsammans:

1. **Encapsulation** skyddar våra data och säkerställer validitet
2. **Inheritance** låter oss återanvända kod och bygga hierarkier
3. **Polymorphism** ger oss flexibilitet att hantera olika objekttyper
4. **Abstraction** låter oss fokusera på vad något gör utan detaljer om hur

### Praktiskt exempel: Banksystem

```java
// Abstrakt basklass
public abstract class Konto {
    // Encapsulation - privata attribut
    private String kontonummer;
    private double saldo;
    private String ägare;
    
    // Konstruktor
    public Konto(String kontonummer, String ägare, double initsaldo) {
        this.kontonummer = kontonummer;
        this.ägare = ägare;
        this.saldo = initsaldo;
    }
    
    // Getters
    public String getKontonummer() { return kontonummer; }
    public String getÄgare() { return ägare; }
    public double getSaldo() { return saldo; }
    
    // Konkreta metoder
    public void insättning(double belopp) {
        if (belopp <= 0) {
            System.out.println("Beloppet måste vara positivt");
            return;
        }
        saldo += belopp;
        System.out.println(belopp + " kr insatt. Nytt saldo: " + saldo);
    }
    
    public boolean uttag(double belopp) {
        if (belopp <= 0) {
            System.out.println("Beloppet måste vara positivt");
            return false;
        }
        
        if (kanGöraUttag(belopp)) {
            saldo -= belopp;
            System.out.println(belopp + " kr uttaget. Nytt saldo: " + saldo);
            return true;
        } else {
            System.out.println("Uttag nekades");
            return false;
        }
    }
    
    // Abstrakt metod - olika kontotyper implementerar detta olika
    protected abstract boolean kanGöraUttag(double belopp);
    
    // För polymorfism - varje kontotyp ska beskriva sig
    public abstract String getKontotyp();
}

// Konkret subklass
public class Sparkonto extends Konto {
    private double ränta;
    
    public Sparkonto(String kontonummer, String ägare, double initsaldo, double ränta) {
        super(kontonummer, ägare, initsaldo);
        this.ränta = ränta;
    }
    
    public double getRänta() { return ränta; }
    
    // Kan bara ta ut pengar om det finns tillräckligt saldo
    @Override
    protected boolean kanGöraUttag(double belopp) {
        return belopp <= getSaldo();
    }
    
    // Implementation av abstrakt metod
    @Override
    public String getKontotyp() {
        return "Sparkonto med " + (ränta * 100) + "% ränta";
    }
    
    // Unik metod för Sparkonto
    public void beräknaRänta() {
        double räntebelopp = getSaldo() * ränta;
        insättning(räntebelopp);
        System.out.println("Ränta tillagd: " + räntebelopp + " kr");
    }
}

// Annan subklass
public class Lönekonto extends Konto {
    private double kreditgräns;
    
    public Lönekonto(String kontonummer, String ägare, double initsaldo, double kreditgräns) {
        super(kontonummer, ägare, initsaldo);
        this.kreditgräns = kreditgräns;
    }
    
    public double getKreditgräns() { return kreditgräns; }
    
    // Kan ta ut pengar upp till kreditgränsen
    @Override
    protected boolean kanGöraUttag(double belopp) {
        return (getSaldo() - belopp) >= -kreditgräns;
    }
    
    // Implementation av abstrakt metod
    @Override
    public String getKontotyp() {
        return "Lönekonto med " + kreditgräns + " kr kreditgräns";
    }
}

// Interface för funktionalitet
public interface Överförbar {
    boolean överförTill(Konto mottagare, double belopp);
}

// Implementera interface
public class DigitaltKonto extends Lönekonto implements Överförbar {
    private boolean mobilbank;
    
    public DigitaltKonto(String kontonummer, String ägare, double initsaldo, 
                        double kreditgräns, boolean mobilbank) {
        super(kontonummer, ägare, initsaldo, kreditgräns);
        this.mobilbank = mobilbank;
    }
    
    public boolean harMobilbank() { return mobilbank; }
    
    @Override
    public boolean överförTill(Konto mottagare, double belopp) {
        if (uttag(belopp)) {
            mottagare.insättning(belopp);
            System.out.println("Överföring slutförd");
            return true;
        }
        return false;
    }
    
    @Override
    public String getKontotyp() {
        return "Digitalt " + super.getKontotyp() + 
               (mobilbank ? " med mobilbank" : " utan mobilbank");
    }
}

// Användning - visar polymorfism
public class Bank {
    public static void main(String[] args) {
        // Polymorfism - alla är Konto men av olika subtyper
        Konto[] konton = new Konto[3];
        konton[0] = new Sparkonto("S123", "Kalle", 5000, 0.02);
        konton[1] = new Lönekonto("L456", "Lisa", 3000, 1000);
        konton[2] = new DigitaltKonto("D789", "Olle", 1000, 500, true);
        
        // Loopa genom konton och visa info
        for (Konto konto : konton) {
            System.out.println("---------------------------");
            System.out.println("Ägare: " + konto.getÄgare());
            System.out.println("Typ: " + konto.getKontotyp());  // Polymorfisk anrop
            System.out.println("Saldo: " + konto.getSaldo());
            
            // Testa uttag på olika konton
            konto.uttag(2000);  // Polymorfiskt beteende
            
            // Specialbehandling med instanceof och casting
            if (konto instanceof Sparkonto) {
                Sparkonto spark = (Sparkonto) konto;
                spark.beräknaRänta();
            }
            
            // Använd interface
            if (konto instanceof Överförbar) {
                System.out.println("Detta konto kan göra överföringar");
                Överförbar digitalt = (Överförbar) konto;
                
                // Bara som exempel
                if (konton[0] != konto) {
                    digitalt.överförTill(konton[0], 100);
                }
            }
        }
    }
}
```

## Steg för steg mot bättre OOP-design

När du utvecklar program med OOP, tänk på dessa steg:

1. **Identifiera objekt**: Vad är de huvudsakliga "sakerna" i ditt program?
2. **Identifiera attribut**: Vilken data behöver varje objekt lagra?
3. **Identifiera beteenden**: Vilka operationer kan utföras på eller av objekten?
4. **Identifiera relationer**: Hur relaterar objekten till varandra?
5. **Organisera i klasser**: Skapa klasser baserade på dina objekt
6. **Använd encapsulation**: Gör attribut privata och erbjud metoder för åtkomst
7. **Identifiera gemensamma egenskaper**: Leta efter möjligheter till arv
8. **Identifiera abstraktioner**: Vad är generella koncept som kan vara abstrakta?
9. **Definiera interfaces**: Vilka beteenden kan delas mellan orelaterade klasser?
10. **Utnyttja polymorfism**: Designa för att hantera olika objekttyper enhetligt

## Sammanfattning

Objektorienterad programmering är ett kraftfullt sätt att strukturera kod som speglar verklighetens objekt och relationer. Genom att förstå och använda de fyra grundpelarna - encapsulation, inheritance, polymorphism och abstraction - kan du skapa kod som är:

- Enklare att förstå och underhålla
- Mer återanvändbar
- Mer flexibel och utbyggbar
- Mer robust och felsäker

Kom ihåg att bra OOP-design handlar inte bara om att använda alla funktioner bara för att de finns - det handlar om att använda rätt verktyg för rätt problem på ett sätt som gör din kod bättre.
