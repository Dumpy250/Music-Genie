# Music-Genie

Music-Genie is a small Java Swing desktop app for browsing and searching a simple song list.
It loads songs from `List.txt`, displays the full list, and lets you filter by band/artist,
genre, release date, and song name. Searches are case-insensitive and support partial matches.

## Features
- GUI built with Swing
- Reads data from a plain-text file (`List.txt`)
- Multi-field search (band/artist, genre, release date, song name)
- Case-insensitive, partial-match search
- Results shown in a modal dialog

## Project structure
- `src/common` — data model and file reader
- `src/view` — Swing UI
- `src/resources` — app resources (icon)
- `List.txt` — sample song data

## Run (compiled classes)
If you already compiled the project to `out/production/Music-Genie`:
```powershell
java -cp out\production\Music-Genie view.MusicGenie
```

## Build (from source)
```powershell
cd C:\Users\Camer\IdeaProjects\Music-Genie
```

```powershell
javac -d out\production\Music-Genie (Get-ChildItem -Recurse -Filter *.java -Path src).FullName
```

```powershell
New-Item -ItemType Directory -Force -Path out\production\Music-Genie\resources | Out-Null
Copy-Item -Force src\resources\lamp.png out\production\Music-Genie\resources\lamp.png
```

```powershell
java -cp out\production\Music-Genie view.MusicGenie
```

## Notes
- This project uses IntelliJ output conventions (`out/production/...`).
- The `out/` directory is build output and should not be committed.
