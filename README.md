# Code bij OOSE-DEA oefentoets Semester 2 2022/2023

Deze repo bevat de code voor opgaven van de proeftoets voor DEA over de 1e 2 weken stof.

De code is voor aantal van de opgaven uit de oefentoets
- Java Streams/Lambda's: concatenatePairwise
- Multithreading: Parallele fizzbuzz.
- Patterns (Calculator)
- Code smells (Operator, InvalidOperationException)

De 1e 2 funtionaliteiten worden nu ook aangeroepen bij runnen van applicatie (`main()` methode). De overige zijn slechts code voorbeelden (dead code) voor theorievragen in de toets, ingevoegd om te kunnen checken dat deze wel compilen.

Hieronder een toelichting en beschrijving van mogelijke uitbreidingen van code (`fork me on GitHub, PR's welkom). Daaronder - zoals elke zichzelfrespecterende `README.md` betaamt- hoe je dit kunt runnen. Bijvoorbeeld als GitHub codespace, direct hier op GitHub.

## Analyse, mogelijke uitbreiding

Coolste feature (meeste) werk was om de multithreading volledig onder test te krijgen. NB: Dit zijn een acceptatie test, geen unit tests, zoals de DEA course zich op focust. Hiervoor zou het nodig zijn nog mocks te maken in om ook aparte lagen te testen. En die lagen indeling ook te maken. Hieronder uitwerken van mogelijke oefeningen.

### 1. Unit tests toevoegen, met mocks
De 1e kandidaat zou zijn het testen van de `ParrallelFizzBuzzer als` 'stand-alone' unit. Diens functionaliteit zit in het halen van input uit de geinjecte FizzBuzzCollecter, doorgeven naar Fizzbuzzer, en berekende output vervolgens weer opslaan. Verder extend deze klasse ook de `Runnable` interface om de gewenste parallele processing voor elkaar te krijgen (hoewel dit in plaats daarvan ook via een .toParallelStream() syntax zou moeten kunnen, bv. zelfs direct in de main).

### 2. Modularisatie/lagen

Alle bestanden staan nu bij elkaar, in een redelijk onmodulaire/gestructureerd aanpak. Dit blijft zo, i.v.m. 'luiheid' (of beter misschien KISS en/of YAGNI principe ;). Maar om uitbreidbaar te maken voor nog meer opgaves in deze zelfde repo/Java project, zou het beter zijn deze code te verdelen in packages per opgave. En daarna als er meerder bestanden zijn binnen zo'n hoofdpackages in 2 of meer layers, zoals 'presentation' en 'logic', om deze verder te structureren zoals we in latere theorieweek leren.

Deze indeling zou je 'folder-by-feature-by-type' kunnen noemen, een uitbreiding van 'folder-by-feature' van o.a. [John Papa](https://www.johnpapa.net/angular-growth-structure/), wat door Papa later ook in o.a. de Angular styleguide terechtkwam, voor schalen van grotere applicaties/codebases [Angular, z.d.](https://angular.io/guide/styleguide#folders-by-feature-structure)). Martin Fowler noemt dit in zijn artikel over pattern 'PresentationDomainDataLayering' (Fowler, 2015), zie figuur 1. De standaard 3-tier/layer architectuur die elke topmodule dan heeft noemt Fowler full-stack.

<img src="https://user-images.githubusercontent.com/3029472/223687473-b0dca56c-5488-4c20-83e0-aa929837df54.png" width="300">

*Figuur 1*: 'Make top level module full-stack' ([Fowler, 2015](https://martinfowler.com/bliki/PresentationDomainDataLayering.html))

#### Waarom three layer voor simpele Console applicatie?

De 'logic' layer spreekt vaak voor zich, maar wellicht roept voor en simpele Console applicatie als deze, de vraag op waarom andere lagen van toepassing zijn. Nou, je kunt de main (`App`) zien als Presentatie, omdat je hier command line argumenten naar toe kan sturen ('gebruikersinput'), en deze tekst naar de console print (output) ter controle voor gebruiker. Een 'data' layer is alleen van toepassing voor data opslag is simpele 'in memory' opslag in een List in `FizzBuzzCollector`. Je kan argumenteren dat je dit ooit zou willen uitbreiden naar persistant storage voor grootschalige lange termijn bepalen van bijvoorbeeld een miljard FizzBuzz waarden. Dit is een wat vergezocht scenario, maar ook de enige reden waarom je 'FizzBuzz' wil paralleliseren (naast natuurlijk als oefening in/illustratie van multithreading).

Vanwege tijdgebrek is dit nu als oefening aan de lezer/gebruiker gelaten (PR's welkom). Het mooist zou zijn een mooi package diagram te maken van de 'gewenste situatie'. Maar hier in ieder geval nog iets volledigere uitwerking van het layer ontwerp:

- nl.han.dea
  - App (presentation)
- nl.han.dea.lambda
  - nl.han.dea.lambda.presentation (App)
  - nl.han.dea.lambda.logic (StringHelpers.java)
- nl.han.dea.threading
  - nl.han.dea.threading.presentation (App, FizzBuzzPrinter)
  - nl.han.dea.lambda.logic (ParallelFizzBuzzer, Fizzbuzzer)
  - nl.han.dea.data (FizzBuzzCollector)
  - nl.han.dea.crosscuttingconcerncs (FizzBuzzCalculation (DTO klasse))
- nl.han.dea.codesmells (Calculator)
  - niet onderverdeeld

## Runnen en testen

Clone dit project en run in je favoriete IDE zoals IntelliJ. Of gebruik 'Run en Debug' in Visual Studio Code. Of run het direct als GitHub Codespace.

Om unit tests te draaien gebruik:
`mvn test`

Om code coverage rapporten te zien gebruik:
`mvn package`

De `JaCoCo` Maven dependency is aanwezig om **Ja**va **Co**de **Co**verage te bepalen. Ook raad ik de [VS Code Koverage extensie](https://marketplace.visualstudio.com/items?itemName=tenninebt.vscode-koverage) om coverage per folder en file te tonen in een nieuwe 'Testing' pane.

## Code runnen direct in GitHub Codespace

Je kunt deze code naast clonen en lokaal runnen in VS Code of IntelliJ Idea ook direct runnen op GitHub zelf. Namelijk via een GitHub code space. Zie hieronder een deel van de uitleg van de README van de originele `vs-code-remote-try-java` repository waar deze repo initieel een fork van was (klik [hier](https://github.com/microsoft/vscode-remote-try-java) voor de volledige README uit die repo).

[![Open in Dev Containers](https://img.shields.io/static/v1?label=Dev%20Containers&message=Open&color=blue&logo=visualstudiocode)](https://vscode.dev/redirect?url=vscode://ms-vscode-remote.remote-containers/cloneInVolume?url=https://github.com/microsoft/vscode-remote-try-java)

A **development container** is a running container with a well-defined tool/runtime stack and its prerequisites. You can try out development containers with **[GitHub Codespaces](https://github.com/features/codespaces)** or **[Visual Studio Code Dev Containers](https://aka.ms/vscode-remote/containers)**.

This is a sample project that lets you try out either option in a few easy steps. We have a variety of other [vscode-remote-try-*](https://github.com/search?q=org%3Amicrosoft+vscode-remote-try-&type=Repositories) sample projects, too.

> **Note:** If you already have a Codespace or dev container, you can jump to the [Things to try](#things-to-try) section.

## Setting up the development container

### GitHub Codespaces
Follow these steps to open this sample in a Codespace:
1. Click the **Code** drop-down menu.
2. Click on the **Codespaces** tab.
3. Click **Create codespace on main**.

For more info, check out the [GitHub documentation](https://docs.github.com/en/free-pro-team@latest/github/developing-online-with-codespaces/creating-a-codespace#creating-a-codespace).

