$('.form').find('input, textarea').on('keyup blur focus', function (e) {

  var $this = $(this),
      label = $this.prev('label');

	  if (e.type === 'keyup') {
			if ($this.val() === '') {
          label.removeClass('active highlight');
        } else {
          label.addClass('active highlight');
        }
    } else if (e.type === 'blur') {
    	if( $this.val() === '' ) {
    		label.removeClass('active highlight');
			} else {
		    label.removeClass('highlight');
			}
    } else if (e.type === 'focus') {

      if( $this.val() === '' ) {
    		label.removeClass('highlight');
			}
      else if( $this.val() !== '' ) {
		    label.addClass('highlight');
			}
    }

});
$('.tab a').on('click', function (e) {

  e.preventDefault();

  $(this).parent().addClass('active');
  $(this).parent().siblings().removeClass('active');

  target = $(this).attr('type');

  $('.tab-content > div').not(target).hide();

  $(target).fadeIn(600);

});

function createAccount() {
  var email = document.getElementById("create-email").value;
  var password = document.getElementById("create-pw").value;

  firebase.auth().createUserWithEmailAndPassword(email, password).catch(function(error) {
    // Handle Errors here.
    var errorCode = error.code;
    var errorMessage = error.message;
    signedIn = false;
    alert(errorCode);
    });
}

function login() {
  var email = document.getElementById("login-email").value;
  var password = document.getElementById("login-pw").value;
  var signedIn = true;

  //button.value = document.getElementById("user-email").value;
  firebase.auth().signInWithEmailAndPassword(email, password).catch(function(error) {
    // Handle Errors here.
    signedIn = false;
    var errorCode = error.code;
    var errorMessage = error.message;
    alert(errorCode);
    // ...
});
}
firebase.auth().onAuthStateChanged(function(user) {
if (user) {
  var users = firebase.auth().currentUser.uid;
  updateUser(users);
  setUserCode(users);
} else {
}
});
function updateUser(x) {
  window.theUser = x;
  window.location = "CodeEditor/codeEditor.html";
}
function getUser() {
  return theUser;
}
