# College Directory Application

## Overview
This application aims to facilitate interaction between students, faculty members, and administrators within a college. The project is currently in progress, with the Administrator and Student sections developed.

## Features

### 1. Login Page
- **Interface**: Username, Password, and Role selection (Student/Faculty Member/Administrator).
- **Functionality**: Validates credentials, redirects based on role, handles errors.

### 2. Student Section (Developed)
#### A. View Personal Profile
- **Interface**: Displays personal and academic information.
- **Functionality**: Fetches and displays profile details from the database.

#### B. Search for Other Students
- **Interface**: Search bar with filters; list view of matching students.
- **Functionality**: Implements search functionality, displays results dynamically.

#### C. Contact Faculty Advisors
- **Interface**: List view of assigned faculty advisors with contact options.
- **Functionality**: Fetches and displays advisor details, provides contact links.

### 3. Administrator Section (Developed)
#### A. Manage Student and Faculty Records
- **Interface**: Form to add, update, or remove records; list view with CRUD options.
- **Functionality**: Implements CRUD operations, reflects changes immediately.

#### B. Dashboard with Graphs
- **Interface**: Visual representation of data (e.g., enrollment trends).
- **Functionality**: Fetches and aggregates data, provides interactive elements.

### 4. Faculty Member Section (In Progress)

## Technical Stack
- **Frontend**: HTML/CSS/JavaScript (React planned)
- **Backend**: Java with Spring Boot
- **Database**: PostgreSQL

## Running the Application
![College Directory Application]([https://your-image-url.com/your-image.jpg](https://github.com/nabanitaghosh8/CollageDirectoryApplication/blob/main/Screenshot%202024-07-24%20103010.png))
1. **Clone the repository**:
    ```sh
    git clone <repository-url>
    ```

2. **Navigate to the project directory**:
    ```sh
    cd college-directory-app
    ```

3. **Setup the database**:
    - Ensure PostgreSQL is installed and running.
    - Run the SQL schema script to create tables and insert initial data.

## Project Status
- **Completed**: Administrator Section, Student Section
- **In Progress**: Faculty Member Section

## Contribution
1. Fork the repository.
2. Create a new branch for your feature/bugfix.
3. Commit your changes and push the branch.
4. Open a pull request describing your changes.


