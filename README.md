# MyGraphQL
## Kotlin GitHub GraphQL API App

This Kotlin app uses the GitHub GraphQL API to fetch and display a list of max 50 repositories with their names and the number of stars. The search query is statically defined in the code.

The app has a loading state, error state, and loaded repositories state. It also includes unit and UI tests. 

> [!NOTE]
GITHUB TOKEN needs to be added in gradle.properties

GITHUB_TOKEN=XXXXXXXXXXXXXXXXXXXX

### Architecture

The app uses the following architecture - MVVM/MVI.

* **Networking:** Package for communicating with the GitHub GraphQL API via Apollo Kotlin client
* **UI:** Package for rendering the data in the UI using Jetpack Compose.
* **Domain:** Package for modeling the data from the API.

### Features

* **Search:** The app allows you to search for repositories based on static query. The search query is defined in the code. Max 50 results are returned with repo name and number of users who starred the given repository.
* **List:** The app displays a list of the names and number of stars of the first 50 repositories that match the search query.
* **Status:** The app displays the current status, such as "Loading", "Error", or "Loaded".

### Technology stack

* Kotlin
* Apollo-Kotlin
* Coroutines
* Compose
* Unit testing with JUnit 4 and Turbine
* UI testing with Espresso

### Benefits

* Easy to use: The app has a simple and intuitive UI.
* Efficient: The app uses Apollo-Kotlin to fetch data from the GitHub GraphQL API efficiently.
* Robust: The app includes unit and UI tests to ensure its quality.
* Fulfills requirements: The app meets all of the requirements specified by the description, such as the ability to find interesting and well-established repositories to work on.

### Use cases

The app can be used by developers to:

* Discover new and interesting repositories to work on.
* Track the popularity of their own repositories.
* Learn about the latest trends in the software development community.

### Screenshots TBA

[Screenshot of the main view](./screenshot.png)

### Installation

To install the app, add 
> [!NOTE]
GITHUB TOKEN needs to be added in gradle.properties

GITHUB_TOKEN=XXXXXXXXXXXXXXXXXXXX

