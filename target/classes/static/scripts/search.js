//datepicker
var nowDate = new Date();
var today = new Date(nowDate.getFullYear(), nowDate.getMonth(), nowDate.getDate(), 0, 0, 0, 0);

$(document).ready(function(){
 $("#inputCheckIn").datepicker({
  format: "DD, yyyy-mm-dd",
  startDate: today,
  endDate: "+1y"
 })

 $("#outputCheckOut").datepicker({
  format: "DD, yyyy-mm-dd",
  startDate: "+1d",
  endDate: "+1y"
 })  
});

//update checkout
function updateCheckOut(){
   var duration = parseInt($("#inputDuration").val());
   var checkIn = $("#inputCheckIn").datepicker('getDate');
   var checkOut = checkIn;

   if (duration < 1) {
     duration = 1;
     $("#inputDuration").val(1);
   }
   if (duration > 30) {
     duration = 30;
    $("#inputDuration").val(30);
   }

   checkOut.setDate(checkOut.getDate() + duration);

   $("#outputCheckOut").datepicker('setDate', checkOut);
  
 }
 
//update checkin
function updateCheckIn(){
  var duration = parseInt($("#inputDuration").val());
  var checkOut = $("#outputCheckOut").datepicker('getDate');
  var checkIn = checkOut;

  if (duration < 1) {
    duration = 1;
    $("#inputDuration").val(1);
  }
  if (duration > 30) {
    duration = 30;
   $("#inputDuration").val(30);
  }

  checkIn.setDate(checkIn.getDate() - duration);

  $("#inputCheckIn").datepicker('setDate', checkIn);
 
}
 
//toUpperCase
function toUpperCase(){
  var destination = $("#inputDestination").val();
  var newDestination = destination.toUpperCase();

  $("#inputDestination").val(newDestination);
}

 //only between 1 and 30
 function validateGuestRange(){
   var guestVal = parseInt($("#inputGuest").val());
   var roomVal = parseInt($("#inputRoom").val());

   if(guestVal < 1){
    $("#inputGuest").val(1);
    guestVal = 1;
   }

   if(guestVal > 30){
    $("#inputGuest").val(30);
    guestVal = 30;
   }

   if (guestVal < roomVal) {
     $("#inputGuest").val(roomVal);
     guestVal = roomVal;
   }

   $("#outputGuestRoom").val(guestVal + " Adults(s), " + roomVal + " Room(s)");
 }

 function validateRoomRange(){
   var guestVal = parseInt($("#inputGuest").val());
   var roomVal = parseInt($("#inputRoom").val());

   if(roomVal < 1){
    $("#inputRoom").val(1);
    roomVal = 1;
   }

   if(roomVal > 30){
    $("#inputRoom").val(30);
    roomVal = 30;
   }

   if (guestVal < roomVal) {
     $("#inputRoom").val(guestVal);
     roomVal = guestVal;
   }

   $("#outputGuestRoom").val(guestVal + " Adults(s), " + roomVal + " Room(s)");
 }

 //only number
 function validateNumberInput(ctrl){
   return (event.charCode !=8 && event.charCode ==0 || (event.charCode >= 48 && event.charCode <= 57))
 }

 //static text
 function validateInput(ctrl) {
    if (event.keyCode == 8 || event.keyCode == 46) {   //backspace pressed or delete key pressed 
      return false;
    }
    return true;
  }