## Course Website 
 - https://www.dukelearntoprogram.com//


## Week 2

- `while` loop: When number of iteration is not known
- Example: `ATG` and `TAA`

#### Algo
1. I found the first occurrence of `ATG`
2. I found the `TAA` after the `ATG`
3. I checked if the distance between them was a multiple of 3
4. It wasn't, so I found the next `TAA`
5. I checked if the distance between them was a multiple of 3
6. It was, so everything between them was my number

- How many times we need to check the last `TAA` ?
  - use `while` loop here.

#### Generalized

---
#### Finding a gene using while loop 

`A T G A T C G C T A A  T  G  C  T  T  A  A  G  C  T  A  T  G`
`0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 `

1. I found the first occurrence of "ATG" (it was at index 0) --> `startIndex`
2. I found the "TAA" after the "ATG" started at index 3 --> `startIndex` + 3, (it was at 8) --> `currIndex` 
3. I checked if the distance between --> (`currIndex` - `startIndex`) them was a multiple of 3
4. It wasn't, so I found that next "TAA" started at 9 -->(`currIndex` + 1) (it was at 15) --> `currIndex`
5. I checked if the distance between --> (`currIndex` - `startIndex`) them was multiple of 3
6. It was, so everything between them was my answer --> `startIndex` + `currIndex` + 3 is the answer

#### Generalize

1. I found the first occurrence of "ATG"  `startIndex`
2. If `startIndex` is -1, then your answer is the empty string.  
---
##### Split the method into two method, as there can be three stop codon `TAA`,`TGA`,`TAG` 
##### Find stop codon method
3. Find the `TAA` starting from (`startIndex +3`), call this result `currIndex`
4. As long as `currIndex` is not equal to -1
   5. check if (`currIndex - startIndex`) is a multiple of 3
      6. if so, the text between startIndex and currIndex + 3 is your answer
      7. if not, update currIndex to the index of the next "TAA", starting (`currIndex + 1`)
8. Your answer is the empty string 
---
3. findStopCodon(dnaStr, startIndex, "TAA") and call the result taaIndex
4. findStopCodon(dnaStr, startIndex, "TAG") and call the result tagIndex
5. findStopCodon(dnaStr. startIndex, "TGA") and call the result tgaIndex
6. Take the smallest of taaIndex, tagIndex, tgaIndex: Call in minIndex
7. Your answer is the text from startIndex to minIndex+3

---

#### Seprartion of Concerns

## Iterating over all genes 
1. Set startIndex to 0 
2. Repeat the following steps
   3. Find the next gene after startIndex 
   4. If no gene was found, leave this loop 
   5. Print that gene out -----> DO SOMETHING WITH THAT GENE
   6. Set startIndex to just pass the end of the gene.
   
- What kind of "something" ?
- Check condition before printing
- Count? (maybe with some condition)?
- Save to file?
- Build web page with them ?

## At high level our algorithm does two things:

1. Get all the genes from source of data.
2. Process all the genes.

- We can achieve this introducing a  storage [List] - Something that can hold all the genes, and all the 
  - operations can be performed using the storage[List]. 

### Null in Java

1. Meaning nothing or no object 
2. CSVRecord LargestSoFar = null; - This is how you initialize a variable.
3. return null; - No such answer exist. 
4. if(largestSoFar == null)
5. NullPointerException 
6. Special Null Type
   7. Literal null has this type 
   8. Can be converted to any object type
- Primitive Types - Cannot be null 
  - What are primitive type?
    - int, double, char and boolean
    - byte, short, long, float

- Object Types: Can be null 
  - FileResource, String, CSVRecord, Pixel
  - Anything with methods
  - Any class you write is also an object type. 