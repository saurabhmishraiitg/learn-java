# Nexus Java Archetype (Module)

- Sample command to leverage the archetype

```bash
mvn archetype:generate -DarchetypeGroupId=org.nexus \
-DarchetypeArtifactId=nexus-java-archetype -DarchetypeVersion=0.0.2-SNAPSHOT \
-DgroupId=org.nexus -DartifactId=hdfs-utils \
-Dversion=0.0.1-SNAPSHOT
```

## TODOs

- [x] Update archetype to include a README.md file
- [x] Add logger package import
- [x] Add junit test import
- [x] Include resource directory
- [x] Include log4j2.xml file
