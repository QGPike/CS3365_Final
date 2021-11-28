# CS3365_Final
Supermarket Checkout/Inventory System (SCIS) Implementation and Documentation


Problem Description:

There are supermarkets across the US where a checkout system processes customer checkout,
and an inventory system controls the level of product stock in the supermarkets. A cashier can
use a supermarket checkout system to check out a customer’s items. A supermarket inventory
system can trace the product stock level and make order products to maintain the proper level of
product stock in the supermarket.

The checkout system consists of a store computer to which the cash registers are connected.
Each cash register is equipped with its processor, a touch screen (containing numeric keys,
function keys, scale/total/payment type buttons, and cash register display), an electronic barcode scanner, a scale, a customer order receipt printer, a credit/debit card reader, a check
reader, and a customer display where item and price information are shown to the customer.
Each register has a holder for a till containing cash, checks, coupons, etc., which is automatically
opened at the end of each customer transaction.

To check out an order, the cashier enters the identification number of each item. This is done
either by scanning the item over the bar-code scanner or manually from the keypad. In the latter
case, the cashier enters the number followed by the function key ITEM-ID. Based on the
number, the cash register obtains product information from the product inventory. The product
information contains an item description to be displayed to both cash register and customer
displays and printed on the receipt, price, and information on a discount. As items are being
checked through, prices and item descriptions appear on the customer and cash register displays.
The system also outputs the item description and price to the customer order receipt printer.
For bulk items, the product information indicates that the item must be weighed on the scale. The
final weight is calculated when the cashier presses the SCALE button. The weight and price are
displayed and printed on the receipt.

The supermarket provides memberships for loyal customers. When the first item is scanned or
the item’s ID is entered via a credit/debit card reader in each checkout, a customer is prompted to
enter the phone number and member PIN (4 digits) to verify the customer. If a customer is loyal,
the credit points corresponding to the total price are added to the customer account. The credit
points can be used to receive some gifts from the supermarkets.
After all the items in the order have been processed, the cashier presses the TOTAL function
key. The cash register computes and displays the total price including tax. The tax and the total
are also printed on the receipt. The TOTAL button can be pressed only once for each order. Once 

the TOTAL has been pressed, the order cannot be changed. When the total has been computed,
the till is automatically opened. After the total has been displayed, the cashier accepts payment. The payment amount is entered,
followed by a payment type button. All supermarkets accept CASH, CHECK, and
CREDIT/DEBIT. If cash is paid, the cashier is prompted to enter the amount displayed and
printed on the receipt. If a check is used, the check is scanned by the check reader. The check is
verified by the system. If the check is accepted, the cashier is prompted to place it in the receipt
printer. A line containing date, time, store identity, cashier identity, and order number are printed
on the check.

For credit/debit card payment, the customer enters a card into the credit/debit card reader. For a
debit card, a customer enters a PIN to the credit/debit card reader. A message is then sent to the
appropriate credit/debit card authorization center. The card request is either accepted or rejected.
If accepted, an authorization code is returned. The card number and authorization code are
printed on the receipt. If a credit or debit card is not accepted and no other payment is offered,
the order is canceled.

When complete payment has been received, the cash register computes the amount of change,
displays it, and prints it on the receipt. Finally, the receipt is fed out of the printer. At this point,
the cashier must close the till, which is automatically locked in position until the next customer
transaction has been completed.

The inventory system dynamically keeps track of the current numbers of items. When the
number of an item goes below a certain threshold, an inventory message is created and stored in
the system. Inventory orders with quantities of products are automatically sent at night to the
suppliers and are recorded in the system. 
