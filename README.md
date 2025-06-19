
# To-Do List Manager

*I keep a running log of my project thoughts and design decisions in `notes.txt`.*

A simple Java console application that lets multiple users maintain their own to-do lists.  
Each user's tasks are stored in a single linked list.

## Features

- Create up to 10 users, each with a unique name  
- Add tasks with descriptions  
- Mark tasks as completed  
- View all tasks for any user  

## Prerequisites

- Java JDK 11 or higher  
- Maven 3.6+


## Configuration

- The system supports up to 10 users by default.  
- To change this, edit the `users` array size in `Main.java`.

## Project Structure

```
src/
  main/java/com/todolistmanager/
    ├── Main.java       # Entry point and menu  
    ├── Task.java       # Task model (description + status)  
    ├── TaskList.java   # Single linked list for tasks  
    └── User.java       # User model (name + todo list)  
pom.xml               # Maven build file  
.gitignore            # Files to ignore in Git  
README.md             # Project documentation  
```

## Usage

1. Choose **Create a new user** to add someone.  
2. Use **Add task to a user** to insert a task.  
3. **Mark a task completed** to toggle its status.  
4. **View a user’s tasks** to see their list and statuses.  
5. **Exit** to close the program.


## Sample Usage

```
1. Create a new user
Enter username: Alice
User "Alice" created. Total users: 1

2. Add task to a user
Select user 0: Alice
Enter task description: Buy milk
Added task for Alice: Buy milk

4. View a user’s tasks
Select user 0: Alice
Tasks for Alice:
0: [ ] Buy milk
```
## Testing

Used JUnit 5 to cover core functionality in:

- `src/test/java/com/todolistmanager/TaskTest.java`  
- `src/test/java/com/todolistmanager/TaskListTest.java`  
