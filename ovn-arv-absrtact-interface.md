

## **Grundläggande Övningar** (Förståelse av koncept)  

### **1. Skapa en abstrakt klass för ett fordon**  
- Skapa en **abstrakt klass** `Vehicle` med:  
  - En variabel `speed` (int).  
  - En **abstrakt metod** `move()`.  
- Skapa två klasser `Car` och `Bicycle` som **ärver** från `Vehicle` och implementerar `move()`.  
- Testa genom att skapa en instans av `Car` och `Bicycle` och anropa `move()`.  

---

### **2. Skapa ett interface för flygande objekt**  
- Skapa ett **interface** `Flyable` med metoden `fly()`.  
- Skapa två klasser `Airplane` och `Bird` som **implementerar** `Flyable`.  
- Testa genom att skapa objekt av `Airplane` och `Bird` och anropa `fly()`.  

---

## **Medelsvåra Övningar** (Kombinera abstrakta klasser och interface)  

### **3. Kombinera abstrakta klasser och interface i ett djursystem**  
- Skapa en **abstrakt klass** `Animal` med:  
  - En metod `makeSound()` (abstrakt).  
- Skapa ett **interface** `Swimmable` med:  
  - En metod `swim()`.  
- Skapa två klasser:  
  - `Dog` som **ärver** från `Animal` och implementerar `makeSound()`.  
  - `Fish` som **ärver** från `Animal` och **implementerar** `Swimmable`.  
- Testa genom att skapa objekt och anropa deras metoder.  

---

### **4. Skapa en spelmekanik med fiender**  
- Skapa en **abstrakt klass** `Enemy` med:  
  - En `health`-variabel.  
  - En **abstrakt metod** `attack()`.  
- Skapa två subklasser `Goblin` och `Orc` som **ärver** från `Enemy` och implementerar `attack()`.  
- Skapa ett **interface** `MagicUser` med:  
  - En metod `castSpell()`.  
- Skapa en klass `DarkWizard` som **ärver** från `Enemy` och **implementerar** `MagicUser`.  
- Testa genom att skapa objekt av varje fiende och anropa deras attacker.  

---


### **5. Skapa ett system för elektroniska enheter**  
- Skapa en **abstrakt klass** `ElectronicDevice` med:  
  - En variabel `brand` (t.ex. "Apple", "Samsung").  
  - En **abstrakt metod** `turnOn()`.  
- Skapa två subklasser `Smartphone` och `Laptop` som **ärver** från `ElectronicDevice` och implementerar `turnOn()`.  
- Skapa ett **interface** `Rechargeable` med en metod `charge()`.  
- Låt både `Smartphone` och `Laptop` **implementera** `Rechargeable`.  
- Testa genom att skapa objekt av varje enhet och anropa deras metoder.  
