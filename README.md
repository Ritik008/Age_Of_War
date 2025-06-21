## How to Run

1. **Compile the Java files:**
   ```bash
   javac WarMain.java
   ```

2. **Run the program:**
   ```bash
   java WarMain
   ```

## Input Format

The program expects two lines of input in the format:
```
Class#Count;Class#Count;Class#Count;Class#Count;Class#Count
```

Example:
```
Spearmen#10;Militia#30;FootArcher#20;LightCavalry#1000;HeavyCavalry#120
Militia#10;Spearmen#10;FootArcher#1000;LightCavalry#120;CavalryArcher#100
```

## Output

- Returns optimal arrangement if winning is possible
- Returns "There is no chance of winning" if no winning arrangement exists

## Unit Classes
Militia, Spearmen, LightCavalry, HeavyCavalry, FootArcher, CavalryArcher