Spotify Snap


## General info
This is the v0.1.0 release.

## Authors
Wendall Roberts 

Merghani Hag Elnour

Eyvn King

Gerardo Garcia

## Main Entrypoints

## Technologies
Project is created with:
* Java: 16.0.0
* junit-jupiter: 5.8.0
* junit-jupiter-params: 5.8.0
* org.openjfx.javafxplugin: 0.07
* junit: 5.8
* json-path: 2.6.0

## Features
Enter an artist name and return very basic info via the command line


## Setup
Current entry point is Main.java. It is recommended to run this in intellij Idea and right click run on Main.

## Known Errors
Requires entering of a client id and secret as password hiding is not quite ready thus making this project more for developrs
and very enthusiastic power users

The following messages still appear in the compiler due to gradle settings
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.


##Credit
* got code for retrieving access token from API, and other functions from dargmuesli
* dargmuesli GitHub Repository: https://github.com/spotify-web-api-java/spotify-web-api-java
