# Directory Traversal

## Overview

A simple [Spring Shell](https://projects.spring.io/spring-shell/) application to demonstrate various directory traversal strategies.  The quick start guide executes a script to demostrate the various commands, but the shell is interactive and commands can be executed individually.

## Requirements

Java 8

## Quick Start

```
git clone https://github.com/dougbeasley/traversal.git
cd ssi-traversal
./gradlew
./build/install/ssi-traversal/bin/ssi-traversal

___________                                            .__   
\__    _______________ ___  __ ___________ __________  |  |  
  |    |  \_  __ \__  \\  \/ _/ __ \_  __ /  ___\__  \ |  |  
  |    |   |  | \// __ \\   /\  ___/|  | \\___ \ / __ \|  |__
  |____|   |__|  (____  /\_/  \___  |__| /____  (____  |____/
                      \/          \/          \/     \/      

Path Traversal
simple:breadth> script test.shell
```

## Command Reference

### Setting the traversal strategy type
`set type <breadth|depth>`

### Setting the output detail
`set detail <true|false>`

### Traversing the file systems
`traverse [path]`
defaults to the current directory

## Running Tests

`./gradlew test`

