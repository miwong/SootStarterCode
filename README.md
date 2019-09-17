# Starter code for Android application analysis using Soot.

This provides a very basic template to analyze an APK.  The APK file should be passed in as the first command line argument.

Gradle is used to build the application.  A wrapper script is provided that should download all of the dependencies.

To build:

    ./gradlew build
  
To run (with a helper script that calls `./gradlew run`:

    ./RunSootTutorial <APK file>
    

