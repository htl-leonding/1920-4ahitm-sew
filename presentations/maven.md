# Maven

## Build-Prozess

.java --> compile mit javac --> .class-File --> package --> .jar

### Build-Tools

- make: für C / C++
- Ant: kein automatischer Download der Libraries (Dependencies); IDE-spezifisch (kein Standard für die Ant-Tasks)
  - durch hinzufügen von Ivy können auch mit Ant die Dependencies automatisch downloaded werden
- maven: automatischen Download der Libraries (durch Eintragen in pom.xml); maven ist standardisiert, daher kann ein maven-Projekt auf allen IDEs geöffnet werden
  - Nachteil: sehr strikt (starre Struktur)
  - Abhilfe: gradle
- gradle: verwendet für die Dependencies maven. Ist allerdings in seiner Struktur flexibler. Kann in groovy konfiguriert werden.


### Libraries

Die Libraries werden von maven im home-Verzeichnis des Users im Verzeichnis .m2 gespeichert. Dadurch wird sichergestellt, dass eine Library nur beim ersten Projekt downgeloaded werden muss. Bei allen weiteren wird die lokale Kopie verwendet.


### Weitere Funktionalität

Maven kann durch Plugins erweitert werden (zB zum Starten von Servern) oder Paketieren von speziellen Archiven (zB war, ear, ...)

### Commands

```
mvn clean compile
```

