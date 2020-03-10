$(document).ready(function() {

  function ajaxCallRequest(f_method, f_url, f_data) {
    $("#dataSent").val(unescape(f_data));
    var f_contentType = 'application/x-www-form-urlencoded; charset=UTF-8';
    
    $.ajax({
      url: f_url,
      type: f_method,
      contentType: f_contentType,
      dataType: 'json',
      data: f_data,
      success: function(data) {
        var jsonResult = JSON.stringify(data);
        $("#results").val(unescape(jsonResult));
      }
    });
    
  }


//  var formResults = JSON.stringify({
//   first_name = document.querySelector("#first_name"),
//   last_name = document.querySelector("#last_name"),
//   civility = document.querySelector("#civility"),
//   email = document.querySelector("#email"),
//   phone_number = document.querySelector("#phone_number")
//  });


$("#sendSerialized").click(function(event) {
    event.preventDefault();
    var form = $('#contact_form');
    var method = form.attr('method');
    var url = form.attr('action');
    var objectData = $(form).serializeObject();
    var data = JSON.stringify(objectData); 
    console.log(data);
    ajaxCallRequest(method, url, data);
  });

  $.mockjax({
    url: 'http://localhost:8080/Collaborators',
    type: 'POST',
    contentType: 'application/x-www-form-urlencoded',
    responseTime: 0,
    response: function(settings) {
      var data = settings.data;
      this.responseText = data;
    }
  });
  



