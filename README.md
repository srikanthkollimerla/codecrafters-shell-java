# Build Your Own Shell 🖥️  

This repository contains my implementation of a **custom shell**, built as part of the Codecrafters challenge. The shell is written in **Java** and includes support for various built-in commands and features.  

## Features Implemented 🚀  

- **REPL (Read-Eval-Print Loop)** – Interactive command-line processing  
- **Built-in Commands:**  
  - `echo` – Prints text to standard output  
  - `exit` – Terminates the shell  
  - `type` – Identifies whether a command is a built-in function or an executable  
  - `pwd` – Prints the current working directory  
  - `cd` – Changes the current directory  
    - Supports **absolute paths** (e.g., `/usr/local/bin`)  
    - Supports **relative paths** (e.g., `./`, `../`, `./dir`)  
    - Supports `~` for **home directory**  
- **Executing External Programs with Arguments** (e.g., `ls -la`, `cat file.txt`)  
- **Support for Quoting with Single Quotes ('')** to preserve spaces  

# Future Enhancements 🔧

- Add support for double quotes ("")
- Implement environment variable expansion (e.g., $HOME, $PATH)
- Improve error handling and edge case handling

# Acknowledgments 🎯
Codecrafters' Build Your Own Shell challenge.
