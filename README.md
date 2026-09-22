# java-core-exercises
# Java Enterprise Fundamentals

Transitioning core architectural concepts, strict typing, and concurrency patterns from Python and Rust into idiomatic modern Java.

> **Note on AI Usage:** AI was used exclusively to draft this `README.md` and serve as an interactive mentor/tutor to guide architectural concepts and best practices. All source code in this repository was written and implemented by hand without code generation.

---

## Overview

This repository contains a progressive sequence of standard-library Java drills. Rather than basic syntax, the focus is on mastering Java's type safety, memory considerations, functional pipelines, and concurrency primitives prior to working with full-stack enterprise frameworks like Spring Boot.

### Key Objectives
* **Deterministic Precision:** Eliminate floating-point inaccuracies using `BigDecimal`.
* **Declarative Processing:** Replace traditional loops and Python/Rust comprehensions with Java Streams and `Optional`.
* **Decoupled Architecture:** Build repositories and services using Interfaces, Inversion of Control (IoC), and constructor-based Dependency Injection without framework magic.
* **JVM Concurrency:** Implement thread-safe producer-consumer patterns using `BlockingQueue`, `ExecutorService`, and cooperative thread termination.

---

## Project Structure

```text
src/
├── ex01_domain/       # Exercise 1: Domain Modeling, Enums & BigDecimal
├── ex02_streams/      # Exercise 2: Declarative Pipelines (Streams & Optional)
├── ex03_di/           # Exercise 3: Interfaces, Repositories & Manual DI
└── ex04_concurrency/  # Exercise 4: Concurrent Queue & Worker Pools
```

---

## Exercise Summary

### Exercise 1: The Strict Domain Model (Financial Ledger)
* **Focus:** `java.math.BigDecimal`, `RoundingMode`, domain modeling, custom exceptions.
* **Description:** An in-memory ledger managing accounts and transfers. Enforces strict financial calculations to prevent floating-point rounding errors typical of `float`/`double`.

### Exercise 2: The Data Pipeline (Streams & Optional)
* **Focus:** Java Records, `java.util.stream.Stream`, `Collectors`, `Optional<T>`.
* **Description:** Parses structured text logs into immutable records and processes them via declarative stream operations (filtering, grouping, aggregating) while avoiding explicit loops and null pointers.

### Exercise 3: Repository & Interface Pattern (Manual DI)
* **Focus:** Interfaces, Polymorphism, Inversion of Control (IoC), Constructor Injection.
* **Description:** Separates business logic from data storage mechanisms. Demonstrates the mechanics behind Spring's `@Service` and `@Repository` layers by manually assembling dependencies at runtime.

### Exercise 4: The Concurrent Event Dispatcher (Producer-Consumer)
* **Focus:** `BlockingQueue`, `ExecutorService`, thread pools, `Runnable`, graceful shutdown.
* **Description:** Coordinates asynchronous item processing between an input dispatcher and background worker threads. Demonstrates thread-safe queue operations, blocking backpressure, and cooperative task cancellation.

---

## Getting Started

### Prerequisites
* Java Development Kit (JDK) 17 or higher
* Any standard Java IDE (IntelliJ IDEA, Eclipse, VS Code) or build tool (Maven/Gradle)

### Running the Exercises
Each module contains its own runnable `Main.java` entry point. 

From the project root:

```bash
# Compile all source files
javac -d out $(find src -name "*.java")

# Run a specific exercise (e.g., Exercise 4)
java -cp out ex04_concurrency.Main
```

---

## Upstream Application

These exercises serve as the foundational backend layer for:
* **Financial Services / Auditing:** Deterministic calculations, custom exception hierarchies, and transactional entity mapping.
* **Event-Driven Architectures:** Thread pools, asynchronous queues, and real-time push events.