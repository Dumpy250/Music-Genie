# Music-Genie

Music-Genie is a small Java Swing desktop app for browsing and searching a simple song list.
It loads songs from `List.txt`, displays the full list, and lets you filter by band/artist,
genre, release date, and song name. Searches are case-insensitive and support partial matches.

The About dialog credits Cameron Basham and identifies the project as SENG 102 coursework.

## Features
- GUI built with Swing; no third-party library imports in the current source
- Reads data from a plain-text file (`List.txt`)
- Multi-field search: **all supplied criteria must match** (AND, not OR)
- Case-insensitive substring matching; release dates are searched as text, not date ranges
- Fixed genre dropdown; **Any** skips the genre filter
- Results shown in a modal dialog
- Empty fields with genre **Any** produce a prompt rather than a search; the main window already shows the full list

## Project structure
- `src/common` — data model and file reader
- `src/view` — Swing UI; entry point: `view.MusicGenie`
- `src/resources/lamp.png` — icon loaded as `/resources/lamp.png` from the classpath
- `List.txt` — sample song data, read from the process's working directory
- `Music-Genie.iml` and `.idea/` — IntelliJ project metadata; no Maven or Gradle build is supplied

## Requirements
- A JDK with `javac`, `java` and desktop Swing/AWT support, plus a graphical desktop session.
- The checked-in IntelliJ configuration selects **JDK 24**. This is an IDE setting, **not a demonstrated minimum Java version** or a verified compatibility matrix.
- [JDK 24 has been superseded](https://jdk.java.net/24/). For ongoing use, prefer a maintained JDK distribution, such as a supported JDK 25 LTS build, with compatibility checked before adopting it. No JDK upgrade or build verification is implied by this guide; see the [Java support roadmap](https://www.oracle.com/java/technologies/java-se-support-roadmap.html).

## Build (from source)

These are **source-checked, unexecuted instructions**. Start in the repository root—the directory containing `List.txt` and `src/`. The commands use the ignored `out/classes` folder rather than relying on IntelliJ's generated directory layout.

### Windows PowerShell

```powershell
New-Item -ItemType Directory -Force -Path out/classes | Out-Null
javac -d out/classes (Get-ChildItem -Recurse -Filter *.java -Path src).FullName
```

Only after compilation succeeds, copy the icon:

```powershell
New-Item -ItemType Directory -Force -Path out/classes/resources | Out-Null
Copy-Item -Force src/resources/lamp.png out/classes/resources/lamp.png
```

### macOS / Linux shell

```sh
mkdir -p out/classes
javac -d out/classes src/common/*.java src/view/*.java
```

Only after compilation succeeds:

```sh
mkdir -p out/classes/resources
cp src/resources/lamp.png out/classes/resources/lamp.png
```

## Run (compiled classes)

Stay in the repository root and use the same JDK used for compilation:

```sh
java -cp out/classes view.MusicGenie
```

`-cp` locates the compiled packages and copied icon; it does **not** change where `List.txt` is read. Missing data is reported to the console, and a missing icon can prevent the window from opening. If using IntelliJ instead, set its run working directory to the repository root and ensure the output contains `resources/lamp.png`; `out/production/Music-Genie` is an IDE convention, not a requirement of the application.

## Data format

The reader consumes four whitespace-separated tokens per song, in this order:

```text
band_or_artist genre release_date song_name
```

This is a format illustration, **not a header to add**. For example, the supplied file contains:

```text
Queen Rock 1975 Bohemian
```

Despite wording in the GUI, this is not a CSV parser: there is no quoted-field or embedded-space handling. Keep each field to one token. The parser does not skip a header, remove duplicates, or validate dates; the header-like first row and repeated songs in the sample file are treated as ordinary entries. Incomplete records can stop loading with an uncaught parsing error.

## Notes
- This is a song-metadata browser, not an audio player, streaming client or recommendation engine.
- The **Edit → Source** menu has no implemented editing action; there is no GUI save/import workflow.
- The genre dropdown is hard-coded, not derived from the file, and text inputs are not trimmed automatically.
- `out/` is ignored build output and should not be committed. No automated tests or verified build/run results are supplied with this documentation pass.
