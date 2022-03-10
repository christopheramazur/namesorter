# namesorter
java name sorter

# Use
Clone the repository and run java -jar NameSorter.jar

A prompt should appear in your console, or a console should be provided if the .jar was run through another method.

Provide the console an absolute or relative path to a file (e.g. "filename.extension", "./filename.extension", "~/docs/filename.extension", etc.).
- The file must consist of names in the format "Last Name, First Name\n"

The console will print the names alphabetically to the console, as well as to a file named "filename-sorted.extension" in the present directory.

The console will display any errors that you have encountered, as well as the completion status.

The program will exit. 

# Testing
My apologies, I haven't used Java's testing before and between Maven and JUnit was not able to get tests running in time.

Ideal tests for this program would be:
- Validating filename input is handled or excepted
- Validating data format is handled or excepted
- Validating null data and empty lists are handled or excepted
- Validating program exits on completion or exception

# Future work
- Decoupling fullname creation from sorting
- Looping main flow and expanding intake to accept multiple files
- Accepting and parsing args for e.g. filters, aggregations, export formats