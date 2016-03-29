# VCS

VCS (**Version Control System**) project with **Java** by Mant�, Dominykas and Ugnius.

## Description

Common reports and programs or information blocks are modified by several users as the latest version of any material should be accessible for all project (group) members. The system should be able to show the last version and all the previous versions, and to recover to some previous version if the last version is broken. The system should show what was changed in each version, who made the modification, who worked and committed most frequently.

## Deadlines
Project is done by a group of 2-3 students. The project topic must be chosen before March 25 14:00 during practice sessions or lectures. At least one representative of the group must come to set up the topic. Later the topic cannot be chosen. The topic will not be assigned via e-mails.

Deadlines of project activities:

I programming part (April 10th 22:00)
II programming part (May 1st 22:00)
Project report (May 5th 22:00)
Review (individual work) (May 10th 22:00)
Project defence (weeks 14 and 16)

## Programming Parts
The final program must be fully functional and it must have GUI.

**I part.**

The flow of the program is simulated using chosen time granularity (time should "go" by: e.g. one day, then a day in one week, etc.; you do not have to change the computer system time - you simulate start of the system on some date).

All major classes must be defined (they may be unfinished or with some empty methods).

Also, all proper test data must be prepared (nice data, names, text, etc.).

In the main class as a comment or in additional TXT file, the full (expected) functionality of the final program must be presented and described.

**II part.**

Fully functional system, finished (your own description of expected functionality is uploaded with part I) and modified based on the comments for part I.

## Programming Requirements
Topics are related to services. In some projects, you have to choose to create the project from the perspective of service provider while in some projects - from the perspective of service clients. Be creative! The description of the project is just the main idea and the basic functionality, but much more functionality must be included.

**Requirements of the programming part:**

* At least 6 classes must be defined.
* Usage of inheritance. Your defined class is to be inherited. Extension of the Java API class is not counted.
* Only the main method can be static! Other static methods and static variables are not allowed.
* All class variables must be non-static and local/temporary/loop variables can not be defined as class variables.
* The main method can contain less than 6 code lines.
    * Any other method should not be too long, too (it cannot last for several pages).
* Usage of overloading and overriding.
* Simulation of the *real time flow*. The parameters (start date/time, jump over time, etc.) can be passed in the command line (and/or GUI) during program execution.
    * E.g. the program starts on 2016-02-15 (or any other chosen day), some steps are done by the user. At any step the program time can pass further by X days, months, or hours. The user initiates it when the user wants it. After time goes by X time units the changes are represented: more goods are delivered, the service time ended, more data are available, etc.
* Some information must be stored in file system.
    * Nice test data must be prepared (as Part I required). The data cannot have person A B that buys product C. A, B, and C must be realistic.
* Logical access modifiers.
* Comments are written in javadoc style.
You will get comments on part I and all comments must be considered and implemented.
* Coding style. Class names, variables, and methods must be only in one language, either English, either Lithuanian. Do not mix languages. E.g. Clientas class would not be acceptable.
* In the final version handle all I/O exceptions correctly. Remember that your colleagues will review your work, thus, you have to explain how to compile and run your program, where the data files are stored. *If you use some IDE tell which one*.
    * Prepare your program for the VU MIF environment, i.e. be aware that VU MIF supports Java **version 7**, but not 8 (usually IDEs can switch from one compiler to another if the compiler is installed; but this is done in settings). Project defence will be at VU MIF computers. Also, students will have to review each others projects and during the defence any student could be asked to show how she/he tried to run/execute some project.
        * The risk is to use something that is supported only in Java version 8. Thus, test your program much in advance!
    * It is recommended to remove *deprecated* usage of Java.
    * Archive your project correctly so that any other student would be able to run the program without creating additional files, directories, etc.
    * When all the members of the team are listed be aware that they should be listed alphabetically (it is a standard), otherwise, the first student gets most of the credit :)
* Non-standard (non- Java API) packages are not allowed to use.
* Do not make comments for each line. Comments should be before the important methods, complex blocks, etc.
