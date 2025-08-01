# RemWasteManagement_UIAutomation – Selenium Test Suite

This is a **UI Test Automation Framework** for the **REM Waste Management** React Admin application. It uses **Selenium WebDriver**, **TestNG**, and **ExtentReports** with a Page Object Model (POM) design.

---

## ✅ What Does This Test?

This framework validates UI functionalities such as:

- Login page validations
- Dashboard verification
- Category and Customer management pages
- End-to-end smoke/regression flows
- UI element assertions
- Screenshot capture on failure

---

## 🧰 Tech Stack & Tools

| Tool / Library       | Purpose                                   |
|----------------------|--------------------------------------------|
| Selenium WebDriver   | Browser automation                         |
| TestNG               | Test management and orchestration          |
| ExtentReports        | Rich HTML test reporting                   |
| Java 8+              | Programming language                       |
| Maven                | Project dependency management              |

---

## 📂 Project Structure
RemWasteManagement_UIAutomation/
│
├── src/
│ ├── main/
│ │ └── java/
│ │ ├── pages/
│ │ │ ├── BaseClass.java # Common driver setup and utilities
│ │ │ ├── LoginPage.java # Login page locators & actions
│ │ │ ├── DashboardPage.java # Dashboard actions
│ │ │ ├── CategoriesPage.java # Category page elements
│ │ │ └── CustomerPage.java # Customer page elements
│ │
│ │ ├── reports/
│ │ │ └── ExtentManager.java # Extent report config
│ │
│ │ └── utils/
│ │ ├── ScreenshotUtil.java # Capture screenshots on failure
│ │ └── TestListener.java # TestNG listeners for report logging
│
├── src/test/java/
│ └── tests/
│ ├── BaseTest.java # Common test setup/teardown
│ └── LoginTest.java # Test case for login flow
│
├── pom.xml # Maven dependencies
├── testng.xml # TestNG suite configuration
├── test-output/ # TestNG default report folder
└── target/ # Maven build folder


---

## ▶️ How to Run the Tests

### 1. Clone the Project

```bash
git clone https://github.com/your-username/RemWasteManagement_UIAutomation.git
cd RemWasteManagement_UIAutomation

2. Configure Test Details**
Update browser configuration or application URL if needed inside BaseClass.java.

3. Run the Tests
Using TestNG:
Right-click testng.xml in your IDE and choose Run As → TestNG Suite

🧪 Reporting
The framework uses ExtentReports to generate visually rich HTML reports.

Reports are auto-generated after each test run.

Location: test-output/ExtentReports/ or inside the reports/ folder if configured there.

Screenshots are captured on test failures.

💡 Features
Modular Page Object Model (POM)

Cross-browser ready (Chrome default)

Screenshot capture on failure

Custom HTML Reports using ExtentReports

TestNG Listeners to manage report events

Maven-managed dependencies

⚠️ Notes
Make sure browser drivers (e.g., chromedriver) are compatible and available on your system path.

The project can be extended to include CI tools like Jenkins or GitHub Actions for continuous integration.
