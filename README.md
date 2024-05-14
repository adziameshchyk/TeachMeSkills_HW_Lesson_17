# Basics of working with xml and json
>This repository was created for homework in lessons №17 - "Basics of working with xml and json".
## Tasks

### Mandatory task:  
0. Write a program to parse xml document.  

   The program receives as input a string to the folder where the document is located.
   You only need to parse one document - accordingly, provide various checks, for example, that there are no files in the folder, or that there are several xml documents in the folder and other possible checks.

   It is necessary to parse the xml document and write the contents of the line tags into another document.
   The file name for the entry must consist of tag values ​​and look like: <firstName>_<lastName>_<title>.txt

   

### Extra credit task:  
Additionally implement the following functionality:
 
    -if the value 1 is entered in the properties file - parse the document using SAX  
    -if the value 2 is entered in the properties file - parse the document using DOM
   
***

## XML document for parsing: 
```xml

<?xml version="1.0"?>
<sonnet type="Shakespearean">
  <author>
    <lastName>Shakespeare</lastName>
    <firstName>William</firstName>
    <nationality>British</nationality>
    <yearOfBirth>1564</yearOfBirth>
    <yearOfDeath>1616</yearOfDeath>
  </author>
  <title>Sonnet 130</title>
  <lines>
    <line>My mistress' eyes are nothing like the sun,</line>
    <line>Coral is far more red than her lips red.</line>
    <line>If snow be white, why then her breasts are dun,</line>
    <line>If hairs be wires, black wires grow on her head.</line>
    <line>I have seen roses damasked, red and white,</line>
    <line>But no such roses see I in her cheeks.</line>
    <line>And in some perfumes is there more delight</line>
    <line>Than in the breath that from my mistress reeks.</line>
    <line>I love to hear her speak, yet well I know</line>
    <line>That music hath a far more pleasing sound.</line>
    <line>I grant I never saw a goddess go,</line>
    <line>My mistress when she walks, treads on the ground.</line>
    <line>And yet, by Heaven, I think my love as rare</line>
    <line>As any she belied with false compare.</line>
  </lines>
</sonnet>

```
     
