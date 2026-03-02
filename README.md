# Employee Management & Leave Approval System

An advanced Java-based management system designed to handle complex organizational tasks, including employee role management, bonus calculations, and automated leave approval workflows.

---

## 🚀 Core Features
* **Hierarchical Role System**: Implements a robust class hierarchy for **Managers**, **Developers**, and **Designers**, each with specialized attributes and behaviors.
* **Automated Leave Workflow**: Features a dedicated `Approver` interface that allows Managers to authorize leave records and track employee states (Working vs. On Leave).
* **Dynamic Bonus Engine**: Overrides core methods to calculate role-specific bonuses (15% for Managers, 12% for Developers, and 10% for Designers).
* **File-Driven Operations**: Processes bulk commands through `Input.txt` and generates detailed transaction logs in `Output.txt`.
* **Leave History Tracking**: Maintains a comprehensive record of all historical leaves for every employee using a specialized `Leave` class.

---

## 🛠️ Technical Implementation
* **OOP Principles**: Extensive use of **Abstract Classes**, **Interfaces**, and **Method Overriding**.
* **Data Structures**: Utilizes `ArrayList` and `List` for efficient employee and record management.
* **Java Time API**: Integrates `java.time.LocalDate` for accurate leave duration and scheduling.

---

## 📂 Class Overview
* **Employee (Abstract)**: The foundational blueprint for all staff members.
* **Manager**: Implements the `Approver` interface to manage staff states and leave requests.
* **Leave**: A model class representing a duration of absence linked to a specific employee.
* **EmployeeManagementSystem**: The central controller that parses commands like `Add_Manager`, `Give_Leave`, and `printAllEmployees`.
