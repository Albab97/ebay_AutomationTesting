🛒 eBay E-Commerce Automation Testing Project

### 🚀 Overview
This project automates the testing of key functionalities of the **eBay website** using **Selenium WebDriver**, **Java**, and **TestNG**.  
It demonstrates an end-to-end test automation framework that validates the core e-commerce workflows such as **Login**, **Sign Up**, **Dashboard**, and **Add to Cart**.
This project follows a **structured QA approach** — complete with a detailed **Test Plan document** and **Test Cases Excel sheet** uploaded in this repository.
---

### 🧩 Features Covered
- ✅ **Login Functionality** – Verify valid and invalid login scenarios.
- 🧾 **Sign Up Page** – Check field validations and new user registration.
- 📊 **Home Page** – Ensure correct elements displayed after login and tested the Search functionality.
- 🛍️ **Add to Cart** – Validate adding and removing products from the cart.

---

### ⚙️ Tech Stack
| Category | Technology Used |
|-----------|-----------------|
| Programming Language | Java |
| Automation Framework | Selenium WebDriver |
| Build Tool | Maven |
| Test Framework | TestNG |
| IDE Used | IntelliJ IDEA / Eclipse |
| Browser | Google Chrome |

---

### 📁 Project Structure
eBay-Automation/
│
├── src/
│ ├── main/java/
│ │ └── resources/ # Drivers utility
│ ├── test/java/
│ │ └── com.tests/ # Test Classes
│
├── pom.xml # Maven Dependencies
├── testng.xml # TestNG Suite Configuration
└── README.md # Project Documentation

---

### 🧠 Concepts Demonstrated
- Page Object Model (POM) design pattern
- Implicit and Explicit Waits
- Locators: ID, CSS Selectors, XPath
- Assertions for validation
- Reusable utility methods
- Browser setup via `ChromeOptions`

---

### 🧪 How to Run the Tests
1. Clone the repository
   ```bash
   git clone https://github.com/Albab97/ebay_AutomationTesting.git
   cd ebay-AutomationTesting
Install dependencies

bash
Copy code
mvn clean install
Execute test suite

bash
Copy code
mvn test