<h1 align="center">🧮 The good and old spends control 🧮</h1>

<h1 align="center">
 <img src="https://img.shields.io/badge/Usability-Easy-brightgreen">
 <img src="https://img.shields.io/badge/Database-Local-orange">
 <img src="https://img.shields.io/badge/Exportable-CSV-blue">
 <img src="https://img.shields.io/badge/Charset-UTF8-purple">
</h1>

<p align="center">This project has been made for a work in the Computer Science course (Programming Language III) in the University (Universidade Regional Integral do Alto Uruguai e das Missões), from Santo Ângelo RS.</p>

## Summary
* [About](#ℹ%EF%B8%8F-about)
* [Screenshots](#%EF%B8%8F-screenshots)
* [Features](#-features)
* [Technologies](#%EF%B8%8F-technologies-involved)
* [Platforms](#%EF%B8%8F-platforms)
* [Database Management](#-database-management)
* [Requirements to Run](#%EF%B8%8F-requirements-to-run)

### ℹ️ About
This is a basic project made to control and map, where the user's money is coming from or going to.

### 🖼️ Screenshots
<h1 align="center">
 <img height="500" src="src/assets/screenshots/login-sip.png">
 <img height="500" src="src/assets/screenshots/main-sip.png">
 <img height="500" src="src/assets/screenshots/newreg-sip.png">
 <img height="500" src="src/assets/screenshots/filter-sip.png">
</h1>

### 🥏 Features
* You can use it offline, once the database is locally stored in .txt files
* Users can create different accounts for different purpouses
* Users can add/edit/remove every register in their account
* Users can search and map their spents by filtering the registers
  * Every time the registers table changes, the total value refreshes
* When user deletes himself, the same happens with all his registers, so, be warned
* Data exportable to csv file, so you can use this data with other softwares like Excel, MySQL...

### ⚙️ Technologies involved
* [Java](https://www.java.com/pt_BR/) ☕

### 💾 Database management
* There are two classes wich manages these files, BD_Registros and BD_Usuarios
  * BD_Registros is responsible for *R/W* of the registers file
  * BD_Usuarios is responsible for *R/W* of the users file

### 🖥️ Platforms
* PC only 🖥️

### ☑️ Requirements to Run
* Need to have installed the [Java Runtime Environment](https://www.java.com/pt_BR/download/) in your machine
* Need to have the db_users.txt and db_registers.txt **exclusively** on root path of the .jar executable file

