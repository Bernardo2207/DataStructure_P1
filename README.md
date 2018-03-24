# DataStructure_P1
**Strategies of Intersections Project:**

This project's purpose is to determine the efficiency of intersections in different sized sets. 
To look for these interesctions different data structure implementations where made.
  1. ArrayList
  2. HashMaps
  3. Sets
  
**How to execute the intersection search in the sets?**
 You must type in the terminal the following: "java -classpath ./bin p1MainClasses/Part1Main".
Put a number from 1-4 after Main, each number represents a different strategy to look for the intersections in the sets. 
**Strategy 1** is based in MySet1, wich implements the arrayList. **Stragtegy 2** is based in MySet2, which implements the hashMaps. 
**Strategy 3** also uses the hashMaps but while Strategy 2 has a complete set and its reducing it based on the condition , strategy 3 initialy has an empty set and 
in each steps its adding new elements.

Our second purpose is to prove in an empirical way the different strategies of the intersection search in different sets with the use of tables and charts.
**How to execute the empirical tests of these different strategies?**
just write the following **"java -classpath ./bin p1MainClasses/Part2Main n m isize fsize istep rep"**
these arguments have as a meaning:
1. **n** = number of companies
2. **m** = number of crime events
3. **isize** = initial size for experimentations
4. **fsize** = final size for experimentations
5. **istep** = increment of sizes
6. **rep** = number of repetitions for each size 
