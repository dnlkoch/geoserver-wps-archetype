# geoserver-wps-archetype

A Maven archetype for implementing custom WPS-processes for GeoServer (see
http://docs.geoserver.org/stable/en/developer/programming-guide/wps-services/index.html).

[![Build Status](https://travis-ci.org/marcjansen/geoserver-wps-archetype.png)](https://travis-ci.org/marcjansen/geoserver-wps-archetype)

## Quickstart

Checkout the archetype:
```
git clone https://github.com/marcjansen/geoserver-wps-archetype.git
```

Enter the archetype directory:
```
cd geoserver-wps-archetype/archetype/
```

Install the archetype to your local maven repository:
```
mvn install
```

Enter your workspace directory:
```
cd {YOUR_WORKSPACE_DIR}
```

Use the archetype to create your WPS project in interactive mode:
```
mvn archetype:generate \
-DarchetypeGroupId=de.terrestris.geoserver.wps \
-DarchetypeArtifactId=geoserver-wps-archetype \
-DarchetypeVersion=0.1-SNAPSHOT
```

You will have to enter a `groupId`, `artifactId`, `version` and a (Java-)`package` for your Maven-Geoserver-WPS-project. You also have to provide a `geoserver-version`, `geotools-version` and `wps-project-name` that will also be used in `pom.xml` of the WPS project you are about to create.

Confirm your configuration with `Y`.

If you want to speed up this process, use something like this:

```
mvn archetype:generate \
-DarchetypeGroupId=de.terrestris.geoserver.wps \
-DarchetypeArtifactId=geoserver-wps-archetype \
-DarchetypeVersion=0.1-SNAPSHOT \
-DgroupId=de.terrestris.geoserver.wps \
-DartifactId=wps-examples \
-Dversion=1.0-SNAPSHOT \
-Dpackage=de.terrestris.geoserver.wps.example \
-Dgeoserver-version=2.6.2 \
-Dgeotools-version=12.2 \
-Dwps-project-name=Some\ WPS\ Project
```

Now enter the directory of the WPS project (which will have the name of the `artifactId` that was used in the step before):
```
cd wps-examples
```

Adapt the code for your needs and then build a `JAR`-File of your WPS:
```
mvn package
```

In the `target/`-subfolder you will find the `JAR`-File that has to be deployed in the `WEB-INF/lib/` folder of your GeoServer.

Good luck!
