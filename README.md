[🇧🇷️](README-PTBR.md)

# Bootcamp Management System

## Table of Contents
- [Project Description](#project-description)
- [Technologies Used](#technologies-used)
- [Project Structure](#project-structure)
- [Implemented Features](#implemented-features)
- [Running the Project](#running-the-project)
- [Author](#author)
- [License](#license)


## Project Description

This project implements a bootcamp management system for developers, allowing enrollment of developers in bootcamps,
management of their progress through content, and calculation of total XP earned. It uses simple graphical interfaces
for user interaction.

## Technologies Used

- Java
- Lombok
- Swing (for GUI)
- IDE: IntelliJ IDEA

## Project Structure

The project is structured as follows:

- **Main Package (`com.bootcamp`):**
    - `domain`: Contains domain classes such as `Bootcamp`, `Content`, `Dev`, etc.
    - `service`: Contains `BootcampService` class for managing operations related to bootcamps and developers.
    - `util`: Contains `JOptionPaneUtil` class to facilitate interaction with JOptionPane.

## Implemented Features

1. **Class `Bootcamp`:**
    - Allows adding content and developers to a bootcamp.
    - Methods to get contents and developers from a bootcamp.

2. **Class `Dev`:**
    - Allows enrolling a developer in a bootcamp.
    - Method to progress through bootcamp contents.
    - Method to calculate total XP based on completed contents.

3. **Class `BootcampService`:**
    - Manages bootcamp addition.
    - Enrolls developers in bootcamps.
    - Controls developers' progress through contents.
    - Displays contents enrolled and completed by a developer.

4. **Graphical Interface (`JOptionPaneUtil`):**
    - Uses JOptionPane to select date and time.

## Running the Project

To run the project, import it into your IDE (such as IntelliJ IDEA) and execute the `BootcampApplication` class.

## Author

Developed by Lucas Santos

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
