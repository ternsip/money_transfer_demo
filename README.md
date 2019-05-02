# money_transfer_demo
Implementing simple demonstration of REST for transfering money between accounts without any Frameworks
By default it is allowed only to read_all (via http://localhost:8000/accounts) and transfer money (via http://localhost:8000/send)
For transferring money use POST BODY - {"amount": "23","fromAccountId": "1","toAccountId": "2"}
