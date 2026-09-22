# Lab 2: Second Activity: Translating Python code to Java code

The second lab activity this week will have your team practice using GitHub Issues
to divide up coding tasks and PRs to contribute code. The code itself should feel quite familiar,
as we will be translating Python code that implements some common data structures to implement the
multiset ADT.

The goals of this activity are to:
- give you practice applying a branch and merge workflow
- use pull requests to provide a mechanism to ensure other team members can review code contributed
  to a software project before it is accepted into the main branch
- give you a first experience of coding in a collaborative environment
- experiment with how to most effectively divide up coding tasks

# The Task

In the previous activity, you practised creating branches and making pull requests. Now, you'll
apply those skills to a collaborative coding task.

> **Note:** This may seem like a big task at first, but remember that your team will divide the
> work into smaller tasks!

Your goal is to translate the Python code in `python/adts.py` into a functionally equivalent
set of Java classes. Some parts will translate directly, while others will require you to explore
unfamiliar Java syntax and concepts.

**We don't expect you to get everything working during the lab.** The goal is to make progress
and get a sense of what it is like to work on a larger coding task as a team. Try things out,
look things up, ask questions, and don't be afraid to make mistakes!

## Setting Expectations

During the lab, aim to:

- create at least two GitHub Issues per team member
- have each team member:
    - close at least one GitHub Issue
    - create at least one pull request
    - review at least one pull request from another team member
- actively discuss strategies for working effectively on a shared code base
- get the provided subset of tests passing on the code in your GitHub repository

You do **not** need to complete the entire translation during the lab.

## The Code

You will be developing several Java classes that implement the `MultiSet` ADT. You will also
complete a `main` method equivalent to the main block in the provided Python code.

The Python main block runs a timing experiment comparing the different implementations. This
should feel similar to code you saw in your first-year CS courses.

## Instructions

- [x] Choose one member of your team to fork the starter repository:
  https://github.com/CSC207-2026F-UofT/lab2-multiset-adt

- [x] The repository owner should add the other team members as collaborators. This gives everyone
  access to the same shared remote repository.

> **Note:** On GitHub, check **Settings → General** and ensure that Issues are enabled.
> ![images/GitHubIssuesSetting.png](images/GitHubIssuesSetting.png)

---

- [x] Get a local copy of the remote repository.

      You can do this using either method from last week: `git clone <url>` or creating a new
      project from version control in IntelliJ.

---

- [x] Take some time to skim the rest of the instructions to get a sense of what you'll be doing
  in this activity. If you have any immediate questions, discuss them with your group or ask
  your TA.

---

- [ ] As a team, explore the Python code and identify specific pieces of code that need to be
  translated. Also look at what has already been provided in the Java starter code,
  including the provided Java test files.
  > The **Initial Advice** section below highlights a few things your team should think about as 
  > you explore the code. You can also ask other groups or your TA for advice as needed.

---

- [ ] Based on your group discussion, create GitHub Issues describing the tasks your team needs to
  complete.

---

- [ ] Once your team has created a set of Issues, each team member should be assigned one or more Issues
  to start working on.

---

- [ ] Create a branch for your assigned Issue and work locally to complete the task.

---

- [ ] Push your **branch** to the remote repository and create a pull request.

---

- [ ] When a teammate creates a PR, have at least one other team member review it.
  - Review the changes on GitHub.
  - Pull the branch and try running the code locally when appropriate.
  - Give feedback, both verbally and through a GitHub review or comment.
  - Once the PR is ready, merge it into `main`.

---

- [ ] Once everyone has created a PR and had it merged, continue working to close more of the Issues
  your team opened. This will give you more practice with the branch-and-merge workflow.

---

- [ ] Towards the end of the lab, take some time as a team to reflect on what worked well and where
  you encountered difficulties. In particular, think about how effectively you divided the work
  and coordinated changes to your shared repository.

---

### Initial Advice

A few general strategies before you begin:

1. **Work incrementally.** You don't need to get the whole program working at once. Look for pieces
   that can be developed *independently*. This also reduces the chance of merge conflicts later.

   For example, because we have defined a common `MultiSet` abstraction, different team members
   can work on:
    - client code that uses the `MultiSet` API, and
    - classes that implement the `MultiSet` API.

2. **Consider dividing work by class.** Each class should go in its own file in Java, so splitting
   up the work by class is one way to reduce the chance of conflicts.

