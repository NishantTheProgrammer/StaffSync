# StaffSync

StaffSync is a role-based workforce management system designed to streamline company operations. Admins can manage companies, oversee organizational hierarchy, notify employees, and handle worklogs and payslips. Companies can manage employees, projects, salaries, and organizational updates. Employees can manage tasks, apply for leave, log work hours, and access payslips.

---

## Features

### Admin
- Manage companies: Add, remove, and edit company details.
- Notify employees with important updates.
- Oversee the organizational hierarchy.
- Generate and manage employee payslips.
- View and track employee worklogs.

### Company
- Manage employees: Add, remove, and edit employee information.
- Oversee projects: Add, remove, and edit projects.
- Administer salaries and organizational hierarchy.
- Notify employees about critical updates.

### Employee
- Manage project tasks: Add, remove, and edit tasks.
- Apply for leave and approve leave requests (if a manager).
- Download and approve payslips (if a manager).
- Fill in and submit worklogs accurately.

---

## Workflow

Here’s an overview of the workflow within **StaffSync**:

![StaffSync Workflow](https://raw.githubusercontent.com/NishantTheProgrammer/StaffSync/refs/heads/main/docs/flow.png)

---

## Entity Relationship Diagram (ERD)

The ERD illustrates the relationships between different entities in the system:

![StaffSync ERD](https://raw.githubusercontent.com/NishantTheProgrammer/StaffSync/refs/heads/main/docs/erd.png)

---

## Prerequisites

- Java 23 or higher
- Maven 3.6+
- PostgreSQL database

---

## Getting Started

1. Clone the repository:
   ```bash
   git clone https://github.com/NishantTheProgrammer/StaffSync
   cd StaffSync
