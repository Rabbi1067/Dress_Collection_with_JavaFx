
# Dress Collection with JavaFX

![Java](https://img.shields.io/badge/Java-17-blue?logo=java)
![JavaFX](https://img.shields.io/badge/JavaFX-17-lightblue)
![License](https://img.shields.io/badge/License-MIT-green)

---

## Table of Contents
- [Overview](#overview)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Installation & Setup](#installation--setup)
- [How It Works](#how-it-works)
- [Project Structure](#project-structure)
- [Contributing](#contributing)
- [License](#license)

---

## Overview
**Dress Collection** is a JavaFX-based desktop application for managing dress inventories. Users can efficiently add, update, delete, and view dresses with details such as name, color, size, price, and other relevant information.  

The project demonstrates the use of **JavaFX for GUI**, **file-based data storage**, and clean application design in Java.

---

## Features
- Add new dress entries with full details.
- Update or edit existing dresses.
- Delete dresses from the collection.
- View all dresses in a tabular format.
- Persistent storage using a text file (`dress.txt`).
- Interactive and user-friendly JavaFX interface.

---

## Technologies Used
- **Java 17** – Core language
- **JavaFX** – GUI framework
- **FXML** – UI layout design
- **Maven** – Build and dependency management
- **RandomAccessFile / Text Files** – For storing dress information

---

## Installation & Setup

1. **Clone the repository**
git clone https://github.com/Rabbi1067/Dress_Collection_with_JavaFx.git
cd Dress_Collection_with_JavaFx
Build the project using Maven

bash
Copy code
mvn clean install
Run the JavaFX application

bash
Copy code
mvn javafx:run
How It Works
Launch the application to view the list of dresses.

Click Add to insert a new dress entry.

Select a dress to Update or Delete it.

All changes are saved automatically in dress.txt.

FXML files separate the UI from the application logic for maintainability.

Project Structure
Dress_Collection_with_JavaFx/
├── src/
│   └── main/
│       ├── java/
│       │   └── [Controllers, Models, Main Application]
│       └── resources/
│           └── [FXML files for UI layout]
├── target/           # Compiled classes and build files
├── dress.txt         # Stores dress data
├── pom.xml           # Maven configuration
└── README.md
