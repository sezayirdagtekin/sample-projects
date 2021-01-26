# Hiking-booking


What Do You Need?
  Apache Maven 3.6.3
  java version  11.0.9


1.  Open windows terminal. Go to project folder
  e.g D:\hiking-tour> 
 
2 .  Run project   mvn spring-boot:run

You will see main menu
---BOOKING MAIN MENU----
[1]  Active Tour List(Info)
[2]  Create New Bookings(Hiker)
[3]  Cancel Bookings(Hiker)
[4]  List My Bookings(Hiker)
[5]  List Daily Bookings(Admin)
[E]  Exit

 Also there is second sub menu for creation booking

[1]  Create booking for yourself?
[2]  Create booking for friends?
[M]  Main Menu


You can follow the directions. input controls available in many places

------------------------------------------------------------------

SAMPLE LOGS

------------------------------------------------------------------


    .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.4.2)

2021-01-25 13:20:28.772  INFO 9060 --- [           main] com.sezayir.demo.HikingTourApplication   : Starting HikingTourApplication using Java 11.0.9 on DESKTOP-51EU7MB with PID 9060 (D:\hiking-tour\target\classes started by sezay in D:\hiking-tour)
2021-01-25 13:20:28.774  INFO 9060 --- [           main] com.sezayir.demo.HikingTourApplication   : No active profile set, falling back to default profiles: default
2021-01-25 13:20:29.186  INFO 9060 --- [           main] com.sezayir.demo.HikingTourApplication   : Started HikingTourApplication in 0.781 seconds (JVM running for 1.153)
---BOOKING MAIN MENU----
[1]  Active Tour List(Info)
[2]  Create New Bookings(Hiker)
[3]  Cancel Bookings(Hiker)
[4]  List My Bookings(Hiker)
[5]  List Daily Bookings(Admin)
[E]  Exit
Select option:
1
All available tours:
Mordor : Tour(name=Mordor, price=99.90, ageRange=AgeRange [low=18, high=40], start=14:00, end=19:00)
Shire : Tour(name=Shire, price=29.89, ageRange=AgeRange [low=5, high=100], start=07:00, end=09:00)
Gondor : Tour(name=Gondor, price=59.89, ageRange=AgeRange [low=11, high=50], start=10:00, end=13:00)
---BOOKING MAIN MENU----
[1]  Active Tour List(Info)
[2]  Create New Bookings(Hiker)
[3]  Cancel Bookings(Hiker)
[4]  List My Bookings(Hiker)
[5]  List Daily Bookings(Admin)
[E]  Exit
Select option:
2
[1]  Create booking for yourself?
[2]  Create booking for friends?
[M]  Main Menu
1
please enter name:
sezayir
Please enter age:
39
Please enter day(eg:2021-02-02) :2021-03-03
Please enter tour name(Shire,Mordor or Gondor):
Mordor
2021-01-25 13:21:05.470  INFO 9060 --- [           main] c.s.demo.service.BookingServiceImpl      : Hiker created booking:Booking(date=2021-03-03, hiker=Hiker(name=sezayir, age=39), tour=Tour(name=Mordor, price=99.90, ageRange=AgeRange [low=18, high=40], start=14:00, end=19:00), refrenceName=null)
Do you want to make another reservation for your self?[Y]/[N]
Y
Please enter day(eg:2021-02-02) :2021-03-03
Please enter tour name(Shire,Mordor or Gondor):
Gondor
2021-01-25 13:21:27.431  INFO 9060 --- [           main] c.s.demo.service.BookingServiceImpl      : Hiker created booking:Booking(date=2021-03-03, hiker=Hiker(name=sezayir, age=39), tour=Tour(name=Gondor, price=59.89, ageRange=AgeRange [low=11, high=50], start=10:00, end=13:00), refrenceName=null)
Do you want to make another reservation for your self?[Y]/[N]
N
[1]  Create booking for yourself?
[2]  Create booking for friends?
[M]  Main Menu
2
Firstly,We will get your information!
please enter name:
sezayir
Please enter day(eg:2021-02-02) :2021-03-03
Next step needs friend's name and age
please enter name:
john
Please enter age:
67
Please enter tour name(Shire,Mordor or Gondor):
Shire
2021-01-25 13:22:28.457  INFO 9060 --- [           main] c.s.demo.service.BookingServiceImpl      : Hiker created booking:Booking(date=2021-03-03, hiker=Hiker(name=john, age=67), tour=Tour(name=Shire, price=29.89, ageRange=AgeRange [low=5, high=100], start=07:00, end=09:00), refrenceName=sezayir)
Do you want to make another reservation for your friend?[Y]/[N]
N
[1]  Create booking for yourself?
[2]  Create booking for friends
[M]  Main Menu
M
---BOOKING MAIN MENU----
[1]  Active Tour List(Info)
[2]  Create New Bookings(Hiker)
[3]  Cancel Bookings(Hiker)
[4]  List My Bookings(Hiker)
[5]  List Daily Bookings(Admin)
[E]  Exit
Select option:
5
Please enter day(eg:2021-02-02) :2021-03-03
2021-01-25 13:22:57.558  INFO 9060 --- [           main] com.sezayir.demo.input.InputData         : List of bookings in date:2021-03-03
Booking(date=2021-03-03, hiker=Hiker(name=sezayir, age=39), tour=Tour(name=Mordor, price=99.90, ageRange=AgeRange [low=18, high=40], start=14:00, end=19:00), refrenceName=null)
Booking(date=2021-03-03, hiker=Hiker(name=sezayir, age=39), tour=Tour(name=Gondor, price=59.89, ageRange=AgeRange [low=11, high=50], start=10:00, end=13:00), refrenceName=null)
Booking(date=2021-03-03, hiker=Hiker(name=john, age=67), tour=Tour(name=Shire, price=29.89, ageRange=AgeRange [low=5, high=100], start=07:00, end=09:00), refrenceName=sezayir)
---BOOKING MAIN MENU----
[1]  Active Tour List(Info)
[2]  Create New Bookings(Hiker)
[3]  Cancel Bookings(Hiker)
[4]  List My Bookings(Hiker)
[5]  List Daily Bookings(Admin)
[E]  Exit
Select option:
4
please enter name:
sezayir
Please enter your age:
39
2021-03-03=[Booking(date=2021-03-03, hiker=Hiker(name=sezayir, age=39), tour=Tour(name=Mordor, price=99.90, ageRange=AgeRange [low=18, high=40], start=14:00, end=19:00), refrenceName=null), Booking(date=2021-03-03, hiker=Hiker(name=sezayir, age=39), tour=Tour(name=Gondor, price=59.89, ageRange=AgeRange [low=11, high=50], start=10:00, end=13:00), refrenceName=null), Booking(date=2021-03-03, hiker=Hiker(name=john, age=67), tour=Tour(name=Shire, price=29.89, ageRange=AgeRange [low=5, high=100], start=07:00, end=09:00), refrenceName=sezayir)]
---BOOKING MAIN MENU----
[1]  Active Tour List(Info)
[2]  Create New Bookings(Hiker)
[3]  Cancel Bookings(Hiker)
[4]  List My Bookings(Hiker)
[5]  List Daily Bookings(Admin)
[E]  Exit
Select option:
3
please enter name:
sezayir
Please enter day(eg:2021-02-02) :2021-03-03
Please enter tour(Shire,Mordor or Gondor):
Gondor
2021-01-25 13:24:02.150  INFO 9060 --- [           main] c.s.demo.service.BookingServiceImpl      : Hiker removed booking:Booking(date=2021-03-03, hiker=Hiker(name=sezayir, age=39), tour=Tour(name=Gondor, price=59.89, ageRange=AgeRange [low=11, high=50], start=10:00, end=13:00), refrenceName=null)
---BOOKING MAIN MENU----
[1]  Active Tour List(Info)
[2]  Create New Bookings(Hiker)
[3]  Cancel Bookings(Hiker)
[4]  List My Bookings(Hiker)
[5]  List Daily Bookings(Admin)
[E]  Exit
Select option:
4
please enter name:
sezayir
Please enter your age:
39
2021-03-03=[Booking(date=2021-03-03, hiker=Hiker(name=sezayir, age=39), tour=Tour(name=Mordor, price=99.90, ageRange=AgeRange [low=18, high=40], start=14:00, end=19:00), refrenceName=null), Booking(date=2021-03-03, hiker=Hiker(name=john, age=67), tour=Tour(name=Shire, price=29.89, ageRange=AgeRange [low=5, high=100], start=07:00, end=09:00), refrenceName=sezayir)]
---BOOKING MAIN MENU----
[1]  Active Tour List(Info)
[2]  Create New Bookings(Hiker)
[3]  Cancel Bookings(Hiker)
[4]  List My Bookings(Hiker)
[5]  List Daily Bookings(Admin)
[E]  Exit
Select option:
E
2021-01-25 13:24:38.033  INFO 9060 --- [           main] com.sezayir.demo.input.InputData         : Bye!