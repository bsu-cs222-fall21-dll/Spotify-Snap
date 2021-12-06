Spotify Snap

This application is for users who are trying to pull live data about their favorite artists. 

## General info
This is the v0.3.0 release.

## Authors
Wendall Roberts 

Merghani Hag Elnour

Eyvn King

Gerardo Garcia

## Main Entrypoints
* Main.java: Run to use application with the command line.
* Two Options for GUI. Open the program with intellij and the build.gradle file can be used to select which desired GUI


## Technologies
Project is created with:
* Java: 16.0.0
* junit-jupiter: 5.8.0
* junit-jupiter-params: 5.8.0
* org.openjfx.javafxplugin: 0.07
* REST API (also known as RESTful API): 4.4.0
* junit: 5.8
* json-path: 2.6.0

## Features
* Enter an artist name and return very basic info via the command line
* Returns searched artists name, ID, URL, and total followers.
* GUI version of the previous features.

## Setup
To run this project, clone this repository, and download the dependencies and plugins listed in build.gradle. To select a GUI version use do one of the following
* Paste the following line into the program's build.gradle file to run one version of the gui
* mainClassName = 'view.gui.spotifySnapInterface'
* Or replace 'view.gui.spotifySnapInterface' with 'GUI'

## Known Errors

