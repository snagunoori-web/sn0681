About
**Tool-Rental-MicroService** :  This application build as micro-service to calculate rental of the tool for provided details and it will generate rental
agreement.


****Specification****
The demonstration is to code and test a simple tool rental application. 
 - The application is a point-of-sale tool for a store, like Home Depot, that rents big tools. 
 - Customers rent a tool for a specified number of days. 
 - When a customer checks out a tool, a Rental Agreement is produced. 
 - The store charges a daily rental fee, whose amount is different for each tool type. 
 - Some tools are free of charge on weekends or holidays. 
 - Clerks may give customers a discount that is applied to the total daily charges to reduce the final
charge.


**Tools**
The tools available for rental are as follows:

** Tool       Daily      Weekday charge   Weekend charge   Holiday charge**  
   Ladder     $1.99         Yes                Yes               No
 Chainsaw      $1.49        Yes                No               Yes
Jackhammer    $2.99         Yes                No                 No

Each tool instance has the following attributes: 
**Tool Code** - Unique identifier for a tool instance

**Tool Type** - The type of tool. The type also specifies the daily rental charge, and the days for which the daily rental charge applies.

**Brand** - The brand of the ladder, chain saw or jackhammer.



**Holidays**
There are only two (2) holidays in the calendar:
   - Independence Day, July 4th - If falls on weekend, it is observed on the closest weekday (if Sat, then Friday before, if Sunday, then Monday after)
   - Labor Day - First Monday in September


**Checkout**
Checkout requires the following information to be provided:
  - Tool code - See tool table above
  - Rental day count - The number of days for which the customer wants to rent the tool. (e.g. 4
days)
  - Discount percent - As a whole number, 0-100 (e.g. 20 = 20%)
  - Check out date

**Validation And Exception**
Checkout should throw an exception with an instructive, user-friendly message if
  - Rental day count is not 1 or greater
  - Discount percent is not in the range 0-100

Checkout generates a Rental Agreement instance with the following values.
 - Tool code - Specified at checkout 
 - Tool type - From tool info 
 - Tool brand - From tool info 
 - Rental days - Specified at checkout
 -  Check out date - Specified at checkout 
 - Due date - Calculated from checkout date and rental days. 
 - Daily rental charge - Amount per day, specified by the tool type. 
 - Charge days - Count of chargeable days, from day after checkout through and including due
date, excluding “no charge” days as specified by the tool type. 
 - Pre-discount charge - Calculated as charge days X daily charge. Resulting total rounded half up
to cents. 
 - Discount percent - Specified at checkout. 
 - Discount amount - calculated from discount % and pre-discount charge. Resulting amount
rounded half up to cents. 
 - Final charge - Calculated as pre-discount charge - discount amount.


**Technical:**
   - spring-boot application with rest
   - Used In memory data base  h2database to load test data on start up application.

**Database**
    Used h2database to load test data

**Packages:**
   created packages as per java standards
   - controller
   - service
   - model
   - entity
   - validator
   - util
   - formatter


**Test:**
   Written Junit test cases to cover functionality