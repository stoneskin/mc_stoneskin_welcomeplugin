# My Wecome plugin for bukkit/spigot mincraft server

## Feature

I wrote the plugin because I can't find a simple welcome message plugin that support line break.

- Split the msg into multiple lines with any spliter 

![screenshot](./screenshot.jpg)

------

## example of config.yml

config.yml could be find in `\plugins\welcome_plugin\`

```yml
#config.yml
welcome:
    message: '&5Welcome, &r&2%p&r&5 to the &bMC &5server!\n
&6*** Server Rules ***\n
&f 1. No Griefing!\n
&f 2. No repeat command blocks!\n
&l&eObey the rule and &aEnjoy&e or you will be &cbanned&e.'

    linebreak: '\\n'
```

for message color and format check [Minecraft Formatting code](https://minecraft.gamepedia.com/Formatting_codes).

------

## Release

[2020-07-06] *Release 1.0* [download welcome_plugin-1.0.jar](./release/welcome_plugin-1.0.jar)

------

## Build the project

### Install Maven

for how to use Maven please read Maven in 5 min:
<http://maven.apache.org/guides/getting-started/maven-in-five-minutes.html>

### Set Maven path

`set PATH=%PATH%;C:\tools\apache-maven-3.6.3\bin`

### Download the [spigot.jar](./lib/spigot-1.15.2.jar) and add to dependency

option 1. save to lib folder and add to pow.html dependency

   ```xml
    <dependency>
         <groupId>spigot</groupId>
         <artifactId>spigot</artifactId>
         <scope>system</scope>
         <version>1.0</version>
         <systemPath>${basedir}\lib\spigot-1.15.2.jar</systemPath>
    </dependency>
   ```

option 2. import to maven repository
check [import-jars](http://maven.apache.org/general.html#importing-jars)

### run command in the folder with pom.xml

`mvn package`
