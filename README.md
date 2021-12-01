# USD To EUR Converter
Service for converting dollars into euros and vice versa, taking into account the current exchange rate.

## Starting the service
To start working with a project, you need to: 
   1 Build an image by typing ```docker buid -t application .``` 
   2 Run container by typing ```docker run -it application```

## Working with the service
Service requests look like: ```/<request_type>?param=<count>```, where the request type is one of 2 commands:
   - EtoU - conversion from euros to dollars
   - UtoE - conversion from dollars to euros

Count -- original currency amount. So request can looks like this: ```/EtoU?params=138```
As a result, we get the amount of currency into which the conversion was carried out.
