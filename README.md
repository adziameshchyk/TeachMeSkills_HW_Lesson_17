# Regular Expression
>This repository was created for homework in lessons №16 - "Regular Expression".
## Tasks

### Mandatory task:  
0. The program receives the path to the folder as input (set via the console).  
    The specified folder contains text files (txt format).  
    Each file contains arbitrary text. This text may contain a document number (one or more), email and phone number.  
    document number in the format: xxxx-yyy-xxxx-yyy-xyxy, where x is any number, and y is any letter of the Russian or Latin alphabet  
    phone number in the format: +(ХХ)ХХХХХХХ

   The document may not contain all the information, i.e. for example, may not contain a phone number, or other field.  
    It is necessary to extract information from N text documents. The number of documents for processing N is set from the console.  
    If the folder contains fewer documents than the specified number, all documents should be processed.  
    The extracted information must be saved in the following data structure:

           Map<String, Document>, where  
        key of type String is the name of the document without extension,  
        value of type Document - a custom class object whose fields contain information extracted from a text document

   
    Consider the output of messages in cases where,
    - let the input be sent to a folder in which there are no files
    - all files have an inappropriate format (only TXT files should be processed)
    - also messages in case of other exceptional situations
  
   At the end of the program, a message should be displayed indicating how many documents were processed and how many documents were in invalid format.


