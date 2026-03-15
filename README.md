# SortingVisualizer

> Watching O(n²) in real time so you truly feel the pain.

A **real-time sorting algorithm visualizer** built with Java Swing. Watch elements shuffle, compare, and swap their way to sorted order — step by animated step.

## What it does

- Renders an array of values as a bar chart on a Swing `JPanel`
- Animates the sorting process: highlights comparisons and swaps in real time
- Supports multiple sorting algorithms via a factory pattern
- Currently implemented: **Bubble Sort**, **Insertion Sort**

## How it works

Each algorithm implements the `Sorter` interface. `SortFactory` maps algorithm names to their implementations. `SortInitializer` generates the initial random array and wraps each element in a `SortObject` (value + visual state). The `Workflow` class drives the animation loop: it steps through each comparison/swap, updates the `SortObject` state (highlighted, swapped, sorted), and triggers a repaint on the `JPanel`. `SortHelpers` and `Utility` provide shared math and array helpers.

## Tech stack

- **Java** (standard library)
- **Java Swing / Java2D** for rendering

## Getting started

### Prerequisites

- Java 8+
- IntelliJ IDEA or Eclipse

### Run

1. Open the project in IntelliJ (source root: `SortVisualizer/src/`).
2. Run `Main.java`.
3. A window opens with a randomized bar chart. Watch it sort itself.

### Compile manually

```bash
javac -d out SortVisualizer/src/**/*.java SortVisualizer/src/*.java
java -cp out Main
```

## Project structure

```
SortVisualizer/src/
├── Main.java
└── com/
    ├── bubble/
    │   ├── Bubble.java           # bubble sort state
    │   ├── BubbleInitializer.java
    │   └── BubbleSorter.java     # bubble sort implementation
    ├── insert/
    │   └── Insert.java           # insertion sort implementation
    └── helper/
        ├── Sorter.java           # algorithm interface
        ├── SortFactory.java      # algorithm registry
        ├── SortInitializer.java  # array setup
        ├── SortObject.java       # element + visual state
        ├── SortHelpers.java      # comparison helpers
        ├── Workflow.java         # animation driver
        └── Utility.java          # shared utilities
```
