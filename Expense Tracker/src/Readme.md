💰 Expense-Tracker

Hi! This is a simple CLI app to track expenses, created as an exercise inspired by roadmap.sh
.
It’s built in pure Java (no external dependencies) and uses a plain text file for storing expenses.

✨ Features

➕ Add an expense with a description and amount

✏️ Update an expense by its ID

❌ Delete an expense by its ID

📜 View all expenses

📊 View a summary of all expenses

⚙️ Installation

Clone this repository:

git clone https://github.com/<your-username>/Expense-Tracker.git
cd Expense-Tracker/src


Run the app:

If you have the exported JAR:

# The JAR was built with OpenJDK 21.0.5-ea (2024-10-15)
java -jar Expense-Tracker.jar <command>


Or compile and run using your favorite IDE (e.g., IntelliJ, Eclipse, VS Code).

💻 Usage
# Add expenses
$ java -jar Expense-Tracker.jar add --description "Lunch" --amount 20
# Expense added successfully (ID: 1)

$ java -jar Expense-Tracker.jar add --description "Dinner" --amount 10
# Expense added successfully (ID: 2)

# View all expenses
$ java -jar Expense-Tracker.jar list
# ID    Date         Description       Amount
# 1     2025-09-26   Lunch             $20
# 2     2025-09-26   Dinner            $10

# View total summary
$ java -jar Expense-Tracker.jar summary
# Total expenses: $30

# Delete an expense
$ java -jar Expense-Tracker.jar delete --id 1
# Expense deleted successfully

# View updated summary
$ java -jar Expense-Tracker.jar summary
# Total expenses: $10

# Update an expense
$ java -jar Expense-Tracker.jar update --id 2 --description "Dinner with friends" --amount 25
# Expense updated successfully

📂 Project Structure
Expense-Tracker/
├── model/              # Expense class (data model)
├── dao/                # File-based DAO for saving/loading expenses
├── controller/         # Handles operations between CLI and DAO
├── util/               # CLI input validator and parser
└── main/               # Entry point (Main.java)

📦 Tech Stack

Language: Java (SE 21)

Storage: Text file (no database)

Interface: Command Line (CLI)
