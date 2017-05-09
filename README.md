# Anpharos
The repo for the final project of "Estructuras".


## Cloning
For cloning the repo the user must have git-lfs
[Install Git Lfs](https://help.github.com/articles/installing-git-large-file-storage/)


## Building
For compiling, run the following command from the project root:

### UNIX (Linux & MACOS)
```
javac -cp ".:anpharos/Processing/core.jar:anpharos/Processing/controlP5.jar" anpharos/app/Login.java
```


### Windows
```
javac -classpath ".;anpharos\Processing\core.jar;anpharos\Processing\controlP5.jar" anpharos\app\Login.java
```

## Usage
For running, use:

### UNIX
```
java -cp ".:anpharos/Processing/core.jar:anpharos/Processing/controlP5.jar" anpharos.app.Login
```

#### Windows
```
java -classpath ".;anpharos\Processing\core.jar;anpharos\Processing\controlP5.jar" anpharos.app.Login
```
