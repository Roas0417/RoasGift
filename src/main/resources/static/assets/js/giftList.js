var main = {
    init : function () {
        var _this = this;
        /*$('#btn-save').on('click', function () {
            _this.save();
			_this.saveImg();
        });*/

		$('#btn-update').on('click', function () {
            _this.update();
        });

 		$('#btn-delete').on('click', function () {
            _this.delete();
        });

    },
    /*save : function () {
        var data = {
            giftName: $('#giftName').val(),
            giftBrand: $('#giftBrand').val(),
            giftCategory: $('#giftCategory').val(),
            giftPrice: $('#giftPrice').val(),
            giftContent: $('#giftContent').val()
        };

		$.ajax({
            type: 'POST',
            url: '/api/v1/gift',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 등록되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },*/

	/*saveImg : function () {
		
		var form = $('#listForm')[0];
		var formData = new FormData(form);
		formData.append("img", $("#imgs")[0].files[0]);
		//var file = $("#imgs")[0].files[0];
		
		$.ajax({
            type: 'POST',
            url: '/api/v1/gift',
			enctype: 'multipart/form-data',
			processData: false, 
			contentType: false,
			data : formData*/
			/*success:function(json) {
                var obj = JSON.parse(json);
			}*/
			
		
	update : function () {
        var data = {
            giftName: $('#giftName').val(),
            giftBrand: $('#giftBrand').val(),
            giftCategory: $('#giftCategory').val(),
            giftPrice: $('#giftPrice').val(),
            giftSold: $('#giftSold').val(),
            giftContent: $('#giftContent').val()
        };

        var id = $('#giftId').val();

        $.ajax({
            type: 'PUT',
            url: '/api/v1/gift/'+id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 수정되었습니다.');
            window.location.href = '/gift/list';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },

    delete : function () {
        var id = $('#giftId').val();

        $.ajax({
            type: 'DELETE',
            url: '/api/v1/gift/'+id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8'
        }).done(function() {
            alert('글이 삭제되었습니다.');
            window.location.href = '/gift/list';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }

};

main.init();