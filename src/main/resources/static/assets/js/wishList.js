function saveWishList(s) {
	
	$('#heart'+s+' img').attr({
		"src": "/assets/img/gallery/heart_full.png",
		"onclick": "deleteWishList("+s+")",
		"alt": "즐겨찾기 제거"
	});
	
	var data = {
		userId : $('#userId').val(),
		giftId : s
	};
	 $.ajax({
            type: 'POST',
            url: '/api/wish',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
	
};

function deleteWishList(s) {
	
	$('#heart'+s+' img').attr({
		"src": "/assets/img/gallery/heart_empty.png",
		"onclick": "saveWishList("+s+")",
		"alt": "즐겨찾기 추가"
	});
	
	var data = {
		userId : $('#userId').val(),
		giftId : s
	};
	 $.ajax({
            type: 'DELETE',
            url: '/api/wish',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
	
};

function notLogined(){
	alert('로그인하여 주십시오.');
	
};

