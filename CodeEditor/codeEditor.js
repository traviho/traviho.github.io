
 var contents = myCodeMirror.getValue();
 alert("Hey");
 var id = firebase.auth().currentUser.uid;

 function submitCode() {
   compileCode();
   var add = 'class Car {public void moveForward() {System.out.println("Moving Forward");} public void moveBackward() {System.out.println("Moving Backward");} public void turnLeft() {System.out.println("Turning Left");} public void turnRight() {System.out.println("Turning Right");}}';
   var content = myCodeMirror.getValue() ;
   contents = myCodeMirror.getValue() + add;
   TOKEN   = { time_created: 1480566364000,
 msg_mac: 'xr5k8DYMYeruzEZelBndLu4QGR9Go7iFy97pIeRAEDk=' }



// any kind of extension (.txt,.cpp,.cs,.bat)
var filename = "Program.java";

var codeFile = new Blob([content], {
type: "text/plain;charset=utf-8"
});

//saveAs(codeFile, filename);
 }
 function compileCode() {
   TOKEN   = { time_created: 1480566364000,
 msg_mac: 'xr5k8DYMYeruzEZelBndLu4QGR9Go7iFy97pIeRAEDk=' }

var repl = new ReplitClient('api.repl.it', '80', 'java', TOKEN);

repl.connect().then(
   function() {
       start();
   },
   function() {
   }
);

function start() {
       repl.evaluate(
           contents,
            {
               stdout: function(str) {
                 document.querySelector('.result').innerHTML = "";
                   document.querySelector('.out').innerHTML += str + '\n';
               }
            }
       ).then(
           function(result) {
               document.querySelector('.result').innerHTML += (result.error || result.data) + '\n';
           },
           function(err) {
               console.error(err);
           }
       );
}
 }
 firebase.auth().onAuthStateChanged(function(user) {
 if (user) {
   alert("HI IM SIGNED IN THE CODE EDITOR");
 } else {
   alert("I JUst Signed Out BItch");
 }
 });
