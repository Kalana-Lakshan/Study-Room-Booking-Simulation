# Study Room Booking Simulation (Multithreading in Java)

This project simulates a study room booking system where multiple students (threads) attempt to access shared resources (study rooms). It demonstrates basic concepts of **multithreading**, **locking**, and **concurrency control** in Java.

## 🧠 Overview

- Five `Student` threads attempt to book one of five shared `room` objects.
- Each student makes 5 attempts to book a randomly chosen room.
- If a room is available, it is booked for a short period (300ms) and then released.
- If a room is already booked, a `studyroomunavailableexception` is thrown and handled.

This simulation ensures thread-safe access to rooms using `ReentrantLock`.

---

## 🛠 Technologies Used

- Java (JDK 8 or higher)
- `java.util.concurrent.locks.ReentrantLock`
- Basic multithreading (`Runnable`, `Thread`)
- Exception handling

---

## 📁 Project Structure

```
StudyRoomSimulation/
├── ERC.java          # Main class containing the simulation
└── README.md         # This file
```

---

## 🚀 How to Run

1. **Compile the Java file:**
   ```bash
   javac ERC.java
   ```

2. **Run the program:**
   ```bash
   java ERC
   ```

---

## 🔄 Sample Output

```
s1 is waiting to access r3
room 3 is booked now
s2 is waiting to access r3
s2 encountered an issue room 3 is currently booked
...
room 3 is free
```

> Output may vary since room access is randomized and concurrent.

---

## 📌 Key Concepts Demonstrated

- **Concurrency:** Multiple threads (students) access a limited set of shared resources (rooms).
- **Mutual Exclusion:** Rooms are protected using `ReentrantLock` to ensure only one thread can book a room at a time.
- **Exception Handling:** A custom exception is used to indicate when a room is unavailable.
- **Thread Coordination:** Each student independently waits, books, and frees rooms in its own thread.

---

## 📈 Possible Improvements

- Add waiting queues or retry logic for unavailable rooms.
- Track and report which student used which room.
- Use `Semaphore` or `Condition` for finer control over waiting and notification.
- Add a GUI or log file output.

---

## 👤 Author

This simulation was developed as a simple multithreading practice example in Java.

---

## 📜 License

This project is open-source and free to use for educational purposes.
