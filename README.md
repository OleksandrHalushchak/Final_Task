# Final_Task
1.	Tests are running in 2 threads by default.
2.	The project uses Logging (log4j2). Logs write to console and to the file by directory “target/logs.log”.
3.	The project uses Reporting (allure). Reporting results saves to the file by directory “target/allure-results”.
4.	The project contains the following test cases:

Test case #1
-	checking that text near the email field on the buttom of the page equals 'Get our latest news and special sales';
-	checking that text under email field on the buttom of the page contains 'You may unsubscribe at any moment. For that purpose, please find my contact info in the legal notice.';
-	checking that all characters on 'SUBSCRIBE' button in upper case.

Test case #2 (Check languages)
-	checking that 44 langueges exists in 'Language' dropdown in the top menu;
-	checking that 'Українська' language exist in dropdown.

Test case #3 (Registration with valid data)
-	checking user name appear near cart button after registration.

Test case #4 (Registration with invalid data)
-	checking that 'First name' higlighted in red, after registration with invalid 'First name';
-	checking that pop-up with text 'Invalid name' appear under field.

Test case #5 (Check categories)
-	checking that 'MEN' and 'WOMEN' sub menu items appears;
-	checking that 'STATIONERY' and 'HOME ACCESSORIES' sub menu items appears;
-	checking that no any sub category appears.

Test case #6 (Check popular products)
-	checking that 8 products exist in 'POPULAR PRODUCTS' section
-	checking that every product has name
-	checking that every product has price
-	checking that all prices bigger than 0.00

Test case #7 (Price drop check)
-	checking that every product in 'Prices drop page' has old and new price
-	checking that promo price for every product calculates correct

Test case #9 (Adding to cart)
After entering any product in the search field, changing 'Paper type' and 'Quantity’, clicking button 'ADD TO CART':
-	check that new window with title 'Product successfully added to shopping cart' appears
-	check that correct 'Paper Type' and 'Quantity' is shown on the left side of the window
-	check that 'Total' calculated correct

