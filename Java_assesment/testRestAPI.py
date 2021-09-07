try:
    from pip import main as pipmain
except ImportError:
    from pip._internal import main as pipmain
pipmain(['install', 'requests'])

import requests

URL = "http://127.0.0.1:8080/addRecord"

URLGet = "http://127.0.0.1:8080/getAllRecordsRest"
for i in range(100):
        li={"id":5, "firstName" :"Ajjlo", "lastName":"Aikol", "title":"book","isbn":"112548" }
        li["id"]=li["id"]+i
        li["firstName"]=li["firstName"]+"A"
        li["lastName"]=li["lastName"]+"A"
        li["title"]=li["title"]+str(i)
        li["isbn"]=li["isbn"]+str(i)
        r=requests.post(url=URL,data=li)
        print(r.text)
r=requests.get(url=URLGet)
print(r.text)

