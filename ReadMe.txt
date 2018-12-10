Login:
Rule:
1. User name cannot be repeated.
2. Password must match user name.
3. For displaying the ID normally, delete the databank every time before creating new     account, since the data has been pre-stored. 

Password is as same as username.
Pre-set user name List:
sysadmin  //System Admin
libadmin  //Library Admin
cafeadmin  //Cafe Admin
stu1,stu2,stu3,stu4,...stu7  //Student
lib1,lib2,lib3  //Librarian
tutor1,tutor2,tutor3  //Tutor
worker1,worker2,worker3  //Cafe worker



Student Role:

Student can:
1. Make appointment with tutors. Students can book any time, and tutors will accept it if they have time (time crush is not allowed).
2. Borrow books from library. Any book request will contains several books (one for each), and be processed by librarian. Students cannot keep one more same book. If they already have the book with them, it won't show up in the book list.
3. Order Coffee from cafe. Coffee order has multiple choice of coffee and its quantity.

Tutor Role:

Tutor can:
1. Accept Appointment request from students, and assign study room for the request. Room cannot be used by more than one request at the same time. Also, tutors/students cannot have more than one appointment at the same time.
2. Decline the request. If tutor decline the request (after they accept it), the status will be changed to sent, and other tutors can take that request.

Worker Role:

Worker can:
Accept coffee request. Worker cannot decline the coffee order in our system. As long as students pay for the order, they should take it. Also, we don't have Storage for coffee. If one kind of coffee is out of stock, worker can delete them.

Librarian Role:

Librarian can:
1. Accept/ Decline the book request.
2. Analysis the most popular book/coffee and most active students.

BookRequest

Status:
1. Sent. 
2. Returned. Students return the book back to library.
3. Accept. Librarians accept the request, and lend the books to students.
4. Decline. Librarians decline the Request.



AppointmentRequest

Status:
1. Sent  from Student to Tutor, or be cancelled.
2. Cancelled  Student cancel the appointment request, cancelled won't be seen by tutor.
3. Accepted  Tutor accept the request


Rule:
Student, StudyRoom, Tutor cannot have one more appointment at the same time.

Tutor can only see request assigned to themselves or not assigned.

Tutor can cancel accept request to Sent status, and other tutors can accept that request.