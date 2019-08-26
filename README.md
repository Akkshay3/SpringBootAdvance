"# SpringBootAdvance" 
Endpoint  For validation List of object,
http://localhost:9099/student/addAll

Input : {"listOfStudent":[{"name":"A","city":"q","contactNo":"1","emailId":"xyz!mail.com","roll_no":1},
{"name":"B","city":"Mumbai","contactNo":"9988776655","emailId":"abc@hotmail.com","roll_no":2},
{"name":"C","city":"Bangalore","contactNo":"8710462300","emailId":"pqr@outlook.com","roll_no":3}]}

Output : {
    "timeStamp": "26-08-2019 11:13:18",
    "message": "Validation Error",
    "details": "uri=/student/addAll",
    "subErrors": {
        "listOfStudent[0]": [
            {
                "object": "validStudentList",
                "field": "listOfStudent[0].emailId",
                "rejectedValue": "xyz!mail.com",
                "message": "Enter valid Email Address"
            },
            {
                "object": "validStudentList",
                "field": "listOfStudent[0].contactNo",
                "rejectedValue": "1",
                "message": "Please Enter valid Mobile No"
            },
            {
                "object": "validStudentList",
                "field": "listOfStudent[0].name",
                "rejectedValue": "A",
                "message": "Student Name should contain atleast Four characters"
            }
        ],
        "listOfStudent[2]": [
            {
                "object": "validStudentList",
                "field": "listOfStudent[2].name",
                "rejectedValue": "C",
                "message": "Student Name should contain atleast Four characters"
            }
        ],
        "listOfStudent[1]": [
            {
                "object": "validStudentList",
                "field": "listOfStudent[1].name",
                "rejectedValue": "B",
                "message": "Student Name should contain atleast Four characters"
            }
        ]
    }
}