3. **Consider dividing work by method.** Some classes have several methods that need to be written,
   so you can also divide up work at the method level. Keep in mind, however, that two people
   editing the same file are more likely to encounter merge conflicts.

4. **Use the provided tests as you work.** We haven't discussed writing tests in Java yet, so you
   aren't expected to write additional tests. However, you're welcome to use the provided tests as
   examples if you'd like to try writing your own.

5. **Keep `main` in a working state.** Think about the order in which your team merges PRs.
   Whenever possible, code merged into `main` should compile and pass the tests that were passing
   before the merge.

**Remember: success today means making a plan and progress as a team, not completing every method.**

### Java Concepts

The following are a few Java concepts that you may be seeing for the first time today, or that
you may have encountered only recently. You'll learn more about them soon,
so don't worry if you find some parts of the code challenging to implement today. There should still be
plenty of pieces you can work on using your current knowledge of Java.

An important skill when programming is learning how to find information as you need it. Get in the
habit of looking up unfamiliar concepts and syntax. The official Java documentation, the course
notes, and the official Java tutorials are all useful resources. Your TA and peers are also
valuable sources of information.

The sections below briefly highlight some concepts you'll need to explore as you implement the code
today. Again, we don't expect you to know all of these things already. Part of the exercise is
identifying what you can implement with your current knowledge and what you need to look up or ask
questions about.

#### Abstract Classes

In the Python code, the `MultiSet` ADT is represented by an abstract class. We can use an abstract
class for the Java version too. A non-abstract subclass of an abstract class must provide
implementations for all of its inherited abstract methods.

> **Looking ahead:** Java also has `interface`s, which are often used to specify an API that other
> classes implement. Because our `MultiSet` abstraction consists entirely of abstract methods and
> has no instance variables, it could naturally be represented as a Java interface. We'll learn much
> more about interfaces throughout the course.

#### Constructors

Constructors are used to initialize newly created objects. They play a role similar to `__init__`
methods in Python, although there are some important differences that we'll explore in class.

To create an object in Java, you'll typically use the `new` keyword followed by a constructor call.

#### Delegation / Composition

The provided code for classes like `BST` and `BSTMultiSet` demonstrates a common design approach in
which one class stores an instance of another class as a private instance variable. Rather than
implementing all of its functionality directly, the class can **delegate** work to the object it
contains.

This approach is useful for organizing code, controlling access, and adapting one API to another.
Look at the public methods provided by the contained class and consider which of them you can call
rather than implementing the same behaviour again yourself.

#### Access Modifiers

In the Python code, you'll notice the use of a leading underscore to indicate that an attribute is
intended to be private, or an implementation detail of the class. Java instead uses access modifiers
to specify who can access classes, methods, and variables.

For now, two useful rules of thumb are:
- methods that are part of your public API should generally be `public`
- instance variables should generally be `private` unless there is a reason for them not to be

#### JavaDoc

We haven't talked about documentation too much yet, but you can look at existing Java code to get a
sense of how Java code is documented.

For example, try hovering over a documented Java class or method in IntelliJ to see its JavaDoc.
You can think of JavaDoc as serving a role similar to docstrings in Python.

#### Generics

Thinking back to your work with common ADTs in first year, you may recall seeing the use of the `Any` type
annotation to indicate that an ADT could contain many different kinds of objects.

For this exercise, we have simplified the code by assuming that our multisets only store integers.

In Java, we'll soon learn about **Generics**, which allow us to specify what type of objects a
particular instance of an ADT will store. Once we learn about Generics, we encourage you to look back
at this code and consider how you could generalize it.

#### The Java Collections Framework (JCF)

The **Java Collections Framework (JCF)** provides interfaces and classes for many common collection
ADTs in Java. We'll learn more about the JCF soon, and you'll use it throughout the term whenever
you need common data structures for storing and manipulating collections of objects.

The JCF contains code that serves purposes similar to what you're implementing today, but makes use
of additional Java features, such as Generics and Interfaces, that we'll learn about soon.

## Extra

If your team does fully replicate the behaviour of the provided Python code, think about possible
changes or extensions you could make:

- Could you make the timing experiment more customizable so that it can time other things?
    - For example, how might you allow a user to vary the problem sizes for an experiment or
      customize what statistics are reported?

- How could you use Generics to generalize the `MultiSet` ADT so that it can contain different
  kinds of objects?

- How would the code change if we represented the `MultiSet` ADT using a Java Interface instead
  of an abstract class?