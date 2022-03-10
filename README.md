# namesorter
java name sorter

# Use
Clone the repository 

Run the program and provide the console an absolute or relative path to a file (e.g. <filename>.<extension>, ./<filename>.<extension>, ~/docs/<filename>.<extension>).

The file must consist of names in the format "Last Name, First Name\n"

The console will print the names alphabetically to the console, as well as to a file named <filename>-sorted.<extension> in the present directory.

# Structure
The launcher will generate a UI handler that contains a console. 

Text is taken in through this console and displayed back out through it as well.

Once a valid filename is received, it is passed to a file handler which opens the file and reads text from it into an arraylist.

The arraylist is accessed by the launcher and sent to the name sorter, where it is sorted. 

The sorted list is taken by the launcher and passed to the file handler to be written. The launcher will also pass the sorted list to the ui handler for display.

Finally, the launcher will take the output path for the file and pass it to the ui handler for completion display.

Logging and errors are handled in the launcher primarily beacuse that's how I've done it in Go so far -- happy to learn new paradigms.