
function scrollToTop() {
    var position =
        document.body.scrollTop || document.documentElement.scrollTop;
    if (position) {
        window.scrollBy(0, -Math.max(1, Math.floor(position / 10)));
        scrollAnimation = setTimeout("scrollToTop()", 10);
    } else clearTimeout(scrollAnimation);
}

$(document).ready(function() {    
    dialogSign();
    dialogRes();
    getData();
});
var msg = null;
function dialogSign() {
    $('#log-in').click(function(){
        $('#over').fadeIn(300);
        $('#dialog-sign').fadeIn(300);
    });
    $('.close-sign').click(function() {
        $('#over').hide();
        $('#dialog-sign').hide();       
    });
    $('.close-res').click(function() {
        $('#over').hide();
        $('#dialog-res').hide();       
    });
    $('#sig').click(function(){
        var data = $("#frm-login").serialize();
        $.ajax({
            url:"danhSachSanPham",
            type:"POST",
            data: data,
            dataType: "JSON",
        success: function(data)
        {
            msg = data[0].msg;
            if(msg === 1) {
                window.location.replace("danhSachSanPham");
            } else if (msg === 3) {
                $('#msg').hide().html("tai khoan chua dung, vui long thu lai").fadeIn("fast");
                alert("NHAP SAI ROI KIA");
            }
        }
        })    
    });    
}
// jQuery(document).ready(function ($) {
//        var value = '@Request.RequestContext.HttpContext.Session["login"]';
//        alert(value);
//    }); 
function dialogRes() {
    $('#resgister').click(function() {
        $('#dialog-sign').hide();
        $('#dialog-res').show();
    });
}

//$(document).ready(function() {
//    dialog = $("#dialog-sign").dialog({
//        autoOpen: false,
//        modal: true
//    });
//    initEvens();
//}); 

function getData() {
    $.ajax ({
        url : "danhSachSanPham",
        method : 'GET',
        dataType : 'JSON',
    }).done (function(response) {
        console.log(response);
    });
}
// lấy thẻ 
    var input = document.querySelector("#filter");
    var results = [{name: "Hieu",pic:"..."},{name: "aieu 1",}];
    var filterDiv= $('<div>').appendTo('.container-1');  
    
    function onSearching() {   
        var textSearch = input.value.toUpperCase();
        
            if(textSearch!==null) {    
                var filter_rs = results.filter(obj => obj["name"].toUpperCase().startsWith(textSearch));
                
                filterDiv.id="filter_hidden";
//                  filterDiv.setAttribute("id", "filter_hidden");

                var cont = document.querySelector('.container-1');
                cont.appendChild(filterDiv);

                var ul = document.createElement('ul');
                filterDiv.appendChild(ul);
                for(i = 0;i < filter_rs.length; i++) {
                    var li = document.createElement('li');
                    var a = document.createElement('a');
                    a.innerHTML = filter_rs[i]["name"];
                    li.appendChild(a);
                    ul.appendChild(li);
                    console.log(a);
                }
            }
            input.onkeydown = function() {
                var key = event.keyCode || event.charCode;

               if( key == 8 || key == 46 ) {
                    while(ul.lastElementChild) {
                        ul.removeChild(ul.lastElementChild);
                    }
                }
                        
            };
        } 
      //gán sự kiện cho thẻ input
    input.addEventListener("keyup", onSearching);


   