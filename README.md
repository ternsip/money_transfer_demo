# Money transfer demo
**Implementing simple demonstration of REST for transfering money between accounts without any Frameworks**

By default it is allowed only to 
- read_all via GET http://localhost:8000/accounts
- transfer money via POST http://localhost:8000/send use json body - 
{"amount": "23","fromAccountId": "1","toAccountId": "2"}
