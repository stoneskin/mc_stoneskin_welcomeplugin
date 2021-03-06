# My Welcome Message plugin for bukkit/spigot Minecraft server

## Feature

I wrote the plugin because I can't find a simple welcome message plugin that support line break.

- Split the msg into multiple lines with any splitter

![screenshot](./screenshot.jpg)

- Could display the welcome message, and Op could reload the config 
  
  - `/welcome` to display the welcome message
  - `/welcome reload` to reload the welcome message, (need op)

- support 1.16.1, 1.15.x and lower version.
- support multiple message sections
- support delay display message sections.
  
------

## example of config.yml

config.yml could be find in `\plugins\welcome_plugin\`

```yml
#config.yml
welcome:
    message: '&5Welcome, &r&2%p&r&5 to the Minecraft server! \n Enjoy~~'
    messages:
        - '&3 section1'
        - '&6 section2\ content....'
    linebreak: '\\n'
    delay: 2
```

for message color and format check [Minecraft Formatting code](https://minecraft.gamepedia.com/Formatting_codes).

**todo:** will support multiple line saved in array.

------

## Installation

Download the plugin jar file and put in the plugins folder,
After the first run, you will see the \welcome_plugin\ folder in the plugins
you could update the config.yml to change the welcome message.

------

## Release
- [2020-07-11] *Release 1.0.2* [downlaod welcome_plugin-1.0.2.jar](https://www.spigotmc.org/resources/welcome-message-plugin-support-multiple-lines.81206/download?version=343643)
- [2020-07-10] *Release 1.0.1* [download welcome_plugin-1.0.1.jar](./release/welcome_plugin-1.0.1.jar)
- [2020-07-06] *Release 1.0* [download welcome_plugin-1.0.jar](./release/welcome_plugin-1.0.jar)

## Other download source

- download from [spigot](https://www.spigotmc.org/resources/welcome-message-plugin-support-multiple-lines.81206/)

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

```xml
    <repositories>
      <!-- This adds the Spigot Maven repository to the build -->
      <repository>
          <id>spigot-repo</id>
          <url>https://hub.spigotmc.org/nexus/content/repositories/snapshots/</url>
      </repository>
    </repositories>
```

 ```xml
    <dependency>
       <groupId>org.spigotmc</groupId>
       <artifactId>spigot-api</artifactId>
       <version>1.15.2-R0.1-SNAPSHOT</version>
       <!-- <version>1.16.1-R0.1-SNAPSHOT</version> -->
       <scope>provided</scope>
    </dependency>
 ```

### run command in the folder with pom.xml

`mvn package`
