IMP.init('imp88489189'); 	
  
$('#btn-bay-now').on('click', function () {
	var data = {
		userId : $('#userId').val(),
		giftId : $('#giftId').val(),
		amount : $('#giftPrice').val()
	    };
	
	IMP.request_pay({
	    pg : 'html5_inicis',
	    pay_method : 'card',
	    merchant_uid : 'merchant_' + new Date().getTime(), /* 필수 */
	    name : $('#giftBrand').val() + ' / '+ $('#giftName').val(),
	    amount : $('#giftPrice').val(), /* 필수 */
	    buyer_email : $('#userEmail').val(),
	    buyer_name :  $('#nickName').val(),
	    buyer_tel : '010-1234-5678' /* 필수 */
	}, function(rsp) {
	    if ( rsp.success ) {
			//[1] 서버단에서 결제정보 조회를 위해 jQuery ajax로 imp_uid 전달하기
	    	jQuery.ajax({
	    		url: '/api/payment', //cross-domain error가 발생하지 않도록 동일한 도메인으로 전송
	    		type: 'POST',
	    		dataType: 'json',
            	contentType:'application/json; charset=utf-8',
            	data: JSON.stringify(data)
	    	}).done(function() {
	    		//[2] 서버에서 REST API로 결제정보확인 및 서비스루틴이 정상적인 경우
	    			var msg = '결제가 완료되었습니다.';
	    			msg += '\n고유ID : ' + rsp.imp_uid;
	    			msg += '\n상점 거래ID : ' + rsp.merchant_uid;
	    			msg += '\n결제 금액 : ' + rsp.paid_amount;
	    			msg += '\n카드 승인번호 : ' + rsp.apply_num;
					msg += '\n상품 번호 : ' + $('#giftId').val();
					alert(msg);
	    	
	    	}).fail(function (error) {
            alert(JSON.stringify(error));
        });
			
	    } else { // 결제 실패.
	        var msg = '결제에 실패하였습니다.';
	        msg += '에러내용 : ' + rsp.error_msg;
	   		alert(msg);
	    }
	
	});

});