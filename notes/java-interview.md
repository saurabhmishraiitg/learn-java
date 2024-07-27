# Java Interview

- **Question** Explain about Exception Handling in Java.
  - What are different types of Exception
  - What are the subclasses of Throwable
  - What is the difference between Checked and Unchecked Exception
  - What is the difference between Checked and Runtime Exception
  - Give some example of Errors
- **Question** Explain about JVM (<https://anturis.com/blog/java-virtual-machine-the-essential-guide/>)
  - What are the component of JVM
  - What is function of ClassLoader, Execution Engine and HeapSpace
  - What are the types of HeapSpace
  - What is the difference between Heap and Non-Heap Space
  - What is the difference between Eden, Survivor and Tenured Pool
  - What is the difference between young and old generation
  - What is the difference between Method area (Permanent Generation) and Native area (Code Cache)
  - What does Xmx, Xms, Xmn, XX:NewRatio, Xss(ThreadStack Size)
  - What is a JIT Compiler? What is it's alternate (Interprator)
  - How does garbage collection work
  - What is the difference between major and minor garbage collection
- **Question** Explain about Inheritance, Polymorphism
- **Question** Explain about Design Patterns in Java
- **Question** What are different Collections in Java
- **Question** How does multi-threading work in Java
- **Question** What is the difference between user and daemon threads?
  - User threads are critical to program logic whereas daemon threads may be carrying out maintenance activities to assist user threads. Therefore when the main thread exists, it checks if there are any user threads still running. If no other user threads are active then the application will exit, irrespective of if any daemon thread is active or not
  - Hence, user thread prevent JVM from exiting if still active, daemon thread are ignored if no other user threads are active.
- **Question** What is new in JDK7 and JDK8
  - Java 7 has new multi-catch, Filesystem API (NIO 2), multi-catch, string in switch clause, better resource management (auto-close of resources in try-catch) etc.
  - Java 8 has brought along support of lambda expressions, streaming apis, Functional Interfaces (interface with exactly 1 abstract method) and ability to add default/static methods in interfaces
- **Question** What is the difference between Heap and Stack (<http://stackoverflow.com/questions/79923/what-and-where-are-the-stack-and-heap>)
- **Question** What is the difference between string object and literal? (<http://stackoverflow.com/questions/3297867/difference-between-string-object-and-string-literal>)
- **Question** What are immutable objects? Give some example of these. What is benefit of using immutable objects?
  - Primitive wrappers (Integer, Long, Short, Double, Float, Character, Byte, Boolean) are also all immutable
  
- **Question** What is reflection in Java?
- **Question** What is the significance of volatile keyword in Java?
- **Question** How to create an immutable object (<http://stackoverflow.com/questions/6305752/how-to-create-immutable-objects-in-java>)
  - Make the class final
  - Make all members final, set them explicitly, in a static block, or in the constructor
  - Make all members private
  - No Methods that modify state
  - Be extremely careful to limit access to mutable members(remember the field may be finalbut the object can still be mutable. ie private final Date imStillMutable). You should make defensive copies in these cases.
- **Question** Benefits of using immutable objects
  - Guarantee on the state of the object results in simpler implementation concerns
  - Thread safety is implied
- **Question** What is difference between Runnable and Thread approach for Multi Threading (<https://manikandanmv.wordpress.com/tag/extends-thread-vs-implements-runnable/>)
  - When you extends Thread class, after that you can’t extend any other class which you required. (As you know, Java does not allow inheriting more than one class).
  - When you implements Runnable, you can save a space for your class to extend any other class in future or now.
  - When you extends Thread class, each of your thread creates unique object and associate with it.
  - When you implements Runnable, it shares the same object to multiple threads.
- **Question** What is a race condition in multi-threading paradigm? (<http://www.javaworld.com/article/2074318/java-concurrency/java-101--understanding-java-threads--part-2--thread-synchronization.html>)
  - Example of deposit and withdrawal

- **Some properties of abstract classes is as follows**
  - Abstract classes cannot be instantiated. They can only be referenced
  - An abstract class can have main() method
  - An abstract class can be created without any abstract methods. This simply means that the class cannot be instantiated, but can be inherited
  - Abstract class can have constructor. They are called when the inheriting class gets instantiated
  - Abstract class can have final methods (methods which cannot be overridden)

- **Signed and Unsigned Bit Shifts**
  - >> is signed right shift of bits i.e. any trailing bit on the left after the shift is filled with the sign bit which is '0' in case of positive integer and '1' in case of negative integer
  - >>> unsigned right shift of bits i.e. trailing bit are irrespectively filled with '0's
  - Also not that all shifts will be reset after 31 to start counting from 0 again since the integer space is 32bit large only
  - Whereas for long this reset occurs at 63

- **Operator overloading**
  - It is not support by JAVA. It only supports method overloading, whereas C++ supports both method and operator overloading.

- **Changes/Enhancements introduced in Java7**
  - These are as follows (<https://www.oreilly.com/learning/java7-features>);
  - Need not explicitly define type inside diamond operator of the instance
    - OLD: Map<String, List<Trade>> trades = new TreeMap<String, List<Trade>> ();
    - NEW: Map<String, List<Trade>> trades = new TreeMap <> ();
  - Strings can be used as part of switch statements like primitives and enumerated types
  - Try-catch statements are capable of automatic resource management i.e. closing open resources like connections, filestreams etc. if they are implementing the AutoCloseable interface. So no need to go ahead and explicitly close the  open resources in finally block to prevent leak
  - We can add underscores to numeric literals to make them more legible e.g. int i = 1_000;
  - Multi catch statements allow for improved exception handling by reducing the amount of code to be written if multiple exceptions of different hierarchy are being caught
  - New filesystem API (NIO 2.0) which brings along newer classes like Path, Paths, FileSystem, FileSystems, Files etc. These new classes make handling of files, operations, instances more efficient compared to their older counterparts e.g.
    - Path myFile  = Paths.get("C:/<here_is_my_file>");
    - Files.delete(), Files.deleteIfExists(), Files.createSymbolicLink(), Files.move() etc.
  - A new WatchService has been added to monitor file changes like, CREATE, UPDATE, DELETE. In case of any change an entry (WatchKey) is added to a queue, which can be used as reference to trigger a corresponding response event
  - Fork and Join framework for multi-threading has been baked into Java to allow for cleaner and more efficient parallelism.
    - Classes responsible for exposing this framework are ForkJoinPool, ForkJoinTask
    - This framework introduces a work-stealing algorithm (which is what distinguishes it from older ExecutorService), which enables it to take work from busy threads if any thread is sitting idle
    - ForkJoinPool fkP = new ForkJoinPool(num_of_tasks);
      fkP.invoke(fork_join_task);
  - New feature called invokedynamics which enables support for dynamically types languages in JVM. Java is a statically types language i.e. the type checking for variables, methods and return type is done at compile time itself. But there are languages out there like Python, Ruby etc. which do these type checkings at runtime This move is in the direction to support these breed of dynamically types languages better in JVM

- **Blocking Queue**

The Java BlockingQueue interface in the java.util.concurrent package represents a queue which is thread safe to put into, and take instances from. (<http://tutorials.jenkov.com/java-util-concurrent/blockingqueue.html>)
A BlockingQueue has 4 different sets of methods for inserting, removing and examining the elements in the queue. Each set of methods behaves differently in case the requested operation cannot be carried out immediately. Here is a table of the methods:

|         | Throws Exception | Special Value | Blocks | Times Out                   |
| ------- | ---------------- | ------------- | ------ | --------------------------- |
| Insert  | add(o)           | offer(o)      | put(o) | offer(o, timeout, timeunit) |
| Remove  | remove(o)        | poll()        | take() | poll(timeout, timeunit)     |
| Examine | element()        | peek()        |        |                             |

- **Polymorphism**
  - method overloading is an example of compile time/static polymorphism because method binding between method call and method definition happens at compile time and it depends on the reference of the class(reference created at compile time and goes to stack).
  - method overriding is an example of run time/dynamic polymorphism because method binding between method call and method definition happens at run time and it depends on the object of the class (object created at runtime and goes to the heap) .

- **Anonymous Class in Java**
  - An anonymous class is a class that is created in an instantiation expression, and you cannot directly access the class without accessing the instance. That's why it's called an anonymous class.
  - Normally anonymous classes are used to create implementations of interfaces and abstract classes and so are referenced using the interface or parent class as the type.

```java
  interface Result {
    boolean success();
}
  
  Result objResult = new Result() {
    public boolean success() { return result; }
};
```

- **Functional Interface**
  - Interface with a single method is called Functional Interface in Java 8. There is an annotation for the same, which is optional
  - Anywhere if object of functional interface can go, we can pass a lambda expression
  - Java has lot of inbuilt functional interfaces

```java
  @FunctionalInterface
  interface Result {
    boolean success();
}
```
