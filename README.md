This is a UI automation framework built using Selenium WebDriver with Java, TestNG, and Page Object Model (POM) design pattern. It automates an e-commerce flow including login, adding products to cart, and placing an order. 

 

📌 Tech Stack 

Java  

Selenium WebDriver  

TestNG  

Maven  

Page Object Model (POM)  

Extent Reports  

 

📁 Project Structure 

src 
├── main/java 
│    ├── base 
│    ├── page 
│    ├── utility 
│ 
├── test/java 
│    ├── test 
│ 
├── resources 
│    ├── config.properties 
│ 
├── Reports 
├── Screenshots 

 

🚀 Features 

Login automation  

Product selection and cart validation  

Checkout flow automation  

Shipping details form automation  

Assertion validations  

Extent HTML reporting  

Screenshot capture on failure  

 

⚙️ Configuration 

Update config.properties file: 

url=https://qa-practice.razvanvancea.ro/auth_ecommerce.html 
expectedTitle=QA Practice | Learn with RV 
email=admin@admin.com 
pswd=admin123 
 
item1=Cucumber 
item2=Eggs 
item3=Protein Powder 
 
phno=9657863289 
street=5876 next street 
city=London 
country=United Kingdom 

 

▶️ How to Run 

Using TestNG XML 

Run: 

testng.xml 

Using Maven 

mvn test 

 

📊 Reports 

After execution, reports will be generated at: 

/Reports/myreport.html 

Screenshots for failed test cases will be stored in: 

/Screenshots 

 

🧪 Test Flow 

Launch application  

Login with valid credentials  

Add products to cart  

Proceed to checkout  

Enter shipping details  

Validate order confirmation  

 

🧩 Test Classes 

LoginTest  

ShoppingCartTest  

ShippingDetailsTest  

 

📷 Screenshot on Failure 

If a test case fails, screenshot will be automatically captured and attached in Extent Report. 

 

Author 

Sandra Sen 

 

 
