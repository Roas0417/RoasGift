var wish = {
    init : function () {
        var _this = this;
        $('.wish-save').on('click', function () {
            _this.save();
        });

 		/*$('#btn-delete').on('click', function () {
            _this.delete();
        });*/
    },
    save : function () {
        var data = {
            userId: $('#userId').val(),
            giftId: $('#giftId').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/wish',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('즐겨찾기에 등록되었습니다.');
            /*window.location.href = '/gift/list';*/
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
	}/*,
	
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
*/
	
};

wish.init();