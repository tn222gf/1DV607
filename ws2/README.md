### Workshop 2
run jar file: java -jar ws2Passing.jar
Make sure to have memberList.xml in same folder

### Changes after Peer Review
#### Code
Creating create/remove/change boat metods in the Member class and removeing this code from the Crud class, as the Member class is the information expert. This removes a hidden association.

#### Class diagram
  * Removing dependency to member_list.XML, which has been moved out from model package to source folder.
  * Adding dependency arrows from classes in the xml package to member and boat, dependencys which was forgotten.

#### Sequence diagrams
  * Changing create member diagram

### Passing grade
![alt text](https://github.com/tn222gf/1DV607/blob/master/ws2/ws2_ClassDiagram_passing_tn222gf.png "ws2 class diagram first submission")
![alt text](https://github.com/tn222gf/1DV607/blob/master/ws2/ws2_seqDiagram_passingGrade_tn222gf.png "ws2 sequence diagram first submission")
![alt text](https://github.com/tn222gf/1DV607/blob/master/ws2/ws2_seqDiagram2_passingGrade_tn222gf.png "ws2 sequence diagram first submission")
