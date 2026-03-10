# 🚌 RedBus Bus Search Automation (Selenium + Java)

This project demonstrates **UI Automation using Selenium WebDriver with Java** to automate a real-world scenario on the RedBus website.

The automation script searches for buses between **Mumbai and Pune**, applies filters such as **Primo Bus** and **Evening (18:00–24:00)**, dynamically loads all available results, and prints the **names of all buses available under the selected filters**.

This project focuses on handling **dynamic web elements, lazy loading, filters, and scrolling using Selenium.**

---

# 🚀 Features

- Automates **RedBus bus search functionality**
- Selects **source and destination locations dynamically**
- Applies **Primo Bus filter**
- Applies **Evening time filter (18:00–24:00)**
- Handles **lazy loading using scrolling**
- Extracts **bus names dynamically**
- Prints the **total number of filtered buses**

---

# 🛠 Tech Stack

- **Language:** Java 11 
- **Automation Tool:** Selenium WebDriver  
- **Browser:** Google Chrome  
- **IDE:** Eclipse / IntelliJ  
- **Wait Strategy:** WebDriverWait (Explicit Wait)

---

# 📂 Project Structure

```
RedBusAutomation
│
├── src
│   └── com.redbus.automation
│       └── RedBusAutomationScript.java
│
└── README.md
```

---

# ⚙️ Automation Workflow

1. Launch Chrome browser
2. Navigate to **https://www.redbus.in**
3. Select **From location → Mumbai**
4. Select **To location → Pune**
5. Click **Search Buses**
6. Click **Proceed**
7. Apply **Primo Bus filter**
8. Apply **Evening time filter (18:00–24:00)**
9. Scroll through the page to load all buses
10. Extract bus names dynamically
11. Print the total number of filtered buses

---

# 📊 Sample Output

```
Total number of Buses found: 24 buses

Shivneri Travels
Purple Bus
IntrCity SmartBus
VRL Travels
...

Total number of Buses available with "Primo Bus" and "Evening" Filter are: 12
```

---

# 🔑 Key Automation Concepts Used

- Explicit Wait (`WebDriverWait`)
- Dynamic XPath Handling
- Handling Search Suggestions
- Filter Automation
- Lazy Loading Handling
- Scrolling using `JavascriptExecutor`
- Dynamic List Handling using Selenium

---

# ▶️ How to Run

### 1️⃣ Clone the repository

```
git clone https://github.com/karan-sagale/RedBusAutomation_Solution
```

### 2️⃣ Open project

Open the project in **Eclipse or IntelliJ**

### 3️⃣ Install dependencies

Make sure you have:

- Java 8+
- Chrome Browser
- ChromeDriver compatible with your Chrome version
- Selenium dependencies

### 4️⃣ Run the script

Run the file:

```
RedBusAutomationScript.java
```

---

# 📌 Learning Highlights

This project demonstrates how to automate:

- Dynamic search suggestion dropdowns
- Filtering search results
- Lazy loading content using scrolling
- Extracting dynamic lists from web applications

---

# 👨‍💻 Author

**Karan Sagale**  
Senior Software Testing Engineer

Passionate about building **automation solutions using Java and Selenium WebDriver**.

GitHub: https://github.com/karan-sagale
