# DentHub

ISPW 2026-27 project, Tor Vergata University of Rome.

## Build and run

Requirements: JDK 21. Maven comes with the wrapper (`./mvnw`), no install needed.

```sh
./mvnw verify                                   # compile + tests
./mvnw javafx:run                               # JavaFX GUI, demo mode
./mvnw javafx:run -Djavafx.args="cli file"      # any interface (gui|cli) + persistence (demo|file|db)
```

In IntelliJ IDEA open this folder as a Maven project: the run configurations in `.run/` (DentHub GUI/CLI x demo/file/db, All tests) appear automatically.

## Layout

| Package (`it.uniroma2.denthub`) | Content |
|---|---|
| `view.javafx`, `view.cli` | the two interfaces and their graphic controllers (FXML in `src/main/resources`) |
| `bean` | data between graphic and application controllers, syntax checks only |
| `controller` | application controllers, one method per internal step of the use case |
| `model` | domain entities |
| `dao` (+ `db`, `file`, `memory`) | DAO interfaces and implementations on MariaDB, file system, demo in RAM |
| `exception` | application exceptions |
| `config` | startup options (interface and persistence mode) |

## Quality

Analysed on [SonarQube Cloud](https://sonarcloud.io/project/overview?id=GliAcopo_DentHub) (Automatic Analysis, profile "Sonar way comprehensive"). `.sonarlint/connectedMode.json` binds SonarQube for IDE to that project.
