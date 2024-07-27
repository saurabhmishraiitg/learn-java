# Java Logging : SLF4J

SLF4J is basically an abstraction layer. It is not a logging implementation. It means that if you're writing a library and you use SLF4J, you can give that library to someone else to use and they can choose which logging implementation to use with SLF4J e.g. log4j or the Java logging API. It helps prevent projects from being dependent on lots of logging APIs just because they use libraries that are dependent on them.

From <http://programmers.stackexchange.com/questions/108683/slf4j-vs-log4j-which-one-to-prefer>
SLF4j can be configured to use log4j as a logging backend so they can work together. However a quite closely related project is logback (<http://logback.qos.ch/>). Logback is a replacement for Log4j: it is a logging framework (as Log4j) but it uses natively the SLF4j API.
SLF4j has some useful companion JAR files which can be used to make other logging API delegate to the SLF4j API : jcl-over-slf4j (replacement API compatible with commons logging), jul-to-slf4j (for java.util.logging), log4j-over-slf4j (API compatible with log4j). Using those you can have a lot of logging API talk forward to SLF4j (useful for third-party JARs) so that you have a single logging framework handling all logs.

- [Java Logging : SLF4J](#java-logging--slf4j)
  - [Strengths of SLF4J](#strengths-of-slf4j)

## Strengths of SLF4J

- Help with saving performance hit due to String concatenation

```java
   if (logger.isDebugEnabled()) { logger.debug("Processing trade with id: " + id + " symbol: " + symbol); }

   logger.debug("Processing trade with id: {} and symbol : {} ", id, symbol);
```

From <http://javarevisited.blogspot.com/2013/08/why-use-sl4j-over-log4j-for-logging-in.html>

- How to use

```java
   org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(HelloWorld.class);
```

From <http://baptiste-wicht.com/posts/2010/02/logging-with-slf4j.html>

- Marker API

The Marker allow essentially to associate tags to logs. This tags enable the different appenders to take only some logs. Lets imagine an appender who write the log using encryption and that must only be used on logs marked as confidential. The Marker enable us to implement that.

This functionally is only available with the LogBack implementation : it's the only who implements the Marker. Nevertheless, you could use the Marker API with the other implementation, but that will have no effect.

From <http://baptiste-wicht.com/posts/2010/02/logging-with-slf4j.html>

- Mapped Diagnostic Context

The "Mapped Diagnostic Context" (MDC) is, in summary, a simple map (key-value set) maintained by the logging framework. In that map, the application can put some key-value couple that could be used to add some information in the logs.

Imagine that we treat information on persons and that we display in logging. The name and the first name of the person must be displayed in each lines of logging. We could can use MDC to automate the include of the name and the first name in the logs.

From <http://baptiste-wicht.com/posts/2010/02/logging-with-slf4j.html>
